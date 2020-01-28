package com.github.mall.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ContractDetailResponse
 * @Description TODO
 * @Author 王炎
 * @Date 2019/9/18 16:01
 * @ModifyDate 2019/9/18 16:01
 * @Version 1.0
 */
@Data
public class ContractDetailResponse implements Serializable {
    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 委托单id
     */
    private Long entrustId;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 合同金额
     */
    private Double contractTotalMoney;

    /**
     * 币种
     */
    private String coinType;


    /**
     * 是否授信
     */
    private String creditFlag;

    /**
     * 合同创建时间
     */
    private String createTime;

    /**
     * 合同状态
     */
    private String ContractState;


    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 合同开始日
     */

    private String startTime;

    /**
     * 合同结束日
     */
    private String endTime;

    /**
     * 项目负责人
     */
    private String projectManager;

    /**
     * 合同预计完成日期
     */
    private String expectedFinishDate;

    /**
     * 授信状态
     */
    private String creditState;

    /**
     * 授信方式
     */
    private String creditWay;

    /**
     * 授信天数
     */
    private Integer creditDay;

    /**
     * 预计授信期限
     */
    private String expectedCreditPeriod;

    /**
     * 授信主体
     */
    private String creditProvider;

    /**
     * 授信金额
     */
    private Double creditAmount;

    /**
     * 占用中的钱
     */
    private Double takeUpMoney;

    /**
     * 已释放的钱
     */
    private Double hashReleaseMoney;

    /**
     * 实际授信期限
     */
    private String actualCreditPeriod;

    /**
     * 附件信息
     */
    private List<AttachMent> attachMentList;


}
