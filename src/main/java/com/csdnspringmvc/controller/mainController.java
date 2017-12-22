package com.csdnspringmvc.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;

        import java.util.Random;

/**
 * Created by toutou on 2017/12/20.
 */
@Controller
public class mainController {
    @RequestMapping("test/href1")
    public String test1(){
        return "test1";
    }

    @RequestMapping("test/href2")
    public String test2(Model model){
        Random random=new Random();
        model.addAttribute("data", random.nextInt(100));
        return "test2";
    }
}
