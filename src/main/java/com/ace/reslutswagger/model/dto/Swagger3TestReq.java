package com.ace.reslutswagger.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

/**
 * 描述：Swagger测试入参类
 *
 * @author AceChen
 * @date 2021/5/30
 */
@Schema(name = "TestSwagger3Req", title = "Swagger3测试入参", description = "Swagger3测试入参类")
@Data
public class Swagger3TestReq {
    @Schema(title = "字符串_a", description = "字符串-a")
    private String a;
    @Schema(title = "数值_b", description = "数值-b")
    private Integer b;
    @Schema(title = "日期_c", description = "日期-c")
    private LocalDate c;
}
