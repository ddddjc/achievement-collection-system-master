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
 * 科学研究-学术会议
 */
@ApiModel(value = "科学研究-学术会议")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResearchMeeting {
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
     * 出生年月
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "出生年月")
    private Date bornAt;

    /**
     * 年度
     */
    @ApiModelProperty(value = "年度")
    private Integer year;

    /**
     * 教师名字
     */
    @ApiModelProperty(value = "教师名字")
    private String teacherName;

    /**
     * 参会人
     */
    @ApiModelProperty(value = "参会人")
    private String participant;

    /**
     * 参会形式
     */
    @ApiModelProperty(value = "参会形式")
    private String participateForm;

    /**
     * 会议形式
     */
    @ApiModelProperty(value = "会议形式")
    private String meetingForm;

    /**
     * 会议名称/培训名称
     */
    @ApiModelProperty(value = "会议名称/培训名称")
    private String meetingName;

    /**
     * 交流报告题目
     */
    @ApiModelProperty(value = "交流报告题目")
    private String reportTopic;

    /**
     * 学科门类
     */
    @ApiModelProperty(value = "学科门类")
    private String subjectCategory;

    /**
     * 会议/培训地点
     */
    @ApiModelProperty(value = "会议/培训地点")
    private String meetingPlace;

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
     * 会议类型
     */
    @ApiModelProperty(value = "会议类型")
    private String meetingCategory;

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