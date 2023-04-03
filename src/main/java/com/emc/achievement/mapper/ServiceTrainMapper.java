package com.emc.achievement.mapper;

import com.emc.achievement.entity.ServiceTrain;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceTrainMapper {
    int insertSelective(ServiceTrain record);

    int updateByPrimaryKeySelective(ServiceTrain record);

    List<ServiceTrain> find();

    ServiceTrain findById(@Param("id") Long id);

    List<ServiceTrain> findByUsername(@Param("username") String username);

    int deleteById(@Param("id") Long id);
}