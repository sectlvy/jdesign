package com.tsoft.service;

import com.tsoft.entity.softmanager.SoftBean;

public interface SoftService {
	/*
	 * 创建一条新的soft记录
	 */
	public int addSoft(SoftBean softBean);
}
