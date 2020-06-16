import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Advent_7_1_2 {


    public static void main(String[] args) {
        List<Advent_7_1> computers = new ArrayList<>();

        int currMax = 0;
        List<String> comparison = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            comparison.add(String.valueOf(i));
        }
        List<String> maxPhase = new ArrayList<>();

        List<String> permutes = new Advent_7_1_2().permute("56789");

        System.out.println(permutes);
        System.out.println(permutes.size());

        String path = "input.txt";

        for (int i = 0; i < 5; i++) {
            computers.add(new Advent_7_1());
            computers.get(i).initInput(path);
        }

        int overallMax = 0;
//
//        permutes.clear();
//        permutes.add("24301");
//        permutes.add("24310");

        for (String s : permutes) {
            String finalOut = "";

            List<String> currNum = new ArrayList<>(Arrays.asList(s.split("")));
            List<String> computerOut = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                computerOut.add("0");
            }

            computers.get(0).firstInput = currNum.get(0);
            computers.get(1).firstInput = currNum.get(1);
            computers.get(2).firstInput = currNum.get(2);
            computers.get(3).firstInput = currNum.get(3);
            computers.get(4).firstInput = currNum.get(4);

            computers.get(0).secondInput = "0";

            String possibleMax = "";

            while (true) {


                computerOut.set(0, computers.get(0).mainFunction());


                computers.get(1).secondInput = computerOut.get(0);
                computerOut.set(1, computers.get(1).mainFunction());

                computers.get(2).secondInput = computerOut.get(1);
                computerOut.set(2, computers.get(2).mainFunction());

                computers.get(3).secondInput = computerOut.get(2);
                computerOut.set(3, computers.get(3).mainFunction());

                computers.get(4).secondInput = computerOut.get(3);
                finalOut = computers.get(4).mainFunction();

                if(finalOut.matches("99")){
                    possibleMax = computerOut.get(4);
                    break;
                }

                computerOut.set(4, computers.get(4).mainFunction());

                computers.get(0).secondInput = computerOut.get(4);

            }

            if(Integer.parseInt(possibleMax) > currMax){
                currMax = Integer.parseInt(possibleMax);
            }

        }

        System.out.println(currMax);
        System.out.println(maxPhase);
    }

    public List<String> permute(String s){
        return permute("", s, null);
    }

    public List<String> permute(String s, String rest, List<String> list){
        if(list == null){
            list = new ArrayList<>();
        }
        if(rest.length() == 0){
            list.add(s);
            return list;
        } else {
            for (int i = 0; i < rest.length(); i++) {

                permute(s + rest.charAt(i), rest.substring(0, i) + rest.substring(i+1), list);
            }
        }
        return list;
    }
}
