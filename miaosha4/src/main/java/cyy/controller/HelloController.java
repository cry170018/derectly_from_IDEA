package cyy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller  //注意这里必须为Controller
public class HelloController {

    /**
     * 本地访问内容地址 ：
     * @param map
     * @return
     */
    @RequestMapping("/hello")
    public String helloHtml(HashMap<String, Object> map) {
        map.put("hello", "欢迎进入HTML页面");
        return "/listitem";
    }
}
