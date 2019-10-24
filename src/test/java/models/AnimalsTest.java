//package models;
//
//import org.junit.Rule;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class AnimalsTest {
//    @Rule
//    public DatabaseRules database = new DatabaseRules();
//
//    @Test
//    public void animal_InstantiatesCorrectly_true() {
//        NonEndangered myAnimal = new NonEndangered("panther", "young", "weak", "endangered");
//        assertEquals(true, myAnimal instanceof NonEndangered);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void animal_InstantiatesWithAge_panther() {
//        NonEndangered myAnimal = new NonEndangered("", "", "", "");
//        assertEquals("panther", myAnimal.getAge());
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void animal_InstantiatesWithHealth_panther() {
//        NonEndangered myAnimal = new NonEndangered("", "", "", "");
//        assertEquals("panther", myAnimal.getHealth());
//    }
//}