package com.github.mall.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName AttachMent
 * @Description TODO
 * @Author 王炎
 * @Date 2019/9/26 17:05
 * @ModifyDate 2019/9/26 17:05
 * @Version 1.0
 */
@Data
public class AttachMent implements Serializable{

    /**
     * 附件id
     */
    private String attachmentId;

    /**
     * 附件名称
     */
    private String attachmentName;

    /**
     * 附件备注
     */
    private String attachmentRemark;
}
