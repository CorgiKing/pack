package com.yy.main.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yy.main.api.request_object.LoginRequest;
import com.yy.main.dbs.db1.repository.UserDao;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
public class LoginController {
	
	
//	@Autowired
//	private UserRepository userRepository;
//	
	
	private UserDao userdao;
	
//	@Autowired
//	@Qualifier("mysqlDb1Template")
//	private JdbcTemplate template1;
	
	@GetMapping("/login")
	@ApiOperation("获取登录页面")
	public String login(){
		return "login";
	}
	
	@PostMapping(value = "/login")
	@ResponseBody
	@ApiOperation(value="登录验证",notes="根据账号和密码验证信息是否正确")
	public Map<String, Object> login(@Valid @ApiParam(value = "login info", required = true) LoginRequest loginRequest,HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		
//		System.out.println(userRepository.findAll().get(0).getName());
		
		if (loginRequest.getAccount().equals("yy") && loginRequest.getPassword().equals("123456")) {
			session.setAttribute("user", loginRequest.getAccount());
			map.put("success", true);
			map.put("message", "登录成功");
			return map;
		}
		
		map.put("success", false);
		map.put("message", "登录失败");
		
		return map;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
}
