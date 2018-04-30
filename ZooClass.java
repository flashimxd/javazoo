
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import zooclass.entity.Animals;
import zooclass.entity.Aquatic;
import zooclass.entity.Avian;
import zooclass.entity.Insect;
import zooclass.entity.Kepper;
import zooclass.entity.Mammal;
import zooclass.entity.Reptile;
import zooclass.entity.animalType;
import zooclass.entity.genderType;


/**
 *
 * @author sora
 */
public class ZooClass {    

    /**
     *
     */
    public static void getHeader() {
            System.out.println("=================================================================");
            System.out.println("==== Object Oriented Constructs - CCT ====");
            System.out.println("==== Project Title: CCTZoo  - Sora ================");
            System.out.println("==== Please, enter with your option to use the CCTZoo system ====== \n");
            System.out.println("A)	See all Animals \n"
                            + "B)	See all Keepers \n"
                            + "C)	Search for Animals \n"
                            + "D)	Search for Keepers \n"
                            + "E)	Add new animals \n"
                            + "F)	Add new keepers \n"
                            + "G)	Update animals \n"
                            + "H)	Update keepers \n");

            System.out.println("Enter with your option...");
    }
    
    private static void getAnimalsList(Integer id) {
       
        JSONArray animals = new JSONArray();
        JSONObject a_return = new JSONObject();

        if(id == 0){
            animals = getAnimals(); 
        }else{
            String a_id = String.valueOf(id);
            a_return = findAnimal(a_id);
            animals.add(a_return);
        }
        
        System.out.println("==== See Bellow all the animals of the CCTZoo ===== \n"); 
        String leftAlignFormat = "| %-10s | %-14s |%-11s | %-12s | %-12s | %-10s | %-10s | %-20s |  %-15s |  %-16s  |%n";
        System.out.format("+------------+----------------+------------+--------------+--------------+------------+-----------------------------------+------------------+--------------------+%n");
        System.out.format("| Ex Number  | Name           |  Type      | Birth day    | Date Arrived |   Gender   |  Offspring | Medication           |   Vacine         |    Kepper          |%n");
        System.out.format("+------------+----------------+------------+--------------+--------------+------------+-----------------------------------+------------------+--------------------+%n");

        JSONArray keepers = getKeppers();
        for (Object a : animals)
        {
          JSONObject animal = (JSONObject) a;
          String name = (String) animal.get("name");
          String exhibitNum = (String) animal.get("exhibitNum");
          String type = (String) animal.get("type");
          String dbirth = (String) animal.get("dateOfBirth");
          String dateOfArrived = (String) animal.get("dateOfArrived");
          String gender = (String) animal.get("gender");
          String offspring = (String) animal.get("offspring");
          String medication = (String) animal.get("medication");
          String vacine = (String) animal.get("vacine");
          String k_id = (String) animal.get("k_id");
          String a_kp = "";
          Integer ex_num = Integer.valueOf(exhibitNum);
          Animals ani = new Animals();

          if(name.length() > 0){
              for (Object k : keepers)
              {
                JSONObject kepper = (JSONObject) k;
                String kp_id = (String) kepper.get("id");
                if(k_id.equals(kp_id)){
                    a_kp = (String) kepper.get("name");
                    String tp = (String) kepper.get("type");
                    String array1[]= tp.split(",");
                    Integer i = 1;
                    Kepper kp = new Kepper();
                    Integer ki_id = Integer.valueOf(kp_id);
                    kp.setId(ki_id);
                    kp.setName(a_kp);
                    animalType atp;
                    for (String temp: array1){
                       switch(temp){
                           case "MA":
                               atp = animalType.MA;
                               if(i == 1){
                                   kp.setType(atp);
                               }else if(i == 2){
                                   kp.setType1(atp);
                               }else if(i == 3){
                                   kp.setType2(atp);
                               }
                           break;
                           
                           case "RE":
                               atp = animalType.RE;
                               if(i == 1){
                                   kp.setType(atp);
                               }else if(i == 2){
                                   kp.setType1(atp);
                               }else if(i == 3){
                                   kp.setType2(atp);
                               }
                           break;
                           
                           case "AV":
                               atp = animalType.AV;
                               if(i == 1){
                                   kp.setType(atp);
                               }else if(i == 2){
                                   kp.setType1(atp);
                               }else if(i == 3){
                                   kp.setType2(atp);
                               }
                           break;
                           
                           case "AQ":
                               atp = animalType.AQ;
                               if(i == 1){
                                   kp.setType(atp);
                               }else if(i == 2){
                                   kp.setType1(atp);
                               }else if(i == 3){
                                   kp.setType2(atp);
                               }
                           break;
                           
                           case "IN":
                               atp = animalType.IN;
                               if(i == 1){
                                   kp.setType(atp);
                               }else if(i == 2){
                                   kp.setType1(atp);
                               }else if(i == 3){
                                   kp.setType2(atp);
                               }
                           break;
                       }
                       i++;
                       
                    }
                    
                    genderType gen = ( gender == "M") ? genderType.M : genderType.F;
                    
                    switch(type) {
                        case "MA":
                          ani = new Mammal(ex_num, animalType.MA, name, dbirth, dateOfArrived, gen, offspring, medication, vacine, kp);
                        break;
                        
                        case "RE":
                          ani = new Reptile(ex_num, animalType.RE, name, dbirth, dateOfArrived, gen, offspring, medication, vacine, kp);
                        break;
                        
                        case "AV":
                          ani = new Avian(ex_num, animalType.AV, name, dbirth, dateOfArrived, gen, offspring, medication, vacine, kp);
                        break;
                        
                        case "AQ":
                          ani = new Aquatic(ex_num, animalType.AQ, name, dbirth, dateOfArrived, gen, offspring, medication, vacine, kp);
                        break;
                        
                        case "IN":
                          ani = new Insect(ex_num, animalType.AQ, name, dbirth, dateOfArrived, gen, offspring, medication, vacine, kp);
                        break;
                        
                      }                    
                }
                
              }
              System.out.format(leftAlignFormat, ani.getExhibitNum(), ani.getName(), ani.getType().name(),ani.getDateOfBirth() , ani.getDateOfArrived(), ani.getGender().name(), ani.getOffspring(), ani.getMedication(), ani.getVacine(), ani.getKepper().getName());
          }
        }
    }
    
    private static void getKeepersList(Integer id) {
        
        JSONArray keppers = new JSONArray();
        JSONObject k_return = new JSONObject();

        if(id == 0){
            keppers = getKeppers(); 
        }else{
            String k_id = String.valueOf(id);
            k_return = findKeeper(k_id);
            keppers.add(k_return);
        }
        
        System.out.println("==== See Bellow all the Keepers of the CCTZoo ===== \n");
        JSONArray keepers = getKeppers();
        String leftAlignFormat = "| %-3s | %-14s | %-17s | %-15s | %n";
        System.out.format("+-----+----------------+-------------------+-----------------+%n");
        System.out.format("| id  | Name           |   Allowed Types   | Animais Keeping |%n");
        System.out.format("+-----+----------------+-------------------+-----------------+%n");
        
        for (Object k : keppers)
        {
            JSONObject kepper = (JSONObject) k;
            String kp_id = (String) kepper.get("id");
            String a_kp = (String) kepper.get("name");
            String tp = (String) kepper.get("type");
            String animais_kp = (String) kepper.get("animais_kp");
            String array1[]= tp.split(",");
            Integer i = 1;
            Integer ki_id = Integer.valueOf(kp_id);
            Integer ani_kp = Integer.valueOf(animais_kp);
            Kepper kp = new Kepper(ki_id, a_kp, ani_kp);
            animalType atp;
            
            for (String temp: array1){
               switch(temp){
                   case "MA":
                       atp = animalType.MA;
                       if(i == 1){
                           kp.setType(atp);
                       }else if(i == 2){
                           kp.setType1(atp);
                       }else if(i == 3){
                           kp.setType2(atp);
                       }
                   break;

                   case "RE":
                       atp = animalType.RE;
                       if(i == 1){
                           kp.setType(atp);
                       }else if(i == 2){
                           kp.setType1(atp);
                       }else if(i == 3){
                           kp.setType2(atp);
                       }
                   break;

                   case "AV":
                       atp = animalType.AV;
                       if(i == 1){
                           kp.setType(atp);
                       }else if(i == 2){
                           kp.setType1(atp);
                       }else if(i == 3){
                           kp.setType2(atp);
                       }
                   break;

                   case "AQ":
                       atp = animalType.AQ;
                       if(i == 1){
                           kp.setType(atp);
                       }else if(i == 2){
                           kp.setType1(atp);
                       }else if(i == 3){
                           kp.setType2(atp);
                       }
                   break;

                   case "IN":
                       atp = animalType.IN;
                       if(i == 1){
                           kp.setType(atp);
                       }else if(i == 2){
                           kp.setType1(atp);
                       }else if(i == 3){
                           kp.setType2(atp);
                       }
                   break;
               }
               i++;

            }
            System.out.format(leftAlignFormat, kp.getId(), kp.getName(), kp.getType().name()+", "+kp.getType1().name()+", "+kp.getType2().name() , kp.getAnimaisNum());
        }
    }
    
    private static JSONArray getKeppers() {
        JSONArray a = new JSONArray();
        
        try{
            JSONParser parser = new JSONParser();
            String path = new File("src/data/keppers.json").getAbsolutePath();
            a = (JSONArray) parser.parse(new FileReader(path));
            return a;
        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        catch(ParseException e){e.printStackTrace();}
        catch(Exception e){e.printStackTrace();}
        
        return a;
    }
    
    private static JSONObject findAnimal(String id) {
        JSONObject animal = new JSONObject();
        JSONArray animals = getAnimals();
        for (Object a : animals)
        {
          animal = (JSONObject) a;
          String a_id = (String) animal.get("exhibitNum").toString();
          if(id.equals(a_id)){
              return animal;
          }
        }
        return new JSONObject();
    }
    
    private static JSONObject findKeeper(String id) {
        JSONObject kepper = new JSONObject();
        JSONArray keppers = getKeppers();
        for (Object k : keppers)
        {
          kepper = (JSONObject) k;
          String a_id = (String) kepper.get("id").toString();
          if(id.equals(a_id)){
              return kepper;
          }
        }
       return new JSONObject();
    }
    
    private static JSONArray getAnimals() {
        JSONArray a = new JSONArray();
        
        try{
            JSONParser parser = new JSONParser();
            String path = new File("src/data/animais.json").getAbsolutePath();
            a = (JSONArray) parser.parse(new FileReader(path));
            return a;
        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        catch(ParseException e){e.printStackTrace();}
        catch(Exception e){e.printStackTrace();}
        
        return a;
    }
    
    private static void getAnimalByExNumber() {
        System.out.println("==== Enter with the exibition number to see animal details ===== \n");
        try(Scanner in = new Scanner(System.in)) {
            String input = in.next();
            Integer id = Integer.valueOf(input);
            getAnimalsList(id);
        }catch(NumberFormatException e) {
            System.out.println("Looks like you entered a non valid option");
        }
    }
    
    private static void getKepperById() {
        System.out.println("==== Enter with the Kepper id to see the Kepper details ===== \n");
        try(Scanner in = new Scanner(System.in)) {
            String input = in.next();
            Integer id = Integer.valueOf(input);
            getKeepersList(id);
        }catch(NumberFormatException e) {
            System.out.println("Looks like you entered a non valid option");
        }
    }
    
    private static void addNewAnimal() {
        //set default values to vars
        String name;
        String type = "";
        String dateOfBirth = "";
        String dateOfArrived = "";
        String gender = "";
        String offspring = "";
        String medication = "";
        String vacine = "";
        String kepper = "";
        
        System.out.println("==== Add a new Animal ===== \n");
        System.out.println("==== Enter with the Animal name ===== \n");
        try(Scanner in = new Scanner(System.in)) {
            String input = in.next();
            if(input.length() < 4){
                System.out.println("Name of a animal must have at least 3 characters.");
            }else{
                name = input;
                System.out.println("==== Enter with the Animal type MA(Mammal), RE(Reptile), AV(Avian), AQ(Aquatic) or IN(Insect). ===== \n");
                
                String input2 = in.next();
             
                if(input2.equals("MA") || input2.equals("RE") || input2.equals("AV") || input2.equals("AQ") || input2.equals("IN")) {      
                    type = input2;
                    
                    System.out.println("==== Enter with the Animal Date of birthday ===== \n");
                    String input3 = in.next();
                    if(input3.length() > 4){
                        dateOfBirth = input3;
                        System.out.println("==== Enter with the Animal Date of arrived ===== \n");
                        String input4 = in.next();
                        if(input4.length() > 4){
                            dateOfArrived = input4;
                            System.out.println("==== Enter with the Animal Gender(M(Male) or F(Female))===== \n");
                            String input5 = in.next();
                            if(input5.equals("M") || input5.equals("F")){
                                gender = input5;
                                System.out.println("==== Enter with the Animal Offspring ===== \n");
                                offspring = in.next();
                                System.out.println("==== Enter with the Animal Medication ===== \n");
                                medication= in.next();
                                System.out.println("==== Enter with the Animal Vacine ===== \n");
                                vacine = in.next();
                                System.out.println("==== Enter with the Kepper ID (Check keppers list if you are not sure about this information)===== \n");
                                String kid = in.next();
                                JSONObject result = findKeeper(kid);
                                //check if the kepper exist
                                if(result.isEmpty()) {
                                    System.out.println("Looks like you entered a non valid kepper ID (Check keppers list if you are not sure about this information)");
                                }else{
                                    //check if the keeper has permission to take care of this kind of animal
                                    if(!checkIfTypeIsAllowed(kid, type)){
                                        System.out.println("This keeper is not allowed to take care of this type of animal.");
                                    }else{
                                        System.out.println(result.get("animais_kp"));
                                        String an_kpp = (String) result.get("animais_kp");
                                        Integer akpp = Integer.valueOf(an_kpp);
                                        //check if the keeper has no longer more than 10 animals
                                        if(akpp >= 10){
                                            System.out.println("This keeper is already taking care of 10 animals, chose another one.");

                                        }else{
                                            kepper = kid;
                                            JSONArray animals = getAnimals();
                                            JSONObject a_return = new JSONObject();
                                            Integer ex_num = animals.size();
                                            a_return.put("exhibitNum", ex_num + 1);
                                            a_return.put("name", name);
                                            a_return.put("type", type);
                                            a_return.put("dateOfBirth", dateOfBirth);
                                            a_return.put("dateOfArrived", dateOfArrived);
                                            a_return.put("gender", gender);
                                            a_return.put("offspring", offspring);
                                            a_return.put("medication", medication);
                                            a_return.put("vacine", vacine);
                                            a_return.put("kepper", kepper);

                                            animals.add(a_return);

                                            try(FileWriter file = new FileWriter("src/data/animais.json")){
                                                file.write(animals.toString());
                                                file.flush();
                                                System.out.println("New Animal add succefull!");
                                                //TODO incrementar número no kepping list
                                            }catch(IOException e){
                                                e.printStackTrace();
                                            }

                                        }
                                    }
                                }
                            }else{
                                System.out.println("Looks like you entered a non valid option");
                            }
                        }else{
                            System.out.println("Looks like you entered a non valid option");
                        }
                        
                    }else{
                        System.out.println("Looks like you entered a non valid option");
                    }
                }else{
                    System.out.println("Looks like you entered a non valid option");
                }
            }
        }catch(NumberFormatException e) {
            System.out.println("Looks like you entered a non valid option");
        }
    }
    
    private static void addNewKeeper() {
        String name = "";
        String animalType = "";
        String animalType1 = "";
        String animalType2 = "";
    
        System.out.println("==== Add a new Keeper ===== \n");
        System.out.println("==== Enter with the Keeper name ===== \n");
        try(Scanner in = new Scanner(System.in)) {
            String input = in.next();
            if(input.length() < 4){
                System.out.println("Name of a Keeper must have at least 3 characters.");
            }else{
                name = input;
                System.out.println("==== Enter with the Animal type 1 MA(Mammal), RE(Reptile), AV(Avian), AQ(Aquatic) or IN(Insect). ===== \n");
                
                String input2 = in.next();
             
                if(input2.equals("MA") || input2.equals("RE") || input2.equals("AV") || input2.equals("AQ") || input2.equals("IN")) {
                    animalType = input2;
                    System.out.println("==== Enter with the Animal type 2 MA(Mammal), RE(Reptile), AV(Avian), AQ(Aquatic) or IN(Insect). ===== \n");
                    String input3 = in.next();
                    
                    if(input3.equals("MA") || input3.equals("RE") || input3.equals("AV") || input3.equals("AQ") || input3.equals("IN")) {
                        animalType1 = input3;
                        
                        System.out.println("==== Enter with the Animal type 3 MA(Mammal), RE(Reptile), AV(Avian), AQ(Aquatic) or IN(Insect). ===== \n");
                        String input4 = in.next();
                        if(input4.equals("MA") || input4.equals("RE") || input4.equals("AV") || input4.equals("AQ") || input4.equals("IN")) {
                            animalType2 = input4;
                            String type = animalType+","+animalType1+","+animalType2;
                            JSONArray keepers = getKeppers();
                            JSONObject k_return = new JSONObject();
                            Integer id = keepers.size();
                            k_return.put("id", id + 1);
                            k_return.put("name", name);
                            k_return.put("animais_kp", "0");
                            k_return.put("type", type);

                            keepers.add(k_return);

                            try(FileWriter file = new FileWriter("src/data/keppers.json")){
                                file.write(keepers.toString());
                                file.flush();
                                System.out.println("New Keeper add succefull!");
                            }catch(IOException e){
                                e.printStackTrace();
                            }
                            
                        }else{
                            System.out.println("Looks like you entered a non valid option");
                        }
                        
                    }else{
                        System.out.println("Looks like you entered a non valid option");
                    }
                    
                    
                }else{
                    System.out.println("Looks like you entered a non valid option");
                }
            }
        }catch(NumberFormatException e) {
            System.out.println("Looks like you entered a non valid option");
        }
    }
    
    private static void updateAnimal() {
        String name = "";
        String type = "";
        String dateOfBirth = "";
        String dateOfArrived = "";
        String gender = "M";
        String offspring = "";
        String medication = "";
        String vacine = "";
        String kepper = "";
        
        System.out.println("==== Update Animal ===== \n");
        
        try(Scanner in = new Scanner(System.in)) {
            
            System.out.println("==== Type the Animal Exibition Number (Check Animals list if you are not sure about this information) ===== \n");
            String aid = in.next();            
            JSONObject animal = findAnimal(aid);
            if(animal.isEmpty()) {
                System.out.println("Looks like you entered a non valid Animal Exibition number (Check Animals list if you are not sure about this information)");
            }else{
                System.out.println("==== What you want to change? 1(Name), 2(Type), 3(Date of birthday), 4(Date of arrived), 5(Gender), 6(Offspring), 7(medication), 8(Vacine), 9(Keeper) ===== \n");
                String input = in.next();
                switch(input){
                    //set Name
                    case "1":
                        System.out.println("==== Type the new Animal Name ===== \n");
                        String nName = in.next();
                        if(nName.length() > 3){
                            animal.remove("name");
                            Animals an =  new Animals();
                            an.setName(nName);
                            animal.put("name", an.getName());
                            setAnimal(animal);
                        }else{
                            System.out.println("==== A new name must be at least 4 characters. ===== \n");
                        }
                    break;
                    //set type
                    case "2":
                        System.out.println("==== Enter with the new Animal Type MA(Mammal), RE(Reptile), AV(Avian), AQ(Aquatic) or IN(Insect) ===== \n");
                        String typeA = in.next();
                        if(typeA.equals("MA") || typeA.equals("RE") || typeA.equals("AV") || typeA.equals("AQ") || typeA.equals("IN")) {
                            animal.remove("type");
                            Animals an =  new Animals();
                            animalType atp = animalType.AQ;
                            switch(typeA){
                                case "MA":
                                    atp = animalType.MA;
                                break;

                                case "RE":
                                    atp = animalType.RE;
                                break;

                                case "AV":
                                    atp = animalType.AV;
                                break;

                                case "AQ":
                                    atp = animalType.AQ;
                                break;

                                case "IN":
                                    atp = animalType.IN;
                                break;
                            }
                            an.setType(atp);
                            animal.put("type", an.getType().toString());
                            setAnimal(animal);
                        }else{
                            System.out.println("Looks like you entered a non valid option");
                        }
                    break;
                    //set data of birthday
                    case "3":
                        System.out.println("==== Type the new Animal Birthday ===== \n");
                        String bday = in.next();
                        if(bday.length() > 3){
                            animal.remove("dateOfBirth");
                            Animals an =  new Animals();
                            an.setDateOfBirth(bday);
                            animal.put("dateOfBirth", an.getDateOfBirth());
                            setAnimal(animal);
                        }else{
                            System.out.println("==== A birth day date must be at least 4 characters. ===== \n");
                        }
                    break;
                    //set data of arrived
                    case "4":
                        System.out.println("==== Type the new Animal Arrived date ===== \n");
                        String aday = in.next();
                        if(aday.length() > 3){
                            animal.remove("dateOfBirth");
                            Animals an =  new Animals();
                            an.setDateOfArrived(aday);
                            animal.put("dateOfArrived", an.getDateOfArrived());
                            setAnimal(animal);
                        }else{
                            System.out.println("==== A arrived day date must be at least 4 characters. ===== \n");
                        }
                    break;
                    //set Gender
                    case "5":
                        System.out.println("==== Type the new Animal gender M(Male), F(Female) ===== \n");
                        String ag = in.next();
                        if(ag.equals("M") || ag.equals("F")) {
                            animal.remove("gender");
                            Animals an =  new Animals();
                            genderType gen = (  ag.equals("M")) ? genderType.M : genderType.F;
                            an.setGender(gen);
                            animal.put("gender", an.getGender().toString());
                            setAnimal(animal);
                        }else{
                            System.out.println("Looks like you entered a non valid option");
                        }
                    break;
                    //set offspring
                    case "6":
                        System.out.println("==== Type the new Animal offspring ===== \n");
                        String offsp = in.next();
                        if(offsp.length() > 3){
                            animal.remove("offspring");
                            Animals an =  new Animals();
                            an.setOffspring(offsp);
                            animal.put("offspring", an.getOffspring());
                            setAnimal(animal);
                        }else{
                            System.out.println("==== A new name must be at least 4 characters. ===== \n");
                        }
                    break;
                    //set medication
                    case "7":
                        System.out.println("==== Type the new Animal Medication ===== \n");
                        String med = in.next();
                        if(med.length() > 3){
                            animal.remove("medication");
                            Animals an =  new Animals();
                            an.setMedication(med);
                            animal.put("medication", an.getMedication());
                            setAnimal(animal);
                        }else{
                            System.out.println("==== A Medication name must be at least 4 characters. ===== \n");
                        }
                    break;
                    //set vacine
                    case "8":
                        System.out.println("==== Type the new Animal Vacine ===== \n");
                        String vac = in.next();
                        if(vac.length() > 3){
                            animal.remove("vacine");
                            Animals an =  new Animals();
                            an.setVacine(vac);
                            animal.put("vacine", an.getVacine());
                            setAnimal(animal);
                        }else{
                            System.out.println("==== A new vacine name must be at least 4 characters. ===== \n");
                        }
                    break;
                    //set keeper
                    case "9":
                        //todo check if type is allowed, check limit 10, olhar se o keeper existe
                        System.out.println("Enter with the Kepper ID (Check keppers list if you are not sure about this information)");
                        String kpid = in.next();
                        JSONObject result = findKeeper(kpid);
                        String anT = (String) animal.get("type");
                        //check if the kepper exist
                        if(result.isEmpty()) {
                            System.out.println("Looks like you entered a non valid kepper ID (Check keppers list if you are not sure about this information)");
                        }else{
                            //check if the keeper has permission to take care of this kind of animal
                            if(!checkIfTypeIsAllowed(kpid, anT)){
                                System.out.println("This keeper is not allowed to take care of this type of animal.");
                            }else{
                                String an_kpp = (String) result.get("animais_kp");
                                Integer akpp = Integer.valueOf(an_kpp);
                                //check if the keeper has no longer more than 10 animals
                                if(akpp >= 10){
                                    System.out.println("This keeper is already taking care of 10 animals, chose another one.");
                                }else{
                                    animal.remove("k_id");
                                    Animals an =  new Animals();
                                    Integer ki = Integer.valueOf(kpid);
                                    Kepper kpe = new Kepper();
                                    kpe.setId(ki);
                                    an.setKepper(kpe);
                                    animal.put("k_id", an.getKepper().getId());
                                    setAnimal(animal);
                                }
                            }
                    }
                    break;
                }
            }
        }catch(NumberFormatException e) {
            System.out.println("Looks like you entered a non valid option");
        }
        
    }
    
    private static void updateKepper() {
        String name = "";
        String animalType0 = "";
        String animalType1 = "";
        String animalType2 = "";
        
        System.out.println("==== Update Keeper ===== \n");
        
        try(Scanner in = new Scanner(System.in)) {
            
            System.out.println("==== Type the Keeper ID (Check keepers list if you are not sure about this information) ===== \n");
            
            String keid = in.next();            
            JSONObject keeper = findKeeper(keid);
            //check if the kepper exist
            if(keeper.isEmpty()) {
                System.out.println("Looks like you entered a non valid kepper ID (Check keppers list if you are not sure about this information)");
            }else{
                System.out.println("==== What you want to change? 1(Name), 2(Type 1), 3(Type 2), 4(Type 3) ===== \n");
                String input = in.next();

                if(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") ){
                    switch(input){
                        //modify keeper name
                        case "1":
                            System.out.println("==== Type the new Keeper Name ===== \n");
                            String nName = in.next();
                            if(nName.length() > 3){
                                keeper.remove("name");
                                Kepper kp =  new Kepper();
                                kp.setName(nName);
                                keeper.put("name", kp.getName());
                                setKeeper(keeper);
                            }else{
                                System.out.println("==== A new name must be at least 4 characters. ===== \n");
                            }
                        break;
                        
                        //modify keeper type 1
                        case "2":
                            System.out.println("==== Enter with the Type 1 MA(Mammal), RE(Reptile), AV(Avian), AQ(Aquatic) or IN(Insect) ===== \n");
                            String tp = in.next();
                            animalType atp = animalType.AQ;
                            if(tp.equals("MA") || tp.equals("RE") || tp.equals("AV") || tp.equals("AQ") || tp.equals("IN") ){
                                Kepper kp =  new Kepper();
                                switch(tp){
                                    case "MA":
                                        atp = animalType.MA;
                                    break;

                                    case "RE":
                                        atp = animalType.RE;
                                    break;

                                    case "AV":
                                        atp = animalType.AV;                           
                                    break;

                                    case "AQ":
                                        atp = animalType.AQ;                                        
                                    break;

                                    case "IN":
                                        atp = animalType.IN;
                                    break;
                                }
                                
                                kp.setType(atp);
                                Integer kpid = Integer.valueOf(keid);
                                kp.setId(kpid);
                                setKeeperType(1, kp);
                            }else{
                                System.out.println("Looks like you entered a non valid option");
                            }
                        break;
                        
                        //modify keeper type 2
                        case "3":
                            System.out.println("==== Enter with the Type 2 MA(Mammal), RE(Reptile), AV(Avian), AQ(Aquatic) or IN(Insect) ===== \n");
                            String tp2 = in.next();
                            animalType atp2 = animalType.AQ;
                            if(tp2.equals("MA") || tp2.equals("RE") || tp2.equals("AV") || tp2.equals("AQ") || tp2.equals("IN") ){
                                Kepper kp =  new Kepper();
                                switch(tp2){
                                    case "MA":
                                        atp2 = animalType.MA;
                                    break;

                                    case "RE":
                                        atp2 = animalType.RE;
                                        
                                    break;

                                    case "AV":
                                        atp2 = animalType.AV;
                                       
                                    break;

                                    case "AQ":
                                        atp2 = animalType.AQ;
                                        
                                    break;

                                    case "IN":
                                        atp2 = animalType.IN;
                                    break;
                                }
                                
                                kp.setType1(atp2);
                                Integer kpid = Integer.valueOf(keid);
                                kp.setId(kpid);
                                setKeeperType(2, kp);
                            }else{
                                System.out.println("Looks like you entered a non valid option");
                            }

                        break;
                        
                        //modify keeper type 3
                        case "4":
                            System.out.println("==== Enter with the Type 3 MA(Mammal), RE(Reptile), AV(Avian), AQ(Aquatic) or IN(Insect) ===== \n");
                            String tp3 = in.next();
                            animalType atp3 = animalType.AQ;
                            if(tp3.equals("MA") || tp3.equals("RE") || tp3.equals("AV") || tp3.equals("AQ") || tp3.equals("IN") ){
                                Kepper kp =  new Kepper();
                                switch(tp3){
                                    case "MA":
                                        atp3 = animalType.MA;
                                    break;

                                    case "RE":
                                        atp3 = animalType.RE;
                                        
                                    break;

                                    case "AV":
                                        atp3 = animalType.AV;
                                       
                                    break;

                                    case "AQ":
                                        atp3 = animalType.AQ;
                                        
                                    break;

                                    case "IN":
                                        atp3 = animalType.IN;
                                    break;
                                }
                                
                                kp.setType2(atp3);
                                Integer kpid = Integer.valueOf(keid);
                                kp.setId(kpid);
                                setKeeperType(3, kp);
                            }else{
                                System.out.println("Looks like you entered a non valid option");
                            }

                        break;
                    }
                }else{
                    System.out.println("Looks like you entered a non valid option");
                }
            }
            
        }catch(NumberFormatException e) {
            System.out.println("Looks like you entered a non valid option");
        }
    }
    
    private static void setAnimal(JSONObject an) {
        JSONArray animals = getAnimals();
        JSONObject animal = new JSONObject();
        String id = (String) an.get("exhibitNum").toString();
       
        for (Object k : animals)
        {
          animal = (JSONObject) k;
          String a_id = (String)animal.get("exhibitNum").toString();
          if(id.equals(a_id)){
              Integer idSet = Integer.valueOf(a_id);
              //set the new value
              animals.set(idSet - 1, an);
          }
        }
        
        //then, modify the JSON with the new keepers list
        try(FileWriter file = new FileWriter("src/data/animais.json")){
            file.write(animals.toString());
            file.flush();
            System.out.println("Animal information succefull updated!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private static void setKeeper(JSONObject kp) {
        
        JSONArray keepers = getKeppers();
        JSONObject keeper = new JSONObject();
        String id = (String) kp.get("id").toString();
       
        for (Object k : keepers)
        {
          keeper = (JSONObject) k;
          String a_id = (String)keeper.get("id").toString();
          if(id.equals(a_id)){
              Integer idSet = Integer.valueOf(a_id);
              //set the new value
              keepers.set(idSet - 1, kp);
          }
        }
        
        //then, modify the JSON with the new keepers list
        try(FileWriter file = new FileWriter("src/data/keppers.json")){
            file.write(keepers.toString());
            file.flush();
            System.out.println("Keeper information succefull updated!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private static void setKeeperType(Integer step, Kepper kp) {
        Long id = kp.getId();
        String keid = String.valueOf(id);
        JSONObject keeper = findKeeper(keid);
        String tp = (String)keeper.get("type");
        keeper.remove("type");
        String types[]= tp.split(",");
        
        if(step == 1){    
            keeper.put("type", kp.getType()+","+types[1]+","+types[2]);
            setKeeper(keeper);
        }else if(step == 2){
            keeper.put("type", types[0]+","+kp.getType1()+","+types[2]);
            setKeeper(keeper);
        }else{
            keeper.put("type", types[0]+","+types[1]+","+kp.getType2());
            setKeeper(keeper);
        }
    }
    
    private static JSONArray deleteKepperFromArray(Integer id) {
        JSONArray keepers = getKeppers();
        keepers.remove(id -1);
        return keepers;
    }
    
    private static boolean checkIfTypeIsAllowed(String id, String AnimalType) {
        JSONObject kp = findKeeper(id);
        String tp = (String) kp.get("type");
        String array1[]= tp.split(",");

        return Arrays.asList(array1).contains(AnimalType);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            getHeader();
            String input = in.next();
            
            switch(input){
                case "A":
                    //TODO get all animais
                    getAnimalsList(0);
                break;
                
                case "B":
                    //TODO get all keepers
                    getKeepersList(0);
                break;
                
                case "C":
                    //TODO get animal by ex numb
                    getAnimalByExNumber();
                break;
                
                case "D":
                    //TODO get kepper by id
                    getKepperById();
                break;
                
                case "E":
                    //add new animal
                    addNewAnimal();
                break;
                
                case "F":
                    //add new kepper
                    addNewKeeper();
                break;
                
                case "G":
                    //Update animal
                    updateAnimal();
                break;
                
                case "H":
                    //Update Keeper
                    updateKepper();
                break;
                
                default:
                    System.out.println("Looks like you entered a non valid option");
                break;
            }
            //System.out.println(input);
            
        } catch(NumberFormatException e) {
            System.out.println("Looks like you entered a non valid option");
        }
    }
    
}
