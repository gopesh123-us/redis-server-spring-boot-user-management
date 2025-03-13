package live.learnjava.redisusermanagement.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import live.learnjava.redisusermanagement.entity.UserEntity;

@Service
public class UserServiceImpl implements IUserService {
	
	private static final String USER_KEY_PREFIX = "USER:";
	
	//use RedisTemplate
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public void saveUser(UserEntity user) {
		redisTemplate.opsForValue().set(USER_KEY_PREFIX+user.getId(), user);
	}

	@Override
	public UserEntity getUser(String id) {
		UserEntity user = (UserEntity) redisTemplate.opsForValue().get(USER_KEY_PREFIX+id);
		return user;
	}

	@Override
	public void deleteUser(String id) {
		redisTemplate.delete(USER_KEY_PREFIX+id);		
	}

	@Override
	public Set<String> getAllUserKeys() {
		Set<String> userKeys = redisTemplate.keys(USER_KEY_PREFIX+"*");
		return userKeys;
	}

}
