package com.bw.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.dao.UserDao;
import com.bw.entity.Type;
import com.bw.entity.User;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> list(Map<?, ?> map) {
		// TODO Auto-generated method stub
		return this.userDao.list(map);
	}

	@Override
	public Integer listCount(Map<?, ?> map) {
		// TODO Auto-generated method stub
		return this.userDao.listCount(map);
	}

	@Override
	public List<Type> type() {
		// TODO Auto-generated method stub
		return this.userDao.type();
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		this.userDao.add(user);
	}

	@Override
	public void deleteall(String ids) {
		// TODO Auto-generated method stub
		String[] idArray=ids.split(",");
		for (int i = 0; i < idArray.length; i++) {
			String id = idArray[i];
			this.userDao.deleteUser(Integer.valueOf(id));
		}
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		this.userDao.deleteUser(id);
	}

	@Override
	public List<User> riqi(Map<?, ?> map) {
		// TODO Auto-generated method stub
		return this.userDao.riqi(map);
	}

	@Override
	public List<User> riqi1(Map<?, ?> map) {
		// TODO Auto-generated method stub
		return this.userDao.riqi1(map);
	}

}
