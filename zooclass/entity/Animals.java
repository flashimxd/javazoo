package zooclass.entity;

/**
 *
 * @author sora
 */
public class Animals {

    private long exhibitNum;
    private animalType type;
    private String name;
    private String dateOfBirth;
    private String dateOfArrived;
    private genderType gender;
    private String offspring;
    private String medication;
    private String vacine;
    private Kepper kepper;

    /**
     *
     */
    public Animals() {

    }

    /**
     *
     * @param exhibitNum
     * @param type
     * @param name
     * @param dateOfBirth
     * @param dateOfArrived
     * @param gender
     * @param offspring
     * @param medication
     * @param vacine
     * @param kepper
     */
    public Animals(long exhibitNum, animalType type, String name, String dateOfBirth, String dateOfArrived, genderType gender, String offspring, String medication, String vacine, Kepper kepper) {
        this.exhibitNum = exhibitNum;
        this.type = type;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfArrived = dateOfArrived;
        this.gender = gender;
        this.offspring = offspring;
        this.medication = medication;
        this.vacine = vacine;
        this.kepper = kepper;
    }

    /**
     *
     * @return
     */
    public long getExhibitNum() {
        return exhibitNum;
    }

    /**
     *
     * @param exhibitNum
     */
    public void setExhibitNum(long exhibitNum) {
        this.exhibitNum = exhibitNum;
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
     * @param Type
     */
    public void setType(animalType Type) {
        this.type = Type;
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
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     *
     * @param dateOfBirth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     *
     * @return
     */
    public String getDateOfArrived() {
        return dateOfArrived;
    }

    /**
     *
     * @param dateOfArrived
     */
    public void setDateOfArrived(String dateOfArrived) {
        this.dateOfArrived = dateOfArrived;
    }

    /**
     *
     * @return
     */
    public genderType getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     */
    public void setGender(genderType gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     */
    public String getOffspring() {
        return offspring;
    }

    /**
     *
     * @param offspring
     */
    public void setOffspring(String offspring) {
        this.offspring = offspring;
    }

    /**
     *
     * @return
     */
    public String getMedication() {
        return medication;
    }

    /**
     *
     * @param medication
     */
    public void setMedication(String medication) {
        this.medication = medication;
    }

    /**
     *
     * @return
     */
    public String getVacine() {
        return vacine;
    }

    /**
     *
     * @param vacine
     */
    public void setVacine(String vacine) {
        this.vacine = vacine;
    }

    /**
     *
     * @return
     */
    public Kepper getKepper() {
        return kepper;
    }

    /**
     *
     * @param kepper
     */
    public void setKepper(Kepper kepper) {
        this.kepper = kepper;
    }

}
