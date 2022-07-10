package hammurabi.docs.Test;

import hammurabi.docs.src.Hamurabi;

import static org.junit.jupiter.api.Assertions.*;

class HamurabiTest {

    @org.junit.jupiter.api.Test
    void peopleStarvedTest() {
        Hamurabi gameTest = new Hamurabi();
        assertEquals(10, gameTest.peopleStarved(1800, 100));
    }

    @org.junit.jupiter.api.Test
    void peopleStarved() {
    }
}