package com.example.utils;


/**
 * ResponseMesg
 */
public class ResponseMesg  {

     // 响应业务状态
     private Integer status;
     // 响应消息
     private String msg;
     // 响应中的数据
     private Object data;
     private String ok; // 不使用
 
     public Integer getStatus() {
         return status;
     }
 
     public String getOk() {
         return ok;
     }
 
     public void setOk(String ok) {
         this.ok = ok;
     }
 
     public Object getData() {
         return data;
     }
 
     public void setData(Object data) {
         this.data = data;
     }
 
     public String getMsg() {
         return msg;
     }
 
     public void setMsg(String msg) {
         this.msg = msg;
     }
 
     public void setStatus(Integer status) {
         this.status = status;
     }
 
     /**
      * 构造函数
      */
     public ResponseMesg() {
     }
 
     public ResponseMesg(Integer status, String msg, Object data) {
         this.status = status;
         this.msg = msg;
         this.data = data;
     }
 
     public ResponseMesg(Object data) {
         this.status = 200;
         this.msg = "OK";
         this.data = data;
     }

    /**
     * 成功调用不需要返回json
     * 
     * @return
     */
    public static ResponseMesg ok() {
        return new ResponseMesg(null);
    }

    /**
     * 成功调用
     * 
     * @param data
     * @return
     */
    public static ResponseMesg ok(Object data) {
        return new ResponseMesg(data);
    }

    /**
     * 失败调用
     * 
     * @param msg
     * @return
     */
    public static ResponseMesg errorMsg(String msg) {
        return new ResponseMesg(500, msg, null);
    }

}