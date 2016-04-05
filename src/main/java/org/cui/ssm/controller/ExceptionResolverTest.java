package org.cui.ssm.controller;

import org.cui.ssm.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/4/4.
 * 测试自定义异常处理器、自定义异常
 */
@Controller
public class ExceptionResolverTest {

    @RequestMapping("/exception.do")
    public void exceptionHandlerTest(Integer id) throws CustomException {
        if (id == 0) {
            throw new CustomException("我让你等0了么！");
        } else {
            throw new RuntimeException("不等于0 想啥呢");
        }
    }
}
