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

        ArrayList<String> input = new ArrayList<>( Arrays.asList( rawInput ) );
        int currOpcode = Integer.parseInt( input.get(0) );
        int instructionPointer = 0;

        long now = System.currentTimeMillis();

        boolean piss = true;

        while ( piss ){

            if(System.currentTimeMillis() > now + 5000){
                System.out.println("...");
                now = System.currentTimeMillis();
            }



            switch (currOpcode){
                case 1: {
                    int pos1 = Integer.parseInt( input.get(instructionPointer + 1) );
                    int pos2 = Integer.parseInt( input.get(instructionPointer + 2) );
                    int pos3 = Integer.parseInt( input.get(instructionPointer + 3) );

                    int num1 = Integer.parseInt( input.get(pos1) );
                    int num2 = Integer.parseInt( input.get(pos2) );
                    int num3 = Integer.parseInt( input.get(pos3) );

                    String tempSum = String.valueOf( num1 + num2 );

                    input.set( pos3, tempSum );

                    break;
                }

                case 2: {
                    int pos1 = Integer.parseInt( input.get(instructionPointer + 1) );
                    int pos2 = Integer.parseInt( input.get(instructionPointer + 2) );
                    int pos3 = Integer.parseInt( input.get(instructionPointer + 3) );

                    int num1 = Integer.parseInt( input.get(pos1) );
                    int num2 = Integer.parseInt( input.get(pos2) );
                    int num3 = Integer.parseInt( input.get(pos3) );

                    String tempSum = String.valueOf( num1 * num2 );

                    input.set( pos3, tempSum );

                    break;
                }

                case 99: {
                    piss = false;
                    break;
                }
            }

            instructionPointer += 4;
            currOpcode = Integer.parseInt( input.get(instructionPointer) );
        }


        System.out.println(input);
    }

    private static ArrayList<String> redoInput() {
        String[] newInput =  new String[0];

        try {
            newInput = new Scanner(new File("input.txt")).nextLine().split(",");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> input = new ArrayList<>(Arrays.asList(newInput));

        return input;
    }

}
