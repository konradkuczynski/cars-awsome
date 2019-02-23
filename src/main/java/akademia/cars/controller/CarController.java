package akademia.cars.controller;

import akademia.cars.model.Car;
import akademia.cars.service.CarService;
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

    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public Car getCars() {
        return carService.getCarById(1);
    }


}
