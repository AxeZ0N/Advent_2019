import java.util.*;

public class Advent_2_1 {
    public static void main(String[] args) {
        ArrayList<String> input = (ArrayList<String>) Arrays.asList( new Scanner("input.txt").nextLine().split(",") );

        int currOpcode = Integer.parseInt( input.get(0) );
        int i = 0;


        while (true){
            switch (currOpcode){
                case 1: {
                    int pos1 = Integer.parseInt( input.get(currOpcode + 1) );
                    int pos2 = Integer.parseInt( input.get(currOpcode + 2) );
                    int pos3 = Integer.parseInt( input.get(currOpcode + 3) );

                    String tempSum = String.valueOf( pos1 + pos2 );

                    input.set( pos3, tempSum );

                    break;
                }

                case 2: {
                    int pos1 = Integer.parseInt( input.get(currOpcode + 1) );
                    int pos2 = Integer.parseInt( input.get(currOpcode + 2) );
                    int pos3 = Integer.parseInt( input.get(currOpcode + 3) );

                    String tempSum = String.valueOf( pos1 * pos2 );

                    input.set( pos3, tempSum );

                    break;
                }

                case 99: {

                    System.out.println(currOpcode);
                    System.exit(0);

                    int pos1 = Integer.parseInt( input.get(currOpcode + 1) );
                    int pos2 = Integer.parseInt( input.get(currOpcode + 2) );
                    int pos3 = Integer.parseInt( input.get(currOpcode + 3) );

                    String tempSum = String.valueOf( pos1 + pos2 );

                    input.set( pos3, tempSum );

                    break;
                }
            }

            i++;
            currOpcode = Integer.parseInt( input.get(i) );
        }


    }


}
