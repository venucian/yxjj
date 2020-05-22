package cn.com.honzh.modules.yxjj.entry;

import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class UserModel {

	/**
	 * 主键id
	 */
	private Integer id;
	
	/**
	 * 微信号
	 */
	
	private String wxID;
	@ApiModelProperty(value="openID",name="openID",required=false)
	private String openID;
	@ApiModelProperty(value="gender",name="性别",required=false)
	private String gender;
	@ApiModelProperty(value="city",name="城市",required=false)
	private String city;
	@ApiModelProperty(value="province",name="省份",required=false)
	private String province;
	@ApiModelProperty(value="country",name="国家",required=false)
	private String country;
	@ApiModelProperty(value="unionId",name="unionId",required=false)
	private String unionId;
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getOpenID() {
		return openID;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}

	/**
	 * 微信头像路径
	 */
	@ApiModelProperty(value="wxPhotoUrl",name="微信头像",required=false)
	private String wxPhotoUrl;
	/**
	 * 用户名
	 */
	@ApiModelProperty(value="loginName",name="用户名",required=false)
	private String loginName;
	@ApiModelProperty(value="nickName",name="匿名",required=false)
	private String nickName;
	/**
	 * 用户密码
	 */
	private String loginPwd;
	
	/**
	 * 最后登陆日期
	 */
	private String lastLoginDate;
	
	/**
	 * 身份证号
	 */
	@ApiModelProperty(value="idCardNo",name="身份证号",required=false)
	private String idCardNo;
	
	/**
	 * 联系电话
	 */
	@ApiModelProperty(value="contact",name="联系电话",required=false)
	private String contact;
	
	/**
	 * 用户类型 1:管理员 2:业务员
	 */
	@ApiModelProperty(value="userType",name="用户类型 1:管理员 2:业务员",required=false)
	private int userType;
	
	/**
	 * 总积分
	 */
	@ApiModelProperty(value="sumScore",name="总积分",required=false)
	private int sumScore;
	
	/**
	 * 推广人数
	 */
	@ApiModelProperty(value="promoteNumber",name="推广人数",required=false)
	private int promoteNumber;
	
	/**
	 * 家庭住址
	 */
	@ApiModelProperty(value="familyAddress",name="家庭住址",required=false)
	private String familyAddress;
	
	/**
	 * 现居住地址
	 */
	@ApiModelProperty(value="currentAddress",name="现居住地址",required=false)
	private String currentAddress;

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

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Object getDeleteUID() {
		return this.deleteUID;
	}

	public void setDeleteUID(Object deleteUID) {
		this.deleteUID = deleteUID;
	}

	public Date getDeleteDate() {
		return this.deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public Object getCreateUID() {
		return this.createUID;
	}

	public void setCreateUID(Object createUID) {
		this.createUID = createUID;
	}

	public Object getUpdateUID() {
		return this.updateUID;
	}

	public void setUpdateUID(Object updateUID) {
		this.updateUID = updateUID;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getWxID() {
		return wxID;
	}

	public void setWxID(String wxID) {
		this.wxID = wxID;
	}

	public String getWxPhotoUrl() {
		return wxPhotoUrl;
	}

	public void setWxPhotoUrl(String wxPhotoUrl) {
		this.wxPhotoUrl = wxPhotoUrl;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getSumScore() {
		return sumScore;
	}

	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}

	public int getPromoteNumber() {
		return promoteNumber;
	}

	public void setPromoteNumber(int promoteNumber) {
		this.promoteNumber = promoteNumber;
	}

	public String getFamilyAddress() {
		return familyAddress;
	}

	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	
	

}
