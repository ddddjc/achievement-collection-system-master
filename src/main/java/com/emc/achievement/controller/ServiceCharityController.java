package com.emc.achievement.controller;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.ServiceCharity;
import com.emc.achievement.service.ServiceCharityService;
import com.emc.achievement.util.DataLat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@Api(tags = "社会服务-公益工作")
@RestController
@RequestMapping("/service")
public class ServiceCharityController {
    @Resource
    ServiceCharityService serviceCharityService;


    @ApiOperation(value = "提交一条记录",notes = "names是所有成功上传的文件名")
    @PostMapping(value = "/charity")
    ResponseResult insert(@RequestBody ServiceCharity record){
        return serviceCharityService.insertSelective(record);
    }


    @ApiOperation(value = "根据唯一id更新记录",notes = "如果用户未新添加文件，names传空即可，更新文件只用传新文件的names")
    @PostMapping("/charity/pu")
    ResponseResult update(@RequestBody ServiceCharity record){
        record.setBornAt(DataLat.set(record.getBornAt()));
        record.setSubmitTime(DataLat.set(record.getSubmitTime()));
        record.setParticipateTime(DataLat.set(record.getParticipateTime()));
        return serviceCharityService.updateByPrimaryKeySelective(record);
    }


    @ApiOperation("根据老师工号查询之前提交的全部记录")
    @GetMapping("/charity")
    ResponseResult records(String username){
        return serviceCharityService.findByUsername(username);
    }

    @ApiOperation(value = "删除记录")
    @ApiImplicitParam(name = "Id",value = "Id")
    @PostMapping("/charity/del")
    ResponseResult delete(@RequestBody HashMap<String,String> Id){
        return serviceCharityService.deleteById(Long.parseLong(Id.get("Id")));
    }

    @ApiOperation(value = "根据唯一id查询单条记录",notes = "包括单条记录和所有附件名称")
    @GetMapping("/charityRecord")
    ResponseResult record(Long recordId){
        return serviceCharityService.findByRecordId(recordId);
    }

    @ApiOperation(value = "查询所有记录")
    @GetMapping("/serviceCharityRecords")
    ResponseResult find(){
        return serviceCharityService.find();
    }

}
