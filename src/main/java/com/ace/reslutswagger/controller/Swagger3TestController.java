package com.ace.reslutswagger.controller;

import com.ace.reslutswagger.model.dto.GenericTestDTO;
import com.ace.reslutswagger.model.dto.Swagger3TestReq;
import com.ace.reslutswagger.model.page.PageParameter;
import com.ace.reslutswagger.model.page.PageResult;
import com.ace.reslutswagger.model.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 描述：Swagger测试专用API
 * Swagger3兼容Swagger2的注解；Swagger3的部分注解在部分场景无效
 *
 * @author AceChen
 * @date 2021/5/30
 */
@Tag(name = "Swagger3测试API")
@RestController
@Slf4j
@RequestMapping("/swagger3")
public class Swagger3TestController {

    @Operation(summary = "Swagger3-基础类型入参-一个")
    @PostMapping("/testA1")
    public Result<String> testA3(@Parameter(name = "a", description = "字符串-a") @RequestParam String a) {
        log.info("这是Swagger测试接口，单个基础类型入参：{}", a);
        return Result.success();
    }

    @Operation(summary = "Swagger3-基础类型入参-多个")
    @PostMapping("/testA2")
    public Result<String> testA4(@Parameter(name = "a", description = "字符串-a") @RequestParam(required = false) String a,
                                 @Parameter(name = "b", description = "数值-b") @RequestParam Integer b) {
        log.info("这是Swagger测试接口，多个基础类型入参：{}，{}", a, b);
        return Result.success();
    }

    @Operation(summary = "Swagger3-对象入参", description = "Swagger3注解的对象参数")
    @PostMapping("/testB1")
    public Result<String> testB2(@RequestBody Swagger3TestReq swagger3TestReq) {
        log.info("这是Swagger测试接口，对象类型入参：{}", swagger3TestReq.toString());
        return Result.success();
    }

    @Operation(summary = "Swagger3-对象入参+返回值泛型", description = "Swagger3注解的对象参数+统一返回值泛型")
    @ApiResponse(responseCode = "200", description = "请求成功")
    @PostMapping("/testC1")
    public Result<GenericTestDTO> testC1(@RequestBody Swagger3TestReq swagger3TestReq) {
        log.info("这是Swagger测试接口，对象类型入参：{}", swagger3TestReq.toString());
        return Result.success(new GenericTestDTO());
    }

    @Operation(summary = "Swagger3-分页参数对象入参+返回值泛型+分页结果泛型", description = "Swagger3注解的对象参数+统一返回值泛型+分页结果泛型")
    @ApiResponse(responseCode = "200", description = "请求成功")
    @PostMapping("/testC2")
    public Result<PageResult<GenericTestDTO>> testC2(@RequestBody PageParameter pageParameter) {
        long total = 7;
        pageParameter.init(total);
        log.info("这是Swagger测试接口，对象类型入参：{}", pageParameter.toString());
        return Result.success(new PageResult<>(pageParameter.getPageSize(), pageParameter.getPageNo(), total, new GenericTestDTO()));
    }
}
