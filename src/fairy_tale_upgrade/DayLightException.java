package fairy_tale_upgrade;

public class DayLightException extends Exception{
    public DayLightException(String name){
        super("The "+name+" can't shine at night");
    }
}
