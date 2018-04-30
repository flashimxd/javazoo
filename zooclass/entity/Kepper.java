package zooclass.entity;

/**
 *
 * @author sora
 */
public class Kepper {
    
    private long id;
    private String name;
    private animalType type;
    private animalType type_1;
    private animalType type_2;
    private long animaisNum;
    
    public Kepper(long id, String name, animalType type, animalType type_1, animalType type_2, long animaisNum) {
       this.id = id;
       this.name = name;
       this.type = type;
       this.type_1 = type_1;
       this.type_2 = type_2;
       this.animaisNum = animaisNum;
    }
    
    public Kepper(long id, String name, long animaisNum) {
       this.id = id;
       this.name = name;
       this.animaisNum = animaisNum;
    }
    
    public Kepper() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public animalType getType() {
        return type;
    }

    public void setType(animalType type) {
        this.type = type;
    }
    
    public animalType getType1() {
        return type_1;
    }

    public void setType1(animalType type_1) {
        this.type_1 = type_1;
    }
    
    public animalType getType2() {
        return type_2;
    }

    public void setType2(animalType type_2) {
        this.type_2 = type_2;
    }
    
    public long getAnimaisNum() {
        return animaisNum;
    }
    
    public void setAnimaisNum(long animalNumb) {
        this.animaisNum = animalNumb;
    }
}
