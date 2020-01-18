package cn.kunlong.center.core.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class StringHelper {

	private StringHelper() {
	}

	/**
	 * 对字符串排版，并考虑中文字符。
	 *
	 * <ul>
	 * <li>一个汉字相当于两个英文字符的宽度。</li>
	 * <li>如果字符串长度大于最大长度，则返回的字符串补{@code "."}，表示尚有其它字符未输出。</li>
	 * </ul>
	 *
	 * <p>
	 * 举例：
	 * <ul>
	 * <li>typeset("a", 3)返回{@code "a  "}三个字符，尾部有两个空格。</li>
	 * <li>typeset("abcd", 3)返回{@code "ab."}三个字符。</li>
	 * <li>typeset("中", 3)返回{@code "中 "}两个字符，尾部有一个空格。</li>
	 * <li>typeset("中文", 3)返回{@code "中."}两个字符。</li>
	 * <li>typeset("a中文", 3)返回{@code "a.."}三个字符。</li>
	 * </ul>
	 *
	 * @param s
	 * @param maxLength
	 * @return
	 */
	public static String typeset(String s, int maxLength) {
		if (s == null) {
			return null;
		}

		// 处理中文字符
		byte[] bytes;
		try {
			bytes = s.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("中文字符转换异常", e);
		}

		// 最多取maxLength个英文字符的长度
		int charCount = 0;
		int byteCount = 0;
		int lastStep = -1;
		for (int k = 0; k < bytes.length;) {
			if (bytes[k] < 0) {
				if (byteCount > maxLength - 2)
					break;

				lastStep = 2;
				byteCount += 2;
				k += 2;
			} else {
				lastStep = 1;
				byteCount++;
				k++;
			}

			charCount++;

			if (byteCount == maxLength)
				break;
		}

		if (charCount < s.length() && byteCount == maxLength) {
			charCount--;
			byteCount -= lastStep;
		}

		String format = "%-" + (maxLength - (byteCount - charCount)) + "s";

		String name = s.substring(0, charCount);
		if (charCount < s.length()) {
			for (int i = 0; i < maxLength - byteCount; i++) {
				name += ".";
			}
		}

		return String.format(format, name);
	}

	/**
	 * 转为字符串集合
	 * 
	 * @param toSplit
	 * @param delimiter
	 * @return
	 */
	public static <T> List<String> trans2StringList(String toSplit, String delimiter) {
		if (StringUtils.isEmpty(toSplit))
			return null;
		String[] strArr = toSplit.split(delimiter);
		List<String> r = new ArrayList<String>(strArr.length);
		for (String s : strArr) {
			if (!StringUtils.isEmpty(s)) {
				r.add(s);
			}
		}
		return r;
	}

	/**
	 * 转为整数集合
	 * 
	 * @param toSplit
	 * @param delimiter
	 * @return
	 */
	public static <T> List<Integer> trans2IntegerList(String toSplit, String delimiter) {
		if (StringUtils.isEmpty(toSplit))
			return null;
		String[] strArr = toSplit.split(delimiter);
		List<Integer> r = new ArrayList<Integer>(strArr.length);
		for (String s : strArr) {
			if (!StringUtils.isEmpty(s)) {
				r.add(Integer.parseInt(s));
			}
		}
		return r;
	}

	/**
	 * 是普通字符串(中文、数据、字母、下划线或其组合)
	 * 
	 * @param words
	 * @return
	 */
	public static boolean isNormalCharacters(String words) {
		Pattern p = Pattern.compile("[\\w\\u4E00-\\u9FA5]+$");
		return p.matcher(words).matches();
	}

	/**
	 * 是否包含脚本
	 * 
	 * @param words
	 * @return
	 */
	public static boolean containsScript(String words) {
		if (words == null)
			return false;
		Pattern p = Pattern.compile(".*['\\\"\\&\\\\<>]+.*");
		return p.matcher(words).matches();
	}

	/**
	 * 检测邮箱地址是否合法
	 * 
	 * @param email
	 * @return true合法 false不合法
	 */
	public static boolean isEmail(String email) {
		if (StringUtils.isEmpty(email)) return false;
		Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");// 复杂匹配
		Matcher m = p.matcher(email);
		return m.matches();
	}
}
