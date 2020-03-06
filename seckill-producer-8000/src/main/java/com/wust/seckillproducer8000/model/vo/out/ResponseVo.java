package com.wust.seckillproducer8000.model.vo.out;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 统一请求返回体
 *
 * JsonInclude 为空字段不返回
 *
 * @author wxl
 * @date 2020.3.6
 */
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVo {

    /**
     * 请求响应码
     * 成功时为200
     */
    private Integer responseCode = 200;

    /**
     * 请求响应码对应描述
     */
    private String responseMsg = "请求成功";

    /**
     * 请求流水号
     */
    private String reqSerialNo;

    /**
     * 请求返回体
     */
    private Object data;

    /**
     * 扩展字段
     */
    private Object extendField;

    public ResponseVo(){}

    public ResponseVo(Integer responseCode, String responseMsg) {
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    public ResponseVo(Integer responseCode, String responseMsg, Object data) {
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
        this.data = data;
    }

    public ResponseVo(Object data) {
        this.data = data;
    }
}