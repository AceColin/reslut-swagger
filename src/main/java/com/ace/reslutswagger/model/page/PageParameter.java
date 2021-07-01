package com.ace.reslutswagger.model.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：分页参数实体类
 *
 * @author AceChen
 * @date 2021/6/28
 */
@Schema(name = "PageParameter", title = "分页参数", description = "分页参数实体")
@Data
public class PageParameter implements Serializable {
    private static final long serialVersionUID = 3809782578272943999L;

    @Schema(title = "分页标识", description = "分页启用标识；默认:true", defaultValue = "true")
    private boolean paged = true;
    @Schema(title = "页容量", description = "页容量；默认:10，取值范围:[10,1000]", defaultValue = "10")
    private int pageSize = 10;
    @Schema(title = "当前页码", description = "当前页码；默认:1", defaultValue = "1")
    private long pageNo = 1;
    @Schema(title = "起始索引", description = "数据库中当前页的起始索引", hidden = true)
    private long startIndex;

    /**
     * 描述：初始化相关参数
     * 适用于一般场景
     *
     * @author AceChen
     * @date 2021/6/29
     */
    public void init() {
        // 修正页容量，即 10 <= pageSize <= 1000
        this.pageSize = Math.min(Math.max(this.pageSize, 10), 1000);
        // 修正页码，即 pageNo >= 1
        this.pageNo = Math.max(this.pageNo, 1);
        // 计算开始索引
        this.startIndex = (this.pageNo - 1) * this.pageSize;
    }

    /**
     * 描述：初始化并修正相关参数
     * 适用于已知数据总量的场景
     *
     * @param total 数据总量
     * @author AceChen
     * @date 2021/6/29
     */
    public void init(long total) {
        // 修正页容量，即 10 <= pageSize <= 1000
        this.pageSize = Math.min(Math.max(this.pageSize, 10), 1000);
        // 计算总页数
        long totalPage = Math.floorDiv((Math.max(total, 0) + this.pageSize - 1), this.pageSize);
        // 修正页码，即 pageNo >= 1
        this.pageNo = Math.min(Math.max(pageNo, 1), Math.max(totalPage, 1));
        // 计算开始索引
        this.startIndex = (this.pageNo - 1) * this.pageSize;
    }

}
