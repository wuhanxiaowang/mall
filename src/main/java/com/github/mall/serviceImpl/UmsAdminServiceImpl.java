package com.github.mall.serviceImpl;

import cn.hutool.core.util.RandomUtil;
import com.github.mall.common.ApiResult;
import com.github.mall.entity.UmsAdmin;
import com.github.mall.dao.UmsAdminDao;
import com.github.mall.exception.BizException;
import com.github.mall.service.UmsAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author wy
 * @since 2019-09-12
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminDao, UmsAdmin> implements UmsAdminService {

    @Autowired
    UmsAdminDao umsAdminDao;

    @Transactional
    @Override
    public ApiResult getUser() {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setUsername(RandomUtil.randomString(5));
        umsAdmin.setPassword(RandomUtil.randomNumbers(6));
        umsAdmin.setNickName(RandomUtil.randomString(6));
        umsAdmin.setStatus(RandomUtil.randomInt());
        umsAdmin.setEmail(RandomUtil.randomNumbers(8));
        umsAdmin.setIcon(RandomUtil.randomString(10));
        int insert = umsAdminDao.insert(umsAdmin);
        insert=0;
        if(insert<1){
            throw new BizException("插入失败");
        }

        return ApiResult.success("ok");
    }
}
