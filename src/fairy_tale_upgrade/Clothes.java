package fairy_tale_upgrade;

import java.util.Objects;

public abstract class Clothes {
    private final int size;
    private final String type;
    private final Condition condition;
    private final int capacity;

    Clothes(String type, int size, Condition condition, int capacity){
        this.size = size;
        this.type = type;
        this.condition = condition;
        this.capacity=capacity;
    }

    public static class Headdress extends Clothes{
        public Headdress(String type, int size, Condition condition) {
            super(type, size, condition,0);
        }

        public Headdress(String type, int size, Condition condition, int capacity){
            super(type, size, condition,capacity);
        }
    }

    public static class Outerwear extends Clothes{
        public Outerwear(String type, int size, Condition condition) {
            super(type, size, condition,0);
        }

        public Outerwear(String type, int size, Condition condition, int capacity){
            super(type, size, condition,capacity);
        }
    }
    @Override
    public String toString() {
        return "Clothes {" + "type = " + type + ", " + "size = " + size + ", " + "condition = " + condition + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Clothes)) return false;
        Clothes clothes = (Clothes) obj;
        return Objects.equals(size, clothes.size) && Objects.equals(type, clothes.type) && Objects.equals(condition, clothes.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, type, condition);
    }

    public int getSize() {
        return size;
    }

    public String getType(){return type;}

    public int getCapacity(){return capacity;}
}

