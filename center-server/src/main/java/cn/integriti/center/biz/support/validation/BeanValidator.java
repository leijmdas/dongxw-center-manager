package cn.integriti.center.biz.support.validation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path.Node;
import javax.validation.ValidationException;
import javax.validation.Validator;

import org.mybatis.hbatis.core.annotation.Column;
import org.springframework.util.StringUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * JSR303 Validator(Hibernate Validator)工具类.
 * <p/>
 * ConstraintViolation中包含propertyPath, message 和invalidValue等信息.
 * 提供了各种convert方法，适合不同的i18n需求: 1. List<message> 2. List<propertyPath + separator
 * + message> 3. Map<propertyPath, message>
 */
@SuppressWarnings("all")
public class BeanValidator {

	private static LocalValidatorFactoryBean validatorFactory;

	private static Locale defaultLocale = Locale.CHINESE;

	public static void setValidatorFactory(LocalValidatorFactoryBean validatorFactory) {
		BeanValidator.validatorFactory = validatorFactory;
	}

	/**
	 * 较验
	 *
	 * @param obj
	 */
	public static void propertyCheck(Object obj) {

		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Object>> constraintViolations = validate(validator, obj);
		if (!constraintViolations.isEmpty()) {
			ConstraintViolation<Object> cv = constraintViolations.iterator().next();
			throw new ValidationException(getErrorMessage(cv, defaultLocale));
		}
	}

	/**
	 * 较验属性
	 *
	 * @param obj
	 * @param propPaths
	 * @param inverse
	 *            是否反转
	 */
	public static void propertyCheck(Object obj, String[] propPaths, boolean inverse) {
		if (propPaths == null)
			throw new IllegalArgumentException("property paths should be supplied");
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Object>> constraintViolations = validate(validator, obj);
		if (constraintViolations.isEmpty()) {
			return;
		}
		for (ConstraintViolation cv : constraintViolations) {
			String propPath = cv.getPropertyPath().toString();
			if (inverse) {
				for (String tmp : propPaths) {
					if (tmp.equals(propPath)) {
						break;
					}
				}
			} else {
				for (String tmp : propPaths) {
					if (tmp.equals(propPath)) {
						throw new ValidationException(getErrorMessage(cv, defaultLocale));
					}
				}
			}
		}
	}

	/**
	 * 调用JSR303的validate方法, 验证失败时抛出ConstraintViolationException.
	 */
	public static Set<ConstraintViolation<Object>> validate(Validator validator, Object object, Class<?>... groups) throws ConstraintViolationException {
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
		return constraintViolations;
	}

	/**
	 * 调用JSR303的validate方法, 验证失败时抛出ConstraintViolationException.
	 */
	public static void validateWithException(Validator validator, Object object, Class<?>... groups) throws ConstraintViolationException {
		Set constraintViolations = validator.validate(object, groups);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}
	}

	/**
	 * 辅助方法,
	 * 转换ConstraintViolationException中的Set<ConstraintViolations>中为List<message>.
	 */
	public static List<String> extractMessage(ConstraintViolationException e) {
		return extractMessage(e.getConstraintViolations());
	}

	/**
	 * 辅助方法, 转换Set<ConstraintViolation>为List<message>
	 */
	public static List<String> extractMessage(Set<? extends ConstraintViolation> constraintViolations) {
		List<String> errorMessages = new ArrayList<String>();
		for (ConstraintViolation violation : constraintViolations) {
			errorMessages.add(violation.getMessage());
		}
		return errorMessages;
	}

	/**
	 * 辅助方法,
	 * 转换ConstraintViolationException中的Set<ConstraintViolations>为Map<property,
	 * message>.
	 */
	public static Map<String, String> extractPropertyAndMessage(ConstraintViolationException e) {
		return extractPropertyAndMessage(e.getConstraintViolations());
	}

	/**
	 * 辅助方法, 转换Set<ConstraintViolation>为Map<property, message>.
	 */
	public static Map<String, String> extractPropertyAndMessage(Set<? extends ConstraintViolation> constraintViolations) {
		Map<String, String> errorMessages = new HashMap<String, String>();
		for (ConstraintViolation violation : constraintViolations) {
			errorMessages.put(violation.getPropertyPath().toString(), violation.getMessage());
		}
		return errorMessages;
	}

	/**
	 * 辅助方法, 转换ConstraintViolationException中的Set<ConstraintViolations>为List<
	 * propertyPath message>.
	 */
	public static List<String> extractPropertyAndMessageAsList(ConstraintViolationException e) {
		return extractPropertyAndMessageAsList(e.getConstraintViolations(), " ");
	}

	/**
	 * 辅助方法, 转换Set<ConstraintViolations>为List<propertyPath message>.
	 */
	public static List<String> extractPropertyAndMessageAsList(Set<? extends ConstraintViolation> constraintViolations) {
		return extractPropertyAndMessageAsList(constraintViolations, " ");
	}

	/**
	 * 辅助方法, 转换ConstraintViolationException中的Set<ConstraintViolations>为List<
	 * propertyPath +separator+ message>.
	 */
	public static List<String> extractPropertyAndMessageAsList(ConstraintViolationException e, String separator) {
		return extractPropertyAndMessageAsList(e.getConstraintViolations(), separator);
	}

	/**
	 * 辅助方法, 转换Set<ConstraintViolation>为List<propertyPath +separator+ message>.
	 */
	public static List<String> extractPropertyAndMessageAsList(Set<? extends ConstraintViolation> constraintViolations, String separator) {
		List<String> errorMessages = new ArrayList<String>();
		for (ConstraintViolation violation : constraintViolations) {
			String propertyName = violation.getPropertyPath().toString();
			errorMessages.add(getErrorMessage(violation, defaultLocale));
		}
		return errorMessages;
	}

	public static String getErrorMessage(ConstraintViolation violation, Locale locale) {
		String text = "";
		Field field;
		try {
			String fieldName = null;
			Iterator<Node> it = violation.getPropertyPath().iterator();
			while(it.hasNext()){
				fieldName = it.next().getName();
			}
			field = violation.getLeafBean().getClass().getDeclaredField(fieldName);
			if (field != null && field.getAnnotation(Column.class) != null) {
				Column col = field.getAnnotation(Column.class);
				text = col.comment();
			}
		} catch (Exception e) {
			text = violation.getPropertyPath().toString();
		}
		if (StringUtils.isEmpty(text)) {
			text = violation.getPropertyPath().toString();
		}
		return text + violation.getMessage();
		// MessageSource messageSource =
		// validatorFactory.getMessageInterpolator()
		// if (messageSource != null) {
		// String key = violation.getRootBeanClass().getName() + "." +
		// violation.getPropertyPath().toString();
		// String text = messageSource.getMessage(key, null, locale);
		// if(StringUtils.isBlank(text)){
		// try {
		// Field field =
		// violation.getRootBeanClass().getField(violation.getPropertyPath().toString());
		// if(field != null && field.getAnnotation(Column.class)!=null){
		// Column col = field.getAnnotation(Column.class);
		// text = col.comment();
		// }
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// return text + violation.getMessage();
		// }
		// return violation.getMessage();
	}
}
