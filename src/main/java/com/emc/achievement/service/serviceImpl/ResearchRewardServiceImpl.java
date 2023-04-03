package com.emc.achievement.service.serviceImpl;

import com.emc.achievement.entity.ResearchReward;
import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.mapper.AttachmentMapper;
import com.emc.achievement.mapper.ResearchRewardMapper;
import com.emc.achievement.service.AttachmentService;
import com.emc.achievement.service.ResearchRewardService;
import com.emc.achievement.util.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
@Slf4j
@Service
public class ResearchRewardServiceImpl implements ResearchRewardService {

    @Resource
    private ResearchRewardMapper researchRewardMapper;
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
    public ResponseResult insertSelective(ResearchReward record) {
        log.info("======= 插入ResearchReward数据 ======="+record);
//        record.setId(SnowFlakeUtil.getSnowFlakeId());
        record.setId(idGenerator.nextId());
        record.setSubmitTime(new Date());
        System.out.println(record.toString());
        if (researchRewardMapper.insertSelective(record) == 1) {
            if(record.getNames() != null){
                for (String name : record.getNames()){
                    attachmentMapper.updateRecordIdByName(record.getId(), name);
                }
            }
            log.info("======= 插入ResearchReward成功 =======");
        return ResponseResult.ofSuccess("添加成功");
    }
        log.error("======= 插入ResearchReward失败 =======");
        return ResponseResult.ofFail("添加失败");
    }
    /**
     *@author: hxq
     *@date: 2020/10/7 下午4:21
     *@description: 更新一条记录
     */
    @Override
    public ResponseResult updateByPrimaryKeySelective(ResearchReward record) {
        log.info("======= 更新ResearchReward数据 ======="+record);
        if (researchRewardMapper.updateByPrimaryKeySelective(record) == 1) {
            if(record.getNames() != null){
                for (String name : record.getNames()){
                    attachmentMapper.updateRecordIdByName(record.getId(), name);
                }
            }
            log.info("======= 更新ResearchReward成功 =======");
            return ResponseResult.ofSuccess("更新成功");
        }
        log.error("======= 更新ResearchReward失败 =======");
        return ResponseResult.ofFail("更新失败");
    }

    /**
     *@author: hxq
     *@date: 2020/10/7 下午4:23
     *@description: 查询某个老师的所有提交记录
     */
    @Override
    public ResponseResult findByUsername(String username) {
        log.info("======= 查找老师的所有ResearchReward记录 ======="+username);
        List<ResearchReward> records = researchRewardMapper.findByUsername(username);
        return ResponseResult.ofSuccess("查询记录", records);
    }

    /**
     *@author: hxq
     *@date: 2020/10/7 下午4:23
     *@description: 根据唯一id查询单条记录，并返回请求文件和图片附件的路径
     */
    @Override
    public ResponseResult findByRecordId(Long recordId) {
        log.info("======= 查找ResearchReward单条记录 ======="+recordId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("record", researchRewardMapper.findById(recordId));
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
        log.info("======= 导出ResearchReward全部记录 =======");
        return ResponseResult.ofSuccess("查询全部记录",researchRewardMapper.find());
    }

    @Override
    public ResponseResult deleteById(Long Id) {
        if(researchRewardMapper.deleteById(Id) == 1){
            attachmentService.deleteByRecordId(Id);
            return ResponseResult.ofSuccess("删除记录成功");
        }
        return ResponseResult.ofFail("删除记录失败");
    }
}


