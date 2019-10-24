package models;

import org.sql2o.Connection;

import java.util.List;

public class NonEndangered extends Animals  {
    private static final String ANIMAL_TYPE = "nonendangered";
    public NonEndangered (String name, String age, String health, String type){

        if (name.equals("")) {
            throw new IllegalArgumentException("Enter animal name");
        }
        if (age.equals("")) {
            throw new IllegalArgumentException("Enter animal age");
        }
        if (health.equals("")) {
            throw new IllegalArgumentException("Enter animal health");
        }
        this.name = name;
        this.age = age;
        this.health = health;
        this.type = ANIMAL_TYPE;


    }
    @Override
    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name, age, health, type) VALUES (:name, :age, :health, :type);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("age", this.age)
                    .addParameter("health", this.health)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
        }
    }
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
    public static List<NonEndangered> all(){
        String sql = "SELECT * FROM animals WHERE type='safe'";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(NonEndangered.class);
        }
    }


}
