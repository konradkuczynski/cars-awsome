package akademia.cars.exceptions;

public class AlreadyExists extends Exception{

    String message = "Car already exists";

    public AlreadyExists(String message) {
        super(message);
    }
}
