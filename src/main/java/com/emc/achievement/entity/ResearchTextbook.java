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
 * 科学研究-著作教材
 */
@ApiModel(value = "科学研究-著作教材")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResearchTextbook {
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
     * 著作者
     */
    @ApiModelProperty(value = "著作者")
    private String author;

    /**
     * 合著
     */
    @ApiModelProperty(value = "合著")
    private String coAuthor;

    /**
     * 题名
     */
    @ApiModelProperty(value = "题名")
    private String title;

    /**
     * 成果来源
     */
    @ApiModelProperty(value = "成果来源")
    private String achievementSource;

    /**
     * 成果形式
     */
    @ApiModelProperty(value = "成果形式")
    private String achievementForm;

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
     * 著作或教材
     */
    @ApiModelProperty(value = "著作或教材")
    private String textbook;

    /**
     * 出版社
     */
    @ApiModelProperty(value = "出版社")
    private String press;

    /**
     * 书号
     */
    @ApiModelProperty(value = "书号")
    private String bookNumber;

    /**
     * 出版时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "出版时间")
    private Date publishedDate;

    /**
     * 发行范围
     */
    @ApiModelProperty(value = "发行范围")
    private String issuanceScope;

    /**
     * 是否国家级
     */
    @ApiModelProperty(value = "是否国家级")
    private String isNational;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 字数
     */
    @ApiModelProperty(value = "字数")
    private String wordCount;

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