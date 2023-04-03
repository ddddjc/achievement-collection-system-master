package com.emc.achievement.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文件附件
 */
@ApiModel(value = "文件附件")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {
    /**
     * 唯一id
     */
    @ApiModelProperty(value = "唯一id")
    private Long attachmentId;

    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径")
    private String name;

    /**
     * 对应19张表中唯一id
     */
    @ApiModelProperty(value = "对应19张表中唯一id")
    private Long recordId;
}