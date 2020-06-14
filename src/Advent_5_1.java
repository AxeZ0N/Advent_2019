import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Advent_5_1 {
    public static void main(String[] args) {

        String[] rawInput = new String[0];
        try {
            rawInput = new Scanner(new File("input.txt")).nextLine().split(",");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> input = new ArrayList<>(Arrays.asList(rawInput));


        int instructionPointer = 0;

        long now = System.currentTimeMillis();

        boolean piss = true;

        while (piss) {

            String wholeCode = input.get(instructionPointer);

            StringBuilder sb = new StringBuilder("0000");
            sb.append(wholeCode);

            String paddedCode = sb.toString().substring(sb.toString().length() - 5);


            int currOpcode = Integer.parseInt(paddedCode.substring(3));
            String currBytecode = paddedCode.substring(0, 3);

            //System.out.println(currOpcode);
            //System.out.println(currBytecode);

            String[][] bitState = new String[3][2];

            int j = 2;
            for (int i = 0; i < 3; i++) {
                bitState[i][1] = String.valueOf(currBytecode.charAt(j));
                j--;
            }

//            if (System.currentTimeMillis() > now + 5000) {
//                System.out.println("...");
//                now = System.currentTimeMillis();
//            }

            //System.out.println(Arrays.deepToString(bitState));

            switch (currOpcode) {
                case 1: {
                    int pos1 = 0;
                    int pos2 = 0;
                    int pos3 = 0;

                    int num1 = 0;
                    int num2 = 0;
                    int num3 = 0;

                    pos1 = Integer.parseInt(input.get(instructionPointer + 1));
                    pos2 = Integer.parseInt(input.get(instructionPointer + 2));
                    pos3 = Integer.parseInt(input.get(instructionPointer + 3));

                    try {
                        num1 = Integer.parseInt(input.get(Math.abs(pos1)));
                    } catch (Exception e) {
                        //e.printStackTrace();
                    }
                    try {
                        num2 = Integer.parseInt(input.get(Math.abs(pos2)));
                    } catch (Exception e) {
                        //e.printStackTrace();
                    }
                    try {
                        num3 = Integer.parseInt(input.get(Math.abs(pos3)));
                    } catch (Exception e) {
                        //e.printStackTrace();
                    }

                    int[] num = {num1, num2, num3};
                    int[] pos = {pos1, pos2, pos3};

                    for (int i = 0; i < 3; i++) {
                        if (bitState[i][1].matches("1")) {
                            bitState[i][0] = String.valueOf(pos[i]);
                        } else {
                            bitState[i][0] = String.valueOf(num[i]);
                        }
                    }


                    String tempSum = String.valueOf(Integer.parseInt(bitState[0][0]) + Integer.parseInt(bitState[1][0]));

                    input.set(pos3, tempSum);

                    instructionPointer += 4;

                    break;
                }

                case 2: {
                    int pos1 = 0;
                    int pos2 = 0;
                    int pos3 = 0;

                    int num1 = 0;
                    int num2 = 0;
                    int num3 = 0;


                    pos1 = Integer.parseInt(input.get(instructionPointer + 1));
                    pos2 = Integer.parseInt(input.get(instructionPointer + 2));
                    pos3 = Integer.parseInt(input.get(instructionPointer + 3));


                    try {
                        num1 = Integer.parseInt(input.get(Math.abs(pos1)));
                    } catch (Exception e) {
                        //e.printStackTrace();
                    }
                    try {
                        num2 = Integer.parseInt(input.get(Math.abs(pos2)));
                    } catch (Exception e) {
                        //e.printStackTrace();
                    }
                    try {
                        num3 = Integer.parseInt(input.get(Math.abs(pos3)));
                    } catch (Exception e) {
                        //e.printStackTrace();
                    }

                    int[] num = {num1, num2, num3};
                    int[] pos = {pos1, pos2, pos3};

                    for (int i = 0; i < 3; i++) {
                        if (bitState[i][1].matches("1")) {
                            bitState[i][0] = String.valueOf(pos[i]);
                        } else {
                            bitState[i][0] = String.valueOf(num[i]);
                        }
                    }


                    String tempSum = String.valueOf(Integer.parseInt(bitState[0][0]) * Integer.parseInt(bitState[1][0]));

                    input.set(pos3, tempSum);

                    instructionPointer += 4;

                    break;
                }

                case 3: {
                    int pos1 = Integer.parseInt(input.get(instructionPointer + 1));

                    int num1 = Integer.parseInt(input.get(pos1));

                    String tempSum = getInput();

                    input.set(pos1, tempSum);

                    instructionPointer += 2;

                    break;
                }

                case 4: {
                    int pos1 = Integer.parseInt(input.get(instructionPointer + 1));

                    int num1 = Integer.parseInt(input.get(pos1));

                    String output = input.get(pos1);
                    System.out.print("pointer: " + instructionPointer + " output: ");
                    System.out.println(output);

                    instructionPointer += 2;

                    break;
                }

                case 99: {
                    piss = false;
                    break;
                }

                default:
                    System.out.println("Broken");
                    System.out.println(currOpcode);
                    System.exit(-1);
            }
        }


        System.out.println(input);
    }

    private static String getInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Need input: ");
        return scan.next();
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
