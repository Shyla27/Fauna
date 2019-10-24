package models;
import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;

public class Sightings implements AnimalInterface {
    private String name;
    private String location;
    private int animalId;
    private Timestamp timestamp;
    private int id = 0;
    public Sightings(String name, String location, int animalId) {
        if (name.equals("")) {
            throw new IllegalArgumentException("Please enter a name ");
        }
        //Exception for location
//        if (location.equals("")) {
//            throw new IllegalArgumentException("Please enter a location mate");
//        }
        this.name = name;
        this.location = location;
        this.animalId = animalId;
        this.id = 0;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getAnimalId() {
        return animalId;
    }

    public int getId() {
        return id;
    }

    public Timestamp getSpottedat() {
        return timestamp;
    }
    public Animals getAnimal() {
        String sql = "SELECT * FROM animal WHERE id = :id";
        try(Connection con = DB.sql2o.open()){
            Animals myAnimal = con.createQuery(sql)
                    .addParameter("id",this.animalId)
                    .executeAndFetchFirst(Animals.class);
            return myAnimal;
        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (name, location, animalId, timestamp) VALUES (:name, :location, :animalId, now());";
                     con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("location", this.location)
                    .addParameter("animalId", this.animalId)
                    .executeUpdate()
                    .getKey();
        }
    }
    @Override
    public boolean equals(Object otherSighting){
        if(!(otherSighting instanceof Object)){
            return false;
        }
        Sightings myAnimal = (Sightings) otherSighting;
        return this.getName().equals(myAnimal.getName())&&
                this.getLocation().equals(myAnimal.getLocation())&&
                this.getId()==myAnimal.getId() ;
    }
    public static List<Sightings> all(){
        String sql = "SELECT * FROM sightings;";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sightings.class);
        }
    }
    public static Sightings find(int id){
        String sql = "SELECT * FROM sightings WHERE id = :id";
        try(Connection con = DB.sql2o.open()) {
            Sightings sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sightings.class);
            return sighting;
        }
    }

     @Override
    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM sightings WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

}