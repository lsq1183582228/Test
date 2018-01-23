package com.bw.service;

import java.util.List;
import java.util.Map;

import com.bw.entity.Type;
import com.bw.entity.User;

public interface UserService {
	
	public List<User> list(Map<?,?> map);
	
	public List<User> riqi(Map<?,?> map);
	
	public List<User> riqi1(Map<?,?> map);
	
	public Integer listCount(Map<?,?> map);
	
	public List<Type> type();
	
	public void add(User user);
	
	public void deleteall(String ids);
	
	public void deleteUser(Integer id);

}
