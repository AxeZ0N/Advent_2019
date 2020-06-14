import java.util.ArrayList;
import java.util.Arrays;

public class Advent_4_1 {

    public static void main(String[] args) {
        int bottomLimit =  134792;
        int topLimit =     675810;

        int totalNumPasswords = 0;
        int totalNumPasswords_2 = 0;

        Advent_4_1 advent_4_1 = new Advent_4_1();

        for (int i = bottomLimit; i <= topLimit; i++) {
            int currNum = i;

            int[] digits = advent_4_1.splitToDigits(currNum);

            if( !advent_4_1.isIncreasing(digits) ){

                continue;

            }

            int[] digitsTotal = advent_4_1.countConsecutive(digits);

            for (int j = 0; j <= 9; j++) {

                if( digitsTotal[j] >= 1 ){
                    totalNumPasswords++;
                    break;
                }

            }

            for (int j = 0; j <= 9; j++) {
                if( digitsTotal[j] == 1){
                    totalNumPasswords_2++;
                    break;
                }
            }

        }

        System.out.println(totalNumPasswords);
        System.out.println(totalNumPasswords_2);


    }

    public int[] splitToDigits(int x){
        int[] digits = new int[6];
        int i = 5;

        while (x != 0){
            digits[i] = x % 10;
            x /= 10;
            i--;
        }

        return digits;
    }

    public boolean isIncreasing(int[] digits){
        for (int i = 0; i < 5; i++) {

            if( digits[i + 1] < digits[i] ){
                return false;

            }
        }

        return true;
    }

    public int[] countConsecutive( int[] digits ){
        int[] digitsTotal = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < 5; i++) {
            if( digits[i] == digits[i+1] ){
                int currDigit = digits[i];
                digitsTotal[currDigit]++;
            }

        }

        return digitsTotal;
    }



}
