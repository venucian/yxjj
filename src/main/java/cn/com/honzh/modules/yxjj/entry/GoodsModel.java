package cn.com.honzh.modules.yxjj.entry;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class GoodsModel {

	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 商品标题
	 */
	@ApiModelProperty(value="商品标题",name="goodsTitle",required=false)
	private String goodsTitle;

	/**
	 * 商品名字
	 */
	@ApiModelProperty(value="商品名字",name="goodsName",required=true)
	private String goodsName;
	
	/**
	 * 商品颜色
	 */
	@ApiModelProperty(value="商品颜色",name="goodsColor",required=false)
	private String goodsColor;
	
	/**
	 * 商品重量
	 */
	@ApiModelProperty(value="商品重量",name="goodsWeight",required=false)
	private String goodsWeight;
	/**
	 * 商品详情
	 */
	@ApiModelProperty(value="商品详情",name="goodsContent",required=false)
	private String goodsContent;
	/**
	 * 1限时购2热门推荐3人气单品4新品
	 */
	@ApiModelProperty(value="1限时购2热门推荐3人气单品4新品",name="goodsType",required=false)
	private int goodsType;
	/**
	 * 活动结束时间
	 */
	@ApiModelProperty(value="活动结束时间",name="activityEndDate",required=false)
	private String activityEndDate;
	/**
	 * 商品顺序（可根据后管排序）
	 */
	@ApiModelProperty(value="商品顺序（可根据后管排序）",name="goodsSort",required=false)
	private int goodsSort;
	/**
	 * 商品价格
	 */
	@ApiModelProperty(value="商品价格",name="goodsPrice",required=false)
	private BigDecimal goodsPrice;
	/**
	 * 单个商品积分
	 */
	@ApiModelProperty(value="单个商品积分",name="goodScore",required=false)
	private int goodScore;
	/**
	 * 备注
	 */
	@ApiModelProperty(value="备注",name="goodsRemark",required=false)
	private String goodsRemark;
	
	/**
	 * 创建人
	 */
	private Object createUID;
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

	public String getGoodsTitle() {
		return goodsTitle;
	}

	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsColor() {
		return goodsColor;
	}

	public void setGoodsColor(String goodsColor) {
		this.goodsColor = goodsColor;
	}

	public String getGoodsWeight() {
		return goodsWeight;
	}

	public void setGoodsWeight(String goodsWeight) {
		this.goodsWeight = goodsWeight;
	}

	public String getGoodsContent() {
		return goodsContent;
	}

	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}

	public int getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(int goodsType) {
		this.goodsType = goodsType;
	}

	public String getActivityEndDate() {
		return activityEndDate;
	}

	public void setActivityEndDate(String activityEndDate) {
		this.activityEndDate = activityEndDate;
	}

	public int getGoodsSort() {
		return goodsSort;
	}

	public void setGoodsSort(int goodsSort) {
		this.goodsSort = goodsSort;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getGoodScore() {
		return goodScore;
	}

	public void setGoodScore(int goodScore) {
		this.goodScore = goodScore;
	}

	public String getGoodsRemark() {
		return goodsRemark;
	}

	public void setGoodsRemark(String goodsRemark) {
		this.goodsRemark = goodsRemark;
	}

	public Object getCreateUID() {
		return createUID;
	}

	public void setCreateUID(Object createUID) {
		this.createUID = createUID;
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
