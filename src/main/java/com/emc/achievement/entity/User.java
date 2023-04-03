package com.emc.achievement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户
 */
@ApiModel(value = "用户")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 工号
     */
    @ApiModelProperty(value = "工号")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 是否在职
     */
    @ApiModelProperty(value = "是否在职")
    private Boolean enabled;

    /**
     * 权限
     */
    @ApiModelProperty(value = "权限")
    private String authority;

    /**
     * 职称
     */
    @ApiModelProperty(value = "职称")
    private String jobTitle;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String fullName;

    /**
     * 出生年月日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "出生年月日")
    private Date bornAt;

    /**
     * 信息是否完整
     */
    @ApiModelProperty(value = "信息是否完整")
    private Boolean fullInformation;

    /**
     * 来校时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "来校时间")
    private Date comeTime;

    /**
     * 从教时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "从教时间")
    private Date teachingTime;

    /**
     * 系别
     */
    @ApiModelProperty(value = "系别")
    private String department;
}