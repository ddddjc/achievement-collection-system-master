package com.emc.achievement.service;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.TalentPaper;
import org.springframework.web.multipart.MultipartFile;import java.util.List;

public interface TalentPaperService {


    ResponseResult insertSelective(TalentPaper record);

    ResponseResult updateByPrimaryKeySelective(TalentPaper record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);

}

