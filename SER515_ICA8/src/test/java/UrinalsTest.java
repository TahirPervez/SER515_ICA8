import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @org.junit.jupiter.api.Test
    void readIn() {
        Urinals urinals = new Urinals();
        assertTrue(urinals.readIn("10001"));
    }

    @org.junit.jupiter.api.Test
    void readIn_empty() {
        Urinals urinals = new Urinals();
        assertFalse(urinals.readIn(""));
    }
    @org.junit.jupiter.api.Test
    void readIn_tooLong() {
        Urinals urinals = new Urinals();
        assertFalse(urinals.readIn("00000000000000000000000000000"));
    }
    @org.junit.jupiter.api.Test
    void readIn_invalidCharacter() {
        Urinals urinals = new Urinals();
        assertFalse(urinals.readIn("00101a"));
    }
}