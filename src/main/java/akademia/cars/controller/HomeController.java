package akademia.cars.controller;

import akademia.cars.exceptions.AlreadyExistsException;
import akademia.cars.exceptions.NotFoundException;
import akademia.cars.model.dtos.CarDTO;
import akademia.cars.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String addCar(@Valid @ModelAttribute CarDTO car) throws AlreadyExistsException {

        //todo add methods
        carService.addCar(car);


        return "redirect:/home";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute CarDTO car, Model model) {
        model.addAttribute("car", car);
        return "update";
    }

    @PostMapping("upd")
    public String upd(@Valid @ModelAttribute CarDTO car, String plate,  Model model) throws NotFoundException {
        model.addAttribute("car", car);
        model.addAttribute("plate", plate);
        carService.updateCarByPlate(plate, car);
        return "redirect:/home";
    }

    @PostMapping("delete")
    public String delete(@Valid @ModelAttribute CarDTO car, Model model) {

        model.addAttribute("car", car);
        return "delete";
    }

    @PostMapping("del")
    public String del(@Valid @ModelAttribute CarDTO car, String plate, Model model) throws NotFoundException{
        model.addAttribute("car", car);
        model.addAttribute("plate", plate);
        carService.deleteCar(plate);
        return "redirect:/home";
    }

}
