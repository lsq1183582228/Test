package com.bw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bw.entity.Type;
import com.bw.entity.User;
import com.bw.service.UserService;
import com.bw.util.ToolPage;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//列表
	@RequestMapping(value="list")
	public String list(Model model,HttpServletRequest request,@RequestParam(defaultValue="0")Integer currentPage,String name,String time1) {
		System.out.println("---list---"+name);
		System.out.println("---list1---"+time1);
		
		Map<Object,Object> map = new HashMap<Object,Object>();
		String path=request.getContextPath();
		Integer pageSize=5;
		String url="list?";
		Integer listCount = this.userService.listCount(map);
		map.put("index", currentPage*pageSize);
		map.put("rows", pageSize);
		map.put("name", name);
		map.put("time1", time1);
		
		
		List<User> list = this.userService.list(map);
		ToolPage.page(model, path, currentPage, pageSize, url, listCount, list);
		//model.addAttribute("list",list);
		return "jsp/list";
	}
	
	//描述
	@RequestMapping(value="riqi")
	public String riqi(Model model,HttpServletRequest request,@RequestParam(defaultValue="0")Integer currentPage,String dis) {
		System.out.println("---riqi---"+dis);
		
		Map<Object,Object> map = new HashMap<Object,Object>();
		String path=request.getContextPath();
		Integer pageSize=5;
		String url="riqi?";
		Integer listCount = this.userService.listCount(map);
		map.put("index", currentPage*pageSize);
		map.put("rows", pageSize);
		map.put("dis", dis);
		
		
		List<User> list = this.userService.riqi(map);
		ToolPage.page(model, path, currentPage, pageSize, url, listCount, list);
		//model.addAttribute("list",list);
		return "jsp/list";
	}
	
	//模糊日期
	@RequestMapping(value="riqi1")
	public String riqi1(Model model,HttpServletRequest request,@RequestParam(defaultValue="0")Integer currentPage,String time1) {
		System.out.println("---riqi1---"+time1);
		
		Map<Object,Object> map = new HashMap<Object,Object>();
		String path=request.getContextPath();
		Integer pageSize=5;
		String url="riqi?";
		Integer listCount = this.userService.listCount(map);
		map.put("index", currentPage*pageSize);
		map.put("rows", pageSize);
		map.put("time1", time1);
		
		
		List<User> list = this.userService.riqi1(map);
		ToolPage.page(model, path, currentPage, pageSize, url, listCount, list);
		//model.addAttribute("list",list);
		return "jsp/list";
	}
	//去添加界面
	@RequestMapping(value="toAdd")
	public String toAdd(Model model) {
		System.out.println("---toAdd");
		List<Type> type = this.userService.type();
		model.addAttribute("type",type);
		return "jsp/add";
	}
	
	//添加
	@RequestMapping(value="add")
	public String add(User user) {
		System.out.println("---add");
		this.userService.add(user);
		return "redirect:/list";
	}
	
	//批量删除
	@RequestMapping(value="deleteall")
	public String add(String ids) {
		System.out.println("---deleteall---");
		this.userService.deleteall(ids);
		return "redirect:/list";
	}

}
