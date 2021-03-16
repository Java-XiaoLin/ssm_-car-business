package cn.linstudy.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class FileUploadUtil {

	/**
	 * 文件上传
	 * @param file
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static String uploadFile(MultipartFile file, String path)
			throws Exception {
		//获取随机值
		String uuid = UUID.randomUUID().toString();
		//获取文件原本的名字
		String fileName = file.getOriginalFilename();
		//获取拓展名，含头不含尾
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		// 拼接上传后的文件名称
		fileName = "/upload/" + uuid + fileType;
		File targetFile = new File(path, fileName);
		//把输入流传进去, 会把内容写到目标文件
		FileUtils.copyInputStreamToFile(file.getInputStream(),targetFile);
		return fileName;
	}

	/**
	 * 删除文件
	 * @param pic
	 */
	public static void deleteFile(String pic) {
		File file=new File(pic);
		if(file.exists()) file.delete();
	}
}
