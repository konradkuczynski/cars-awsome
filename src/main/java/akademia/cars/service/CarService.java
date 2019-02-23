package akademia.cars.service;

import akademia.cars.mappers.CarMapper;
import akademia.cars.model.Car;
import akademia.cars.model.dtos.CarDTO;
import akademia.cars.repository.CarRepository;
import akademia.cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {



    private CarRepository carRepository;
    private CarMapper carMapper;

    //Adnotacja autowired jest niewymagana przy konstruktorze


    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car gettCarByPlate(String plate) {
        return carRepository.findCarByPlate(plate).get();
    }

    public Car getCarById(long i) {
        return carRepository.getOne(i);
    }

    public Car getCarByModelAndBrand(String model, String brand) {
        return carRepository.getCarByBrandAndModel(model, brand);
    }

    //--------------------------------------DTO-------------
    public List<CarDTO> getCarsDao() {

        List<CarDTO> list = new ArrayList<>();

        for (Car car: carRepository.findAll()
        ) {
            list.add(carMapper.map(car));
        }
        return list;
    }
}
