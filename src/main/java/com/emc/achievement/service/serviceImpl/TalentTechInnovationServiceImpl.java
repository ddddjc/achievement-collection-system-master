package com.emc.achievement.service.serviceImpl;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.TalentSubjectCompetition;
import com.emc.achievement.entity.TalentTechInnovation;
import com.emc.achievement.mapper.AttachmentMapper;
import com.emc.achievement.service.AttachmentService;
import com.emc.achievement.util.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.emc.achievement.mapper.TalentTechInnovationMapper;
import com.emc.achievement.service.TalentTechInnovationService;

@Slf4j
@Service
public class TalentTechInnovationServiceImpl implements TalentTechInnovationService{

    @Resource
    private TalentTechInnovationMapper talentTechInnovationMapper;
    @Resource
    private IdGenerator idGenerator;
    @Resource
    AttachmentMapper attachmentMapper;
    @Resource
    AttachmentService attachmentService;


    /**
     *@author: hxq
     *@date: 2020/10/7 下午4:21
     *@description: 插入一条记录
     */
    @Override
    public ResponseResult insertSelective(TalentTechInnovation record) {
        log.info("======= 插入TalentTechInnovation数据 {}=======",record);
        record.setId(idGenerator.nextId());
        record.setSubmitTime(new Date());
        if (talentTechInnovationMapper.insertSelective(record) == 1) {
            if(record.getNames() != null){
                for (String name : record.getNames()){
                    attachmentMapper.updateRecordIdByName(record.getId(), name);
                }
            }
            log.info("======= 插入TalentTechInnovation成功 =======");
            return ResponseResult.ofSuccess("添加成功");
        }
        log.error("======= 插入TalentTechInnovation失败 =======");
        return ResponseResult.ofFail("添加失败");
    }


    /**
     *@author: hxq
     *@date: 2020/10/7 下午4:21
     *@description: 更新一条记录
     */
    @Override
    public ResponseResult updateByPrimaryKeySelective(TalentTechInnovation record) {
        log.info("======= 更新TalentTechInnovation数据 {}=======",record);
        if (talentTechInnovationMapper.updateByPrimaryKeySelective(record) == 1) {
            if(record.getNames() != null){
                for (String name : record.getNames()){
                    attachmentMapper.updateRecordIdByName(record.getId(), name);
                }
            }
            log.info("======= 更新TalentTechInnovation成功 =======");
            return ResponseResult.ofSuccess("更新成功");
        }
        log.error("======= 更新TalentTechInnovation失败 =======");
        return ResponseResult.ofFail("更新失败");
    }

    /**
     *@author: hxq
     *@date: 2020/10/7 下午4:23
     *@description: 查询某个老师的所有提交记录
     */
    @Override
    public ResponseResult findByUsername(String username) {
        log.info("======= 查找老师的所有TalentTechInnovation记录 {}=======",username);
        List<TalentTechInnovation> records = talentTechInnovationMapper.findByUsername(username);
        return ResponseResult.ofSuccess("查询用户记录", records);
    }

    /**
     *@author: hxq
     *@date: 2020/10/7 下午4:23
     *@description: 根据唯一id查询单条记录，并返回请求文件和图片附件的路径
     */
    @Override
    public ResponseResult findByRecordId(Long recordId) {
        log.info("======= 查找单条TalentTechInnovation记录 {}=======",recordId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("record", talentTechInnovationMapper.findById(recordId));
        map.put("files", attachmentService.findByRecordId(recordId));
        return ResponseResult.ofSuccess("查询单个记录", map);
    }

    /**
     *@author: hxq
     *@date: 2020/10/27 上午12:09
     *@description: 导出某个报表的全部记录
     */
    @Override
    public ResponseResult find() {
        log.info("======= 导出TalentTechInnovation全部记录 =======");
        return ResponseResult.ofSuccess("查询全部记录",talentTechInnovationMapper.find());
    }

    @Override
    public ResponseResult deleteById(Long Id) {
        if(talentTechInnovationMapper.deleteById(Id) == 1){
            attachmentService.deleteByRecordId(Id);
            return ResponseResult.ofSuccess("删除记录成功");
        }
        return ResponseResult.ofFail("删除记录失败");
    }

}
