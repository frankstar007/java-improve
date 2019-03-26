package com.frankstar.spring.mvc.learn.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Item {

    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 价格
     */
    private Float price;

    /**
     * 图片
     */
    private String pic;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 描述细节
     */
    private String detail;
}
