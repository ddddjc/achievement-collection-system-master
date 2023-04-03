package com.emc.achievement.controller;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.TalentSubjectCompetition;
import com.emc.achievement.service.TalentSubjectCompetitionService;
import com.emc.achievement.util.DataLat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@Api(tags = "人才培养-指导学科竞赛")
@RestController
@RequestMapping("/talent")
public class TalentSubjectCompetitionController {
    @Resource
    TalentSubjectCompetitionService talentSubjectCompetitionService;


    @ApiOperation(value = "提交一条记录",notes = "names是所有成功上传的文件名")
    @PostMapping(value = "/subjectCompetition")
    ResponseResult insert(@RequestBody TalentSubjectCompetition record){
        return talentSubjectCompetitionService.insertSelective(record);
    }


    @ApiOperation(value = "根据唯一id更新记录",notes = "如果用户未新添加文件，names传空即可，更新文件只用传新文件的names")
    @PostMapping("/subjectCompetition/pu")
    ResponseResult update(@RequestBody TalentSubjectCompetition record){
        record.setBornAt(DataLat.set(record.getBornAt()));
        record.setSubmitTime(DataLat.set(record.getSubmitTime()));
        record.setAwardTime(DataLat.set(record.getAwardTime()));
        record.setIssuingTime(DataLat.set(record.getIssuingTime()));
        return talentSubjectCompetitionService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation("根据老师工号查询之前提交的全部记录")
    @GetMapping("/subjectCompetition")
    ResponseResult records(String username){
        return talentSubjectCompetitionService.findByUsername(username);
    }

    @ApiOperation(value = "删除记录")
    @ApiImplicitParam(name = "Id",value = "Id")
    @PostMapping("/subjectCompetition/del")
    ResponseResult delete(@RequestBody HashMap<String,String> Id){
        return talentSubjectCompetitionService.deleteById(Long.parseLong(Id.get("Id")));
    }

    @ApiOperation(value = "根据唯一id查询单条记录",notes = "包括单条记录和所有附件名称")
    @GetMapping("/subjectCompetitionRecord")
    ResponseResult record(Long recordId){
        return talentSubjectCompetitionService.findByRecordId(recordId);
    }

    @ApiOperation(value = "查询所有记录")
    @GetMapping("/subjectCompetitionRecords")
    ResponseResult find(){
        return talentSubjectCompetitionService.find();
    }


}
