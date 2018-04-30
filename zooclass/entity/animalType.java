package zooclass.entity;

/**
 *
 * @author sora
 */
public enum animalType {

    /**
     *
     */
    MA("Mammal"),

    /**
     *
     */
    RE("Reptile"),

    /**
     *
     */
    AV("Avian"),

    /**
     *
     */
    AQ("Aquatic"),
 
    /**
     *
     */
    IN("Insect"); 
    
    private String description;
    
    /**
    * @param description
    */
    private animalType(String description) {
        this.description = description;
    }
    
   /**
   * @return the description
   */
   public String getDescription() {
           return description;
   }

   /**
   * @param description the description to set
   */
   public void setDescription(String description) {
           this.description = description;
   }
           
}
