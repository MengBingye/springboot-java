package com.slabs.springbootjava.service;

import com.slabs.springbootjava.model.UserInfo;

/**
 * @create: 2019/03/18 10:56
 */

public interface IUserInfoService {

    UserInfo selectById(Integer id);
}