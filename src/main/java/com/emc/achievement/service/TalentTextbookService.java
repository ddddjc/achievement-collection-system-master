package com.emc.achievement.service;

import java.util.List;

import com.emc.achievement.entity.ResearchMeeting;
import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.TalentTextbook;
import org.springframework.web.multipart.MultipartFile;

public interface TalentTextbookService {


    ResponseResult insertSelective(TalentTextbook record);

    ResponseResult updateByPrimaryKeySelective(TalentTextbook record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);

}



