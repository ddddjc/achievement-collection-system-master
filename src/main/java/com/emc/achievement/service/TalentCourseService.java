package com.emc.achievement.service;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.TalentCourse;
import org.springframework.web.multipart.MultipartFile;import java.util.List;

public interface TalentCourseService {

    ResponseResult insertSelective(TalentCourse record);

    ResponseResult updateByPrimaryKeySelective(TalentCourse record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);

}

