package com.emc.achievement.mapper;

import com.emc.achievement.entity.Attachment;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttachmentMapper {
    int insert(Attachment record);

    List<Attachment> findByRecordId(@Param("recordId") Long recordId);

    int deleteByRecordId(@Param("recordId") Long recordId);

    int deleteByName(@Param("name") String name);

    int updateRecordIdByName(@Param("updatedRecordId") Long updatedRecordId, @Param("name") String name);

    List<Attachment> findByName(@Param("name")String name);


}