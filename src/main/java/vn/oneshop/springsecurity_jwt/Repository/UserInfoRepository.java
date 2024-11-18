package vn.oneshop.springsecurity_jwt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.oneshop.springsecurity_jwt.entity.UserInfo;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByName(String username);
}
