import org.junit.Test;
 
import java.util.Arrays;

import static org.junit.Assert.*;
 public class SightingTest {
     
     @Test  
     public void Sighting_instantiatesCorrectly_true() {
         Sighting testSighting = setupNewSighting();
         assertEquals(true, testSighting instanceof  Sighting);
     } 
     @Test 
     public void getRangerName_sightingInstantiatesWithRangerName_String() {
         Sighting testSighting = setupNewSighting();
         assertEquals(Mike,  testSighting.getRangerName());
     }
     @Test
     public void getLocation_sightingInstantiatesWithLocation_Zone A() {
         Sighting testSighting = setupNewSighting();
         assertEquals("Zone A" , testSighting.getLocation());
     }
     @Test 
     public void equals_returnTrueIfLocationAndRangerNameAreSame_true () {
         Sighting firstSighting = setupNewSighting();
        Sighting anotherSighting = setupNewSighting();
        assertTrue(firstSighting.equals(anotherSighting));
     }
    
 }