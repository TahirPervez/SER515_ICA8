public class Urinals {

    public Urinals() {}

    /**
     * @param input the input string, could be read in from file or console
     * @return true if valid input, false if not
     *          valid:  1 <= length <= 20
     *                  contains only 0s and 1s
     *                  contains no cases of "11"
     */
    public boolean checkInput(String input) {
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
        return true;
    }

    /**
     * @param input input string
     * @return number of available spots
     */
    public int validSpots(String input) {
        int count = 0;
        // System.out.println("------------------------------------");
        // System.out.println("input: " + input);
        if(checkInput(input)) {
            char[] inputArr = input.toCharArray();
            char previous = '_', pre_previous = '_';
            for(int i = 0; i < inputArr.length; i++) {
                char curr = inputArr[i];
                if(pre_previous == '_') { //__00000
                    pre_previous = curr;
                } else if(previous == '_') { // 0_0_000
                    previous = curr;
                    if(pre_previous == '0' && curr == '0') {
                        count++;
                        inputArr[i-1] = '1';
                        pre_previous = '1';
                    }
                } else { // 00_0_00
                    // System.out.println("order: " + pre_previous + "" + previous + ""  + curr);
                    if(pre_previous == '0' && previous == '0' && curr == '0') {
                        count++;
                        inputArr[i-1] = '1';
                        previous = '1';
                    }
                    if(i == inputArr.length - 1) { // last element
                        if(previous == '0' && curr == '0') {
                            count++;
                            inputArr[i] = '1';
                        }
                    }
                    pre_previous = previous;
                    previous = curr;
                }
            }
            /*
            System.out.print("end result: ");
            for(char curr : inputArr) {
                System.out.print(curr);
            }
            System.out.println();
            */
            return count;
        }
        return -1;
    }

    /**
     * @return 0 for success, -1 for error state
     */
    public int readInFromConsole() {
        return 0;
    }
}