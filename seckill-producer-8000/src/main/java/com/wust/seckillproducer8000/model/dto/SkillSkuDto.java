package com.wust.seckillproducer8000.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品sku类 简化版
 *
 * @author wxl
 * @date 2020.3.6
 */
@Data
@Accessors(chain = true)
public class SkillSkuDto {

    /**
     * 商品spuId
     */
    private Integer spuId;

    /**
     * 商品skuId
     */
    private Integer skuId;

    /**
     * 商品所属活动Id
     */
    private Integer activityId;

    /**
     * 商品名称
     */
    private String goodName;

    /**
     * 商品价格
     */
    private BigDecimal goodPrice;

    /**
     * 商品库存
     */
    private Integer StockNum;

    /**
     * 商品图片
     */
    private String imageUrl;

    /**
     * 秒杀开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 秒杀结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
