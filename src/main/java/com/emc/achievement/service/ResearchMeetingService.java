package com.emc.achievement.service;

import com.emc.achievement.entity.ResearchMeeting;
import com.emc.achievement.entity.ResponseResult;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;import java.util.List;
import java.util.Map;

public interface ResearchMeetingService {


    ResponseResult insertSelective(ResearchMeeting record);

    ResponseResult updateByPrimaryKeySelective(ResearchMeeting record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);
}

