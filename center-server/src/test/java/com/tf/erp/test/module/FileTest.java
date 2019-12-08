package com.tf.erp.test.module;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Properties;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.tf.erp.test.BaseTest;

import cn.integriti.center.core.util.FastDFSHelper;
import cn.integriti.center.core.util.FileHelper;

public class FileTest extends BaseTest {

	@Test
	public void test4Upload() throws Exception {
		FileInputStream in = new FileInputStream(new File("E:/apps/2.png"));
		byte[] bytes = FileHelper.stream2byte(in);
		FastDFSHelper.upload("2.png", ".png", bytes, new HashMap());
	}
	
	@Test
	public void testOrgin() throws Exception{
		Properties props = new Properties();
		props.put(ClientGlobal.PROP_KEY_TRACKER_SERVERS, "47.106.116.213:22122");
		ClientGlobal.initByProperties(props);
		TrackerClient trackerClient = new TrackerClient();
		// 创建一个TrackerServer对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 声明一个StorageServer对象，null。
		StorageServer storageServer = null;
		// 获得StorageClient对象。
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		
		FileInputStream in = new FileInputStream(new File("E:/apps/2.png"));
		byte[] bytes = FileHelper.stream2byte(in);
		storageClient.upload_file(bytes, ".png", null);
	}
}
