package cn.kunlong.center.api;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据转换
 * @name DTFactory
 * @author zz  
 * @date 2018年12月19日  
 * @description:
 */
public class DTFactory {

	private DTFactory() {
		
	}
	@SuppressWarnings("rawtypes")
	private static Map<Class<?>,ITransformer> cache = new ConcurrentHashMap<Class<?>,ITransformer>();
	
	@SuppressWarnings("unchecked")
	public static <K extends ITransformer<S,T>, S,T> K getInstance(Class<K> clazz){
		if(cache.containsKey(clazz)) {
			return (K) cache.get(clazz);
		} else {
			try {
				K transformer = clazz.newInstance();
				cache.put(clazz, transformer);
				return transformer;
			} catch (InstantiationException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
