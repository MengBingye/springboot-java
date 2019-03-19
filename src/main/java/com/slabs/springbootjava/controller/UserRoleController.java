package com.slabs.springbootjava.controller;

import com.slabs.springbootjava.core.ret.RetResult;
import com.slabs.springbootjava.core.ret.RetResponse;
import com.slabs.springbootjava.core.utils.ApplicationUtils;
import com.slabs.springbootjava.model.UserRole;
import com.slabs.springbootjava.service.UserRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BingYe
 * @Description: UserRoleController类
 * @date 2019/03/19 10:41
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Resource
    private UserRoleService userRoleService;

    @PostMapping("/insert")
    public RetResult
            <Integer> insert(UserRole userRole) throws Exception {
        userRole.setId(ApplicationUtils.getUUID());
        Integer state = userRoleService.insert(userRole);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/deleteById")
    public RetResult
            <Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = userRoleService.deleteById(id);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public RetResult
            <Integer> update(UserRole userRole) throws Exception {
        Integer state = userRoleService.update(userRole);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/selectById")
    public RetResult<UserRole> selectById(@RequestParam String id) throws Exception {
        UserRole userRole = userRoleService.selectById(id);
        return RetResponse.makeOKRsp(userRole);
    }

    /**
     * @param page 页码
     * @param size 每页条数
     * @Description: 分页查询
     * @Reutrn RetResult
     * <PageInfo
     * <UserRole>>
     */
    @PostMapping("/list")
    public RetResult
            <PageInfo
                    <UserRole>> list(@RequestParam(defaultValue = "0") Integer page,
                                     @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<UserRole> list = userRoleService.selectAll();
        PageInfo<UserRole> pageInfo = new PageInfo<UserRole>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }
}