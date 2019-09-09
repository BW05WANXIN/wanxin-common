/**
 * 
 */
package com.wanxin.common.testUtils;

import org.junit.Test;

import com.wanxin.common.utils.StringUtil;

/**
 * @author 926474
 *
 */
public class TestStringUtil {
	
	@Test
	public void testHasText() {
		boolean hasText = StringUtil.hasText(" 是女的房价款和");
		System.out.println("是否有值："+hasText);
	}

}
