package vn.oneshop.springsecurity_jwt.Configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import vn.oneshop.springsecurity_jwt.Repository.UserInfoRepository;
import vn.oneshop.springsecurity_jwt.entity.UserInfo;

import java.util.Optional;

public class UserInfoService implements UserDetailsService {
    @Autowired
    UserInfoRepository repository;

    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.repository = userInfoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repository.findByName(username);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }
}
