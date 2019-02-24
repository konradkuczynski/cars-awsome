package akademia.cars.model;

import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Builder
@Table(name = "car")
public class Car {

    public Car(String brand, String model, String power, String plate) {
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.plate = plate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "brand", nullable = false) //ctrl + space
    private String brand;

    @Column(name = "model", nullable = false) //ctrl + space

    private String model;

    @Column(name = "power") //ctrl + space
    private String power;

    @Column(name = "plate", unique = true, nullable = false)
    private String plate;

    public Car() {
        System.out.println("This is new car object");
    }




}
