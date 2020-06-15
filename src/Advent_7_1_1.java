import java.util.ArrayList;
import java.util.List;

public class Advent_7_1_1 {


    public static void main(String[] args) {
        List<Advent_7_1> computers = new ArrayList<>();


        List<String> currNum = new ArrayList<>();
        List<String> computerOut = new ArrayList<>();

        int currMax = 0;

        String path = "input.txt";

        for (int i = 0; i < 5; i++) {
            computers.add(new Advent_7_1());
            computers.get(i).initInput(path);
        }

        int overallMax = 0;

        for (int i = 0; i <5; i++) { //amp one

            for (int j = 0; j < 5; j++) { //amp

                for (int k = 0; k < 5; k++) { //amp

                    for (int l = 0; l < 5; l++) { //amp

                        for (int m = 0; m < 5; m++) { //amp

                            currNum.add(String.valueOf(i));
                            currNum.add(String.valueOf(j));
                            currNum.add(String.valueOf(k));
                            currNum.add(String.valueOf(l));
                            currNum.add(String.valueOf(m));

                            computers.get(0).changeFirstNumbers("0", currNum.get(0));
                            computerOut.add(computers.get(0).mainFunction());

                            computers.get(1).changeFirstNumbers(computerOut.get(0), currNum.get(1));
                            computerOut.add(computers.get(1).mainFunction());

                            computers.get(2).changeFirstNumbers(computerOut.get(1), currNum.get(2));
                            computerOut.add(computers.get(2).mainFunction());

                            computers.get(3).changeFirstNumbers(computerOut.get(2), currNum.get(3));
                            computerOut.add(computers.get(3).mainFunction());

                            computers.get(4).changeFirstNumbers(computerOut.get(3), currNum.get(4));
                            computerOut.add(computers.get(4).mainFunction());

                            if(Integer.parseInt(computerOut.get(4)) > currMax){
                                currMax = Integer.parseInt(computerOut.get(4));
                            }


                        }

                    }
                }
            }
        }
        System.out.println(currMax);
    }
}
