import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @org.junit.jupiter.api.Test
    void readIn() {
        Urinals urinals = new Urinals();
        assertTrue(urinals.readIn("10001"));
    }
}