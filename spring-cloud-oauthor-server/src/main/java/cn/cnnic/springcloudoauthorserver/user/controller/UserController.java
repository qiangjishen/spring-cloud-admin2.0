package cn.cnnic.springcloudoauthorserver.user.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试用例
 * 
 * @author qiang
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
    
    @RequestMapping("/hello")
    public String hello() {
    	int a= 5/0;
    	return "hello";
    }
}
