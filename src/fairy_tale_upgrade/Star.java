package fairy_tale_upgrade;

import java.util.Objects;

public class Star implements LightActions{
    private final String name;
    private PlaceOfSky position;

    Star(String name, PlaceOfSky position){
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Star {" + "name = " + name + ", " + "position = " + position + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Star)) return false;
        Star star = (Star) obj;
        return Objects.equals(name, star.name) && Objects.equals(position, star.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,position);
    }

    public void setPosition(PlaceOfSky pos){
        if(!(position == pos)) {
            System.out.println("The " + name + " has just entered the " + pos);
            position = pos;
        }
    }



    @Override
    public void shining(int brightness, Character[] heroes)throws DayLightException{
        if(PlaceOfSky.invisible == position){
            throw new DayLightException(name);
        }else {
            System.out.println("The " + name + " is shining");
            class Radiation implements RadiationEffects {
                final String type;

                Radiation(String type) {
                    this.type = type;
                }

                @Override
                public void blinding(Character[] heroes) {
                    for (Character hero : heroes) {
                        hero.squint();
                        System.out.println("The " + type + " of the " + name + " are blinding. " + hero.getName() + " is squinting.");
                    }
                }
            }
            Radiation rays = new Radiation("rays");
            if (brightness > 1000) {
                rays.blinding(heroes);
            }
        }
    }
}

