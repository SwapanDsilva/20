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
		//创建一个List集合用于接收Service层方法的返回值
		List<UsersBean> listUser = userDao.getAllUser();
		//创建一个ModelAndView对象 括号里面的参数是指定要跳转到哪个jsp页面
		ModelAndView mav = new ModelAndView("getAll");
		//通过addObject（）方法 我们把要存的值存了进去。
		mav.addObject("listUser", listUser);
		//最后把ModelAndView对象返回出去
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
