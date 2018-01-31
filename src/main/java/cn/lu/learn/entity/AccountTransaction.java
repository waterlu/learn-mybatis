package cn.lu.learn.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "account_transaction")
public class AccountTransaction {
    /**
     * 自增主键
     */
    @Id
    @Column(name = "account_transaction_id")
    @GeneratedValue(generator = "JDBC")
    private Long accountTransactionId;

    /**
     * 交易流水单编号
     */
    @Column(name = "transaction_bill_code")
    private String transactionBillCode;

    /**
     * 用户UUID
     */
    @Column(name = "user_uuid")
    private String userUuid;

    /**
     * 账户UUID
     */
    @Column(name = "account_uuid")
    private String accountUuid;

    /**
     * 对手方用户UUID
     */
    @Column(name = "oppo_user_uuid")
    private String oppoUserUuid;

    /**
     * 对手方账户UUID
     */
    @Column(name = "oppo_account_uuid")
    private String oppoAccountUuid;

    /**
     * 交易时间
     */
    @Column(name = "transaction_time")
    private Date transactionTime;

    /**
     * 金额
     */
    @Column(name = "transaction_amount")
    private BigDecimal transactionAmount;

    @Column(name = "trade_type")
    private String tradeType;

    /**
     * 订单号
     */
    @Column(name = "order_bill_code")
    private String orderBillCode;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    public String getUpdateUuid() {
        return updateUuid;
    }

    public void setUpdateUuid(String updateUuid) {
        this.updateUuid = updateUuid;
    }

    /**
     * 更新标识
     */
    @Column(name = "update_uuid")
    private String updateUuid;

    /**
     * 获取自增主键
     *
     * @return account_transaction_id - 自增主键
     */
    public Long getAccountTransactionId() {
        return accountTransactionId;
    }

    /**
     * 设置自增主键
     *
     * @param accountTransactionId 自增主键
     */
    public void setAccountTransactionId(Long accountTransactionId) {
        this.accountTransactionId = accountTransactionId;
    }

    /**
     * 获取交易流水单编号
     *
     * @return transaction_bill_code - 交易流水单编号
     */
    public String getTransactionBillCode() {
        return transactionBillCode;
    }

    /**
     * 设置交易流水单编号
     *
     * @param transactionBillCode 交易流水单编号
     */
    public void setTransactionBillCode(String transactionBillCode) {
        this.transactionBillCode = transactionBillCode;
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
     * 获取账户UUID
     *
     * @return account_uuid - 账户UUID
     */
    public String getAccountUuid() {
        return accountUuid;
    }

    /**
     * 设置账户UUID
     *
     * @param accountUuid 账户UUID
     */
    public void setAccountUuid(String accountUuid) {
        this.accountUuid = accountUuid;
    }

    /**
     * 获取对手方用户UUID
     *
     * @return oppo_user_uuid - 对手方用户UUID
     */
    public String getOppoUserUuid() {
        return oppoUserUuid;
    }

    /**
     * 设置对手方用户UUID
     *
     * @param oppoUserUuid 对手方用户UUID
     */
    public void setOppoUserUuid(String oppoUserUuid) {
        this.oppoUserUuid = oppoUserUuid;
    }

    /**
     * 获取对手方账户UUID
     *
     * @return oppo_account_uuid - 对手方账户UUID
     */
    public String getOppoAccountUuid() {
        return oppoAccountUuid;
    }

    /**
     * 设置对手方账户UUID
     *
     * @param oppoAccountUuid 对手方账户UUID
     */
    public void setOppoAccountUuid(String oppoAccountUuid) {
        this.oppoAccountUuid = oppoAccountUuid;
    }

    /**
     * 获取交易时间
     *
     * @return transaction_time - 交易时间
     */
    public Date getTransactionTime() {
        return transactionTime;
    }

    /**
     * 设置交易时间
     *
     * @param transactionTime 交易时间
     */
    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    /**
     * 获取金额
     *
     * @return transaction_amount - 金额
     */
    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * 设置金额
     *
     * @param transactionAmount 金额
     */
    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    /**
     * @return trade_type
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * @param tradeType
     */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    /**
     * 获取订单号
     *
     * @return order_bill_code - 订单号
     */
    public String getOrderBillCode() {
        return orderBillCode;
    }

    /**
     * 设置订单号
     *
     * @param orderBillCode 订单号
     */
    public void setOrderBillCode(String orderBillCode) {
        this.orderBillCode = orderBillCode;
    }

    /**
     * @return delete_flag
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * @param deleteFlag
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}