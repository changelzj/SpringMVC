package lzj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试异常处理
 */
@Controller
@RequestMapping("exception")
public class ExcepController {

    @ResponseBody
    @RequestMapping("test")
    public String test() {
        int i=1/0;
        return "jiagsi";
    }


    /**
     * 入参只能是Model ,不能是map,也可以使用modelandview
     * 多个异常处理方法,目标方法寻找能处理与抛出的异常最近的处理方法进行处理
     * 当前方法找不到异常处理方法,则去ControllerAdvice修饰的类寻找处理方法
     * @param e
     * @param model
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public String handlerException(Exception e, Model model) {
        model.addAttribute("errormsg", e.getLocalizedMessage());
        return "error";
    }

    //json返回异常信息,有冲突,注释掉,不能同时使用
//    @ResponseBody
//    @ExceptionHandler(value = {Exception.class})
//    public String handlerExceptionone(Exception e) {
//        return e.getLocalizedMessage();
//    }





}



