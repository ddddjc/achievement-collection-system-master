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
 * 社会服务-比赛裁判
 */
@ApiModel(value = "社会服务-比赛裁判")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceJudgment {
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
     * 老师名称
     */
    @ApiModelProperty(value = "老师名称")
    private String teacherName;

    /**
     * 比赛名称
     */
    @ApiModelProperty(value = "比赛名称")
    private String competitionName;

    /**
     * 比赛时间
     */
    @ApiModelProperty(value = "比赛时间")
    private String competitionTime;

    /**
     * 担任职务
     */
    @ApiModelProperty(value = "担任职务")
    private String position;

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