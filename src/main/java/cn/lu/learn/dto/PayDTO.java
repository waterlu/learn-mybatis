package cn.lu.learn.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * 支付参数对象
 *
 * @author robot
 * @date 2017-12-09
 */
@Getter
@Setter
@ToString
public class PayDTO {

    public interface Insert {}

    public interface Update {}

    /**
     * 订单编号
     *
     */
    @NotBlank(groups = {Insert.class})
    @Size(max = 32)
    private String orderBillCode;

    /**
     * 用户UUID
     *
     */
    @NotBlank(groups = {Insert.class})
    @Size(max = 32)
    private String userUuid;

    /**
     * 产品UUID
     *
     */
    @NotBlank(groups = {Insert.class})
    @Size(max = 32)
    private String productUuid;

    /**
     * 支付金额
     *
     */
    @NotNull(groups = {Insert.class})
    private BigDecimal payAmount;

    /**
     * 支付类型
     *
     */
    private Integer payType;

    /**
     * 支付状态
     *
     */
    private Integer payStatus;

    /**
     * 支付请求内容
     *
     */
    @Size(max = 1024)
    private String payRequest;

    /**
     * 支付响应内容
     *
     */
    @Size(max = 1024)
    private String payResponse;

}