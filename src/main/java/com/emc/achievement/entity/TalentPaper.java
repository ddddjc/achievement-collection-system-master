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
 * 人才培养-科研论文
 */
@ApiModel(value = "人才培养-科研论文")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalentPaper {
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
     * 申报人及排序
     */
    @ApiModelProperty(value = "申报人及排序")
    private String declarerRank;

    /**
     * 第一作者
     */
    @ApiModelProperty(value = "第一作者")
    private String author;

    /**
     * 通讯作者
     */
    @ApiModelProperty(value = "通讯作者")
    private String coAuthor;

    /**
     * 全部作者
     */
    @ApiModelProperty(value = "全部作者")
    private String authors;

    /**
     * 题名
     */
    @ApiModelProperty(value = "题名")
    private String title;

    /**
     * 期刊名称
     */
    @ApiModelProperty(value = "期刊名称")
    private String journalTitle;

    /**
     * 期卷号
     */
    @ApiModelProperty(value = "期卷号")
    private String issueNumber;

    /**
     * 页码
     */
    @ApiModelProperty(value = "页码")
    private String paperNumber;

    /**
     * 发表时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "发表时间")
    private Date issuingTime;

    /**
     * 论文类别
     */
    @ApiModelProperty(value = "论文类别")
    private String paperCategory;

    /**
     * 成果来源
     */
    @ApiModelProperty(value = "成果来源")
    private String achievementSource;

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
     * 文章检索地址
     */
    @ApiModelProperty(value = "文章检索地址")
    private String articleAddress;

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