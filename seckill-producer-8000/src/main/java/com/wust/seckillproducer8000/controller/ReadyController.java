package com.wust.seckillproducer8000.controller;

import com.alibaba.fastjson.JSONObject;
import com.wust.seckillproducer8000.model.dto.SkillSkuDto;
import com.wust.seckillproducer8000.model.vo.in.ReadyVo;
import com.wust.seckillproducer8000.model.vo.out.ResponseVo;
import com.wust.seckillproducer8000.redis.config.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 秒杀活动 前期准备类
 *
 * @author wxl
 * @date 2020.3.6
 */
@Slf4j
@RestController
@RequestMapping("/ready")
public class ReadyController {

    private static final String SKILLINFO = "skillInfo:";
    private static final String SKILLSTOCK = "skillStock:";

    @Autowired
    RedisService redisService;

    /**
     * 秒杀活动开始前 需要将所有信息添加到Redis缓存中
     * 此处提供接口方便测试
     *
     * @author wxl
     * @date 2020.3.6
     */
    @PutMapping("/readyToSkill")
    public ResponseVo getStockNum(@RequestBody ReadyVo readyVo) {

        Integer spuId = readyVo.getSpuId();
        Integer activityId = readyVo.getActivityId();
        Integer skuId = readyVo.getSkuId();

        //ToDo: 验证参数是否有效, 若有效进行后续逻辑 将该商品相关信息添加至Redis
        if(true){
            // 构建秒杀商品sku信息
            SkillSkuDto skillSkuDto = new SkillSkuDto().setSpuId(spuId).setSkuId(skuId).setActivityId(activityId)
                    .setGoodName("测试秒杀商品").setGoodPrice(new BigDecimal(200.00)).setImageUrl("https://github.com/wustwxl")
                    .setStartTime(new Date()).setEndTime(new Date());
            // 将秒杀商品信息添加到缓存
            redisService.setObjectExpire(SKILLINFO + skuId, skillSkuDto, 60*60);
            // 将秒杀商品库存添加到缓存
            redisService.set(SKILLSTOCK + skuId, String.valueOf(100));
            return new ResponseVo();
        }else {
            return new ResponseVo().setResponseCode(403).setResponseMsg("参数无效");
        }

    }

    /**
     * 查看秒杀商品库存情况
     *
     * @author wxl
     * @date 2020.3.6
     */
    @GetMapping(value="/stockNum/{skuId}")
    public ResponseVo getStockNum(@PathVariable("skuId") String skuId) {
        // 查询缓存
        String str = redisService.get(SKILLSTOCK + skuId);
        if(str == null){
            return new ResponseVo().setResponseCode(403).setResponseMsg("参数无效");
        }else{
            log.info("当前商品【skuId:{}】库存【{}】",skuId,str);
            return new ResponseVo(str);
        }
    }

}
