package com.emc.achievement.service.serviceImpl;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.mapper.AttachmentMapper;
import com.emc.achievement.service.AttachmentService;
import com.emc.achievement.util.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.emc.achievement.mapper.TalentTextbookMapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.emc.achievement.entity.TalentTextbook;
import com.emc.achievement.service.TalentTextbookService;

@Slf4j
@Service
public class TalentTextbookServiceImpl implements TalentTextbookService {

    @Resource
    private TalentTextbookMapper talentTextbookMapper;
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
    public ResponseResult insertSelective(TalentTextbook record) {
        log.info("======= 插入TalentTextbook数据 ======="+record);
        record.setId(idGenerator.nextId());
        record.setSubmitTime(new Date());
        if (talentTextbookMapper.insertSelective(record) == 1) {
            if(record.getNames() != null){
                for (String name : record.getNames()){
                    attachmentMapper.updateRecordIdByName(record.getId(), name);
                }
            }
            log.info("======= 插入TalentTextbook成功 =======");
            return ResponseResult.ofSuccess("添加成功");
        }
        log.error("======= 插入TalentTextbook失败 =======");
        return ResponseResult.ofFail("添加失败");
    }

    /**
     *@author: hxq
     *@date: 2020/10/7 下午4:21
     *@description: 更新一条记录
     */
    @Override
    public ResponseResult updateByPrimaryKeySelective(TalentTextbook record) {
        log.info("======= 更新TalentTextbook数据 ======="+record);
        if (talentTextbookMapper.updateByPrimaryKeySelective(record) == 1) {
            if(record.getNames() != null){
                for (String name : record.getNames()){
                    attachmentMapper.updateRecordIdByName(record.getId(), name);
                }
            }
            log.info("======= TalentTextbook更新成功 =======");
            return ResponseResult.ofSuccess("更新成功");
        }
        log.error("======= TalentTextbook更新失败 =======");
        return ResponseResult.ofFail("更新失败");
    }

    /**
     *@author: hxq
     *@date: 2020/10/7 下午4:23
     *@description: 查询某个老师的所有提交记录
     */
    @Override
    public ResponseResult findByUsername(String username) {
        log.info("======= 查找老师的所有TalentTextbook记录 ======="+username);
        List<TalentTextbook> records = talentTextbookMapper.findByUsername(username);
        return ResponseResult.ofSuccess("查询记录", records);
    }

    /**
     *@author: hxq
     *@date: 2020/10/7 下午4:23
     *@description: 根据唯一id查询单条记录，并返回请求文件和图片附件的路径
     */
    @Override
    public ResponseResult findByRecordId(Long recordId) {
        log.info("======= 查找单条TalentTextbook记录 ======="+recordId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("record", talentTextbookMapper.findById(recordId));
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
        log.info("======= 导出TalentTextbook全部记录 =======");
        return ResponseResult.ofSuccess("查询全部记录",talentTextbookMapper.find());
    }

    @Override
    public ResponseResult deleteById(Long Id) {
        if(talentTextbookMapper.deleteById(Id) == 1){
            attachmentService.deleteByRecordId(Id);
            return ResponseResult.ofSuccess("删除记录成功");
        }
        return ResponseResult.ofFail("删除记录失败");
    }
}



