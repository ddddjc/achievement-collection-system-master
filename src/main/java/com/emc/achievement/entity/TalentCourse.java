package com.emc.achievement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 人才培养-课程建设
 */
@ApiModel(value = "com-emc-achievement-entity-TalentCourse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalentCourse {
    /**
     * 唯一id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "唯一id")
    private Long id;

    /**
     * 老师工号
     */
    @ApiModelProperty(value = "老师工号")
    private String username;

    /**
     * 老师姓名
     */
    @ApiModelProperty(value = "老师姓名")
    private String teacherName;

    /**
     * 职称
     */
    @ApiModelProperty(value = "职称")
    private String jobTitle;

    /**
     * 出生年月日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "出生年月日")
    private Date bornAt;

    /**
     * 年度
     */
    @ApiModelProperty(value = "年度")
    private Integer year;

    /**
     * 课程名称
     */
    @ApiModelProperty(value = "课程名称")
    private String courseTitle;

    /**
     * 课程负责人
     */
    @ApiModelProperty(value = "课程负责人")
    private String principal;

    /**
     * 教学团队
     */
    @ApiModelProperty(value = "教学团队")
    private String team;

    /**
     * 课程类别
     */
    @ApiModelProperty(value = "课程类别")
    private String subjectCategory;

    /**
     * 课程形式
     */
    @ApiModelProperty(value = "课程形式")
    private String courseFormat;

    /**
     * 级别
     */
    @ApiModelProperty(value = "级别")
    private String level;

    /**
     * 立项时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "立项时间")
    private Date createTime;

    /**
     * 起止时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "起止时间")
    private Date startTime;

    /**
     * 起止时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "起止时间")
    private Date endTime;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String status;

    /**
     * 系别
     */
    @ApiModelProperty(value = "系别")
    private String department;

    /**
     * 提交时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "提交时间")
    private Date submitTime;

    /**
     * 申报人
     */
    @ApiModelProperty(value = "申报人")
    private String declarer;
    private transient List<String> names;

    public List<String> getNames() {
        return this.names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}