import java.io.*;
import java.util.Scanner;

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
     * @return String containing all results, formatted
     */
    public int readInFromConsole() {
        Scanner scan = new Scanner(System.in);
        String input;
        int res;
        do {
            System.out.println("Enter a set of urinals to get the free spots, or -1 to stop the program");
            input = scan.nextLine();
            res = validSpots(input);
            if(res == -1 && !input.equals("-1")) {
               System.out.println("-1");
            } else {
                System.out.println(res);
            }
        } while (!input.equals("-1"));
        System.out.println(-1);
        scan.close();
        return 0;
    }

    public boolean readInFile(String filename) {
        StringBuilder bffr = new StringBuilder();
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            String input = "";
            while(scan.hasNext() && !input.equals("-1")) {
                input = scan.nextLine();
                int res = validSpots(input);
                // System.out.println(input + " : " + res);
                if(res == -1 && !input.equals("-1")) {
                    bffr.append("-1");
                } else {
                    bffr.append(res);
                }
                bffr.append("\n");
            }
            String base = "output/rule";
            int copy = 0;
            boolean iterating = true;
            do { // getting file name to write to
                String filename2 = base;
                if(copy != 0) {
                    filename2 += "" + copy;
                }
                filename2 += ".txt";
                File version = new File(filename2);
                if (version.exists()) { // iterate through
                    copy++;
                } else { // not an existing file, need to make one
                    iterating = false;
                    FileWriter fw = new FileWriter(version);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(bffr.toString());
                    bw.close();
                    scan.close();
                }
            } while(iterating);
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}