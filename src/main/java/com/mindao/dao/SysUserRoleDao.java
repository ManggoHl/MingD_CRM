package com.mindao.dao;

import java.util.List;

import com.mindao.entity.SysUserRoleEntity;

/**
 * 用户与角色对应关系
 * 
 * @author ligc
 * @email 153277817@qq.com
 * @date 2016年9月18日 上午9:34:46
 */
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);
}
