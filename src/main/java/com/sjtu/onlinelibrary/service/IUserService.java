package com.sjtu.onlinelibrary.service;

import java.util.List;
import java.util.Map;

import com.sjtu.onlinelibrary.DataAccessException;
import com.sjtu.onlinelibrary.entity.User;
import com.sjtu.onlinelibrary.web.viewmodel.Pager;
import com.sjtu.onlinelibrary.web.viewmodel.UserEditModel;

public interface IUserService {

	Pager<UserEditModel> findAll(int pageIndex,Map<String, Object> condition) throws DataAccessException;
	UserEditModel findById(String id) throws DataAccessException;
	User findByName(String username) throws DataAccessException;
	void save(final User user) throws DataAccessException;
	boolean delete(String id);
	 
	User checkLogin(String userName, String password) throws Exception;
	List<User> findByEmail(String email) throws DataAccessException;
	
	List<User> findAll(int pageIndex, String orderFields) throws DataAccessException;
	int countUser(Map<String, Object> condition) throws DataAccessException;
}
