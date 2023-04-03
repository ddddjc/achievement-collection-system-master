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
 * 科学研究-咨询报告
 */
@ApiModel(value = "科学研究-咨询报告")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResearchReport {
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
     * 年度
     */
    @ApiModelProperty(value = "年度")
    private Integer year;

    /**
     * 老师名字
     */
    @ApiModelProperty(value = "老师名字")
    private String teacherName;

    /**
     * 出生年月日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "出生年月日")
    private Date bornAt;

    /**
     * 职称
     */
    @ApiModelProperty(value = "职称")
    private String jobTitle;

    /**
     * 申报人及排序
     */
    @ApiModelProperty(value = "申报人及排序")
    private String declarerRank;

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
     * 第一署名单位
     */
    @ApiModelProperty(value = "第一署名单位")
    private String unit;

    /**
     * 咨询或建议报告名称
     */
    @ApiModelProperty(value = "咨询或建议报告名称")
    private String name;

    /**
     * 提交时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "提交时间")
    private Date finishTime;

    /**
     * 提交部门
     */
    @ApiModelProperty(value = "提交部门")
    private String submitDepartment;

    /**
     * 录用情况
     */
    @ApiModelProperty(value = "录用情况")
    private String employmentStatus;

    /**
     * 批示情况
     */
    @ApiModelProperty(value = "批示情况")
    private String instructionSituation;

    /**
     * 成果来源
     */
    @ApiModelProperty(value = "成果来源")
    private String achievementSource;

    /**
     * 研究类别
     */
    @ApiModelProperty(value = "研究类别")
    private String resourceCategory;

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