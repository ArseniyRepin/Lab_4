package fairy_tale_upgrade;

public class LocationException extends RuntimeException{

    public LocationException(TypeOfLocation place){
        super("The " + place + " is incorrect finish position. Start and final positions must be different!");
    }
}
