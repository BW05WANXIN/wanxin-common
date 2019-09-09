/**
 * 
 */
package com.wanxin.common.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author 926474
 *
 */
public class StreamUtil {
	/**
	 * 关闭流
	 * @param closeables
	 * @throws IOException
	 */
	public static void closeStream(Closeable ...closeables) throws IOException {
		for (Closeable closeable : closeables) {
			closeable.close();
		}
	}
	
	public static void copyStream(InputStream is,OutputStream os) throws IOException {
		byte b[]=new byte[1024];
		while(is.read(b)>0) {
			os.write(b);
		}
		os.flush();
	}
}
