package cn.integriti.center.core.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

	private StringUtil() {}
	public static boolean isNotBlank(CharSequence a) {
		return StringUtils.isNotBlank(a);
	}
	public static String trimToEmpty(String str) {
		return StringUtils.trimToEmpty(str);
	}
	public static boolean isBlank(CharSequence str) {
		return StringUtils.isBlank(str);
	}
}

