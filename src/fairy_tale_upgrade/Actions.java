package fairy_tale_upgrade;

interface RelaxActions{
    void swingingLegs();
}

interface Skills{
    void playingMusic(boolean play, String music, String item);
}

interface PositionActions{
    void running(TypeOfLocation finish_place);
    void sitting(TypeOfLocation place);
    void jump_down(TypeOfLocation purpouse)throws LocationException;
    void walking(TypeOfLocation finish_place);
    void go_down(TypeOfLocation pass, TypeOfLocation finish_place)throws LocationException;
}

interface ClothesActions{
    void put_on(Clothes thing);
}

interface LightActions{
    void shining(int brightness, Character[] heroes)throws DayLightException;
}

interface RadiationEffects{
    void blinding(Character[] heroes);
}

interface LightEffects{
    void sparkling(Character[] heroes);
}

interface FaceActions{
    void squint();
}

interface SecretCommunication{
    void whistle(Messages mes, int volume, Character[] recievers);
    void recieveWhistle(Messages mes, int volume);
}

interface SoundEffects{
    void snoring(boolean snore);
}

interface Instruments{
    String getTrack(boolean start);
    void setName(String name);
    String getName();
}

interface ItemsActions{
    void removeItem(String name);
}
