package cn.kunlong.center.api.provider;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.config.annotation.Service;

import cn.kunlong.center.api.dto.FileInfoDTO;
import cn.kunlong.center.api.service.FileApiService;
import cn.kunlong.center.core.util.FastDFSHelper;
@Service(version = "${dubbo.service.version}")
public class FileApiProvider implements FileApiService {

	@Value("${file.server}")
	private String fileServer;
	@Override
	public FileInfoDTO upload(String name, String ext, byte[] bytes, Map<String, String> props) {
		FileInfoDTO r = new FileInfoDTO();
		try {
			String path = FastDFSHelper.upload(name, ext,
					bytes, null);
			r.setExt(ext);
			r.setName(name);
			r.setPath(fileServer + "/" + path);
			r.setSize((long)bytes.length);
			return r;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public byte[] download(String groupName, String remoteFileName) {
		try {
			byte[] content = FastDFSHelper.download(groupName, remoteFileName);
			return content;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
