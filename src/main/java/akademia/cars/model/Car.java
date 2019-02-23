package akademia.cars.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {

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


}
