package com.emc.achievement.controller;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.TalentCourse;
import com.emc.achievement.service.TalentCourseService;
import com.emc.achievement.util.DataLat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@Api(tags = "人才培养-课程建设")
@RestController
@RequestMapping("/talent")
public class TalentCourseController {
    @Resource
    TalentCourseService talentCourseService;


    @ApiOperation(value = "提交一条记录",notes = "names是所有成功上传的文件名")
    @PostMapping(value = "/course")
    ResponseResult insert(@RequestBody TalentCourse record){
        return talentCourseService.insertSelective(record);
    }


    @ApiOperation(value = "根据唯一id更新记录",notes = "如果用户未新添加文件，names传空即可，更新文件只用传新文件的names")
    @PostMapping("/course/pu")
    ResponseResult update(@RequestBody TalentCourse record){
        record.setBornAt(DataLat.set(record.getBornAt()));
        record.setCreateTime(DataLat.set(record.getCreateTime()));
        record.setEndTime(DataLat.set(record.getEndTime()));
        record.setStartTime(DataLat.set(record.getStartTime()));
        record.setSubmitTime(DataLat.set(record.getSubmitTime()));
        return talentCourseService.updateByPrimaryKeySelective(record);
    }


    @ApiOperation("根据老师工号查询之前提交的全部记录")
    @GetMapping("/course")
    ResponseResult records(String username){
        return talentCourseService.findByUsername(username);
    }

    @ApiOperation(value = "删除记录")
    @ApiImplicitParam(name = "Id",value = "Id")
    @PostMapping("/course/del")
    ResponseResult delete(@RequestBody HashMap<String,String> Id){
        return talentCourseService.deleteById(Long.parseLong(Id.get("Id")));
    }

    @ApiOperation(value = "根据唯一id查询单条记录",notes = "包括单条记录和所有附件名称")
    @GetMapping("/courseRecord")
    ResponseResult record(Long recordId){
        return talentCourseService.findByRecordId(recordId);
    }

    @ApiOperation(value = "查询所有记录")
    @GetMapping("/talentCourseRecords")
    ResponseResult find(){
        return talentCourseService.find();
    }
}
