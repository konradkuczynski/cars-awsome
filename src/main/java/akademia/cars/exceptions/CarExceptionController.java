package akademia.cars.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CarExceptionController {

    @ExceptionHandler(value = AlreadyExistsException.class)
    public ResponseEntity<ExceptionMessage> exception(AlreadyExistsException e) {
        return new ResponseEntity<ExceptionMessage>(new ExceptionMessage("Car Already Exists", HttpStatus.CONFLICT.value()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ExceptionMessage> exception(NotFoundException e) {
        return new ResponseEntity<ExceptionMessage>(new ExceptionMessage("Car Already Exists", HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

}
