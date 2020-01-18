package cn.kunlong.center.core.util;


import java.security.GeneralSecurityException;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class SecurityUtil {
	private static final String DES = "DES";
	
	private SecurityUtil(){}
	public static String md5(String _str) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = _str.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}

			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String encodeBase64(String encodeStr) {
		
		return Base64.encode(encodeStr.getBytes());
	}

	public static String decodeBase64(String decodeStr) {
		
		byte[] decodeBytes = Base64.decode(decodeStr);
		return new String(decodeBytes);
	}
	
	 /**
     * 使用DES加密或解密无编码的原始字节数组, 返回无编码的字节数组结果.
     * 
     * @param inputBytes
     *            原始字节数组
     * @param keyBytes
     *            符合DES要求的密钥
     * @param mode
     *            Cipher.ENCRYPT_MODE 或 Cipher.DECRYPT_MODE
     */
    public static byte[] des(byte[] inputBytes, byte[] keyBytes, int mode) {
        try {
            DESKeySpec desKeySpec = new DESKeySpec(keyBytes);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            
            Cipher cipher = Cipher.getInstance(DES);
            cipher.init(mode, secretKey);
            return cipher.doFinal(inputBytes);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }
}
