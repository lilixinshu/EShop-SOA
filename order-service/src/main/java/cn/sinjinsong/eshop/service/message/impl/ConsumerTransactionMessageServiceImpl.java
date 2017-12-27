package cn.sinjinsong.eshop.service.message.impl;

import cn.sinjinsong.eshop.common.domain.entity.message.ConsumerTransactionMessageDO;
import cn.sinjinsong.eshop.common.enumeration.message.MessageStatus;
import cn.sinjinsong.eshop.dao.message.ConsumerTransactionMessageDOMapper;
import cn.sinjinsong.eshop.service.message.ConsumerTransactionMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sinjinsong
 * @date 2017/12/26
 */
@Service("consumerTransactionMessageService")
public class ConsumerTransactionMessageServiceImpl implements ConsumerTransactionMessageService{
    @Autowired
    private ConsumerTransactionMessageDOMapper mapper;
    
    @Transactional(readOnly = true)
    @Override
    public Map<Long, MessageStatus> findConsumerMessageStatuses(List<Long> ids) {
        Map<Long,MessageStatus> result = new HashMap<>();
        for (Long id : ids) {
            MessageStatus status = mapper.findStatusById(id);
            if(status != null){
                result.put(id,status);
            }
        }
        return result;
    }
    
    @Transactional(readOnly = true)
    @Override
    public ConsumerTransactionMessageDO selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }
    
    @Transactional
    @Override
    public void insert(ConsumerTransactionMessageDO record) {
        mapper.insert(record);
    }
    @Transactional
    @Override
    public void insertIfNotExists(ConsumerTransactionMessageDO record) {
        if(mapper.selectByPrimaryKey(record.getId()) == null){
            mapper.insert(record);
        }
    }
    @Transactional
    @Override
    public void update(ConsumerTransactionMessageDO record) {
        mapper.updateByPrimaryKeySelective(record);
    }
    
    @Transactional(readOnly = true)
    @Override
    public boolean isMessageConsumedSuccessfully(Long id) {
        MessageStatus status = mapper.findStatusById(id);
        return status == MessageStatus.CONSUMED;
    }
}
