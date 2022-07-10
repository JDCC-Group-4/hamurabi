package hammurabi.docs.Test;

import hammurabi.docs.src.Hamurabi;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HamurabiTest {

    @org.junit.jupiter.api.Test
    void peopleStarvedTest() {
        Hamurabi gameTest = new Hamurabi();
        gameTest.setBushelsFed(1000);
        gameTest.setPopulation(100);
        assertEquals(50, gameTest.peopleStarved());
    }

    @org.junit.jupiter.api.Test
    void harvestTest() {
        Hamurabi harTest = new Hamurabi();
        harTest.setBushelsPlanted(100);
        assertEquals(harTest.bushelsPlanted * harTest.bushelsPerAcre,harTest.newHarvest());
    }
}