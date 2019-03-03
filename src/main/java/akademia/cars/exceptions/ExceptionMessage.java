package akademia.cars.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionMessage {

    private String message;
    private int status;

}
