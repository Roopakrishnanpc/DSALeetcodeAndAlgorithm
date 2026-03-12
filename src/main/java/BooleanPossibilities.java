package main.java;

public class BooleanPossibilities {

    public static void main(String[] args) {

        boolean[] values = {false, true};

        for (boolean a : values) {
            for (boolean b : values) {
                for (boolean c : values) {

                    String result;

                    if ((a && b) || (a && c) || (b && c)) {
                        result = "FAIL";
                    } else {
                        result = "PASS";
                    }

                    System.out.println(a + " " + b + " " + c + " -> " + result);
                }
            }
        }
    }
}
class TwentySevenPossibilities {

    public static void main(String[] args) {

        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                for (int c = 0; c < 3; c++) {

                    String result;

                    int count = 0;

                    if (a == 1) count++;
                    if (b == 1) count++;
                    if (c == 1) count++;

                    if (count >= 2)
                        result = "FAIL";
                    else
                        result = "PASS";

                    System.out.println(a + " " + b + " " + c + " -> " + result);
                }
            }
        }
    }
}