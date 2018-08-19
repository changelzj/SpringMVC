package lzj.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControlller {

    @ExceptionHandler(value = {Exception.class})
    public String handlerException(Exception e, Model model) {
        model.addAttribute("errormsg", e.getLocalizedMessage());
        return "error";
    }


}
