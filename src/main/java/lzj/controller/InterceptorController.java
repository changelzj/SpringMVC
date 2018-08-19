package lzj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试拦截器
 */
@Controller
@RequestMapping("interceptor")
public class InterceptorController {

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return "test";
    }


}
