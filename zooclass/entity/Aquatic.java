package zooclass.entity;

/**
 *
 * @author sora
 */
public class Aquatic extends Animals{

    /**
     *
     * @param exhibitNum
     * @param Type
     * @param name
     * @param dateOfBirth
     * @param dateOfArrived
     * @param gender
     * @param offspring
     * @param medication
     * @param vacine
     * @param kepper
     */
    public Aquatic(long exhibitNum, animalType Type, String name, String dateOfBirth, String dateOfArrived, genderType gender, String offspring, String medication, String vacine, Kepper kepper) {
        super(exhibitNum, Type, name, dateOfBirth, dateOfArrived, gender, offspring, medication, vacine, kepper);
    }
    
}
