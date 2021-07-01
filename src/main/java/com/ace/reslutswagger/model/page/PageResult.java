package com.ace.reslutswagger.model.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：分页结果实体类，支持泛型
 *
 * @author AceChen
 * @date 2021/6/28
 */
@Schema(name = "PageResult", title = "泛型分页结果", description = "分页结果实体，支持泛型")
@Data
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 3809782578272943998L;

    @Schema(title = "页容量", description = "每页的数据量")
    private int pageSize;
    @Schema(title = "当前页码", description = "当前的页码")
    private long pageNo;
    @Schema(title = "数据总量", description = "数据的总量")
    private long total;
    @Schema(title = "页码总量", description = "页码的总量")
    private long totalPage;
    @Schema(title = "当前页数据", description = "当前页的数据")
    private T pageData;

    public PageResult() {
    }

    public PageResult(int pageSize, long pageNo, long total, T pageData) {
        // 修正页容量
        this.pageSize = Math.min(Math.max(pageSize, 10), 1000);
        this.total = Math.max(total, 0);
        // 计算总页数
        this.totalPage = Math.floorDiv((this.total + this.pageSize - 1), this.pageSize);
        // 修正页码
        this.pageNo = Math.min(Math.max(pageNo, 1), Math.max(this.totalPage, 1));
        this.pageData = pageData;
    }
}
