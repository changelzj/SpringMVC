package lzj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ant风格的requestmapping
 * ? 匹配一个字符
 * * 任意个字符
 * ** 多层路径
 */
@Controller
public class AntController {

    @RequestMapping("ant?")
    public String testant1() {
        return null;
    }

    @RequestMapping("ant*")
    public String testant2() {
        return null;
    }

    @RequestMapping("ant/**")
    public String testant3() {
        return null;
    }
}



