package cn.lu.learn.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class Pay {
    /**
     * 自增ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "pay_id")
    private Long payId;

    /**
     * 订单编号
     */
    @Column(name = "order_bill_code")
    private String orderBillCode;

    /**
     * 用户UUID
     */
    @Column(name = "user_uuid")
    private String userUuid;

    /**
     * 产品UUID
     */
    @Column(name = "product_uuid")
    private String productUuid;

    /**
     * 支付金额
     */
    @Column(name = "pay_amount")
    private BigDecimal payAmount;

    /**
     * 支付类型
     */
    @Column(name = "pay_type")
    private Integer payType;

    /**
     * 支付状态
     */
    @Column(name = "pay_status")
    private Integer payStatus;

    /**
     * 支付请求内容
     */
    @Column(name = "pay_request")
    private String payRequest;

    /**
     * 支付响应内容
     */
    @Column(name = "pay_response")
    private String payResponse;

    /**
     * 删除标记
     */
    @Column(name = "delete_flag")
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取自增ID
     *
     * @return pay_id - 自增ID
     */
    public Long getPayId() {
        return payId;
    }

    /**
     * 设置自增ID
     *
     * @param payId 自增ID
     */
    public void setPayId(Long payId) {
        this.payId = payId;
    }

    /**
     * 获取订单编号
     *
     * @return order_bill_code - 订单编号
     */
    public String getOrderBillCode() {
        return orderBillCode;
    }

    /**
     * 设置订单编号
     *
     * @param orderBillCode 订单编号
     */
    public void setOrderBillCode(String orderBillCode) {
        this.orderBillCode = orderBillCode;
    }

    /**
     * 获取用户UUID
     *
     * @return user_uuid - 用户UUID
     */
    public String getUserUuid() {
        return userUuid;
    }

    /**
     * 设置用户UUID
     *
     * @param userUuid 用户UUID
     */
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    /**
     * 获取产品UUID
     *
     * @return product_uuid - 产品UUID
     */
    public String getProductUuid() {
        return productUuid;
    }

    /**
     * 设置产品UUID
     *
     * @param productUuid 产品UUID
     */
    public void setProductUuid(String productUuid) {
        this.productUuid = productUuid;
    }

    /**
     * 获取支付金额
     *
     * @return pay_amount - 支付金额
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * 设置支付金额
     *
     * @param payAmount 支付金额
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取支付类型
     *
     * @return pay_type - 支付类型
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 设置支付类型
     *
     * @param payType 支付类型
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 获取支付状态
     *
     * @return pay_status - 支付状态
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * 设置支付状态
     *
     * @param payStatus 支付状态
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 获取支付请求内容
     *
     * @return pay_request - 支付请求内容
     */
    public String getPayRequest() {
        return payRequest;
    }

    /**
     * 设置支付请求内容
     *
     * @param payRequest 支付请求内容
     */
    public void setPayRequest(String payRequest) {
        this.payRequest = payRequest;
    }

    /**
     * 获取支付响应内容
     *
     * @return pay_response - 支付响应内容
     */
    public String getPayResponse() {
        return payResponse;
    }

    /**
     * 设置支付响应内容
     *
     * @param payResponse 支付响应内容
     */
    public void setPayResponse(String payResponse) {
        this.payResponse = payResponse;
    }

    /**
     * 获取删除标记
     *
     * @return delete_flag - 删除标记
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标记
     *
     * @param deleteFlag 删除标记
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}