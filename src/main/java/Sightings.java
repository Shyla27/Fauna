import com.sun.org.apache.bcel.internal.generic.AllocationInstruction;
import com.sun.org.apache.xerces.internal.xni.XMLString;

import java.util.ArrayList;
import java.util.List;

public class Sightings<Int> {
     private String location;
     private Int id;
     private String rangerName;

 public Sightings(String location, String rangerName) {
    this.location = location;
    this.rangerName = rangerName;
 }

    public String getRangerName() {
        return rangerName;
    }

      
      @Override
       public boolean equals(Object otherSightings){
        if (!(otherSightings instanceof Sightings)) {
            return false;
        } else {
            Sightings newSightings = (Sightings) otherSightings;
            return this.getLocation().equals(newSightings.getLocation()) &&
                    this.getRangerName().equals(newSightings.getRangerName());
        }
    }

    private String getLocation() {
        return location;
    }

}