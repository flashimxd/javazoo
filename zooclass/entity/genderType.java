/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooclass.entity;

/**
 *
 * @author sora
 */
public enum genderType {
    M("Male"),
    F("Female");
    
    private String description;
    
    private genderType(String description) {
        this.description = description;
    }
    
   /*
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
