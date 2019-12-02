package com.qf.utils;

import com.qf.pojo.User;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/11/27.
 */
@Data
public class Msg {

    private List<User> list;
    private Integer page;
    private Long total;
}
