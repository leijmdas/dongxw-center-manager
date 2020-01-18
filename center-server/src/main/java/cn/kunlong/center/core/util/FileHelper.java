package cn.kunlong.center.core.util;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.util.StringUtils;

public class FileHelper {

	private FileHelper() {
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @param filename
	 * @return
	 */
	public static String getFileExtByFilename(String filename) {
		if (StringUtils.trimWhitespace(filename).indexOf(".") < 0)
			return "";

		String fileExt = filename.substring(filename.lastIndexOf("."));
		return fileExt.toLowerCase();
	}

	public static String getFileExt(File file) {
		return getFileExtByFilename(file.getName());
	}

	public static byte[] file2byte(File file) throws IOException {
		return stream2byte(new FileInputStream(file));
	}
	/**
	 * 将流转到字节
	 * @param fis
	 * @return
	 * @throws IOException
	 */
	public static byte[] stream2byte(InputStream fis) throws IOException {
		byte[] buffer = null;
		ByteArrayOutputStream bos = null;

		try {
			bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
		} finally {
			try {
				fis.close();
			} catch (Exception e) {

			}
			try {
				bos.close();
			} catch (Exception e) {
			}
		}
		buffer = bos.toByteArray();
		return buffer;
	}
}
