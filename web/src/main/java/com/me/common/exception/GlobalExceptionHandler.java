package com.me.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by jack rose on 2017/11/30.
 */


@ControllerAdvice(annotations = Controller.class)
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 自定义异常捕捉处理 JSON
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultBean defaultExceptionHandler(HttpServletRequest request, Exception e){
        if(e instanceof BusinessException){
            BusinessException businessException = (BusinessException)e;
            ErrorCode errorCode = businessException.getErrorCode();
            String message = businessException.getMessage();
            return new ResultBean(errorCode.getErrorCode(),message,"");
        }
        return new ResultBean(ResultBean.FAIL,"Internal Server Error.","");
    }


}
