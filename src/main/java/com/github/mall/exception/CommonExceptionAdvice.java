package com.github.mall.exception;

import com.github.mall.common.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AccountException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ClassName CommonExceptionAdvice
 * @Description TODO
 * @Author 王炎
 * @Date 2019/9/17 19:56
 * @ModifyDate 2019/9/17 19:56
 * @Version 1.0
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class CommonExceptionAdvice {
    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BizException.class)
    public ApiResult handleServiceException(BizException e) {
        log.error("业务逻辑异常",e);
        return ApiResult.failed("业务逻辑异常"+e.getMessage());
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({AccountException.class})
    public ApiResult handleAuthenticationException(AccountException e) {
        log.error("权限",e);
        return ApiResult.failed("权限异常"+e.getMessage());
    }
}
