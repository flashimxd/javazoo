package zooclass.entity;

/**
 *
//// * @author sora
 */
public enum genderType {

    /**
     *
     */
    M("Male"),

    /**
     *
     */
    F("Female");
    
    private String description;
    
    private genderType(String description) {
        this.description = description;
    }
    
   /*
   * @return the description
   */

    /**
     *
     * @return
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
