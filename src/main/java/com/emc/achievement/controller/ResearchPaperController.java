package com.emc.achievement.controller;

import com.emc.achievement.entity.ResearchPaper;
import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.service.ResearchPaperService;
import com.emc.achievement.util.DataLat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@Api(tags = "科学研究-学术论文")
@RestController
@RequestMapping("/research")
public class ResearchPaperController {
    @Resource
    ResearchPaperService researchPaperService;


    @ApiOperation(value = "提交一条记录",notes = "names是所有成功上传的文件名")
    @PostMapping(value = "/paper")
    ResponseResult insert(@RequestBody ResearchPaper record){
        return researchPaperService.insertSelective(record);
    }


    @ApiOperation(value = "根据唯一id更新记录",notes = "如果用户未新添加文件，names传空即可，更新文件只用传新文件的names")
    @PostMapping("/paper/pu")
    ResponseResult update(@RequestBody ResearchPaper record){
        record.setBornAt(DataLat.set(record.getBornAt()));
        record.setIssuingTime(DataLat.set(record.getIssuingTime()));
        record.setSubmitTime(DataLat.set(record.getSubmitTime()));
        return researchPaperService.updateByPrimaryKeySelective(record);
    }

    @ApiOperation("根据老师工号查询之前提交的全部记录")
    @GetMapping("/paper")
    ResponseResult records(String username){
        return researchPaperService.findByUsername(username);
    }

    @ApiOperation(value = "删除记录")
    @ApiImplicitParam(name = "Id",value = "Id")
    @PostMapping("/paper/del")
    ResponseResult delete(@RequestBody HashMap<String,String> Id){
        return researchPaperService.deleteById(Long.parseLong(Id.get("Id")));
    }

    @ApiOperation(value = "根据唯一id查询单条记录",notes = "包括单条记录和所有附件名称")
    @GetMapping("/paperRecord")
    ResponseResult record(Long recordId){
        return researchPaperService.findByRecordId(recordId);
    }

    @ApiOperation(value = "查询所有记录")
    @GetMapping("/researchPaperRecords")
    ResponseResult find(){
        return researchPaperService.find();
    }
}
