package com.qf.service.impl;

import com.qf.pojo.User;
import com.qf.repository.UserRepository;
import com.qf.service.UserService;
import com.qf.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2019/11/27.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Msg selectAll(Integer size, Integer page) {
        if (page<0){
            page=0;
        }else {
            page= page-1;
        }
        Pageable pages = PageRequest.of(page,size);
        Page<User> all = userRepository.findAll(pages);

        List<User> content = all.getContent();
        System.out.println("+++++++++++++"+content);
        Msg msg=new Msg();
        msg.setList(content);
        msg.setPage(all.getTotalPages());
        msg.setTotal(all.getTotalElements());
        return msg;
    }

    @Override
    public User selectOne(Integer id) {
        Optional<User> byId = userRepository.findById(id);
        User user=null;
        if(byId.isPresent()){
           user = byId.get();
        }
        return user;
    }

    @Override
    public String deleteOne(Integer id) {

        try {
            userRepository.deleteById(id);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "false";
    }

    @Override
    public User updateOne(User user) {
        return userRepository.saveAndFlush(user);
    }
}
