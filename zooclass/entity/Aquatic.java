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
public class Aquatic extends Animals{

    public Aquatic(long exhibitNum, animalType Type, String name, String dateOfBirth, String dateOfArrived, genderType gender, String offspring, String medication, String vacine, Kepper kepper) {
        super(exhibitNum, Type, name, dateOfBirth, dateOfArrived, gender, offspring, medication, vacine, kepper);
    }
    
}
