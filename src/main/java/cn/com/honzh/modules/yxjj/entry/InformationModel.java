package cn.com.honzh.modules.yxjj.entry;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class InformationModel {

	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 机构名称
	 */
	@ApiModelProperty(value="机构名称",name="title",required=false)
	private String title;

	/**
	 * 封面图片路径
	 */
	@ApiModelProperty(value="封面图片路径",name="coverPhoto",required=false)
	private String coverPhoto;
	
	/**
	 * 图文内容
	 */
	@ApiModelProperty(value="图文内容",name="content",required=false)
	private String content;
	
	/**
	 * 排序
	 */
	@ApiModelProperty(value="排序",name="sort",required=false)
	private int sort;
	/**
	 * 阅读量
	 */
	@ApiModelProperty(value="阅读量",name="readNum",required=false)
	private int readNum;
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadNum() {
		return readNum;
	}

	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}

}
