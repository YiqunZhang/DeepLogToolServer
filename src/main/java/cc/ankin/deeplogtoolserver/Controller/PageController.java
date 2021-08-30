package cc.ankin.deeplogtoolserver.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/index")
    public String showPage(Model model) {
        model.addAttribute("message", "鸭子");
        return "index";
    }
}