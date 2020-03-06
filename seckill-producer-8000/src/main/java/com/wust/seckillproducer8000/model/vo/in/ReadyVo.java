package com.wust.seckillproducer8000.model.vo.in;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * 活动开始前准备类
 *
 * @author wxl
 * @date 2020.3.6
 */
@Data
@Accessors(chain = true)
public class ReadyVo {

    /**
     * 秒杀商品 spuId
     */
    @NotNull(message = "spuId should not be null")
    private Integer spuId;

    /**
     * 秒杀商品 skuId
     */
    @NotNull(message = "skuId should not be null")
    private Integer skuId;

    /**
     * 秒杀活动 activityId
     */
    @NotNull(message = "activityId should not be null")
    private Integer activityId;
}
