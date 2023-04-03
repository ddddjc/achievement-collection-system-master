package com.emc.achievement.mapper;

import com.emc.achievement.entity.TalentCourse;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TalentCourseMapper {
    int insertSelective(TalentCourse record);

    int updateByPrimaryKeySelective(TalentCourse record);

    List<TalentCourse> find();

    TalentCourse findById(@Param("id") Long id);

    List<TalentCourse> findByUsername(@Param("username") String username);

    int deleteById(@Param("id") Long id);
}