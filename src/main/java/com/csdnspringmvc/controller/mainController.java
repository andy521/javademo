package com.csdnspringmvc.controller;

        import com.csdnspringmvc.entity.User;
        import com.csdnspringmvc.entity.User1;
        import com.csdnspringmvc.service.User1Service;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
        import java.util.Date;
        import java.util.Random;

/**
 * Created by toutou on 2017/12/20.
 */
@Controller
public class mainController {
    @Autowired
    private User1Service userService;

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

    @RequestMapping("test/href3/data={chuan}")
    public String test3(@PathVariable("chuan")String data, Model model){
        model.addAttribute("data", data);
        return "test2";
    }

    @RequestMapping(value="test/href4", method= RequestMethod.GET)
    public String test4(@RequestParam("t1") int begin,
                        @RequestParam("t2") int end, Model model){
        Random r = new Random();
        model.addAttribute("data", begin+r.nextInt(end-begin));
        model.addAttribute("begin", begin);
        model.addAttribute("end", end);
        model.addAttribute("fangfa", "GET");
        return  "test4";
    }

    @RequestMapping(value="test/href5", method= RequestMethod.POST)
    public String test5(@RequestParam("t11") int begin,
                        @RequestParam("t22") int end, Model model){
        Random r = new Random();
        model.addAttribute("data", begin+r.nextInt(end-begin));
        model.addAttribute("begin", begin);
        model.addAttribute("end", end);
        model.addAttribute("fangfa", "POST");
        return  "test4";
    }

    // 跳转到user提交界面
    @RequestMapping(value="test/postUser", method= RequestMethod.GET)
    public String toUserPost(){
        return "userPost";
    }

    //提交 保存user
    @RequestMapping(value="test/postUser", method = RequestMethod.POST)
    public String doUserPost(@ModelAttribute User1 user, Model model){
        user.setCreatetime(new Date());
        String result;
        if(userService.insert(user) == 1){
            result = "插入成功！";
        }else{
            result = "插入失败！";
        }

        model.addAttribute("result", result);
        return "userPost";
    }

    @RequestMapping(value="test/getall", method = RequestMethod.GET)
    public String getAll(Model model){
        ArrayList<User1> userList = userService.selectAll();
        model.addAttribute("list", userList);
        return "userList";
    }
}
