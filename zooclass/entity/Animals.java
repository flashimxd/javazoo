package zooclass.entity;

/**
 *
 * @author sora
 */
public class Animals {
    
    private long exhibitNum;
    private animalType Type;
    private String name;
    private String dateOfBirth;
    private String dateOfArrived;
    private genderType gender;
    private String offspring;
    private String medication;
    private String vacine;
    private Kepper kepper;
    
    public Animals(){
        
    }
    
    public Animals(long exhibitNum, animalType Type, String name, String dateOfBirth, String dateOfArrived, genderType gender, String offspring, String medication, String vacine, Kepper kepper) {
        this.exhibitNum = exhibitNum;
        this.Type = Type;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfArrived = dateOfArrived;
        this.gender = gender;
        this.offspring = offspring;
        this.medication = medication;
        this.vacine = vacine;
        this.kepper = kepper;
    }
    
    public long getExhibitNum() {
        return exhibitNum;
    }

    public void setExhibitNum(long exhibitNum) {
        this.exhibitNum = exhibitNum;
    }

    public animalType getType() {
        return Type;
    }

    public void setType(animalType Type) {
        this.Type = Type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfArrived() {
        return dateOfArrived;
    }

    public void setDateOfArrived(String dateOfArrived) {
        this.dateOfArrived = dateOfArrived;
    }

    public genderType getGender() {
        return gender;
    }

    public void setGender(genderType gender) {
        this.gender = gender;
    }

    public String getOffspring() {
        return offspring;
    }

    public void setOffspring(String offspring) {
        this.offspring = offspring;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getVacine() {
        return vacine;
    }

    public void setVacine(String vacine) {
        this.vacine = vacine;
    }
    
    public Kepper getKepper() {
        return kepper;
    }

    public void setKepper(Kepper kepper) {
        this.kepper = kepper;
    }
    
}
