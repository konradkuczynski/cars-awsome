package akademia.cars.exceptions;

public class NotFoundException extends Exception{

    String message = "Car not exists!";


    public NotFoundException(String message) {
        super(message);
    }
}
