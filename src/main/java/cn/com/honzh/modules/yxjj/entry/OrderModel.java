package cn.com.honzh.modules.yxjj.entry;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class OrderModel {

	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * openID
	 */
	@ApiModelProperty(value="openID",name="openID",required=false)
	private String openID;

	/**
	 * 订单号
	 */
	@ApiModelProperty(value="orderCode",name="订单号",required=false)
	private String orderCode;
	
	/**
	 * 商品id
	 */
	@ApiModelProperty(value="goodsID",name="商品ID",required=false)
	private String goodsID;
	
	/**
	 * 商品数量
	 */
	@ApiModelProperty(value="goodsNumber",name="商品数量",required=false)
	private int goodsNumber;
	/**
	 * 付款方式 1为现金购买 2积分购买
	 */
	private int payType;
	/**
	 * 1限时购2热门推荐3人气单品4新品
	 */
	private BigDecimal orderTheoryAmount;
	/**
	 * 订单实际金额
	 */
	private BigDecimal orderFactAmount;
	/**
	 * 消耗积分
	 */
	private int consumeScore;
	/**
	 * 配送方式（顺丰快递）
	 */
	private String sendType;
	/**
	 * 订单地址
	 */
	private String orderAddress;
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

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}

	public int getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public BigDecimal getOrderTheoryAmount() {
		return orderTheoryAmount;
	}

	public void setOrderTheoryAmount(BigDecimal orderTheoryAmount) {
		this.orderTheoryAmount = orderTheoryAmount;
	}

	public BigDecimal getOrderFactAmount() {
		return orderFactAmount;
	}

	public void setOrderFactAmount(BigDecimal orderFactAmount) {
		this.orderFactAmount = orderFactAmount;
	}

	public int getConsumeScore() {
		return consumeScore;
	}

	public void setConsumeScore(int consumeScore) {
		this.consumeScore = consumeScore;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
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

}
