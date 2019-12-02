package com.qf.service;

import com.qf.pojo.User;
import com.qf.utils.Msg;

/**
 * Created by Administrator on 2019/11/27.
 */
public interface UserService {
    Msg selectAll(Integer size,Integer page);

    User selectOne(Integer id);

    String deleteOne(Integer id);

    User updateOne(User user);
}
