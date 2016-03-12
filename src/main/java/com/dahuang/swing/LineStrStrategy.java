package com.dahuang.swing;

import java.io.BufferedReader;

/**
 * 单行数据处理策略
 * @author Administrator
 *
 */
public interface LineStrStrategy {
	FileDataBean getResDataBean(BufferedReader bufferedReader);
}
