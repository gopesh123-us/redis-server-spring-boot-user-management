package live.learnjava.redisusermanagement.service;

import java.util.Set;

import live.learnjava.redisusermanagement.entity.UserEntity;

public interface IUserService {
	public void saveUser(UserEntity user);
	public UserEntity getUser(String id);
	public void deleteUser(String id);	
	public Set<String> getAllUserKeys();
}
