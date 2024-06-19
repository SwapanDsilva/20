package com.mr.dao.impl;


import java.util.List;


import org.springframework.stereotype.Repository;

import com.mr.dao.UserDao;
import com.mr.entity.UsersBean;



@Repository
public class UserDaoImpl extends BaseDaoImpl<UserDao> implements UserDao {
	//���캯�����ø���Ĺ��췽��
	public UserDaoImpl() {
		super();
		
		this.setMapper(UserDao.class);
	}
	//��ѯ�����û�
	@Override
	public List<UsersBean> getAllUser() {
		// TODO Auto-generated method stub
		return this.getMapper().getAllUser();
	}
	//�����û�ID��ѯ�û���Ϣ
	public List<UsersBean> getUserById(int id){
		return this.getMapper().getUserById(id);
	}
	//�޸��û���Ϣ
	public void updUser(UsersBean usersBean) {
		this.getMapper().updUser(usersBean);
	}
	//ɾ���û�
	@Override
	public void delUser(int uId) {
		// TODO Auto-generated method stub
		
	}
}
