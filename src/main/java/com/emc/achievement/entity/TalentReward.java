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
 * 人才培养-教学奖励
 */
@ApiModel(value = "人才培养-教学奖励")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalentReward {
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
     * 申报人及排序
     */
    @ApiModelProperty(value = "申报人及排序")
    private String declarerRank;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String teacherName;

    /**
     * 第一完成人
     */
    @ApiModelProperty(value = "第一完成人")
    private String firstFinisher;

    /**
     * 全部完成人
     */
    @ApiModelProperty(value = "全部完成人")
    private String allFinisher;

    /**
     * 获奖作品
     */
    @ApiModelProperty(value = "获奖作品")
    private String winningWorks;

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
     * 奖励等级
     */
    @ApiModelProperty(value = "奖励等级")
    private String rewardLevel;

    /**
     * 颁奖单位
     */
    @ApiModelProperty(value = "颁奖单位")
    private String awardingUnit;

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
     * 成果来源
     */
    @ApiModelProperty(value = "成果来源")
    private String achievementSource;

    /**
     * 成果形式
     */
    @ApiModelProperty(value = "成果形式")
    private String achievementCategory;

    /**
     * 研究类别
     */
    @ApiModelProperty(value = "研究类别")
    private String researchCategory;

    /**
     * 学科门类
     */
    @ApiModelProperty(value = "学科门类")
    private String subjectCategory;

    /**
     * 发表范围
     */
    @ApiModelProperty(value = "发表范围")
    private String issuanceScope;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 提交时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "提交时间")
    private Date submitTime;

    /**
     * 系别
     */
    @ApiModelProperty(value = "系别")
    private String department;
    private transient List<String> names;

    public List<String> getNames() {
        return this.names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}