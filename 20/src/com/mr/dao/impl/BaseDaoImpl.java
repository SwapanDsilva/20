package com.mr.dao.impl;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoImpl<T> {
	//1.����SqlSessionFactory
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	//2.����SqlSession
	protected SqlSession sqlSession;
	//3.���� mapper ����
	private Class<T> mapper;
	
	//4.Ϊmapper ����get  set
	public T getMapper() {
		return sqlSessionFactory.openSession().getMapper(mapper);
	}
	public void setMapper(Class<T> mapper) {
		this.mapper = mapper;
	}
}
