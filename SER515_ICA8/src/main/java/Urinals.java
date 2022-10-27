public class Urinals {
    String urinals;

    public Urinals() {
        urinals = "";
    }

    /**
     * @param input the input string, could be read in from file or console
     * @return true if valid input, false if not
     *          valid:  1 <= length <= 20
     *                  contains only 0s and 1s
     *                  contains no cases of "11"
     */
    public boolean readIn(String input) {
        if(input.isEmpty() || input.length() > 20) {
            return false;
        }
        char previous = '0';
        for (char curr : input.toCharArray()) {
            if(curr != '0' && curr != '1') {
                return false;
            } else {
                if(previous == '1' && curr == '1') {
                    return false;
                }
                previous = curr;
            }
        }
        urinals = input;
        return true;
    }
}