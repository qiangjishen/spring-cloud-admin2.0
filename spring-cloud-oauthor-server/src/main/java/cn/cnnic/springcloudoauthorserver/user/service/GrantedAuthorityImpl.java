package cn.cnnic.springcloudoauthorserver.user.service;

import org.springframework.security.core.GrantedAuthority;

/***
 * 权限类型，负责存储权限和角色
 * 
 * @author qiang
 *
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}