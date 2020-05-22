package cn.com.honzh.modules.yxjj.entry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class DataModel {
	
	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 1院校2专业3.提升层次4.上课类型5.学制6.科类
	 */
	@ApiModelProperty(value="1院校2专业3.提升层次4.上课类型5.学制6.科类",name="dataCode",required=true)
	private int dataCode;

	/**
	 * 名称
	 */
	@ApiModelProperty(value="名称",name="dataName",required=true)
	private String dataName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getDataCode() {
		return dataCode;
	}

	public void setDataCode(int dataCode) {
		this.dataCode = dataCode;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	
}
