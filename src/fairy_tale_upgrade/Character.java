package fairy_tale_upgrade;

import java.util.Objects;

public class Character implements Skills, RelaxActions, PositionActions, ClothesActions, FaceActions, SecretCommunication, SoundEffects, ItemsActions {
    private final String name;
    private int clothes_size;
    private TypeOfLocation now_place = TypeOfLocation.UNKNOWN;
    private int cnt_cl = 0;
    private String face_expression = "normal";
    private final String[] moodType = new String[]{"terrible","depressed","bad","normal","good","great","free","peaceful","carefree"};
    private int moodIndex = 4;
    private boolean sleeping;
    private int capacity = 0;
    private int cnt_it = 0;
    private String[] items = new String[10];
    private Clothes[] clothes = new Clothes[10];
    private boolean snoring;

    Character (String name, int clothes_size){
        this(name, clothes_size, false);
    }

    Character (String name, int clothes_size, boolean sleeping){
        this.name = name;
        this.clothes_size = clothes_size;
        this.sleeping = sleeping;
        snoring = sleeping;
    }

    @Override
    public String toString() {
        return "Character {" + "name = " + name + ", " + "clothes size = " + clothes_size + ", " + "location = " + now_place + ", " + "mood = " + moodType[moodIndex] + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Character)) return false;
        Character eq_char = (Character)obj;
        return Objects.equals(name, eq_char.name) && Objects.equals(clothes_size, eq_char.clothes_size) && Objects.equals(now_place, eq_char.now_place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, clothes_size, cnt_cl, moodType[moodIndex]);
    }

    @Override
    public void running(TypeOfLocation finish_place) {
        if(finish_place == now_place){
            System.out.println(name + " is running on the spot");
        }else {
            if (now_place == TypeOfLocation.UNKNOWN) {
                System.out.println(name + " is running to the " + finish_place);
            } else {
                System.out.println(name + " is running from the " + now_place + " to the " + finish_place);
            }
        }
        now_place = finish_place;
    }

    @Override
    public void sitting(TypeOfLocation place) {
        if(place == TypeOfLocation.UNKNOWN) System.out.println(name + " is sitting");
        else System.out.println(name + " is sitting on the " + place);
        now_place = place;
    }

    @Override
    public void jump_down(TypeOfLocation purpouse){
        if(purpouse == now_place){
            throw new LocationException(purpouse);
        }else{
            if (now_place == TypeOfLocation.UNKNOWN) {
                System.out.println(name + " jumped down to the " + purpouse);
            } else {
                System.out.println(name + " jumped down from the " + now_place + " to the " + purpouse);
            }
        }
        now_place=purpouse;
    }

    @Override
    public void walking(TypeOfLocation finish_place){
        if(finish_place == now_place){
            System.out.println(name + " is walking on the spot");
        }else {
            if (now_place == TypeOfLocation.UNKNOWN) {
                System.out.println(name + " is walking to the " + finish_place);
            } else {
                System.out.println(name + " is walking from the " + now_place + " to the " + finish_place);
            }
        }
        now_place = finish_place;
    }

    @Override
    public void go_down(TypeOfLocation pass, TypeOfLocation finish_place) {
        if(finish_place == now_place){
            throw new LocationException(finish_place);
        }else {
            if (now_place == TypeOfLocation.UNKNOWN) {
                System.out.println(name + " went down the " + pass+ " to the " + finish_place);
            } else {
                System.out.println(name + " went down the " + pass+ " from the " + now_place + " to the " + finish_place);
            }
        }
        now_place = finish_place;
    }

    @Override
    public void playingMusic(boolean play, String music, String item) {
        if(play){
            System.out.println(name + " is playing the " + music);
            moodIndex++;
        }else{
            System.out.println(name + " had just finished playing the "+music);
        }
    }

    @Override
    public void swingingLegs() {
        if(moodIndex < moodType.length-1) moodIndex++;
        System.out.println(name + " is swinging legs, while sitting on the " + now_place);
    }

    @Override
    public void put_on(Clothes thing) {
        if (thing.getSize() >= clothes_size) {
            if(cnt_cl < 10){
                clothes[cnt_cl] = thing;
                cnt_cl++;
                capacity+= thing.getCapacity();
                if(capacity>10-cnt_it){
                    capacity=10-cnt_it;
                }
                System.out.println(name + " put on the " + thing.getType());
            }else{
                System.out.println(name + " can't put on the " + thing.getType() + ". Too many clothes.");
            }
        }

    }

    @Override
    public void squint() {
        face_expression = "squint";
    }

    public void moodUP(){
        if(moodIndex < moodType.length-1) moodIndex++;
    }

    public void describeMood(){
        System.out.println(name + " is in a " + moodType[moodIndex] + " mood");
    }

    public String getName(){return name;}

    @Override
    public void whistle(Messages mess, int volume, Character[] recievers){
        String code = Integer.toString(mess.ordinal(),2);
        for(int i=0;i<code.length();i++){
            if (code.charAt(i)=='1') {
                System.out.println(name + " blew a whistle");
            }else{
                System.out.println(name + " blew a short whistle");
            }
        }
        System.out.println(name + " blew a long whistle");
        for(Character reciever: recievers){
            reciever.recieveWhistle(mess, volume);
        }
    }

    @Override
    public void recieveWhistle(Messages mess, int volume) {
        if(sleeping){
            if(snoring){
                if(volume > 20){
                    this.snoring(false);
                }
            }else{
                if(volume > 80){
                    sleeping = false;
                    System.out.println(name + " picked up ears and woke up.");
                }
            }
        }
        if(!sleeping){
            System.out.println(name + " received an encrypted message: '" + mess + "'.");
        }
    }

    @Override
    public void snoring(boolean snore) {
        snoring = snore;
        if(snore){
            System.out.println(name + " is snoring.");
        }else{
            System.out.println(name + " stopped snoring, but continued to sleep.");
        }
    }

    @Override
    public void removeItem(String name) {
        if(capacity > 0){
            items[cnt_it] = name;
            cnt_it++;
            System.out.println(this.name+ " put the " + name + " in pockets");
        }else{
            System.out.println("It is impossible to remove this thing, there is no free space");
        }
    }
}
