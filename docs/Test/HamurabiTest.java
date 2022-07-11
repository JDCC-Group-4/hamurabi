package hammurabi.docs.Test;

import hammurabi.docs.src.Hamurabi;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HamurabiTest {

    @org.junit.jupiter.api.Test
    void peopleStarvedPeopleStarvedTest() {
        Hamurabi gameTest = new Hamurabi();
        gameTest.setBushelsFed(1000);
        gameTest.setPopulation(100);
        assertEquals(50, gameTest.peopleStarved());
    }

    @org.junit.jupiter.api.Test
    void peopleStarvedNoPeopleStarvedTest() {
        Hamurabi gameTest = new Hamurabi();
        gameTest.setBushelsFed(2000);
        gameTest.setPopulation(100);
        assertEquals(0, gameTest.peopleStarved());
    }

    @org.junit.jupiter.api.Test
    void peopleStarvedOverFedTest() {
        Hamurabi gameTest = new Hamurabi();
        gameTest.setBushelsFed(2500);
        gameTest.setPopulation(100);
        assertEquals(0, gameTest.peopleStarved());
    }

    @org.junit.jupiter.api.Test
    void peopleStarvedPeopleStarvedTest2() {
        Hamurabi gameTest = new Hamurabi();
        gameTest.setBushelsFed(200);
        gameTest.setPopulation(100);
        assertEquals(90, gameTest.peopleStarved());
    }

    @org.junit.jupiter.api.Test
    void peopleStarvedPeopleStarvedTest3() {
        Hamurabi gameTest = new Hamurabi();
        gameTest.setBushelsFed(5000);
        gameTest.setPopulation(500);
        assertEquals(250, gameTest.peopleStarved());
    }

    @org.junit.jupiter.api.Test
    void peopleStarvedPeopleStarvedTest4() {
        Hamurabi gameTest = new Hamurabi();
        gameTest.setBushelsFed(9000);
        gameTest.setPopulation(500);
        assertEquals(50, gameTest.peopleStarved());
    }

    @org.junit.jupiter.api.Test
    void peopleImmigratedTest1() {
        Hamurabi gameTest = new Hamurabi();
        gameTest.setBushelsHarvested(1600);
        gameTest.setPopulation(100);
        gameTest.setAcres(1000);
        assertEquals(3, gameTest.peopleImmigrated());
    }

    @org.junit.jupiter.api.Test
    void peopleImmigratedZeroHarvestTest() {
        Hamurabi gameTest = new Hamurabi();
        gameTest.setBushelsHarvested(0);
        gameTest.setPopulation(100);
        gameTest.setAcres(1000);
        assertEquals(3, gameTest.peopleImmigrated());
    }

    @org.junit.jupiter.api.Test
    void peopleImmigratedLowPopulationTest() {
        Hamurabi gameTest = new Hamurabi();
        gameTest.setBushelsHarvested(1600);
        gameTest.setPopulation(1);
        gameTest.setAcres(1000);
        assertEquals(217, gameTest.peopleImmigrated());
    }

    @org.junit.jupiter.api.Test
    void peopleImmigratedLowAcresTest() {
        Hamurabi gameTest = new Hamurabi();
        gameTest.setBushelsHarvested(1600);
        gameTest.setPopulation(100);
        gameTest.setAcres(10);
        assertEquals(1, gameTest.peopleImmigrated());
    }


    }

