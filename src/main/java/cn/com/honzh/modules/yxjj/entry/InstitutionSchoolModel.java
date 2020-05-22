package cn.com.honzh.modules.yxjj.entry;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class InstitutionSchoolModel {

	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 机构ID
	 */
	@ApiModelProperty(value="institutionID",name="机构ID",required=false)
	private String institutionID;
	/**
	 * 学校名称
	 */
	@ApiModelProperty(value="schoolName",name="学校名称",required=false)
	private String schoolName;

	/**
	 * 学校封面图片路径
	 */
	@ApiModelProperty(value="coverPhoto",name="学校封面图片路径",required=false)
	private String coverPhoto;
	
	/**
	 * 备注（如专升本 美术教育 考证等）
	 */
	@ApiModelProperty(value="remark",name="备注（如专升本 美术教育 考证等）",required=false)
	private String remark;
	/**
	 * 排序
	 */
	private int sort;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新人
	 */
	private Object updateUID;
	/**
	 * 更新时间
	 */
	private Date updateDate;
	/**
	 * 删除人
	 */
	private Object deleteUID;
	/**
	 * 删除时间
	 */
	private Date deleteDate;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInstitutionID() {
		return institutionID;
	}

	public void setInstitutionID(String institutionID) {
		this.institutionID = institutionID;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = new Date();
	}

	public Object getUpdateUID() {
		return updateUID;
	}

	public void setUpdateUID(Object updateUID) {
		this.updateUID = updateUID;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate =  new Date();
	}

	public Object getDeleteUID() {
		return deleteUID;
	}

	public void setDeleteUID(Object deleteUID) {
		this.deleteUID = deleteUID;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate =  new Date();
	}
	
	public String getCoverPhoto() {
		return coverPhoto;
	}

	public void setCoverPhoto(String coverPhoto) {
		this.coverPhoto = coverPhoto;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
