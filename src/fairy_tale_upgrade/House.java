package fairy_tale_upgrade;

public class House {
    private final String name;
    private Condition condition;
    private Window[] windows = new Window[100];
    private int resident_count = 0;

    public House(String name, Condition condition, Character[] residents){
        this.name=name;
        this.condition=condition;
        for(int i=0;i<residents.length;i++){
            windows[i]=new Window(Condition.Old,residents[i].getName());
            resident_count++;
        }
    }
    public void openWindow(String resident_name){
        for(int i=0;i<resident_count;i++){
            if(windows[i].getResident().equals(resident_name)){
                windows[i].open();
            }
        }
    }

    private class Window{
        private Condition condition;
        private String resident_name;
        boolean open = false;

        private Window(Condition condition,String resident_name){
            this.condition=condition;
            this.resident_name=resident_name;
        }

        private void open(){
            if(condition == Condition.Old){
                open = true;
                System.out.println("The window was opened with a bang by "+resident_name);
            }else{
                open = false;
                System.out.println("The window was opened by "+resident_name);
            }
        }

        private String getResident(){
            return resident_name;
        }
    }
}
