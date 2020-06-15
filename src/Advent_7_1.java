import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.*;

public class Advent_7_1 {

    public String path;
    public String inputValue;
    public String phaseValue;
    List<String> input;

    public String mainFunction(){

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
                // add
                case 1: {
                    for (int i = 0; i < 3; i++) {
                        if( bitState[i][1].matches("1") ){
                            bitState[i][0] = input.get(instructionPointer + i + 1);
                        } else {
                            bitState[i][0] = input.get( Integer.parseInt( input.get(instructionPointer + i + 1) ) );
                        }
                    }

                    String tempSum = String.valueOf( Integer.parseInt(bitState[0][0]) + Integer.parseInt(bitState[1][0]) );

                    input.set(Integer.parseInt( input.get(instructionPointer + 3) ), tempSum);

                    instructionPointer += 4;

                    break;
                }
                // multiply
                case 2: {
                    for (int i = 0; i < 3; i++) {
                        if( bitState[i][1].matches("1") ){
                            bitState[i][0] = input.get(instructionPointer + i + 1);
                        } else {
                            bitState[i][0] = input.get( Integer.parseInt( input.get(instructionPointer + i + 1) ) );
                        }
                    }

                    String tempSum = String.valueOf(Integer.parseInt(bitState[0][0]) * Integer.parseInt(bitState[1][0]));

                    input.set(Integer.parseInt( input.get(instructionPointer + 3) ), tempSum);

                    instructionPointer += 4;

                    break;
                }
                // store pointer
                case 3: {
                    int pos1 = Integer.parseInt(input.get(instructionPointer + 1));

                    int num1 = Integer.parseInt(input.get(pos1));

                    String tempSum = getInput();

                    input.set(pos1, tempSum);

                    instructionPointer += 2;

                    break;
                }
                // output pointer
                case 4: {
                    int pos1 = Integer.parseInt(input.get(instructionPointer + 1));

                    String output = input.get(pos1);
                    System.out.print("pointer: " + instructionPointer + " output: ");
                    System.out.println(output);

                    instructionPointer += 2;

                    break;
                }
                // jump if true
                case 5: {
                    for (int i = 0; i < 2; i++) {
                        if( bitState[i][1].matches("1") ){
                            bitState[i][0] = input.get(instructionPointer + i + 1);
                        } else {
                            //bitState[i][0] = input.get( Integer.parseInt( input.get(instructionPointer + i + 1) ) );
                            int position =  Integer.parseInt( input.get( instructionPointer + i + 1));
                            bitState[i][0] = input.get(position);
                        }
                    }

                    int first = Integer.parseInt( bitState[0][0] );
                    int secoond = Integer.parseInt( bitState[1][0] );

                    if (first != 0) {
                        instructionPointer = Integer.parseInt(bitState[1][0]);
                        break;
                    }

                    instructionPointer+=3;

                    break;
                }


                // jump if false
                case 6: {
                    for (int i = 0; i < 2; i++) {
                        if (bitState[i][1].matches("1")) {
                            bitState[i][0] = input.get(instructionPointer + i + 1);
                        } else {
                            bitState[i][0] = input.get(Integer.parseInt(input.get(instructionPointer + i + 1)));
                        }
                    }

                    int first = Integer.parseInt( bitState[0][0] );
                    int secoond = Integer.parseInt( bitState[1][0] );

                    if (first == 0){
                        instructionPointer = Integer.parseInt(bitState[1][0]);
                        break;
                    }
                    instructionPointer+=3;
                    break;
                }

                //less than
                case 7: {
                    for (int i = 0; i < 3; i++) {
                        if( bitState[i][1].matches("1") ){
                            bitState[i][0] = input.get(instructionPointer + i + 1);
                        } else {
                            bitState[i][0] = input.get( Integer.parseInt( input.get(instructionPointer + i + 1) ) );
                        }
                    }

                    if( Integer.parseInt( bitState[0][0] ) < Integer.parseInt( bitState[1][0] ) ){
                        input.set(Integer.parseInt( input.get(instructionPointer + 3) ), "1");

                    } else {
                        input.set(Integer.parseInt( input.get(instructionPointer + 3) ), "0");

                    }

                    instructionPointer += 4;

                    break;

                }

                //equal
                case 8: {
                    for (int i = 0; i < 3; i++) {
                        if( bitState[i][1].matches("1") ){
                            bitState[i][0] = input.get(instructionPointer + i + 1);
                        } else {
                            bitState[i][0] = input.get( Integer.parseInt( input.get(instructionPointer + i + 1) ) );
                        }
                    }

                    String first = bitState[0][0];
                    String second = bitState[1][0];
                    String third = bitState[2][0];

                    if( Integer.parseInt( bitState[0][0] ) == Integer.parseInt( bitState[1][0] ) ){
                        input.set(Integer.parseInt( input.get(instructionPointer + 3) ), "1");
                    } else {
                        input.set(Integer.parseInt( input.get(instructionPointer + 3) ), "0");
                    }

                    instructionPointer += 4;

                    break;

                }

                case 99: {
                    piss = false;
                    break;
                }

                default: {
                    System.out.println("Broken");
                    System.out.println(currOpcode);
                    System.exit(-1);
                }
            }
        }

        return input.get(0);
    }


    private String getInput() {
        return phaseValue;
    }

    public static ArrayList<String> initInput(String path) {

        String[] newInput = new String[0];

        try {
            newInput = new Scanner(new File(path)).nextLine().split(",");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> input = new ArrayList<>(Arrays.asList(newInput));

        return input;
    }

    public String changeFirstNumbers(String pos0, String pos1){
        input.set(0, pos0);
        input.set(1, pos1);

        return  pos0;

    }

}
