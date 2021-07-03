package com.ace.reslutswagger.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 描述：泛型统一返回值示例DTO
 *
 * @author AceChen
 * @date 2021/6/27
 */
@Schema(name = "GenericTestDTO", title = "通用测试对象", description = "通用测试对象实体")
@Data
public class GenericTestDTO {

    @Schema(description = "字符串")
    private String str;
    @Schema(description = "数值")
    private Integer number;
    @Schema(description = "集合")
    private List<String> list;
    @Schema(description = "键值对数据")
    private Map<String, String> map;
}
