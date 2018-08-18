package lzj.controller;

import lzj.entity.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"user"})
@RequestMapping("test3")
public class Test2Controller {

    /**
     * 初始化binder
     * InitBinder修饰的方法通常是WebDataBinder类型的参数，返回必须是void类型
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //不赋值的字段
        binder.setDisallowedFields("name");
    }

    /**
     * result 类型转换器 出错，获取出错信息
     * @param user
     * @param result
     * @return
     */
    @RequestMapping("testBinding")
    public String testBinding(User user, BindingResult result) {
        return null;
    }

    /**
     * 重定向
     * @return
     */
    @RequestMapping("redirect")
    public String testRedirect() {
        return "redirect:/test3";
    }

    /**
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("testConverter")
    public String testConverter() {
        return "json";
    }

    /**
     * 模拟下载效果
     */
    @RequestMapping("down")
    public ResponseEntity<byte[]> testResponseEntity() {
        byte[] body = new byte[]{0,0,0,0};
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename=a.txt");
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);
        return responseEntity;
    }

}



