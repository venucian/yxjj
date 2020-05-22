package cn.com.honzh.modules.yxjj.entry;


public class ResultUtil<T> {

	    // 响应业务状态
	    private Integer status;

	    // 响应消息
	    private String msg;

	    // 响应中的数据
	    private T data;

	    public Integer getStatus() {
	        return status;
	    }

	    public void setStatus(Integer status) {
	        this.status = status;
	    }

	    public String getMsg() {
	        return msg;
	    }

	    public void setMsg(String msg) {
	        this.msg = msg;
	    }

	    public T getData() {
	        return data;
	    }

	    public void setData(T data) {
	        this.data = data;
	    }

	    public ResultUtil(Integer status, String msg, T data) {
	        this.status = status;
	        this.msg = msg;
	        this.data = data;
	    }

	    public ResultUtil(T data) {
	        this.status = 2000;
	        this.msg = "success";
	        this.data = data;
	    }

	    public ResultUtil() {
	        this.status = 2001;
	        this.msg = "error";
	        this.data = null;
	    }

	    public static <T> ResultUtil<T> success(T data) {
	        return new ResultUtil<T>(data);
	    }

	    public static <T> ResultUtil<T> error(T data) {
	        return new ResultUtil<T>(2001, "error", data);
	    }

	    @Override
	    public String toString() {
	        return "ResultUtil [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	    }

	
}
