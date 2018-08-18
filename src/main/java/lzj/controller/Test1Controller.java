package lzj.controller;

import lzj.entity.Address;
import lzj.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

@Controller
//SessionAttributes只能作用于类，将固定变量名的对象和固定类型变量压入session域
@SessionAttributes(value = {"name"}, types = {User.class})
public class Test1Controller {

    @GetMapping("testSessionAttr")
    public ModelAndView testSessionAttr() {
        ModelAndView mv = new ModelAndView("test1");
        mv.addObject("date", new Date());
        //通过SessionAttributes注解 将数据放入request域对象同时也放入session中
        mv.addObject("name", "liuzijian");
        mv.addObject("user", new User());
        return mv;
    }

    @RequestMapping("testModelAttribute")
    public String testModelAttribute(Model model, User user) {

        return "test2";
    }

    /**
     * ModelAttribute修饰的方法，会在目标方法执行之前被springmvc调用
     * 1 首先将对象放入map，放入map的key要与目标方法对应value的参数的类名第一个字母小写的字符串一致，否则目标方法
     * 对应的参数前要用 @ModelAttribute("***")修饰
     * 2 springmvc从map中取出对象，将传入的参数赋值给user
     * 3 调用目标方法，将user传入目标方法
     * @param map
     */
    @ModelAttribute
    public void getUser(Map<String, Object> map) {
        User user = new User();
        user.setAddress(new Address());
        map.put("user", user);
    }




}



