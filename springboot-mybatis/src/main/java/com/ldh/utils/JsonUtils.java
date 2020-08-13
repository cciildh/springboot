package com.ldh.utils;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * JsonUtils
 */
public class JsonUtils {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

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

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    /**
     * 构造函数
     */
    public JsonUtils() {
    }

    public JsonUtils(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JsonUtils(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    /**
     * 成功调用不需要返回json
     * 
     * @return
     */
    public static JsonUtils ok() {
        return new JsonUtils(null);
    }

    /**
     * 成功调用
     * 
     * @param data
     * @return
     */
    public static JsonUtils ok(Object data) {
        return new JsonUtils(data);
    }

    /**
     * 失败调用
     * 
     * @param msg
     * @return
     */
    public static JsonUtils errorMsg(String msg) {
        return new JsonUtils(500, msg, null);
    }

    /**
     * 将对象转换成json字符串。
     * <p>
     * Title: pojoToJson
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     * 
     * @param jsonData json数据
     * @param clazz    对象中的object类型
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象list
     * <p>
     * Title: jsonToList
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * <h6>功能:验证参数信息是否有效</h6>
     * 
     * @param bindingResult
     * @return
     */
    private static String myValidate(BindingResult bindingResult) {
        StringBuffer sbf = new StringBuffer();
        if (bindingResult.hasErrors()) {

            // 获取错误字段信息集合
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();

            // 使用TreeSet是为了让输出的内容有序输出(默认验证的顺序是随机的)
            Set<String> errorInfoSet = new TreeSet<String>();
            for (FieldError fieldError : fieldErrorList) {
                // 遍历错误字段信息
                errorInfoSet.add(fieldError.getDefaultMessage());
                // LOG.debug("[{}.{}]{}", fieldError.getObjectName() , fieldError.getField(),
                // fieldError.getDefaultMessage());
            }

            for (String errorInfo : errorInfoSet) {
                sbf.append(errorInfo);
                sbf.append(",");
            }

        }

        return sbf.substring(0, sbf.length() - 1);
    }

    /**
     * <h6>功能:验证参数信息是否有效</h6>
     * 
     * @param bindingResult
     * @return
     */
    public static JsonUtils errorValidate(BindingResult bindingResult) {
        String mesg = myValidate(bindingResult);
        return new JsonUtils(1001, mesg, null);
    }

     /**
     * <h6>功能:统一验证</h6>
     * 
     * @param bindingResult
     * @return
     */
    public static JsonUtils errorValidate(String mesg) {
        return new JsonUtils(1001, mesg, null);
    }
}