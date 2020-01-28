package com.github.mall.job;

import cn.hutool.core.util.RandomUtil;
import com.github.mall.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: wy
 * @Date: 2020/1/27 21:33
 * @Description:
 */
@Component
@Slf4j
public class TaskJob {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Scheduled(fixedRate = 3000)
    public void testTasks() {
        List<User> userList=new ArrayList<>();
        for(int i=0;i<5;i++){
            User user=new User();
            user.setAge(RandomUtil.randomInt());
            user.setName(RandomUtil.randomString(6));
            user.setPhone(RandomUtil.randomString(11));
            user.setEmail(RandomUtil.randomString(8));
            userList.add(user);
        }
        log.info("定时任务执行时间：" + dateFormat.format(new Date()));
    }

}
