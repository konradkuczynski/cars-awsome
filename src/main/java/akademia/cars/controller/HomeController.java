package akademia.cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value = "home")
    public String getHomePage(Model model) {

        String welcome = "Welcome to my awsome Cars App!";

        model.addAttribute("welcome", welcome);
        return "index";
    }

}
