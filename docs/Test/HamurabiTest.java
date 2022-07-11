package hammurabi.docs.Test;

import hammurabi.docs.src.Hamurabi;
import org.junit.jupiter.api.Test;

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

    @org.junit.jupiter.api.Test
    void plagueTest() {
        Hamurabi plagueT1 = new Hamurabi();
        plagueT1.setPlaguePercent(15);
        plagueT1.setPopulation(100);
        assertEquals(50,plagueT1.plague());

    }

//    @org.junit.jupiter.api.Test
//    void uprisingTest() {
//        Hamurabi riseUP1 = new Hamurabi();
//        riseUP1.setPercentStarved(.45);
//        riseUP1.setUprising();
//        assertEquals(true,riseUP1.uprising());
//
//
//
//    }
}