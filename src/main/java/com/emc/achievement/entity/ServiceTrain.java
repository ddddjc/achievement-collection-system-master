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
 * 社会服务-培训咨询
 */
@ApiModel(value = "社会服务-培训咨询")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceTrain {
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
     * 主题或名称
     */
    @ApiModelProperty(value = "主题或名称")
    private String topic;

    /**
     * 形式
     */
    @ApiModelProperty(value = "形式")
    private String form;

    /**
     * 培训或咨询对象
     */
    @ApiModelProperty(value = "培训或咨询对象")
    private String object;

    /**
     * 培训时间
     */
    @ApiModelProperty(value = "培训时间")
    private String trainingTime;

    /**
     * 地点
     */
    @ApiModelProperty(value = "地点")
    private String location;

    /**
     * 完成人
     */
    @ApiModelProperty(value = "完成人")
    private String finisher;

    /**
     * 参与人数
     */
    @ApiModelProperty(value = "参与人数")
    private Integer participants;

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