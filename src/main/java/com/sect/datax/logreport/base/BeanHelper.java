package com.sect.datax.logreport.base;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

public class BeanHelper {
    private static Logger log = Logger.getLogger(BeanHelper.class);
    /**
     * 
     * @param bean
     * @param beanTarget
     * @param outFileds ����Ҫ�ȶԵ��ֶ���
     * @return
     */
    public static boolean compare(Object bean, Object beanTarget, String... outFileds) {
	boolean isEq = true;
	Field[] fields = bean.getClass().getDeclaredFields();
	for (Field field : fields) {
	    field.setAccessible(true);
	    String property;
	    boolean isneedCompare = true;
	    if (outFileds != null) {
		for (String ofiled : outFileds) {
		    if (ofiled.equalsIgnoreCase(field.getName())) {
			isneedCompare = false;
		    }
		}
	    }
	    if (isneedCompare && !field.getName().equalsIgnoreCase("PKID")) {
		try {
		    property = BeanUtils.getProperty(bean, field.getName());
		    String propertyTarget = BeanUtils.getProperty(beanTarget, field.getName());
		    if (property != null) {
			if (!property.equals(propertyTarget)) {
			    isEq = false;
			}
		    } else {
			if (propertyTarget != null) {
			    isEq = false;
			}
		    }
		} catch (IllegalAccessException e) {
		    log.equals(e);
		} catch (InvocationTargetException e) {
		    log.equals(e);
		} catch (NoSuchMethodException e) {
		    log.equals(e);
		}
	    }
	}
	return isEq;
    }

    public static String getObjectPropertyStr(Object bean) {
	Field[] fields = bean.getClass().getDeclaredFields();
	StringBuffer beanStr = new StringBuffer();
	for (Field field : fields) {
	    field.setAccessible(true);
	    String property;
	    try {
		property = BeanUtils.getProperty(bean, field.getName());
		beanStr.append(" [").append(field.getName()).append(":").append(property).append("] ");
	    } catch (IllegalAccessException e) {
		log.equals(e);
	    } catch (InvocationTargetException e) {
		log.equals(e);
	    } catch (NoSuchMethodException e) {
		log.equals(e);
	    }
	}
	return beanStr.toString();
    }

    public static String getInsertSql(Object bean, String tableName) {
	return getInsertSql(bean, tableName, new String[] { "" });
    }

    /**
     * 
     * @param bean
     * @param tableName
     * @param filedNames
     *            ��Ҫ�ų���ֶ��� Pkid Ĭ���ų�
     * @return
     */
    public static String getInsertSql(Object bean, String tableName, String[] filedNames) {
	Field[] fields = bean.getClass().getDeclaredFields();
	String insertStr = "insert into " + tableName + " ( cloumnName ) values( colvalues)";
	String cloumnName = "";
	String colvalues = "";
	for (Field field : fields) {
	    field.setAccessible(true);
	    boolean isRemoveFiled = false;
	    for (String removeName : filedNames) {
		if (field.getName().equalsIgnoreCase(removeName)) {
		    isRemoveFiled = true;
		}
	    }
	    if (!field.getName().equalsIgnoreCase("pkid") && !isRemoveFiled) {
		cloumnName = cloumnName + field.getName() + ",";
		String propertyValue;
		try {
		    propertyValue = BeanUtils.getProperty(bean, field.getName());
		    colvalues = colvalues + "'" + propertyValue + "',";
		} catch (IllegalAccessException e) {
		    log.error(e);
		} catch (InvocationTargetException e) {
		    log.error(e);
		} catch (NoSuchMethodException e) {
		    log.error(e);
		}
	    }
	}
	cloumnName = cloumnName.substring(0, cloumnName.length() - 1);
	colvalues = colvalues.substring(0, colvalues.length() - 1);
	/** ����windows���ļ��зָ��� ���⴦�� ***/
	colvalues = replaceReg(colvalues.toString());
	insertStr = insertStr.replace("cloumnName", cloumnName).replace("colvalues", colvalues);
	return insertStr;
    }

    public static String getUpdateSql(Object bean, String tableName) {
	return getUpdateSql(bean, tableName, new String[] { "" });
    }

    public static void copySimlarProperty(Object sourceBean, Object targetBean) {
	Field[] fields = sourceBean.getClass().getDeclaredFields();
	for (Field sourceField : fields) {
	    Field[] targetfields = targetBean.getClass().getDeclaredFields();
	    for (Field targetField : targetfields) {
		if (sourceField.getName().equals(targetField.getName()) && sourceField.getType().equals(targetField.getType())) {
		    String sourceValue;
		    try {
			sourceValue = BeanUtils.getProperty(sourceBean, sourceField.getName());
			BeanUtils.setProperty(targetBean, sourceField.getName(), sourceValue);
		    } catch (IllegalAccessException e) {
			log.error(e);
		    } catch (InvocationTargetException e) {
			log.error(e);
		    } catch (NoSuchMethodException e) {
			log.error(e);
		    }
		}
	    }
	}
    }

    public static String getSelectWhereSql(Object bean) {
	Field[] fields = bean.getClass().getDeclaredFields();
	StringBuffer colvalues = new StringBuffer();
	for (Field field : fields) {
	    field.setAccessible(true);
	    boolean isRemoveFiled = false;
	    if (!field.getName().equalsIgnoreCase("pkid") && !isRemoveFiled) {
		try {
		    String sourceValue = BeanUtils.getProperty(bean, field.getName());
		    if (!field.getType().equals(float.class) && !field.getType().equals(double.class)) {
			if (sourceValue != null && sourceValue.length() > 0 && !sourceValue.equals("")
				&& !sourceValue.equals("null")) {
			    colvalues.append(field.getName()).append("='").append(sourceValue).append("' and ");
			}
		    }
		} catch (IllegalAccessException e) {
		    log.error(e);
		} catch (InvocationTargetException e) {
		    log.error(e);
		} catch (NoSuchMethodException e) {
		    log.error(e);
		}
	    }
	}
	String colStr = replaceReg(colvalues.toString());
	return " where " + colStr.substring(0, colStr.length() - 4);
    }

    /**
     * @param filedNames
     *            ��ݿ���û�е� ��Ҫ�ų��
     */
    public static String getUpdateSql(Object bean, String tableName, String[] filedNames) {
	Field[] fields = bean.getClass().getDeclaredFields();
	String updateStr;
	try {
	    updateStr = "update " + tableName + " set setKeyValueStr" + " where pkid=" + BeanUtils.getProperty(bean, "pkid");
	    String setKeyValueStr = "";
	    for (Field field : fields) {
		field.setAccessible(true);
		boolean isRemoveFiled = false;
		for (String removeName : filedNames) {
		    if (field.getName().equalsIgnoreCase(removeName)) {
			isRemoveFiled = true;
		    }
		}
		if (!field.getName().equalsIgnoreCase("pkid") && !isRemoveFiled) {
		    String propertyValue = BeanUtils.getProperty(bean, field.getName());
		    propertyValue = "'" + propertyValue + "',";
		    setKeyValueStr = setKeyValueStr + field.getName() + "=" + propertyValue;
		}
	    }
	    setKeyValueStr = replaceReg(setKeyValueStr);
	    setKeyValueStr = setKeyValueStr.substring(0, setKeyValueStr.length() - 1);
	    return updateStr.replace("setKeyValueStr", setKeyValueStr);
	} catch (IllegalAccessException e) {
	    log.error(e);
	} catch (InvocationTargetException e) {
	    log.error(e);
	} catch (NoSuchMethodException e) {
	    log.error(e);
	}
	return null;
    }

    private static String replaceReg(String setKeyValueStr) {
	if (setKeyValueStr.indexOf("\\") > 0) {
	    setKeyValueStr = setKeyValueStr.replace("\\", "\\\\");
	}
	if (setKeyValueStr.indexOf("null") >= 0) {
	    setKeyValueStr = setKeyValueStr.replace("null", "");
	}
	return setKeyValueStr;
    }

    public static void setTOBean(DynaBean dBean, Object bean) {
	Field[] fields = bean.getClass().getDeclaredFields();
	for (Field field : fields) {
	    field.setAccessible(true);
	    try {
		Object propertyValue = PropertyUtils.getSimpleProperty(dBean, field.getName());
		if(propertyValue!=null && !propertyValue.equals("null")){
		    field.set(bean, PropertyUtils.getSimpleProperty(dBean, field.getName()));
		}
	    } catch (IllegalArgumentException e) {
		log.error(e);
	    } catch (IllegalAccessException e) {
		log.error(e);
	    } catch (InvocationTargetException e) {
		log.error(e);
	    } catch (NoSuchMethodException e) {
		log.error(e);
	    }
	}
    }
}
