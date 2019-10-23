import java.util.ArrayList;
import java.util.List;

public class Sightings {
     private String location;
     private Int id;
     private String rangerName;

 public Sighting(String location, String rangerName) {
    this.location = location;
    this.rangerName = rangerName;
 }

     public getLocation() {
         return location;
     }
      public getId() {
          return id;
      }
      public getName() {
          return name;
      }
      
      @Override
       public boolean equals(Object otherSighting){
        if (!(otherSighting instanceof Sighting)) {
            return false;
        } else {
            Sighting newSighting = (Sighting) otherSighting;
            return this.getLocation().equals(newSighting.getLocation()) &&
                    this.getRangerName().equals(newSighting.getRangerName());
        }
    }

}