package cn.kunlong.center.core.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 密码工具类
 * 
 * @author zz
 *
 */
public class PasswordUtil {
	private PasswordUtil() {
	}

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;

	private static SecureRandom random = new SecureRandom();

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	public static String entryptPassword(String password, byte[] saltBytes) {
		byte[] hashPassword;
		try {
			hashPassword = digest(password.getBytes(), HASH_ALGORITHM, saltBytes, HASH_INTERATIONS);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		return encodeToHex(hashPassword);
	}

	
	private static byte charToByte(char c) {   
	    return (byte) "0123456789ABCDEF".indexOf(c);   
	}  
	/**
	 * 生成随机的Byte[]作为salt.
	 * 
	 * @param numBytes
	 *            byte数组的大小
	 */
	public static byte[] generateSalt(int numBytes) {

		byte[] bytes = new byte[numBytes];
		random.nextBytes(bytes);
		return bytes;
	}

	/**
	 * 对字符串进行散列, 支持md5与sha1算法.
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance(algorithm);

		if (salt != null) {
			digest.update(salt);
		}

		byte[] result = digest.digest(input);

		for (int i = 1; i < iterations; i++) {
			digest.reset();
			result = digest.digest(result);
		}
		return result;
	}
	/**
	 * 转换为16进制字符串
	 * 
	 * @param src
	 * @return
	 */
	public static String encodeToHex(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}
	/**  
	 * 16进制转换为二进制
	 * @param hexString the hex string  
	 * @return byte[]  
	 */  
	public static byte[] hexStringToBytes(String hexString) {   
	    if (hexString == null || hexString.equals("")) {   
	        return null;   
	    }   
	    hexString = hexString.toUpperCase();   
	    int length = hexString.length() / 2;   
	    char[] hexChars = hexString.toCharArray();   
	    byte[] d = new byte[length];   
	    for (int i = 0; i < length; i++) {   
	        int pos = i * 2;   
	        d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));   
	    }   
	    return d;   
	}
	public static void main(String[] args) {
		String str = "admin";
		if (args.length > 0) {
			str = args[0];
		}
		System.out.println("password:" + str + ",encrpt:" + PasswordUtil.entryptPassword(str,PasswordUtil.generateSalt(8)));
	}
}
