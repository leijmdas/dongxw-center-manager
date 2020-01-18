package cn.kunlong.center.web.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import cn.kunlong.center.core.util.StringUtil;

public class WebFileUtil extends FileUtils {
	private HttpServletRequest request;
	private HttpServletResponse response;

	public WebFileUtil(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public static final String DIR_TEMPLATE = "/templates";

	public static String getFileExtByFilename(String filename) {
		if (StringUtil.trimToEmpty(filename).indexOf(".") < 0)
			return "";

		String fileExt = filename.substring(filename.lastIndexOf("."));
		return fileExt;
	}

	public static String getFileExt(File file) {
		return getFileExtByFilename(file.getName());
	}

	public static File getTemplateDir(HttpServletRequest request) {
		// 获取项目根目录
		//String ctxPath = request.getSession().getServletContext().getRealPath("");

		// 获取下载文件
		URL path = WebFileUtil.class.getResource(DIR_TEMPLATE);
		return new File(path.getFile());
	}

	public static File getTemplate(HttpServletRequest request, String fileName) {
		return new File(getTemplateDir(request), fileName);
	}

	public File getTemplate(String fileName) {
		return new File(getTemplateDir(request), fileName);
	}

	public String getOutputAttachementFilename(String filename) throws UnsupportedEncodingException {
		String userAgent = this.request.getHeader("User-Agent");
		String new_filename = URLEncoder.encode(filename, "UTF8");
		// 如果没有UA，则默认使用IE的方式进行编码，因为毕竟IE还是占多数的
		String rtn = "filename=\"" + new_filename + "\"";
		if (userAgent != null) {
			userAgent = userAgent.toLowerCase();
			// IE浏览器，只能采用URLEncoder编码
			if (userAgent.indexOf("msie") != -1) {
				rtn = "filename=\"" + new_filename + "\"";
			}
			// Opera浏览器只能采用filename*
			else if (userAgent.indexOf("opera") != -1) {
				rtn = "filename*=UTF-8''" + new_filename;
			}
			// Safari浏览器，只能采用ISO编码的中文输出
			else if (userAgent.indexOf("safari") != -1) {
				rtn = "filename=\"" + new String(filename.getBytes("UTF-8"), "ISO8859-1") + "\"";
			}
			
			// FireFox浏览器，可以使用MimeUtility或filename*或ISO编码的中文输出
			else if (userAgent.indexOf("mozilla") != -1) {
				rtn = "filename*=UTF-8''" + new_filename;
			}
		}
		return rtn;
	}

	public void saveWorkbook(org.apache.poi.ss.usermodel.Workbook resultWorkbook, String fileName) throws IOException {
		OutputStream os = response.getOutputStream();
		try {
			response.setHeader("content-disposition", "attachment;  filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			response.setContentType("application/msexcel");
			resultWorkbook.write(os);
			os.flush();
		} finally {
			try {
				os.close();
			} catch (Exception e) {
			}
		}
	}
	
	public void write2Response(File file) throws IOException{
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		// 获取输入流
		bis = new BufferedInputStream(new FileInputStream(file));
		// 输出流
		bos = new BufferedOutputStream(response.getOutputStream());
		try {
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} finally {
			// 关闭流
			try {
				bis.close();
			} catch (Exception bisEx) {

			}
			try {
				bos.close();
			} catch (Exception bosEx) {

			}
		}
	}
	
	public void writeAttachment2Response(String outputFilename,File file) throws IOException{
		// 获取文件的长度
		long fileLength = file.length();
		// 设置文件输出类型
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;" + this.getOutputAttachementFilename(outputFilename));
		// 设置输出长度
		response.setHeader("Content-Length", String.valueOf(fileLength));
		write2Response(file);
	}
}
