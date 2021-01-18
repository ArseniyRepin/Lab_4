package fairy_tale_upgrade;

import java.util.Objects;

public abstract class Reservoirs implements LightEffects{
    private final String reservoir_type;
    private String speed;
    private int pollutionIndex;

    Reservoirs(String reservoir_type, String speed, int pollutionIndex){
        this.reservoir_type=reservoir_type;
        this.speed=speed;
        this.pollutionIndex=pollutionIndex;
    }

    public static class River extends Reservoirs{
        public River(String type, String speed, int pollutionIndex){
            super(type,speed,pollutionIndex);
        }
    }

    @Override
    public String toString() {
        return "Water object {" + "type = " + reservoir_type + ", " + "speed = " + speed + ", " + "pollution_index = " + pollutionIndex + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Reservoirs)) return false;
        Reservoirs reservoir = (Reservoirs) obj;
        return Objects.equals(reservoir_type, reservoir.reservoir_type) && Objects.equals(speed, reservoir.speed) && Objects.equals(pollutionIndex, reservoir.pollutionIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservoir_type, speed, pollutionIndex);
    }

    @Override
    public void sparkling(Character[] heroes) {
        if(pollutionIndex <= 2) {
            System.out.println("The " + speed + " " + reservoir_type + " is sparkling");
            for(Character character: heroes){
                character.moodUP();
            }
        }
    }
}

