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
    
    /**
     *
     * @param id
     * @param name
     * @param type
     * @param type_1
     * @param type_2
     * @param animaisNum
     */
    public Kepper(long id, String name, animalType type, animalType type_1, animalType type_2, long animaisNum) {
       this.id = id;
       this.name = name;
       this.type = type;
       this.type_1 = type_1;
       this.type_2 = type_2;
       this.animaisNum = animaisNum;
    }
    
    /**
     *
     * @param id
     * @param name
     * @param animaisNum
     */
    public Kepper(long id, String name, long animaisNum) {
       this.id = id;
       this.name = name;
       this.animaisNum = animaisNum;
    }
    
    /**
     *
     */
    public Kepper() {
    }

    /**
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public animalType getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(animalType type) {
        this.type = type;
    }
    
    /**
     *
     * @return
     */
    public animalType getType1() {
        return type_1;
    }

    /**
     *
     * @param type_1
     */
    public void setType1(animalType type_1) {
        this.type_1 = type_1;
    }
    
    /**
     *
     * @return
     */
    public animalType getType2() {
        return type_2;
    }

    /**
     *
     * @param type_2
     */
    public void setType2(animalType type_2) {
        this.type_2 = type_2;
    }
    
    /**
     *
     * @return
     */
    public long getAnimaisNum() {
        return animaisNum;
    }
    
    /**
     *
     * @param animalNumb
     */
    public void setAnimaisNum(long animalNumb) {
        this.animaisNum = animalNumb;
    }
}
