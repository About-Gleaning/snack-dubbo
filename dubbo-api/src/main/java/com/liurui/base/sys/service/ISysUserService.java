package com.liurui.base.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liurui.base.sys.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author liurui
 * @since 2018-10-18
 */
public interface ISysUserService extends IService<SysUser> {

    List<SysUser> getList();

    SysUser getByAccount(String account);

}
