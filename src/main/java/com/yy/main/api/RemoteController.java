package com.yy.main.api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yy.main.handler.RemoteControlHandler;


@Controller
@RequestMapping("/remote")
public class RemoteController {
	
	@Autowired
	private RemoteControlHandler remoteHandler;
	
	@GetMapping(value = "/connect")
	public String login() {
		
		return "connect";
	}

	@PostMapping(value ="/connect_test")
	@ResponseBody
	public int connect(@RequestParam String username,@RequestParam String password,@RequestParam String ip_address) {
		return remoteHandler.connect(username,password,ip_address);
	}
	
	@GetMapping(value ="/task")
	public String newTask(){
		return "task";
	}
	
	@PostMapping(value ="/run_task")
	@ResponseBody
	public ArrayList runTask(String cmd){
		return remoteHandler.exeCommand(cmd);
	}
}
