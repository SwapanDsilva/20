package com.mr.dao;

import java.util.List;

import com.mr.entity.UsersBean;

public interface UserDao {

	//��ѯUser�����������ݵķ���
	public List<UsersBean> getAllUser();
	
	//�����û�id ��ѯ���û�������Ϣ
	public List<UsersBean> getUserById(int uId);
	
	//�޸ķ���
	public void updUser(UsersBean usersBean);
	
	//ɾ������
	public void delUser(int uId);
}
