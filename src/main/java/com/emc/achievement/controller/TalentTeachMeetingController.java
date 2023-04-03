package com.emc.achievement.controller;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.TalentTeachMeeting;
import com.emc.achievement.service.TalentTeachMeetingService;
import com.emc.achievement.util.DataLat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@Api(tags = "人才培养-教学会议/培训")
@RestController
@RequestMapping("/talent")
public class TalentTeachMeetingController {
    @Resource
    TalentTeachMeetingService talentTeachMeetingService;


    @ApiOperation(value = "提交一条记录",notes = "names是所有成功上传的文件名")
    @PostMapping(value = "/teachMeeting")
    ResponseResult insert(@RequestBody TalentTeachMeeting record){
        return talentTeachMeetingService.insertSelective(record);
    }


    @ApiOperation(value = "根据唯一id更新记录",notes = "如果用户未新添加文件，names传空即可，更新文件只用传新文件的names")
    @PostMapping("/teachMeeting/pu")
    ResponseResult update(@RequestBody TalentTeachMeeting record){
        record.setBornAt(DataLat.set(record.getBornAt()));
        record.setSubmitTime(DataLat.set(record.getSubmitTime()));
        record.setEndTime(DataLat.set(record.getEndTime()));
        record.setStartTime(DataLat.set(record.getStartTime()));
        return talentTeachMeetingService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation("根据老师工号查询之前提交的全部记录")
    @GetMapping("/teachMeeting")
    ResponseResult records(String username){
        return talentTeachMeetingService.findByUsername(username);
    }

    @ApiOperation(value = "删除记录")
    @ApiImplicitParam(name = "Id",value = "Id")
    @PostMapping("/teachMeeting/del")
    ResponseResult delete(@RequestBody HashMap<String,String> Id){
        return talentTeachMeetingService.deleteById(Long.parseLong(Id.get("Id")));
    }

    @ApiOperation(value = "根据唯一id查询单条记录",notes = "包括单条记录和所有附件名称")
    @GetMapping("/teachMeetingRecord")
    ResponseResult record(Long recordId){
        return talentTeachMeetingService.findByRecordId(recordId);
    }

    @ApiOperation(value = "查询所有记录")
    @GetMapping("/teachMeetingRecords")
    ResponseResult find(){
        return talentTeachMeetingService.find();
    }


}
