package akademia.cars.controller;

import akademia.cars.model.Car;
import akademia.cars.model.dtos.CarDTO;
import akademia.cars.service.CarService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    //    @GetMapping("/cars") - to jest to samo co     @RequestMapping(value = "/cars", method = RequestMethod.GET)
    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public List<Car> getCars() {
        return carService.getCars();
    }

    @RequestMapping(value = "dto/cars", method = RequestMethod.GET)
    public List<CarDTO> getCarsDto() {
        return carService.getCarsDao();
    }

    @RequestMapping(value = "/cars/{plate}", method = RequestMethod.GET)
    public Car getCar(@PathVariable String plate) {
        return carService.gettCarByPlate(plate);
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public Car getCar(@RequestParam long id, Model model) {

        model.addAttribute("id", id);
//        System.out.println(carService.getCarById(1));
        return carService.getCarById(id);
    }

    @RequestMapping(value = "/carModelAndBrand", method = RequestMethod.POST)
    public Car getCar(@RequestParam String model1, @RequestParam String brand,  Model model) {

        model.addAttribute("model", model1);
        model.addAttribute("brand", brand);
//        System.out.println(carService.getCarById(1));
        return carService.getCarByModelAndBrand(model1, brand);
    }


}
