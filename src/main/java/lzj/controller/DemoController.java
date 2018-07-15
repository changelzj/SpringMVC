package lzj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Map;

@Controller
@SessionAttributes(value = {"user"})
@RequestMapping("test")
public class DemoController {

    /**
     * 根据视图解析器，得到实际的物理视图做转发操作
     */
    @RequestMapping("hello")
    public String hello() {
        return "success";
    }

    @GetMapping("get/{id}")
    public void getUser(@PathVariable("id") String id) {

    }

    @GetMapping("getheader")
    public void header(@RequestHeader Map map) {

    }

    @GetMapping("getcookie")
    public void cookie(@CookieValue(value = "jsessionId", required = false) String sid) {

    }

    @GetMapping("testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer writer)
            throws IOException {
        writer.write("hello world");
    }


    @GetMapping("mv")
    public ModelAndView testmv() {
        ModelAndView mv = new ModelAndView("test1");
        mv.addObject("date", new Date());
        return mv;
    }

    @GetMapping("map")
    public String testMap(Map<String, Object> map) {
        map.put("as","as");
        return "test1";
    }

    @GetMapping("testSessionAttr")
    public ModelAndView testSessionAttr() {
        ModelAndView mv = new ModelAndView("test1");
        mv.addObject("date", new Date());
        mv.addObject("user", "user");
        return mv;
    }

}



