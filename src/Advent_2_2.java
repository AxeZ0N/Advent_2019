import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Advent_2_2 {
    public static void main(String[] args) {

        String[] rawInput = new String[0];
        try {
            rawInput = new Scanner(new File("input.txt")).nextLine().split(",");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> input = new ArrayList<>(Arrays.asList(rawInput));


        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {

                input = redoInput();
                input.set(1, String.valueOf(i));
                int currOpcode = Integer.parseInt(input.get(0));
                int instructionPointer = 0;

                input.set(2, String.valueOf(j));

                boolean piss = true;

                while (piss) {

                    long now = System.currentTimeMillis();


                    if (System.currentTimeMillis() > now + 5000) {
                        System.out.println("...");
                    }


                    switch (currOpcode) {
                        case 1: {
                            int pos1 = Integer.parseInt(input.get(instructionPointer + 1));
                            int pos2 = Integer.parseInt(input.get(instructionPointer + 2));
                            int pos3 = Integer.parseInt(input.get(instructionPointer + 3));

                            int num1 = Integer.parseInt(input.get(pos1));
                            int num2 = Integer.parseInt(input.get(pos2));
                            int num3 = Integer.parseInt(input.get(pos3));

                            String tempSum = String.valueOf(num1 + num2);

                            input.set(pos3, tempSum);

                            break;
                        }

                        case 2: {
                            int pos1 = Integer.parseInt(input.get(instructionPointer + 1));
                            int pos2 = Integer.parseInt(input.get(instructionPointer + 2));
                            int pos3 = Integer.parseInt(input.get(instructionPointer + 3));

                            int num1 = Integer.parseInt(input.get(pos1));
                            int num2 = Integer.parseInt(input.get(pos2));
                            int num3 = Integer.parseInt(input.get(pos3));

                            String tempSum = String.valueOf(num1 * num2);

                            input.set(pos3, tempSum);

                            break;
                        }

                        case 99: {

                            if (input.get(0).matches("19690720")) {
                                System.out.println("one is: " + input.get(1) + " two is: " + input.get(2));
                                int answer = (100 * Integer.parseInt(input.get(1)) + Integer.parseInt(input.get(2)));
                                System.out.println("answer is: " + answer);
                                System.exit(0);
                            } else {

                                piss = false;
                                break;
                            }

                        }
                    }


                    instructionPointer += 4;
                    currOpcode = Integer.parseInt(input.get(instructionPointer));

                }
            }
        }

        System.out.println(input);
        System.out.println("Broke");
        System.exit(-1);

    }

    private static ArrayList<String> redoInput() {
        String[] newInput = new String[0];

        try {
            newInput = new Scanner(new File("input.txt")).nextLine().split(",");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> input = new ArrayList<>(Arrays.asList(newInput));

        return input;
    }

}
