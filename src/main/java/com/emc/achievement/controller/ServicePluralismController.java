package com.emc.achievement.controller;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.ServicePluralism;
import com.emc.achievement.service.ServicePluralismService;
import com.emc.achievement.util.DataLat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@Api(tags = "社会服务-学术兼职")
@RestController
@RequestMapping("/service")
public class ServicePluralismController {
    @Resource
    ServicePluralismService servicePluralismService;


    @ApiOperation(value = "提交一条记录",notes = "names是所有成功上传的文件名")
    @PostMapping(value = "/pluralism")
    ResponseResult insert(@RequestBody ServicePluralism record){
        return servicePluralismService.insertSelective(record);
    }


    @ApiOperation(value = "根据唯一id更新记录",notes = "如果用户未新添加文件，names传空即可，更新文件只用传新文件的names")
    @PostMapping("/pluralism/pu")
    ResponseResult update(@RequestBody ServicePluralism record){
        record.setBornAt(DataLat.set(record.getBornAt()));
        record.setSubmitTime(DataLat.set(record.getSubmitTime()));
        return servicePluralismService.updateByPrimaryKeySelective(record);
    }


    @ApiOperation("根据老师工号查询之前提交的全部记录")
    @GetMapping("/pluralism")
    ResponseResult records(String username){
        return servicePluralismService.findByUsername(username);
    }

    @ApiOperation(value = "删除记录")
    @ApiImplicitParam(name = "Id",value = "Id")
    @PostMapping("/pluralism/del")
    ResponseResult delete(@RequestBody HashMap<String,String> Id){
        return servicePluralismService.deleteById(Long.parseLong(Id.get("Id")));
    }

    @ApiOperation(value = "根据唯一id查询单条记录",notes = "包括单条记录和所有附件名称")
    @GetMapping("/pluralismRecord")
    ResponseResult record(Long recordId){
        return servicePluralismService.findByRecordId(recordId);
    }


    @ApiOperation(value = "查询所有记录")
    @GetMapping("/servicePluralismRecords")
    ResponseResult find(){
        return servicePluralismService.find();
    }
}