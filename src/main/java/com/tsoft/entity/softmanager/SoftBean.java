package com.tsoft.entity.softmanager;

import java.io.Serializable;

import org.apache.struts.upload.FormFile;

import com.mysql.jdbc.Blob;
import com.tsoft.entity.BaseBean;

public class SoftBean extends BaseBean implements Serializable {
	private static final long serialVersionUID = -3913635297331947838L;
	/*
	 * 软件ID	
	 */
	private String softId;
	/*
	 * 软件名称
	 */
	private String softName;
	/*
	 * 软件存储路径 为相对该软件分类的相对路径
	 */
	private String savePath;
	/*
	 * 软件创建时间
	 */
	private String createTime;
	/*
	 * 软件删除时间
	 */
	private String deleteTime;
	/*
	 * 软件显示位置（软件可以独立于分类而在特定地点特别显示）
	 */
	private String showLocationId;
	
	/*
	 * 设置该软件是否需要根据分类显示
	 */
	private String isShowByKind;
	/*
	 * 设置该软件是否可以独立于分类显示
	 * 只有当isShowBySelf为真时
	 * showLocationId 才可以有值
	 */
	private String isShowBySelf;
	
	/*
	 * 软件所属分类
	 */
	private String kindId;
	/*
	 * 软件描述
	 */
	private String description;
	/*
	 * 软件说明附件存储位置
	 */
	private String desSavePath;
	/*
	 * 软件启动下载时间
	 */
	private String startDownloadTime;
	/*
	 * the soft to file  disk system
	 */
	private FormFile fileContent;
	
	/*
	 * the help document for this soft file 
	 * this document file will load to the database
	 */
	private FormFile fileAttachment;
	
	/*
	 * this to fild is to save the soft file and helper document content to database
	 * if you will save file to disk system please not use it
	 */
	private Blob fileContentBlob;
	private Blob fileAttachmentBlob;
	
	
	public Blob getFileContentBlob() {
		return fileContentBlob;
	}
	public void setFileContentBlob(Blob fileContentBlob) {
		this.fileContentBlob = fileContentBlob;
	}
	public Blob getFileAttachmentBlob() {
		return fileAttachmentBlob;
	}
	public void setFileAttachmentBlob(Blob fileAttachmentBlob) {
		this.fileAttachmentBlob = fileAttachmentBlob;
	}
	public FormFile getFileAttachment() {
		return fileAttachment;
	}
	public void setFileAttachment(FormFile fileAttachment) {
		this.fileAttachment = fileAttachment;
	}
	public FormFile getFileContent() {
		return fileContent;
	}
	public void setFileContent(FormFile fileContent) {
		this.fileContent = fileContent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDesSavePath() {
		return desSavePath;
	}
	public void setDesSavePath(String desSavePath) {
		this.desSavePath = desSavePath;
	}
	public String getStartDownloadTime() {
		return startDownloadTime;
	}
	public void setStartDownloadTime(String startDownloadTime) {
		this.startDownloadTime = startDownloadTime;
	}
	public String getKindId() {
		return kindId;
	}
	public void setKindId(String kindId) {
		this.kindId = kindId;
	}
	public String getSoftId() {
		return softId;
	}
	public void setSoftId(String softId) {
		this.softId = softId;
	}
	public String getSoftName() {
		return softName;
	}
	public void setSoftName(String softName) {
		this.softName = softName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getShowLocationId() {
		return showLocationId;
	}
	public void setShowLocationId(String showLocationId) {
		this.showLocationId = showLocationId;
	}
	public String getIsShowByKind() {
		return isShowByKind;
	}
	public void setIsShowByKind(String isShowByKind) {
		this.isShowByKind = isShowByKind;
	}
	public String getIsShowBySelf() {
		return isShowBySelf;
	}
	public void setIsShowBySelf(String isShowBySelf) {
		this.isShowBySelf = isShowBySelf;
	}
}
