package com.mr.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mr.dao.UserDao;
import com.mr.entity.UsersBean;

@Controller()
@RequestMapping("userController")
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/getAllUser")
	public ModelAndView getAllUser() {
		//����һ��List�������ڽ���Service�㷽���ķ���ֵ
		List<UsersBean> listUser = userDao.getAllUser();
		//����һ��ModelAndView���� ��������Ĳ�����ָ��Ҫ��ת���ĸ�jspҳ��
		ModelAndView mav = new ModelAndView("getAll");
		//ͨ��addObject�������� ���ǰ�Ҫ���ֵ���˽�ȥ��
		mav.addObject("listUser", listUser);
		//����ModelAndView���󷵻س�ȥ
		return mav;
	}
	
	@RequestMapping("/getUserById")
	public ModelAndView getUserById(@Param("uId")Integer uId) {
		ModelAndView mav = new ModelAndView("toUpd");
		List<UsersBean> list = userDao.getUserById(uId);
		mav.addObject("list", list);
		return mav;
	
	}
	
	@RequestMapping("/updUser")
	public String toUpd(UsersBean usersBean){
		userDao.updUser(usersBean);
		return "forward:getAllUser";
	
	}
	
	public String delUser(@Param("uId")Integer uId) {
		userDao.delUser(uId);
		return "forward:getAllUser";
	}
}
