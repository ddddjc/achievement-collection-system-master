package com.emc.achievement.controller;

import com.emc.achievement.entity.ResearchProject;
import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.service.ResearchProjectService;
import com.emc.achievement.util.DataLat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@Api(tags = "科学研究-科研项目")
@RestController
@RequestMapping("/research")
public class ResearchProjectController {
    @Resource
    ResearchProjectService researchProjectService;


    @ApiOperation(value = "提交一条记录",notes = "names是所有成功上传的文件名")
    @PostMapping(value = "/project")
    ResponseResult insert(@RequestBody ResearchProject record){
        return researchProjectService.insertSelective(record);
    }


    @ApiOperation(value = "根据唯一id更新记录",notes = "如果用户未新添加文件，names传空即可，更新文件只用传新文件的names")
    @PostMapping("/project/pu")
    ResponseResult update(@RequestBody ResearchProject record){
        record.setBornAt(DataLat.set(record.getBornAt()));
        record.setSubmitTime(DataLat.set(record.getSubmitTime()));
        record.setEndTime(DataLat.set(record.getEndTime()));
        record.setStartTime(DataLat.set(record.getStartTime()));
        record.setCreateTime(DataLat.set(record.getCreateTime()));
        return researchProjectService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation(value = "删除记录")
    @ApiImplicitParam(name = "Id",value = "Id")
    @PostMapping("/project/del")
    ResponseResult delete(@RequestBody HashMap<String,String> Id){
        return researchProjectService.deleteById(Long.parseLong(Id.get("Id")));
    }

    @ApiOperation("根据老师工号查询之前提交的全部记录")
    @GetMapping("/project")
    ResponseResult records(String username){
        return researchProjectService.findByUsername(username);
    }

    @ApiOperation(value = "根据唯一id查询单条记录",notes = "包括单条记录和所有附件名称")
    @GetMapping("/projectRecord")
    ResponseResult record(Long recordId){
        return researchProjectService.findByRecordId(recordId);
    }

    @ApiOperation(value = "查询所有记录")
    @GetMapping("/researchProjectRecords")
    ResponseResult find(){
        return researchProjectService.find();
    }


}
