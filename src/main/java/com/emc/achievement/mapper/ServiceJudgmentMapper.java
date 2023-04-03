package com.emc.achievement.mapper;

import com.emc.achievement.entity.ServiceJudgment;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceJudgmentMapper {
    int insertSelective(ServiceJudgment record);

    int updateByPrimaryKeySelective(ServiceJudgment record);

    List<ServiceJudgment> find();

    ServiceJudgment findById(@Param("id") Long id);

    List<ServiceJudgment> findByUsername(@Param("username") String username);

    int deleteById(@Param("id") Long id);
}