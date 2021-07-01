package com.ace.reslutswagger.model.result;

/**
 * 描述：接口统一返回值返回码枚举类；可按需新增返回码项
 *
 * @author Ace Chen
 * @date 2021/5/1
 */
public enum ResultEnum {
    /*
     * 枚举状态码：状态码参考了HTTP请求
     * 400：错误请求，语法错误导致服务器无法理解请求信息
     * 401：请求授权失败，客户试图未经授权访问受密码保护的页面
     * 407：类似401，用户必须首先在代理服务器上得到授权
     * 408：客户端没有在服务器指定的时间内完成请求
     * 410：所请求的资源不可用，且服务器无进一步的参考地址
     * 412：一个或多个请求头字段在当前请求中错误
     */
    /** 描述：成功 */
    SUCCESS(true,2000,"请求成功！"),
    /** 描述：通用异常 */
    ERROR(false,4000,"请求失败！"),
    /** 描述：权限不足 */
    ERROR_UNAUTHORIZED(false,4001,"权限不足！"),
    /** 描述：未登录 */
    ERROR_UNAUTHENTICATED(false,4007,"您还未登录！"),
    /** 描述：系统繁忙 */
    ERROR_SERVER_BUSY(false,4008,"抱歉，系统繁忙，请稍后重试！"),
    /** 描述：未知错误 */
    ERROR_UNKNOWN(false, 4010, "未知错误！"),
    /** 描述：参数错误 */
    ERROR_PARAM(false, 4012, "参数错误！");
    // 其他返回码……

    /** 是否成功 */
    private final boolean success;
    /** 状态码 */
    private final int code;
    /** 提示信息 */
    private final String message;

    /** 构造器，在枚举类中是私有的 */
    ResultEnum(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean getSuccess() {
        return success;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
