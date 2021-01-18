/*
91329.5
Муми-тролль побежал прямо на музыку и внизу у реки увидел Снусмумрика.
Тот сидел на перилах моста, нахлобучив на лоб свою старую шляпу, и болтал над водой ногами.
Солнце только что поднялось над верхушками деревьев и светило им прямо в лицо.
А они жмурились от его лучей, болтали ногами над бегущей сверкающей водой, и на сердце у них было привольно и беззаботно.

Доиграв последнюю строчку своей весенней песенки, Снусмумрик сунул гармошку в карман и спрыгнул с перил.
Муми-тролль стал под окошком восточной мансарды и, сунув в рот лапы, дал сигнал по одним им понятной тайной системе: три простых свистка и один долгий. (Это означало: есть дело.)
Слышно было, что Снифф перестал храпеть, но не шелохнулся и они повторили сигнал с удвоенной силой.
Окошко с треском распахнулось.
Снифф навострил помятые со сна уши и спустился вниз по веревочной лестнице.
 */

package fairy_tale_upgrade;

public class Main {

    public static void main(String[] args) {
        //1 sentence
        Character mummytroll = new Character("Mummy-troll",35);
        Character snufkin = new Character("Snufkin",40);
        snufkin.put_on(new Clothes.Headdress("hat",50,Condition.Old));
        snufkin.put_on(new Clothes.Outerwear("coat",45,Condition.Old,2));

        Instruments harmonica = new Instruments() {
            private final String[] tracks = new String[]{"Spring song"};
            private String type;
            private String nowTrack;

            @Override
            public String getTrack(boolean start) {
                if(start) {
                    nowTrack = tracks[(int)(Math.random()*tracks.length)];
                }
                return nowTrack;
            }

            @Override
            public void setName(String name){
                this.type=name;
            }

            @Override
            public String getName(){
                return type;
            }
        };

        harmonica.setName("Harmonica");
        snufkin.playingMusic(true, harmonica.getTrack(true), harmonica.getName());
        mummytroll.running(TypeOfLocation.river);

        //2 sentence
        snufkin.sitting(TypeOfLocation.banister);
        snufkin.swingingLegs();

        //3 sentence
        Star sun = new Star("Sun", PlaceOfSky.invisible);
        sun.setPosition(PlaceOfSky.rise);
        try{
            sun.shining(1200, new Character[]{mummytroll,snufkin});
        }catch (DayLightException ex1){
            System.out.println(ex1.getMessage());
            System.out.println("Position changed to the rise");
            sun.setPosition(PlaceOfSky.rise);
        }

        //4 sentence
        mummytroll.sitting(TypeOfLocation.banister);
        mummytroll.swingingLegs();
        snufkin.sitting(TypeOfLocation.banister);
        snufkin.swingingLegs();
        Reservoirs.River river = new Reservoirs.River("river", "running", 0);
        river.sparkling(new Character[]{mummytroll,snufkin});
        mummytroll.describeMood();
        snufkin.describeMood();

        //5 sentence
        snufkin.playingMusic(false, harmonica.getTrack(false), harmonica.getName());
        snufkin.removeItem(harmonica.getName());
        snufkin.jump_down(TypeOfLocation.bridge);

        //6 sentence
        Character sniff = new Character("Sniff",37, true);
        House mummyhouse = new House("MummyHome", Condition.Old, new Character[]{mummytroll, snufkin, sniff});
        mummytroll.jump_down(TypeOfLocation.bridge);
        mummytroll.walking(TypeOfLocation.mummyhouse_backyard);
        mummytroll.whistle(Messages.There_is_a_case, 50, new Character[]{sniff});

        //7 sentence
        mummytroll.whistle(Messages.There_is_a_case, 100, new Character[]{sniff});

        //8 sentence
        mummyhouse.openWindow(sniff.getName());

        //9 sentence
        try{
            sniff.go_down(TypeOfLocation.rope_ladder,TypeOfLocation.mummyhouse_backyard);
        }catch (LocationException ex2){
            ex2.printStackTrace();
        }
    }
}
