package com.emc.achievement.service;

import com.emc.achievement.entity.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AttachmentService {

    ResponseResult insert(MultipartFile file);

    ResponseResult delete(String name);

    List<String> findByRecordId(Long recordId);

    int deleteByRecordId(Long recordId);
}
