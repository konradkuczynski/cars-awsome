package akademia.cars.repository;

import akademia.cars.model.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // mozna dac tez adnotacje @Component
public interface CarRepository extends JpaRepository<Car, Long> {

//    List<Car> findAll();

    Car getCarByBrandAndModel(String model, String brand);


//    @Query(value = "select car FROM cars.car where  car.brand =?1 ", nativeQuery = true) //JPQL
    @Query(value = "select * FROM car where  plate=?1", nativeQuery = true) //liczna 1 oznacza numer parametru w metodzie
    Optional<Car> findCarByPlate(String plate);



}
