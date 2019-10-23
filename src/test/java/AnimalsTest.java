import org..junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    Animal testAnimal=  new Animal("Mufasa", 1);
    Animal secondAnimal = new Animal("Rafiki", 1);
    Animal otherSecondAnimal = new  Animal("Simba",3);


    @Test 
    public void Animal_instantiates correctly_true() {
        assertEquals(true, testAnimal instanceof Animal);
    } 
    @Test 
    public void Animal_instantiatesWithName_String() {
       assertEquals("Mufasa" testAnimal.getName()); 
    }
    @Test 
    public void Animal_instantiatesWithSightingId_Int() {
        assertEquals(1, testAnimal.getSightingId());
    }
    
}