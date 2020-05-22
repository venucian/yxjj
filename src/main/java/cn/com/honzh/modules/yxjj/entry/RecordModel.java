package cn.com.honzh.modules.yxjj.entry;

import java.util.Date;

import io.swagger.annotations.ApiModel;
@ApiModel
public class RecordModel {

	/**
	 * 主键id
	 */
	private Integer id;
	
	private String openID;
	/**
	 * 用户id
	 */
	private int userID;
	

	/**
	 * 签到日期
	 */
	private Date signDate;
	
	/**
	 * 商品颜色
	 */
	private String threeCount;
	
	/**
	 * 商品重量
	 */
	private String sevenCount;
	/**
	 * 商品详情
	 */
	private String fourteenCount;
	/**
	 * 1限时购2热门推荐3人气单品4新品
	 */
	private int totalCount;
	
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

	public String getOpenID() {
		return openID;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public String getThreeCount() {
		return threeCount;
	}

	public void setThreeCount(String threeCount) {
		this.threeCount = threeCount;
	}

	public String getSevenCount() {
		return sevenCount;
	}

	public void setSevenCount(String sevenCount) {
		this.sevenCount = sevenCount;
	}

	public String getFourteenCount() {
		return fourteenCount;
	}

	public void setFourteenCount(String fourteenCount) {
		this.fourteenCount = fourteenCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
		this.updateDate = updateDate;
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
		this.deleteDate = deleteDate;
	}

}
