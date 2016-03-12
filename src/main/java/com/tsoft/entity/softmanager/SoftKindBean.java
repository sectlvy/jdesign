package com.tsoft.entity.softmanager;

import java.io.Serializable;
import java.sql.Timestamp;

import com.tsoft.entity.BaseBean;

public class SoftKindBean extends BaseBean  implements Serializable{
	private static final long serialVersionUID = -257625477814506512L;
	/*
	 * 分类ID
	 */
	private String kindId;
	/*
	 * 分类名称
	 */
	private String kindName;
	/*
	 * 分类存储路径
	 */
	private String savePath;
	/*
	 * 分类创建时间
	 */
	private Timestamp createTime;
	/*
	 * 分类删除时间（分类不允许直接删除，等删除时间到达一定的长度时，由系统自动删除）
	 */
	private Timestamp deleteTime;
	/*
	 * 分类显示位置（为一个以逗号隔开的字符串）
	 */
	private String showLocationId;
	public String getKindId() {
		return kindId;
	}
	public void setKindId(String kindId) {
		this.kindId = kindId;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getShowLocationId() {
		return showLocationId;
	}
	public void setShowLocationId(String showLocationId) {
		this.showLocationId = showLocationId;
	}
}
