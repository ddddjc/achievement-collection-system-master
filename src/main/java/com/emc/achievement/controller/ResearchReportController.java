package com.emc.achievement.controller;

import com.emc.achievement.entity.ResearchReport;
import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.service.ResearchReportService;
import com.emc.achievement.util.DataLat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@Api(tags = "科学研究-咨询报告")
@RestController
@RequestMapping("/research")
public class ResearchReportController {
    @Resource
    ResearchReportService researchReportService;


    @ApiOperation(value = "提交一条记录",notes = "names是所有成功上传的文件名")
    @PostMapping(value = "/report")
    ResponseResult insert(@RequestBody ResearchReport record){
        return researchReportService.insertSelective(record);
    }


    @ApiOperation(value = "根据唯一id更新记录",notes = "如果用户未新添加文件，names传空即可，更新文件只用传新文件的names")
    @PostMapping("/report/pu")
    ResponseResult update(@RequestBody ResearchReport record){
        record.setBornAt(DataLat.set(record.getBornAt()));
        record.setSubmitTime(DataLat.set(record.getSubmitTime()));
        record.setFinishTime(DataLat.set(record.getFinishTime()));
        return researchReportService.updateByPrimaryKeySelective(record);
    }


    @ApiOperation("根据老师工号查询之前提交的全部记录")
    @GetMapping("/report")
    ResponseResult records(String username){
        return researchReportService.findByUsername(username);
    }

    @ApiOperation(value = "删除记录")
    @ApiImplicitParam(name = "Id",value = "Id")
    @PostMapping("/report/del")
    ResponseResult delete(@RequestBody HashMap<String,String> Id){
        return researchReportService.deleteById(Long.parseLong(Id.get("Id")));
    }

    @ApiOperation(value = "根据唯一id查询单条记录",notes = "包括单条记录和所有附件名称")
    @GetMapping("/reportRecord")
    ResponseResult record(Long recordId){
        return researchReportService.findByRecordId(recordId);
    }

    @ApiOperation(value = "查询所有记录")
    @GetMapping("/researchReportRecords")
    ResponseResult find(){
        return researchReportService.find();
    }

}
