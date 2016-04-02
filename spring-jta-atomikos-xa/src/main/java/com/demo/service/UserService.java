package com.demo.service;

import java.sql.Connection;

import javax.sql.DataSource;
import javax.sql.XAConnection;
import javax.sql.XADataSource;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;
import javax.transaction.xa.XAResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.demo.dao.LogDao;
import com.demo.dao.UserDao;
import com.demo.entity.User;

@Service
public class UserService {
	
	UserTransaction userTransaction;
	TransactionManager transactionManager;
	
	XAResource xAResource;
	XADataSource xADataSource;
	XAConnection xAConnection;
	
	DataSource dataSource;
	Connection connection;
	
	TransactionInterceptor transactionInterceptor;
	
	com.atomikos.jdbc.AtomikosDataSourceBean adas;

	@Autowired
	private UserDao userDao;
	@Autowired
	private LogDao logDao;
	
	@Transactional
	public void save(User user){
		userDao.save(user);
		logDao.save(user);
		throw new RuntimeException();
	}
}
