package cn.integriti.center.api.service;

import java.util.Map;

import cn.integriti.center.api.dto.FileInfoDTO;

public interface FileApiService {

	/**
	 * 上传
	 * @param name
	 * @param ext
	 * @param bytes
	 * @param props
	 * @return
	 */
	FileInfoDTO upload(String name,String ext,byte[] bytes,Map<String, String> props);
	
	/**
	 * 下载
	 * @param groupName
	 * @param remoteFileName
	 * @return
	 */
	byte[] download(String groupName, String remoteFileName);
}
