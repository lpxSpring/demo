package com.example.test.hibernatevalidator;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

/**
 * @author 18124550
 * @date 2019/7/15
 */
public class PayRequestDto {

    /**
     * 支付完成时间
     **/
    @Valid
    @NotEmpty(message="支付完成时间不能空", groups = {Default.class})
    @Size(max=14,message="支付完成时间长度不能超过{max}位")
    private String payTime;

    /**
     * 状态
     **/
    @Valid
    @Pattern(regexp = "0[0123]", message = "状态只能为00或01或02或03", groups = {Default.class})
    private String status;

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
