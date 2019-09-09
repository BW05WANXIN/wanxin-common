/**
 * 
 */
package com.wanxin.common.utils;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * @author 926474
 *
 */
public class FileUtil {
	public static Logger logger=Logger.getLogger(FileUtil.class);
	
	
	
	public static String getSuffix(String fileName) {
		
		int dotIndex = fileName.lastIndexOf('.');
		// 没有扩展名
		if (dotIndex<0) {
			return "";
		}
		// 最后一位是'.'
		if (dotIndex>=fileName.length()) {
			return "";
		}
	
		return fileName.substring(dotIndex);
		
		//return fileName.substring(fileName.lastIndexOf('.'));
	}
	
	
	/**
	 * 删除文件 若有目录则删除子目录中所有文件
	 * 使用递归删除
	 * @param path
	 */
	public static void delFilePath(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			return;// 不存在直接返回
		}
		if(file.isFile()) {
			// 是文件直接删除再返回
			file.delete();
			return;
		}
		if (file.isDirectory()) {
			// 是目录 遍历
			String[] list = file.list();
			for (String subPath : list) {
				System.out.println(subPath);
				// 得到子文件路径
				// 调用删除功能
				delFilePath(fileName+"\\"+subPath);
			}
			file.delete();
		}
		logger.info(fileName);
	}
	
	
	/**
	 * 获取系统属性
	 */
	public static String getSystemProperty(String key) {
		String property = System.getProperty(key);
		return property;
	}
}
