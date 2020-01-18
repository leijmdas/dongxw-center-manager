package cn.kunlong.center.core.util;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * FastDFS文件操作
 * 
 * @author zz
 *
 */
public class FastDFSHelper {

	private FastDFSHelper() {
	}

	/**
	 * 上传
	 * 
	 * @param name
	 * @param fileExt
	 * @param bytes
	 * @param props
	 * @return
	 * @throws IOException
	 */
	public static String upload(String name, String fileExt, byte[] bytes, Map<String, String> props) throws Exception {

		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		NameValuePair nvp = new NameValuePair();
		nvp.setName("name");
		nvp.setValue(name);

		nvps.add(nvp);
		if (props != null) {
			for (Entry<String, String> entry : props.entrySet()) {

				NameValuePair tmp = new NameValuePair();
				tmp.setName(entry.getKey());
				tmp.setValue(entry.getValue());
				nvps.add(tmp);
			}
		}

		StorageClientExecutor<String> executor = new AbstractStorageClientExecutor<String>() {

			@Override
			public String execute(StorageClient storageClient) throws Exception {
				String[] results = storageClient.upload_file(bytes, fileExt, nvps.toArray(new NameValuePair[0]));

				return results[0] + "/" + results[1];
			}

		};
		return executor.execute();
	}

	/**
	 * 下载
	 * 
	 * @param group
	 * @param path
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	public static byte[] download(String group, String remoteFilename) throws Exception {
		StorageClientExecutor<byte[]> executor = new AbstractStorageClientExecutor<byte[]>() {

			@Override
			public byte[] execute(StorageClient storageClient) throws Exception {
				return storageClient.download_file(group, remoteFilename);
			}

		};
		return executor.execute();
	}

	public static Integer delete(String group, String remoteFilename) throws Exception {
		StorageClientExecutor<Integer> executor = new AbstractStorageClientExecutor<Integer>() {

			@Override
			public Integer execute(StorageClient storageClient) throws Exception {
				return storageClient.delete_file(group, remoteFilename);
			}

		};
		return executor.execute();
	}

	static interface StorageClientExecutor<T> {

		T execute() throws Exception;
	}

	static abstract class AbstractStorageClientExecutor<T> implements StorageClientExecutor<T> {

		@Override
		public T execute() throws Exception {
			// 创建一个TrackerClient对象。
			TrackerClient trackerClient = new TrackerClient();
			// 创建一个TrackerServer对象。
			TrackerServer trackerServer = trackerClient.getConnection();
			// 声明一个StorageServer对象，null。
			StorageServer storageServer = null;
			// 获得StorageClient对象。
			StorageClient storageClient = new StorageClient(trackerServer, storageServer);
			try {
				return this.execute(storageClient);
			} finally {
				try {
					if (trackerServer != null) {
						trackerServer.close();
					}
				} catch (Exception err) {
				}
			}
		}

		public abstract T execute(StorageClient storageClient) throws Exception ;
	}
}
