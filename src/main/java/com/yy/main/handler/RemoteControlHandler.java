package com.yy.main.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

@Component
public class RemoteControlHandler {
	Connection con;
	Session session;
	
	/**
	 * 连接远程主机
	 * @param username
	 * @param password
	 * @param ip_address
	 * @return 1连接成功,2用户名或密码错误,-1连接异常
	 */
	public int connect(String username, String password, String ip_address) {
		con = new Connection(ip_address);
		try {
			con.connect();
			boolean iscon = con.authenticateWithPassword(username, password);
			if (!iscon) {
				System.out.println("用户名或者密码不正确!");
				return 2;
			}else {
				System.out.println("连接成功!");
				session = con.openSession();
				session.execCommand("last");
//				session = con.openSession();
//				session.execCommand("ll");
				
				
                //session.execCommand("perl /root/hello.pl");
                //只允许使用一行命令，即session对象只能使用一次execCommand这个方法，
                //多次使用则会出现异常
                //使用多个命令用分号隔开
                //session.execCommand("cd /root; sh hello.sh"); 
				
				//将Terminal屏幕上的文字全部打印出来
                InputStream is = new StreamGobbler(session.getStdout());
                BufferedReader brs = new BufferedReader(new InputStreamReader(is));
                while (true)
                {
                    String line = brs.readLine();
                    if (line == null)
                    {
                        break;
                    }
                    System.out.println(line);
                    
                }
				return 1;
			}
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("远程连接异常!");
		}
		return -1;
	}
	
	public ArrayList<String> exeCommand(String cmd){
		if (session != null) {
			try {
				session.execCommand(cmd);
				//将Terminal屏幕上的文字全部打印出来
              InputStream is = new StreamGobbler(session.getStdout());
              BufferedReader brs = new BufferedReader(new InputStreamReader(is));
              ArrayList<String> list = new ArrayList<String>();
              String line = null;
              while ((line = brs.readLine()) != null)
              {
            	  list.add(line);
              }
              
              return list;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ArrayList<String> list = new ArrayList<String>();
		list.add("error!");
		return list;
	}
}
