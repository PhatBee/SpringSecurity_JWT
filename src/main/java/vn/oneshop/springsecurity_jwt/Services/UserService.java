package vn.oneshop.springsecurity_jwt.Services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.oneshop.springsecurity_jwt.Repository.UserInfoRepository;
import vn.oneshop.springsecurity_jwt.entity.UserInfo;

@Service
public record UserService(UserInfoRepository repository, PasswordEncoder passwordEncoder) {
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "Thêm User thành công";
    }
}
