package com.mindao.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindao.dao.TokenDao;
import com.mindao.entity.TokenEntity;
import com.mindao.service.TokenService;


@Service("tokenService")
public class TokenServiceImpl implements TokenService {
	@Autowired
	private TokenDao tokenDao;
	//12小时后过期
	private final static int EXPIRE = 3600 * 12;

	@Override
	public TokenEntity queryByUserId(String userId) {
		return tokenDao.queryByUserId(userId);
	}

	@Override
	public TokenEntity queryByToken(String token) {
		return tokenDao.queryByToken(token);
	}

	@Override
	public void save(TokenEntity token){
		tokenDao.save(token);
	}
	
	@Override
	public void update(TokenEntity token){
		tokenDao.update(token);
	}
	
	@Override
	public boolean isExpired(Date expireTime){
		Date d=new Date();
		return d.getTime()>expireTime.getTime()?true:false;
	}

	@Override
	public Map<String, Object> createToken(String userId) {
		//生成一个token
		String token = UUID.randomUUID().toString();
		//当前时间
		Date now = new Date();

		//过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

		//判断是否生成过token
		TokenEntity tokenEntity = queryByUserId(userId);
		if(tokenEntity == null){
			tokenEntity = new TokenEntity();
			tokenEntity.setUserId(userId);
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//保存token
			save(tokenEntity);
		}else{
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//更新token
			update(tokenEntity);
		}

		Map<String, Object> map = new HashMap<>();
		map.put("token", token);
		map.put("expire", EXPIRE);

		return map;
	}

	@Override
	public void deleteByToken(String token) {
		tokenDao.deleteByToken(token);
	}
}
