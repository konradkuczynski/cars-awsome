package akademia.cars.controller;

import akademia.cars.exceptions.AlreadyExists;
import akademia.cars.exceptions.NotFoundException;
import akademia.cars.model.Car;
import akademia.cars.model.dtos.CarDTO;
import akademia.cars.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("dto/cars")
    public ResponseEntity<?> addCar(@RequestBody CarDTO carDTO) throws AlreadyExists {
        if(!carService.addCar(carDTO)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);// http 409
        } else { return new ResponseEntity<>(HttpStatus.CREATED);} //http 201
    }

    @PostMapping("dto/cars/param")
    public ResponseEntity<?> addCarParams(
            @RequestParam String brand,
            @RequestParam String model,
            @RequestParam String power,
            @RequestParam String plate)
            throws AlreadyExists {
        if(!carService.addCar(new CarDTO(brand,model,power,plate))) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);// http 409
        } else { return new ResponseEntity<>(HttpStatus.CREATED);} //http 201
    }

    @DeleteMapping("dto/cars/{plate}")
    public ResponseEntity<?> deleteCar(@PathVariable String plate) throws NotFoundException {

        if (carService.deleteCar(plate)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
//            throw new NotFoundException("Car not exists");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/dto/cars/{plate}")
    public CarDTO updateCar(@PathVariable(value = "plate") String plate, @RequestBody CarDTO carDTO) throws NotFoundException {

//        Optional<Car> carOptional = carService.gettCarByPlateOptional(plate);
        return carService.updateCarByPlate(plate, carDTO);

    }




}
