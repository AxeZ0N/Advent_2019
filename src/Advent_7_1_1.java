import java.util.ArrayList;
import java.util.List;

public class Advent_7_1_1 {


    public static void main(String[] args) {
        List<Advent_7_1> computers = new ArrayList<>();

        int currMax = 0;
        List<String> comparison = new ArrayList<>();
        for (int i = 4; i >= 0; i--) {
            comparison.add(String.valueOf(i));
        }
        List<String> maxPhase = new ArrayList<>();

        String path = "input.txt";

        for (int i = 0; i < 5; i++) {
            computers.add(new Advent_7_1());
            computers.get(i).initInput(path);
        }

        int overallMax = 0;

        for (int i = 0; i < 5; i++) { //amp one

            for (int j = 0; j < 5; j++) { //amp

                for (int k = 0; k < 5; k++) { //amp

                    for (int l = 0; l < 5; l++) { //amp

                        for (int m = 0; m < 5; m++) { //amp

                            List<String> currNum = new ArrayList<>();

                            List<String> computerOut = new ArrayList<>();


                            currNum.add(String.valueOf(i));
                            currNum.add(String.valueOf(j));
                            currNum.add(String.valueOf(k));
                            currNum.add(String.valueOf(l));
                            currNum.add(String.valueOf(m));

                            computers.get(0).secondInput = "0";
                            computers.get(0).firstInput = currNum.get(0);
                            computerOut.add(computers.get(0).mainFunction());


                            computers.get(1).firstInput = currNum.get(1);
                            computers.get(1).secondInput = computerOut.get(0);
                            computerOut.add(computers.get(1).mainFunction());

                            computers.get(2).firstInput = currNum.get(2);
                            computers.get(2).secondInput = computerOut.get(1);;
                            computerOut.add(computers.get(2).mainFunction());

                            computers.get(3).firstInput = currNum.get(3);
                            computers.get(3).secondInput = computerOut.get(2);
                            computerOut.add(computers.get(3).mainFunction());

                            computers.get(4).firstInput = currNum.get(4);
                            computers.get(4).secondInput = computerOut.get(3);
                            computerOut.add(computers.get(4).mainFunction());

                            if(Integer.parseInt(computerOut.get(4)) > currMax){
                                currMax = Integer.parseInt(computerOut.get(4));
                                maxPhase = currNum;

                            }


                        }

                    }
                }
            }
        }
        System.out.println(comparison);
        System.out.println(currMax);
        System.out.println(maxPhase);
    }
}
