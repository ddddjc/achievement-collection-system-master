package com.emc.achievement.controller;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.service.AttachmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
*@author: hxq
*@date: 2020/10/7 下午4:15
*@description: 文件回显
*/
@Slf4j
@Api(tags = "获取文件")
@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${file.path}")
    String filePath;
    @Resource
    AttachmentService attachmentService;

    @ApiOperation(value = "获取文件", notes = "通过文件名下载文件，文件名列表在查询单个记录时可获得")
    @GetMapping("/{name:.+}")
    public ResponseEntity getFile(@PathVariable("name") String name,
                                  HttpServletResponse response) throws FileNotFoundException, UnsupportedEncodingException {
        File file = new File(filePath+name);
        InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", String.format("attachment;filename=\"%s", URLEncoder.encode(name, "UTF-8")));
        headers.add("Cache-Control", "no-cache,no-store,must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        ResponseEntity<Object> responseEntity = ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .body(inputStreamResource);
        log.info("获取文件成功"+name);
        return responseEntity;
    }

    @ApiOperation(value = "上传文件",notes = "上传成功，需要将文件名保存至表中一起提交,存在上传未保存的情况（再次上传同名文件status为2），再次上传时需要更改文件名。")
    @PostMapping("/upload")
    public ResponseResult upload(MultipartFile file){
        return attachmentService.insert(file);
    }

    @ApiOperation("删除文件")
    @PostMapping("/delete/del")
    public ResponseResult upload(String name){
        return attachmentService.delete(name);
    }

}