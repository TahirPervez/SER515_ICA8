import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @org.junit.jupiter.api.Test
    void checkInput() {
        Urinals urinals = new Urinals();
        assertTrue(urinals.checkInput("10001"));
    }

    @org.junit.jupiter.api.Test
    void checkInput_empty() {
        Urinals urinals = new Urinals();
        assertFalse(urinals.checkInput(""));
    }
    @org.junit.jupiter.api.Test
    void checkInput_tooLong() {
        Urinals urinals = new Urinals();
        assertFalse(urinals.checkInput("00000000000000000000000000000"));
    }
    @org.junit.jupiter.api.Test
    void checkInput_invalidCharacter() {
        Urinals urinals = new Urinals();
        assertFalse(urinals.checkInput("00101a"));
    }
    @org.junit.jupiter.api.Test
    void checkInput_doubleOne() {
        Urinals urinals = new Urinals();
        assertFalse(urinals.checkInput("001011"));
    }
    @org.junit.jupiter.api.Test
    void validSpots() {
        Urinals urinals = new Urinals();
        assertEquals(1, urinals.validSpots("10001"));
    }

    @org.junit.jupiter.api.Test
    void validSpots_allZeros() {
        Urinals urinals = new Urinals();
        assertEquals(3, urinals.validSpots("00000"));
    }
    @org.junit.jupiter.api.Test
    void validSpots_first() {
        Urinals urinals = new Urinals();
        assertEquals(1, urinals.validSpots("00101"));
    }
    @org.junit.jupiter.api.Test
    void validSpots_last() {
        Urinals urinals = new Urinals();
        assertEquals(1, urinals.validSpots("101000"));
    }
    @org.junit.jupiter.api.Test
    void validSpots_lengthTwo_Zeros() {
        Urinals urinals = new Urinals();
        assertEquals(1, urinals.validSpots("00"));
    }
    @org.junit.jupiter.api.Test
    void validSpots_lengthTwo() {
        Urinals urinals = new Urinals();
        assertEquals(0, urinals.validSpots("10"));
    }

    /**
    @org.junit.jupiter.api.Test
    void readInFromConsole() {
        Urinals urinals = new Urinals();
        assertEquals(0, urinals.readInFromConsole());
    }
    */
}