package cn.cnnic.springcloudoauthorserver.user.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * 具体的验证处理方法，可以是redis，也可以从mysql里读取。
 * @author qiang
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// User user = userRepository.findByUsername(username);
		// if(user == null){
		// throw new UsernameNotFoundException(username);
		// }
		String password = DigestUtils.md5DigestAsHex(("111111").getBytes());
		return new org.springframework.security.core.userdetails.User("qiang", password, new ArrayList());
	}

}