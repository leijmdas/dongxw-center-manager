package cn.kunlong.center.core.util;


import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;

import org.springframework.beans.BeanUtils;

public class CollectionUtil {

	private CollectionUtil() {
	}
	/**
	 * 是否为空(包含null)
	 * @param col
	 * @return
	 */
	public static <T> boolean isEmpty(Collection<T> col){
		return col == null || col.isEmpty();
	}
	/**
	 * 取一个结果
	 * @param col
	 * @return
	 */
	public static <T> T uniqueResult(Collection<T> col) {
		if (col == null || col.isEmpty())
			return null;
		if (col.size() > 1) {
			throw new RuntimeException("期待返回1个结果,实际返回" + col.size()+"个结果");
		}
		return col.iterator().next();
	}
	
	public static <T> T getEntity(Collection<T> col,String property,Serializable key){
		if(col == null || col.isEmpty()){
			return null;
		}
		T t = col.iterator().next();
		String getMethodName = "get"+property.substring(0,1).toUpperCase()+property.substring(1,property.length());
		Method readMethod = BeanUtils.findMethodWithMinimalParameters(t.getClass(),getMethodName);
		for(T tmp:col){
			Object obj;
			try {
				obj = readMethod.invoke(tmp);
				if(key.equals(obj)){
					return tmp;
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			
		}
		return null;
	}
}
