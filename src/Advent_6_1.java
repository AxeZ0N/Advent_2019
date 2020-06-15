import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Advent_6_1 {

    private static HashMap<String, String> allOrbits;

    public static void main(String[] args) {
        readOrbits("input.txt");


    }

    private static List<String> readOrbits(String s) {
        List<String> allLines = new ArrayList<>();
        allOrbits = new HashMap<>();
        try {
            allLines = Files.readAllLines(Paths.get("input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : allLines) {
            String[] bodies = line.split("\\)");
            allOrbits.put(bodies[1], bodies[0]);
        }

        System.out.println("Number of orbiting bodies: " + allOrbits.size());

        int allOrbitCount = 0;

        for (String body : allOrbits.keySet()) {
            int currOrbitCount = countOrbits(body, 0);
            System.out.println(String.format("Body %s orbits %d Body(s)", body, currOrbitCount));
            allOrbitCount += currOrbitCount;

        }

        System.out.println(String.format("Total orbits: %d", allOrbitCount));
        System.out.println(String.format("Path to santa: %d", countDistance("YOU", "SAN")));

        return allLines;
    }

    private static int countDistance(String startBody, String endBody) {
        List<String> startBodyPath = pathToRoot(startBody, null);
        String lastPlanet = endBody;
        List<String> pathToSanta = new ArrayList<>();

        while ( allOrbits.containsKey(lastPlanet) && !startBodyPath.contains(lastPlanet)){
            lastPlanet = allOrbits.get(lastPlanet);
            pathToSanta.add(lastPlanet);
        }

        return pathToSanta.size() - 2 + startBodyPath.indexOf(lastPlanet);

    }

    private static List<String> pathToRoot(String planetToRoute, List<String> list) {
        if (list == null) {

            list = new ArrayList<>();

        }

        if (allOrbits.containsKey(planetToRoute)) {
            list.add(planetToRoute);
        } else {
            return list;
        }

        return pathToRoot(allOrbits.get(planetToRoute), list);


    }


    private static int countOrbits(String body, int i) {
        if (allOrbits.containsKey(body)) {
            return countOrbits(allOrbits.get(body), i + 1);
        }
        return i;
    }


}
