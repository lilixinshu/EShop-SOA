package cn.sinjinsong.eshop.dao.message;

import cn.sinjinsong.eshop.common.domain.entity.message.ProducerTransactionMessageDO;
import cn.sinjinsong.eshop.common.enumeration.message.MessageStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductTransactionMessageDOMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producer_transaction_message
     *
     * @mbggenerated
     */
    int insert(ProducerTransactionMessageDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producer_transaction_message
     *
     * @mbggenerated
     */
    ProducerTransactionMessageDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producer_transaction_message
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ProducerTransactionMessageDO record);
    int deleteByPrimaryKey(Long id);
    List<Long> findMessageIdsByStatusCreatedAfter(@Param("statuses") List<MessageStatus> statuses,@Param("gap") Integer minute);
    List<ProducerTransactionMessageDO> selectBatchByPrimaryKeys(@Param("ids") List<Long> ids);
}