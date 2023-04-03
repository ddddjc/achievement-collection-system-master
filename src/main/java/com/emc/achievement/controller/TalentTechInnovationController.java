package com.emc.achievement.controller;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.TalentTechInnovation;
import com.emc.achievement.service.TalentTechInnovationService;
import com.emc.achievement.util.DataLat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@Api(tags = "人才培养-指导科技创新")
@RestController
@RequestMapping("/talent")
public class TalentTechInnovationController {
    @Resource
    TalentTechInnovationService talentTechInnovationService;


    @ApiOperation(value = "提交一条记录",notes = "names是所有成功上传的文件名")
    @PostMapping(value = "/techInnovation")
    ResponseResult insert(@RequestBody TalentTechInnovation record){
        return talentTechInnovationService.insertSelective(record);
    }


    @ApiOperation(value = "根据唯一id更新记录",notes = "如果用户未新添加文件，names传空即可，更新文件只用传新文件的names")
    @PostMapping("/techInnovation/pu")
    ResponseResult update(@RequestBody TalentTechInnovation record){
        record.setBornAt(DataLat.set(record.getBornAt()));
        record.setCreateTime(DataLat.set(record.getCreateTime()));
        return talentTechInnovationService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation("根据老师工号查询之前提交的全部记录")
    @GetMapping("/techInnovation")
    ResponseResult records(String username){
        return talentTechInnovationService.findByUsername(username);
    }

    @ApiOperation(value = "删除记录")
    @ApiImplicitParam(name = "Id",value = "Id")
    @PostMapping("/techInnovation/del")
    ResponseResult delete(@RequestBody HashMap<String,String> Id){
        return talentTechInnovationService.deleteById(Long.parseLong(Id.get("Id")));
    }

    @ApiOperation(value = "根据唯一id查询单条记录",notes = "包括单条记录和所有附件名称")
    @GetMapping("/techInnovationRecord")
    ResponseResult record(Long recordId){
        return talentTechInnovationService.findByRecordId(recordId);
    }

    @ApiOperation(value = "查询所有记录")
    @GetMapping("/techInnovationRecords")
    ResponseResult find(){
        return talentTechInnovationService.find();
    }


}
