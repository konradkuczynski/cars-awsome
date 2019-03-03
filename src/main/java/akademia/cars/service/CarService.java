package akademia.cars.service;

import akademia.cars.exceptions.AlreadyExistsException;
import akademia.cars.exceptions.NotFoundException;
import akademia.cars.mappers.CarMapper;
import akademia.cars.model.Car;
import akademia.cars.model.dtos.CarDTO;
import akademia.cars.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<CarDTO> getCarsDto() {

        List<CarDTO> carDTOS = new ArrayList<>();
        carRepository
                .findAll()
                .stream()
                .map(c -> {
                    return carDTOS.add(carMapper.map(c));
                })
                .collect(Collectors.toList());
        return carDTOS;
    }

    public boolean deleteCar(String plate) throws NotFoundException {
        Optional<Car> car= carRepository.findCarByPlate(plate);
        if(car.isPresent()) {
            carRepository.deleteById(car.get().getId());
            return false;
        } else {return false;}
    }

    public boolean addCar(CarDTO carDTO) throws AlreadyExistsException {

        Optional<Car> car = carRepository.findCarByPlate(carDTO.getPlate());
//        Optional.of(carRepository.findCarByPlate(carDTO.getPlate()).orElseGet(() -> carRepository.findCarByPlate(carDTO.getPlate()).ifPresent(d -> {})

        if(car.isPresent()) {
            throw new AlreadyExistsException();
        } else {
//            Car carDao = new Car(carDTO.getBrand(),
//                    carDTO.getModel(),
//                    carDTO.getPlate(),
//                    carDTO.getPlate());
//            carRepository.save(carDao);
            carRepository.save(Car.builder().brand(carDTO.getBrand()).model(carDTO.getModel()).power(carDTO.getPower()).plate(carDTO.getPlate()).build());
            return true;
        }




    }

    public Optional<Car> gettCarByPlateOptional(String plate) {
        return carRepository.findCarByPlate(plate);
    }

    public CarDTO updateCarByPlate(String plate, CarDTO carDTO) throws NotFoundException {

        Optional<Car> ca = carRepository.findCarByPlate(plate);
        if(ca.isPresent()) {
            ca.get().setBrand(carDTO.getBrand());
            ca.get().setModel(carDTO.getModel());
            ca.get().setPlate(carDTO.getPlate());
            ca.get().setPower(carDTO.getPower());

            carRepository.save(ca.get());
            return carMapper.map(ca.get());

        }
        throw new NotFoundException();
    }

    public Car addNewCarDTO(CarDTO carDTO, String plate) throws AlreadyExistsException {

        if (carRepository.findCarByPlate(plate).isPresent()) {
            return carRepository.save(
                    Car.builder()
                    .brand(carDTO.getBrand())
                    .model(carDTO.getModel())
                    .power(carDTO.getPower())
                    .build()
            );
        } throw new AlreadyExistsException();
    }




}
