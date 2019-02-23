package akademia.cars.model.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {

    private String brand;
    private String model;
    private String power;
    private String plate;



}
