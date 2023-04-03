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
 * 人才培养-指导学科竞赛
 */
@ApiModel(value = "com-emc-achievement-entity-TalentSubjectCompetition")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalentSubjectCompetition {
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
     * 指导教师
     */
    @ApiModelProperty(value = "指导教师")
    private String teacher;

    /**
     * 获奖项目
     */
    @ApiModelProperty(value = "获奖项目")
    private String projectName;

    /**
     * 获奖名称
     */
    @ApiModelProperty(value = "获奖名称")
    private String awardName;

    /**
     * 获奖等级
     */
    @ApiModelProperty(value = "获奖等级")
    private String awardGrade;

    /**
     * 获奖时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "获奖时间")
    private Date awardTime;

    /**
     * 发证时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "发证时间")
    private Date issuingTime;

    /**
     * 颁奖单位
     */
    @ApiModelProperty(value = "颁奖单位")
    private String awardingUnit;

    /**
     * 级别
     */
    @ApiModelProperty(value = "级别")
    private String level;

    /**
     * 学生主持人
     */
    @ApiModelProperty(value = "学生主持人")
    private String studentHost;

    /**
     * 学生类型
     */
    @ApiModelProperty(value = "学生类型")
    private String studentCategory;

    /**
     * 学生团队
     */
    @ApiModelProperty(value = "学生团队")
    private String studentTeam;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

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
    private transient List<String> names;

    public List<String> getNames() {
        return this.names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}