package com.ace.reslutswagger.model.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：接口统一返回值，支持泛型
 *
 * @author Ace Chen
 * @date 2021/5/1
 */
@Schema(name = "Result", title = "统一返回值对象", description = "统一返回值，支持泛型")
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 3809782578272943997L;
    /** 请求成功标记 */
    @Schema(title = "请求成功标记", description = "请求成功标记", defaultValue = "true")
    private boolean success;
    /** 响应状态码 */
    @Schema(title = "响应状态码", description = "响应状态码", defaultValue = "2000")
    private int code;
    /** 响应提示信息 */
    @Schema(title = "响应提示信息", description = "响应提示信息", defaultValue = "请求成功")
    private String message;
    /** 响应数据 */
    @Schema(title = "响应数据", description = "响应数据")
    private T data;

    /** 私有实例化 */
    private static <T> Result<T> newInstance(ResultEnum resultEnum) {
        Result<T> result = new Result<>();
        result.setSuccess(resultEnum.getSuccess());
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }

    /** 成功返回 */
    public static <T> Result<T> success() {
        return newInstance(ResultEnum.SUCCESS);
    }
    /** 成功返回 */
    public static <T> Result<T> success(T data) {
        Result<T> result = newInstance(ResultEnum.SUCCESS);
        result.setData(data);
        return result;
    }
    /** 通用失败返回 */
    public static <T> Result<T> error() {
        return newInstance(ResultEnum.ERROR);
    }
    /** 通用失败返回 */
    public static <T> Result<T> error(String message) {
        Result<T> result = newInstance(ResultEnum.ERROR);
        result.setMessage(message);
        return result;
    }
    /** 指定失败返回 */
    public static <T> Result<T> error(ResultEnum errEnum) {
        return newInstance(errEnum);
    }
    /** 指定失败返回 */
    public static <T> Result<T> error(ResultEnum errEnum, String message) {
        Result<T> result = newInstance(errEnum);
        result.setMessage(message);
        return result;
    }
}
