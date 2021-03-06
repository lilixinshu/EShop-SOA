package cn.sinjinsong.eshop.dao.user;

import cn.sinjinsong.eshop.common.domain.entity.user.RoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleDOMapper  {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated
     */
    int insert(RoleDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated
     */
    RoleDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(RoleDO record);

    
    List<RoleDO> findByUserId(@Param("id") Long id); 
    
    void insertUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);
    long findRoleIdByRoleName(@Param("role") String role);
}