package com.qbk.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: quboka
 * @Date: 2018/12/9 10:35
 * @Description: 用户身份认证
 */
@Log4j2
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     *  根据用户名加载用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登陆用户名："+username);
        //TODO 根据用户名查找数据库
//        Users user = usersMapper.selectByUsername(lowercaseUsername);
//        if (user == null) {
//            throw new UsernameNotFoundException("用户名不存在");
//        }

        //TODO 根据查找到的用户信息 判断用户是否被冻结
//        return new User(username,"123456", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return new User(username,passwordEncoder.encode("123456"), true,true,true,true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
