package com.qf.repository;

import com.qf.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2019/11/27.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
