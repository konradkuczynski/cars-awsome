package akademia.cars.controller;

import akademia.cars.exceptions.AlreadyExists;
import akademia.cars.model.Car;
import akademia.cars.model.dtos.CarDTO;
import akademia.cars.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

    private CarService carService;

    public HomeController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "home")
    public String getHomePage(Model model) {

        String welcome = "Welcome to my awsome Cars App!";

        model.addAttribute("welcome", welcome);
        model.addAttribute("cars", carService.getCars());
        return "index";
    }

    @PostMapping("add")
    public String addCar(@Valid @ModelAttribute CarDTO car) throws AlreadyExists {

        //todo add methods
        carService.addCar(car);


        return "redirect:/home";
    }

}
