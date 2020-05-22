package cn.com.honzh.modules.yxjj.entry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class ApplyerModel {

	/**
	 * 主键id
	 */
	@ApiModelProperty(value="主键id",name="id")
	private Integer id;
	/**
	 * 申请的机构或者院校名字
	 */
	@ApiModelProperty(value="申请的机构或者院校名字",name="orgName",required=true)
	private String orgName;

	/**
	 * 负责人名字
	 */
	@ApiModelProperty(value="负责人名字",name="applyerName",required=true)
	private String applyerName;
	
	/**
	 * 负责人电话
	 */
	@ApiModelProperty(value="负责人电话",name="applyerPhone",required=true)
	private String applyerPhone;
	
	/**
	 * 申请类型 1机构 2院校 3个人
	 */
	@ApiModelProperty(value="申请类型 1机构 2院校 3个人",name="applyType",required=true)
	private int applyType;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getApplyerName() {
		return applyerName;
	}

	public void setApplyerName(String applyerName) {
		this.applyerName = applyerName;
	}

	public String getApplyerPhone() {
		return applyerPhone;
	}

	public void setApplyerPhone(String applyerPhone) {
		this.applyerPhone = applyerPhone;
	}

	public int getApplyType() {
		return applyType;
	}

	public void setApplyType(int applyType) {
		this.applyType = applyType;
	}

}
