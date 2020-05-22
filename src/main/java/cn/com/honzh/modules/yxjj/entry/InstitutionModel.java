package cn.com.honzh.modules.yxjj.entry;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class InstitutionModel {

	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 机构名称
	 */
	@ApiModelProperty(value="机构名称",name="institutionName",required=true)
	private String institutionName;

	/**
	 * 封面图片路径
	 */
	@ApiModelProperty(value="封面图片路径",name="coverPhoto",required=false)
	private String coverPhoto;
	
	/**
	 * 省份
	 */
	@ApiModelProperty(value="省份",name="province",required=false)
	private String province;
	
	/**
	 * 城市
	 */
	@ApiModelProperty(value="省份",name="city",required=false)
	private String city;
	/**
	 * 县区
	 */
	@ApiModelProperty(value="县区",name="county",required=false)
	private String county;
	/**
	 * 机构类型1学历提升2成人教育3教师资格
	 */
	@ApiModelProperty(value="机构类型1学历提升2成人教育3教师资格",name="institutionType",required=false)
	private int institutionType;
	/**
	 * 年限
	 */
	@ApiModelProperty(value="年限",name="yearLimit",required=false)
	private String yearLimit;
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

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	
	public String getCoverPhoto() {
		return coverPhoto;
	}

	public void setCoverPhoto(String coverPhoto) {
		this.coverPhoto = coverPhoto;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public int getInstitutionType() {
		return institutionType;
	}

	public void setInstitutionType(int institutionType) {
		this.institutionType = institutionType;
	}

	public String getYearLimit() {
		return yearLimit;
	}

	public void setYearLimit(String yearLimit) {
		this.yearLimit = yearLimit;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
