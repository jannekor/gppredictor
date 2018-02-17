package predictor;

import java.util.ArrayList;
import java.util.Scanner;
// import org.json;

public class Application {

    public static void main(String[] args) {

        ArrayList drivers = new ArrayList();
        drivers.add("Hamilton");
        drivers.add("Bottas");
        drivers.add("Vettel");
        drivers.add("Raikkonen");
        drivers.add("Ricciardo");
        drivers.add("Verstappen");
        drivers.add("Perez");
        drivers.add("Ocon");
        drivers.add("Stroll");
        drivers.add("Massa");
        drivers.add("Sainz");
        drivers.add("Kvyat");
        drivers.add("Grosjean");
        drivers.add("Magnussen");
        drivers.add("Hulkenberg");
        drivers.add("Palmer");
        drivers.add("Alonso");
        drivers.add("Vandoorne");
        drivers.add("Ericsson");
        drivers.add("Wehrlein");

        Scanner reader = new Scanner(System.in);

        ArrayList predictTopTen = new ArrayList();
        ArrayList resultsTopTen = new ArrayList();

        String predictedPole;
        String resultPole;
        String predictedFastest;
        String resultFastest;
        String predictedGained;
        String resultGained;

        int points = 0;
        int eventCount = 0;
        int raceCount = 0;
        int topThree = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.println("Predict driver " + i + ": ");
            String input = reader.next();
            while (!drivers.contains(input)) {
                System.out.println("Driver doesn't exist, add a driver: ");
                input = reader.next();
            }
            predictTopTen.add(input);
        }

        System.out.println("Enter pole position: ");
        predictedPole = reader.next();
        while (!drivers.contains(predictedPole)) {
            System.out.println("Driver doesn't exist, add a driver: ");
            predictedPole = reader.next();
        }
        System.out.println("Enter fastest lap: ");
        predictedFastest = reader.next();
        while (!drivers.contains(predictedFastest)) {
            System.out.println("Driver doesn't exist, add a driver: ");
            predictedFastest = reader.next();
        }
        System.out.println("Enter positions gained: ");
        predictedGained = reader.next();
        while (!drivers.contains(predictedGained)) {
            System.out.println("Driver doesn't exist, add a driver: ");
            predictedGained = reader.next();
        }

        /*
        for (int i = 1; i <= 12; i++) {
            System.out.println("Enter result driver " + i + ": ");
            String input2 = reader.next();
            while (!drivers.contains(input2)) {
                System.out.println("Driver doesn't exist, add a driver: ");
                input2 = reader.next();
            }
            resultsTopTen.add(input2);
        }

        System.out.println("Enter pole position result: ");
        resultPole = reader.next();
        while (!drivers.contains(resultPole)) {
            System.out.println("Driver doesn't exist, add a driver: ");
            resultPole = reader.next();
        }
        System.out.println("Enter fastest lap result: ");
        resultFastest = reader.next();
        while (!drivers.contains(resultFastest)) {
            System.out.println("Driver doesn't exist, add a driver: ");
            resultFastest = reader.next();
        }
        System.out.println("Enter positions gained result: ");
        resultGained = reader.next();
        while (!drivers.contains(resultGained)) {
            System.out.println("Driver doesn't exist, add a driver: ");
            resultGained = reader.next();
        }
        */
        resultsTopTen.add("Verstappen");
        resultsTopTen.add("Hamilton");
        resultsTopTen.add("Ricciardo");
        resultsTopTen.add("Vettel");
        resultsTopTen.add("Bottas");
        resultsTopTen.add("Perez");
        resultsTopTen.add("Vandoorne");
        resultsTopTen.add("Stroll");
        resultsTopTen.add("Massa");
        resultsTopTen.add("Ocon");
        resultsTopTen.add("Alonso");
        resultsTopTen.add("Magnussen");
        resultFastest = "Vettel";
        resultGained = "Vettel";
        resultPole = "Hamilton";

        if (predictedFastest.equals(resultFastest)) {
            points = points + 5;
            eventCount++;
            System.out.println("Points after fastest: " + points);
        }
        if (predictedGained.equals(resultGained)) {
            points = points + 5;
            eventCount++;
            System.out.println("Points after gained: " + points);
        }
        if (predictedPole.equals(resultPole)) {
            points = points + 5;
            eventCount++;
            System.out.println("Points after pole: " + points);
        }
        if (eventCount == 3) {
            points = points + 20;
            System.out.println("Points after event bonus: " + points);
        }

        String current;

        for (int i = 0; i < predictTopTen.size(); i++) {
            current = predictTopTen.get(i).toString();

            if (i == 0) {
                // compary only current and plus12
                if (current.equals(resultsTopTen.get(i))) {
                    points = points + 20;
                    raceCount++;
                    topThree++;
                    System.out.println("Points after winner: " + points);
                } else if (current.equals(resultsTopTen.get(i + 1))) {
                    points = points + 5;
                    System.out.println("Points after 0+1: " + points);
                } else if (current.equals(resultsTopTen.get(i + 2))) {
                    points = points + 2;
                    System.out.println("Points after 0+2: " + points);
                }
            } else if (i == 1) {
                // compare only current, minus1 and plus12
                if (current.equals(resultsTopTen.get(i))) {
                    points = points + 10;
                    raceCount++;
                    topThree++;
                    System.out.println("Points after secondplace: " + points);
                } else if (current.equals(resultsTopTen.get(i - 1))) {
                    points = points + 5;
                    System.out.println("Points after 1-1: " + points);
                } else if (current.equals(resultsTopTen.get(i + 1))) {
                    points = points + 5;
                    System.out.println("Points after 1+1: " + points);
                } else if (current.equals(resultsTopTen.get(i + 2))) {
                    points = points + 2;
                    System.out.println("Points after 1+2: " + points);
                }
            } else if (i == 2) {
                if (current.equals(resultsTopTen.get(i))) {
                    points = points + 10;
                    raceCount++;
                    topThree++;
                    System.out.println("Points after " + i + "thplace: " + points);
                } else if (current.equals(resultsTopTen.get(i - 1))) {
                    points = points + 5;
                    System.out.println("Points after " + i + "-1: " + points);
                } else if (current.equals(resultsTopTen.get(i - 2))) {
                    points = points + 2;
                    System.out.println("Points after " + i + "-2: " + points);
                } else if (current.equals(resultsTopTen.get(i + 1))) {
                    points = points + 5;
                    System.out.println("Points after " + i + "+1: " + points);
                } else if (current.equals(resultsTopTen.get(i + 2))) {
                    points = points + 2;
                    System.out.println("Points after " + i + "+2: " + points);
                }
            } else if (i == 8) {
                // compare only current, plus1 and minus12
                if (current.equals(resultsTopTen.get(i))) {
                    points = points + 10;
                    raceCount++;
                    System.out.println("Points after ninthplace: " + points);
                } else if (current.equals(resultsTopTen.get(i + 1))) {
                    points = points + 5;
                    System.out.println("Points after 8+1: " + points);
                } else if (current.equals(resultsTopTen.get(i - 1))) {
                    points = points + 5;
                    System.out.println("Points after 8-1: " + points);
                } else if (current.equals(resultsTopTen.get(i - 2))) {
                    points = points + 2;
                    System.out.println("Points after 8-2: " + points);
                }
            } else if (i == 9) {
                // compare only current and minus12
                if (current.equals(resultsTopTen.get(i))) {
                    points = points + 10;
                    raceCount++;
                    System.out.println("Points after tenthplace: " + points);
                } else if (current.equals(resultsTopTen.get(i - 1))) {
                    points = points + 5;
                    System.out.println("Points after 10-1: " + points);
                } else if (current.equals(resultsTopTen.get(i - 2))) {
                    points = points + 2;
                    System.out.println("Points after 10-2: " + points);
                } else if (current.equals(resultsTopTen.get(i + 1))) {
                    points = points + 5;
                    System.out.println("Points after 10+1: " + points);
                } else if (current.equals(resultsTopTen.get(i + 2))) {
                    points = points + 2;
                    System.out.println("Points after 10+2: " + points);
                }
            } else {
                if (current.equals(resultsTopTen.get(i))) {
                    points = points + 10;
                    raceCount++;
                    System.out.println("Points after " + i + "thplace: " + points);
                } else if (current.equals(resultsTopTen.get(i - 1))) {
                    points = points + 5;
                    System.out.println("Points after " + i + "-1: " + points);
                } else if (current.equals(resultsTopTen.get(i - 2))) {
                    points = points + 2;
                    System.out.println("Points after " + i + "-2: " + points);
                } else if (current.equals(resultsTopTen.get(i + 1))) {
                    points = points + 5;
                    System.out.println("Points after " + i + "+1: " + points);
                } else if (current.equals(resultsTopTen.get(i + 2))) {
                    points = points + 2;
                    System.out.println("Points after " + i + "+2: " + points);
                }
            }
        }

        if (raceCount == 10) {
            points = points + 100;
            System.out.println("Points after raceCount 10: " + points);
        } else if (raceCount >= 6) {
            points = points + 60;
            System.out.println("Points after raceCount >=6: " + points);
        }

        if (topThree == 3) {
            points = points + 30;
            System.out.println("Points after topThree: " + points);
        }

        System.out.println("Total number of points: " + points);
        System.out.println("Eventcount: " + eventCount);
        System.out.println("Racecount: " + raceCount);
        System.out.println("Top three: " + topThree);
    }
}



