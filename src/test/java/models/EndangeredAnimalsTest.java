package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalsTest {
    @Rule
    public DatabaseRules database = new DatabaseRules();

    @Test
    public void EndangeredAnimals_InstantiatesCorrectly_true() {
        EndangeredAnimals myEndangeredAnimal = new EndangeredAnimals("panther", "young", "weak", "");
        assertEquals(true, myEndangeredAnimal instanceof EndangeredAnimals);
    }
}

