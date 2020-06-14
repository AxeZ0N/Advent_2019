import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Advent_2_1 {
    public static void main(String[] args) {

        String[] rawInput = new String[0];
        try {
            rawInput = new Scanner(new File("input.txt")).nextLine().split(",");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> input = new ArrayList<>( Arrays.asList( rawInput ) );
        int currOpcode = Integer.parseInt( input.get(0) );
        int i = 0;


        while (true){
            switch (currOpcode){
                case 1: {
                    int pos1 = Integer.parseInt( input.get(i + 1) );
                    int pos2 = Integer.parseInt( input.get(i + 2) );
                    int pos3 = Integer.parseInt( input.get(i + 3) );

                    int num1 = Integer.parseInt( input.get(pos1) );
                    int num2 = Integer.parseInt( input.get(pos2) );
                    int num3 = Integer.parseInt( input.get(pos3) );

                    String tempSum = String.valueOf( num1 + num2 );

                    input.set( pos3, tempSum );

                    break;
                }

                case 2: {
                    int pos1 = Integer.parseInt( input.get(i + 1) );
                    int pos2 = Integer.parseInt( input.get(i + 2) );
                    int pos3 = Integer.parseInt( input.get(i + 3) );

                    int num1 = Integer.parseInt( input.get(pos1) );
                    int num2 = Integer.parseInt( input.get(pos2) );
                    int num3 = Integer.parseInt( input.get(pos3) );

                    String tempSum = String.valueOf( num1 * num2 );

                    input.set( pos3, tempSum );

                    break;
                }

                case 99: {


                    System.out.println(input);
                    System.exit(0);

                    int pos1 = Integer.parseInt( input.get(i + 1) );
                    int pos2 = Integer.parseInt( input.get(i + 2) );
                    int pos3 = Integer.parseInt( input.get(i + 3) );

                    String tempSum = String.valueOf( pos1 + pos2 );

                    input.set( pos3, tempSum );

                    break;
                }
            }

            i += 4;
            currOpcode = Integer.parseInt( input.get(i) );
        }
    }

}
