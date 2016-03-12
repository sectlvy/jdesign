package com.tsoft.service.impl;

import com.tsoft.dao.SoftDao;
import com.tsoft.entity.softmanager.SoftBean;
import com.tsoft.service.SoftService;

public class SoftServiceImpl implements SoftService {
	
	private SoftDao tsoftDao;
	public int addSoft(SoftBean softBean) {
		return tsoftDao.addSoft(softBean);
	}

}
