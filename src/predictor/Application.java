package predictor;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    static Scanner reader = new Scanner(System.in);

    public static ArrayList<String> fetchDrivers() {
        // This method generates and returns the list of all drivers competing in the Formula One season
        // TODO: change the implementation of this method to read the drivers from JSON file

        ArrayList<String> drivers = new ArrayList<String>();
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

        return drivers;
    }


    public static ArrayList<String> giveTopTenPredictions(ArrayList<String> drivers) {
        // In this method the top ten race results are prompted from the user

        ArrayList<String> predictions = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            System.out.println("Predict driver " + i + ": ");
            String input = reader.next();
            while (!drivers.contains(input)) {
                System.out.println("Driver doesn't exist, add a driver: ");
                input = reader.next();
            }
            predictions.add(input);
        }
        return predictions;
    }


    public static ArrayList<String> giveEventPredictions(ArrayList<String> drivers) {
        // In this method the event predictions are prompted from the user

        ArrayList<String> events = new ArrayList<String>();
        String predictedPole;
        String predictedFastest;
        String predictedGained;

        System.out.println("Enter pole position: ");
        predictedPole = reader.next();
        while (!drivers.contains(predictedPole)) {
            System.out.println("Driver doesn't exist, add a driver: ");
            predictedPole = reader.next();
        }
        events.add(predictedPole);

        System.out.println("Enter fastest lap: ");
        predictedFastest = reader.next();
        while (!drivers.contains(predictedFastest)) {
            System.out.println("Driver doesn't exist, add a driver: ");
            predictedFastest = reader.next();
        }
        events.add(predictedFastest);

        System.out.println("Enter positions gained: ");
        predictedGained = reader.next();
        while (!drivers.contains(predictedGained)) {
            System.out.println("Driver doesn't exist, add a driver: ");
            predictedGained = reader.next();
        }
        events.add(predictedGained);

        return events;
    }


    public static ArrayList<String> giveTopTwelveResults(ArrayList<String> drivers) {
        // In this method the top ten race results are prompted from the user

        ArrayList<String> resultsTopTwelve = new ArrayList<String>();

        for (int i = 1; i <= 12; i++) {
            System.out.println("Enter result driver " + i + ": ");
            String input = reader.next();
            while (!drivers.contains(input)) {
                System.out.println("Driver doesn't exist, add a driver: ");
                input = reader.next();
            }
            resultsTopTwelve.add(input);
        }
        /*TODO: change implementation to read these from JSON file
        resultsTopTwelve.add("Verstappen");
        resultsTopTwelve.add("Hamilton");
        resultsTopTwelve.add("Ricciardo");
        resultsTopTwelve.add("Vettel");
        resultsTopTwelve.add("Bottas");
        resultsTopTwelve.add("Perez");
        resultsTopTwelve.add("Vandoorne");
        resultsTopTwelve.add("Stroll");
        resultsTopTwelve.add("Massa");
        resultsTopTwelve.add("Ocon");
        resultsTopTwelve.add("Alonso");
        resultsTopTwelve.add("Magnussen");
        */
        return resultsTopTwelve;
    }


    public static ArrayList<String> giveEventResults(ArrayList<String> drivers) {
        // In this method the event results are prompted from the user

        String resultPole;
        String resultFastest;
        String resultGained;
        ArrayList<String> resultsEvents = new ArrayList<String>();

        System.out.println("Enter pole position result: ");
        resultPole = reader.next();
        while (!drivers.contains(resultPole)) {
            System.out.println("Driver doesn't exist, add a driver: ");
            resultPole = reader.next();
        }
        resultsEvents.add(resultPole);

        System.out.println("Enter fastest lap result: ");
        resultFastest = reader.next();
        while (!drivers.contains(resultFastest)) {
            System.out.println("Driver doesn't exist, add a driver: ");
            resultFastest = reader.next();
        }
        resultsEvents.add(resultFastest);

        System.out.println("Enter positions gained result: ");
        resultGained = reader.next();
        while (!drivers.contains(resultGained)) {
            System.out.println("Driver doesn't exist, add a driver: ");
            resultGained = reader.next();
        }
        resultsEvents.add(resultGained);

        /*TODO: change implementation to read these from JSON file as well
        String resultPole = "Hamilton";
        String resultFastest = "Vettel";
        String resultGained = "Vettel";
        ArrayList<String> resultsEvents = new ArrayList<String>();

        resultsEvents.add(resultPole);
        resultsEvents.add(resultFastest);
        resultsEvents.add(resultGained);
        */
        return resultsEvents;
    }


    public static int calculateEventPoints(ArrayList<String> predictions, ArrayList<String> results, int points) {
        // This method calculates points from the race events, including bonus points

        int eventCount = 0;

        for (int i = 0; i < predictions.size(); i++) {
            if (predictions.get(i).equals(results.get(i))) {
                points = points + 5;
                eventCount++;
            }
        }
        if (eventCount == 3) {
            points = points + 20;
        }

        return points;
    }


    public static int calculateRacePoints(ArrayList<String> predictedTopTen, ArrayList<String> resultsTopTen, int points) {
        // This method calculates points from the top ten positions, including bonus points

        int raceCount = 0;
        int topThree = 0;
        String current;

        for (int i = 0; i < predictedTopTen.size(); i++) {
            current = predictedTopTen.get(i).toString();

            if (i == 0) {
                // compare only current and plus1-2
                if (current.equals(resultsTopTen.get(i))) {
                    points = points + 20;
                    raceCount++;
                    topThree++;
                } else if (current.equals(resultsTopTen.get(i + 1))) {
                    points = points + 5;
                } else if (current.equals(resultsTopTen.get(i + 2))) {
                    points = points + 2;
                }
            } else if (i == 1) {
                // compare only current, minus1 and plus1-2
                if (current.equals(resultsTopTen.get(i))) {
                    points = points + 10;
                    raceCount++;
                    topThree++;
                } else if (current.equals(resultsTopTen.get(i - 1))) {
                    points = points + 5;
                } else if (current.equals(resultsTopTen.get(i + 1))) {
                    points = points + 5;
                } else if (current.equals(resultsTopTen.get(i + 2))) {
                    points = points + 2;
                }
            } else if (i == 2) {
                if (current.equals(resultsTopTen.get(i))) {
                    points = points + 10;
                    raceCount++;
                    topThree++;
                } else if (current.equals(resultsTopTen.get(i - 1))) {
                    points = points + 5;
                } else if (current.equals(resultsTopTen.get(i - 2))) {
                    points = points + 2;
                } else if (current.equals(resultsTopTen.get(i + 1))) {
                    points = points + 5;
                } else if (current.equals(resultsTopTen.get(i + 2))) {
                    points = points + 2;
                }
            } else if (i == 8) {
                // compare only current, plus1 and minus1-2
                if (current.equals(resultsTopTen.get(i))) {
                    points = points + 10;
                    raceCount++;
                } else if (current.equals(resultsTopTen.get(i + 1))) {
                    points = points + 5;
                } else if (current.equals(resultsTopTen.get(i - 1))) {
                    points = points + 5;
                } else if (current.equals(resultsTopTen.get(i - 2))) {
                    points = points + 2;
                }
            } else if (i == 9) {
                // compare only current and minus1-2
                if (current.equals(resultsTopTen.get(i))) {
                    points = points + 10;
                    raceCount++;
                } else if (current.equals(resultsTopTen.get(i - 1))) {
                    points = points + 5;
                } else if (current.equals(resultsTopTen.get(i - 2))) {
                    points = points + 2;
                } else if (current.equals(resultsTopTen.get(i + 1))) {
                    points = points + 5;
                } else if (current.equals(resultsTopTen.get(i + 2))) {
                    points = points + 2;
                }
            } else {
                if (current.equals(resultsTopTen.get(i))) {
                    points = points + 10;
                    raceCount++;
                } else if (current.equals(resultsTopTen.get(i - 1))) {
                    points = points + 5;
                } else if (current.equals(resultsTopTen.get(i - 2))) {
                    points = points + 2;
                } else if (current.equals(resultsTopTen.get(i + 1))) {
                    points = points + 5;
                } else if (current.equals(resultsTopTen.get(i + 2))) {
                    points = points + 2;
                }
            }
        }

        if (raceCount == 10) {
            points = points + 100;
        } else if (raceCount >= 6) {
            points = points + 60;
        }

        if (topThree == 3) {
            points = points + 30;
        }

        return points;
    }


    public static void main(String[] args) {

        int points = 0;

        ArrayList<String> drivers = fetchDrivers();
        ArrayList<String> predictedTopTen = giveTopTenPredictions(drivers);
        ArrayList<String> predictedEvents = giveEventPredictions(drivers);
        ArrayList<String> resultsTopTen = giveTopTwelveResults(drivers);
        ArrayList<String> resultsEvents = giveEventResults(drivers);

        points = calculateEventPoints(predictedEvents, resultsEvents, points);
        points = calculateRacePoints(predictedTopTen, resultsTopTen, points);

        System.out.println("Total number of points: " + points);
    }
}



