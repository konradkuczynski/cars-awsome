package akademia.cars.repository;

import akademia.cars.model.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // mozna dac tez adnotacje @Component
public interface CarRepository extends JpaRepository<Car, Long> {

//    List<Car> findAll();



}
