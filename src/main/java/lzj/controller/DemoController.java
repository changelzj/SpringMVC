package lzj.controller;

import lzj.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Map;

@Controller
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

    /**
     * 绑定请求参数
     */
    @RequestMapping("testRequestParam")
    public void testRequestParam(@RequestParam(value = "uname", required = true) String uname,
                                 @RequestParam(value = "pwd", required = false) String pwd,
                                 @RequestParam(value = "age", required = false, defaultValue = "12") int age) {

        System.out.println(uname + pwd + age);
        return;
    }

    @RequestMapping("testRequestParams")
    public void testRequestParam(@RequestParam Map<String, Object> map) {
        System.out.println(map);
        return;
    }


    @GetMapping("getheaders")
    public void headers(@RequestHeader Map map) {
        System.out.println(map);
    }

    /**
     * 请求头信息
     * @param agent
     */
    @GetMapping("getheader")
    public void header(@RequestHeader("user-agent") String agent) {
        System.out.println(agent);
    }




    @GetMapping("getcookie")
    public void cookie(@CookieValue(value = "JSESSIONID", required = false) String sid) {
        System.out.println(sid);
    }

    /**
     * pojo 包装  级联属性支持
     * @param user
     * @return
     */
    @RequestMapping("testpojo")
    public String testpojo(User user) {
        System.out.println(user);
        return "success";
    }


    @GetMapping("testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer writer)
            throws IOException {
        writer.write("hello world");
    }

    /**
     * modelandview存放数据，包含视图和模型信息
     * model内的数据最终放在req域对象
     * @return
     */
    @GetMapping("mv")
    public ModelAndView testmv() {
        ModelAndView mv = new ModelAndView("test1");
        mv.addObject("date", new Date());
        return mv;
    }

    /**
     * 目标方法传入map，用于存放信息到域对象
     * @param map
     * @return
     */
    @GetMapping("testMap")
    public String testMap(Map<String, Object> map) {
        map.put("as", "胶粘");
        return "test1";
    }

    /**
     * 目标方法传入model，用于存放信息到域对象
     * 除了map  model  ,modelmap类型也可以
     * @param map
     * @return
     */
    @GetMapping("testModel")
    public String testModel(Model model) {
        model.addAttribute("as", "胶粘");
        return "test1";
    }




}



