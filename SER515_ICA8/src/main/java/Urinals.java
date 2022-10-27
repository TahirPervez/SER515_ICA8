public class Urinals {
    String urinals;

    public Urinals() {
        urinals = "";
    }
    public boolean readIn(String input) {
        if(input.isEmpty() || input.length() > 20) {
            return false;
        }
        urinals = input;
        return true;
    }
}