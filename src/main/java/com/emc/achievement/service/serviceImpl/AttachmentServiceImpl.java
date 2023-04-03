package com.emc.achievement.service.serviceImpl;

import com.emc.achievement.entity.Attachment;
import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.mapper.AttachmentMapper;
import com.emc.achievement.service.AttachmentService;
import com.emc.achievement.util.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
/**
*@author: hxq
*@date: 2020/10/7 下午4:19
*@description: 插入或更新表记录时文件附件的处理，更新时选择性删除和新建文件
*/
@Slf4j
@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Resource
    IdGenerator idGenerator;
    @Resource
    AttachmentMapper attachmentMapper;
    @Value("${file.path}")
    String filePath;

    @Override
    public ResponseResult insert(MultipartFile file) {
        String originName = file.getOriginalFilename();
        log.info("======= 上传文件 {}=======",originName);
        List<Attachment> exist = attachmentMapper.findByName(originName);
        if (!exist.isEmpty()){
            log.info("======= 上传同名文件 ========");
            ResponseResult result = ResponseResult.ofFail("该文件名已经存在，请更改文件名再次尝试");
            //上传文件未保存，无法再次上传同名文件，需要用户给文件再更名，给前端返回status为2，提示用户
            result.setStatus(2);
            return result;
        }
        File serverFile = new File(filePath+originName);
        try {
            file.transferTo(serverFile);
            Attachment record = new Attachment();
            record.setAttachmentId(idGenerator.nextId());
            record.setName(originName);
            if(attachmentMapper.insert(record) == 1) {
                log.info("======= 文件上传成功 =======");
                return ResponseResult.ofSuccess("文件上传成功",originName);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        log.error("======= 文件上传失败 =======");
        return ResponseResult.ofFail("文件上传失败");
    }

    @Override
    public ResponseResult delete(String name) {
        File file = new File(filePath+name);
        if(!file.exists()){
            log.warn("======= 尝试删除不存在的文件 =======");
            return ResponseResult.ofFail("文件不存在");
        }
        if(file.delete() && attachmentMapper.deleteByName(name) == 1){
            log.info("======= 删除文件:{} =======",name);
            return ResponseResult.ofSuccess("文件删除成功");
        }
        log.error("======= 删除文件失败 =======");
        return ResponseResult.ofFail("文件删除失败");
    }

    @Override
    public List<String> findByRecordId(Long recordId) {
        List<Attachment> files = attachmentMapper.findByRecordId(recordId);
        List<String> names = files.stream().map(file -> file.getName()).collect(Collectors.toList());
        log.info("======= 导出单条记录的所有文件名 ======="+recordId+"======="+names);
        return names;
    }

    @Override
    public int deleteByRecordId(Long recordId) {
        return attachmentMapper.deleteByRecordId(recordId);
    }
}
