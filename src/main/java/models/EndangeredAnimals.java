package models;
import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimals extends  Animals {
    private static final String ANIMAL_TYPE = "endangered";
    public EndangeredAnimals(String name, String age, String health, String type) {
{
//        if (name.equals("")) {
//            throw new IllegalArgumentException("Please enter a name");
//        }
//        if (age.equals("")) {
//            throw new IllegalArgumentException("Please enter the age of the animal");
//        }
//        if (health.equals("")) {
//            throw new IllegalArgumentException("Please enter the health status of the animal");
//        }
        this.name = name;
        this.age = age;
        this.health = health;
        this.type = ANIMAL_TYPE;
    }}



    @Override
    public boolean equals(Object otherAnimal){
        if(!(otherAnimal instanceof Object)){
            return false;
        }
        Animals myAnimal = (Animals) otherAnimal;
        return this.getName().equals(myAnimal.getName())&&
                this.getType().equals(myAnimal.getType())&&
                this.getId()==myAnimal.getId() ;

    }
    @Override
    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO endangered (name,health, age,  type) VALUES (:name,:health, :age,  :type);";
                    con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("age", this.age)
                    .addParameter("health", this.health)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<EndangeredAnimals> all(){
        String sql = "SELECT * FROM endangered";
        try(org.sql2o.Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(EndangeredAnimals.class);
        }
    }

}