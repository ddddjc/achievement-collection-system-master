package com.emc.achievement.service;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.ServiceEditor;
import org.springframework.web.multipart.MultipartFile;import java.util.List;

public interface ServiceEditorService {

    ResponseResult insertSelective(ServiceEditor record);

    ResponseResult updateByPrimaryKeySelective(ServiceEditor record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);

}



