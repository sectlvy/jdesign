package com.sect.datax.logreport.base;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

public abstract class BaseBean {
    private Logger log = Logger.getLogger(BaseBean.class);

    public abstract String getTableName();

    @Override
    public String toString() {
	StringBuffer strbu = new StringBuffer(this.getClass().getName() + ":��");
	Field[] fields = this.getClass().getDeclaredFields();
	for (Field field : fields) {
	    field.setAccessible(true);
	    String property;
	    try {
		property = BeanUtils.getProperty(this, field.getName());
		strbu.append(field.getName()).append("=").append(property).append(",");
	    } catch (IllegalAccessException e) {
		log.error(e);
	    } catch (InvocationTargetException e) {
		log.error(e);
	    } catch (NoSuchMethodException e) {
		log.error(e);
	    }
	}
	return strbu.substring(0, strbu.length() - 1) + "��";
    }
}
