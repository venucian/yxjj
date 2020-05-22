package cn.com.honzh.core;

/**
 * 表类型枚举
 * @author peng.li
 * @date 2019年1月12日
 * @company 洛阳鸿卓电子信息技术有限公司
 */
public enum TableTypeEnum {
	
    /**
     * 用户表sys_user
     */
    TABLE_SYS_USER(1, "%s对用户表sys_user进行%s操作"),
    
    
    /**
     * 客户表sys_client
     */
    TABLE_SYS_CLIENT(2, "%s客户表sys_client进行%s操作"),
    
    /**
     * 企业表involved_enterprise_info
     */
    TABLE_INVOLVED_ENTERPRISE_INFO(3, "%s对企业表involved_enterprise_info进行%s操作"),
	
	/**
     * 用资产表involved_assetslist_info
     */
	TABLE_INVOLVED_ASSETSLIST_INFO(4,"%s对资产表involved_assetslist_info");
	
	/**
	 * App端相关接口
	 */
	public static final String APP_GET_CLIENTDETAIL_BYID = "/crm/app/appGetClientDetailByID.do";
	public static final String APP_GET_CLIENTLIST = "/crm/app/appGetClientList.do";
	public static final String APP_GET_INVOLVEDASSETS_LIST = "/crm/app/appGetInvolvedAssetsList.do";
	public static final String APP_GET_INVOLVEDENTERPRISE_LIST = "/crm/app/appGetInvolvedEnterpriseList.do";
	public static final String APPLOGIN = "/crm/app/appLogin.do";
	
	/**
	 * pc端相关接口
	 */
	public static final String ADD_CLIENT = "/crm/client/addClient.do";
	public static final String DELETE_CLIENT_LIST = "/crm/client/deleteClientList.do";
	public static final String GET_CLIENT_LIST = "/crm/client/getClientList.do";
	
	public static final String ADD_INVOLVED_ASSETSLIST_INFO = "/crm/enterprise/addInvolvedAssetslistInfo.do";
	public static final String ADD_INVOLVED_ENTERPRISE_INFO = "/crm/enterprise/addInvolvedEnterpriseInfo.do";
	public static final String DELETE_INVOLVED_ASSETSLIST = "/crm/enterprise/deleteInvolvedAssetsList.do";
	public static final String DELETE_INVOLVED_ENTERPRISEINFO_BYID = "/crm/enterprise/deleteInvolvedEnterpriseInfoByID.do";
	public static final String GET_INVOLVED_ASSETSLIST = "/crm/enterprise/getInvolvedAssetsList.do";
	public static final String GET_INVOLVED_ENTERPRISELIST = "/crm/enterprise/getInvolvedEnterpriseList.do";
	
	public static final String ADD_USER = "/crm/user/addUser.do";
	public static final String DELETE_USER_LIST = "/crm/user/deleteUserList.do";
	public static final String GET_USER_LIST = "/crm/user/getUserList.do";
	public static final String LOGIN = "/crm/user/login.do";
    
    private Integer type;
    
    private String name;
    
    private TableTypeEnum(Integer type, String name){
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
