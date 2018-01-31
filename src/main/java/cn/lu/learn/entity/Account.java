package cn.lu.learn.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class Account {
    /**
     * 账户UUID
     */
    @Id
    @Column(name = "account_uuid")
    private String accountUuid;

    /**
     * 用户UUID
     */
    @Column(name = "user_uuid")
    private String userUuid;

    /**
     * 账户类型
     */
    @Column(name = "account_type")
    private String accountType;

    /**
     * 账户状态
     */
    @Column(name = "account_status")
    private Integer accountStatus;

    /**
     * 账户余额
     */
    @Column(name = "account_amount")
    private BigDecimal accountAmount;

    /**
     * 账户可用余额
     */
    @Column(name = "account_cash_amount")
    private BigDecimal accountCashAmount;

    /**
     * 账户冻结金额
     */
    @Column(name = "account_freeze_amount")
    private BigDecimal accountFreezeAmount;

    /**
     * 删除标记
     */
    @Column(name = "delete_flag")
    private Byte deleteFlag;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取账户类型
     *
     * @return account_type - 账户类型
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * 设置账户类型
     *
     * @param accountType 账户类型
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * 获取账户状态
     *
     * @return account_status - 账户状态
     */
    public Integer getAccountStatus() {
        return accountStatus;
    }

    /**
     * 设置账户状态
     *
     * @param accountStatus 账户状态
     */
    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * 获取账户余额
     *
     * @return account_amount - 账户余额
     */
    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    /**
     * 设置账户余额
     *
     * @param accountAmount 账户余额
     */
    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
    }

    /**
     * 获取账户可用余额
     *
     * @return account_cash_amount - 账户可用余额
     */
    public BigDecimal getAccountCashAmount() {
        return accountCashAmount;
    }

    /**
     * 设置账户可用余额
     *
     * @param accountCashAmount 账户可用余额
     */
    public void setAccountCashAmount(BigDecimal accountCashAmount) {
        this.accountCashAmount = accountCashAmount;
    }

    /**
     * 获取账户冻结金额
     *
     * @return account_freeze_amount - 账户冻结金额
     */
    public BigDecimal getAccountFreezeAmount() {
        return accountFreezeAmount;
    }

    /**
     * 设置账户冻结金额
     *
     * @param accountFreezeAmount 账户冻结金额
     */
    public void setAccountFreezeAmount(BigDecimal accountFreezeAmount) {
        this.accountFreezeAmount = accountFreezeAmount;
    }

    /**
     * 获取删除标记
     *
     * @return delete_flag - 删除标记
     */
    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标记
     *
     * @param deleteFlag 删除标记
     */
    public void setDeleteFlag(Byte deleteFlag) {
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