/**
 * Week 11 - IO Homework
 *
 * This program reads a CSV file containing the biathlon results of 10 athletes.
 * Each line in the file is transformed into an Athlete type object and added to a list.
 * A 10 second penalty is added for each miss, represented as "o" (eg. xxoox - 2 misses).
 * The list is sorted by the final time and the top 3 athletes are printed.
 *
 *
 * @author Florin
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args)  {
        List<Athlete> athletes = readFromCSV("SkiResults.csv");
        Set<Athlete> sortedAthletes = new TreeSet<>(new sortByLowestTime());

        for(int i = 0; i<athletes.size(); i++){
            sortedAthletes.add(athletes.get(i));
        }
        athletes.clear();
        athletes = new ArrayList<>(sortedAthletes);
        System.out.println("         Biathlon top 3 athletes");
        System.out.println("-----------------------------------------");
        for(int i = 0; i <= 2; i++){
            System.out.println(athletes.get(i));
        }
    }


    private static List<Athlete> readFromCSV(String fileName){
        List<Athlete> athletes = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
            String line = br.readLine();

            while (line != null){
                String[] elements = line.split(",");
                Athlete athlete = createAthlete(elements);
                athletes.add(athlete);
                line = br.readLine();
            }

        } catch (IOException e){
            System.err.println("IO Error!");
        }
        return athletes;
    }

    private static Athlete createAthlete(String[] element){
        int number = Integer.parseInt(element[0]);
        String name = element[1];
        String country = element[2];

        String initialTime = element[3];
        String[] splitTime = initialTime.split(":");
        int minutes;
        int seconds;
        try {
            minutes = Integer.parseInt(splitTime[0]);
            seconds = Integer.parseInt(splitTime[1]);

        }catch (NumberFormatException e){
            minutes = 0;
            seconds = 0;
        }
        int [] integerTime = {minutes,seconds};

        String range1 = element[4];
        int missedRange1 = range1.length() - range1.replace("o", "").length();
        String range2 = element[5];
        int missedRange2 = range2.length() - range2.replace("o", "").length();
        String range3 = element[6];
        int missedRange3 = range3.length() - range3.replace("o", "").length();

        int penalty = ((missedRange1 + missedRange2 + missedRange3) * 10);
        int penaltyMinutes = penalty / 60;
        int penaltySeconds = penalty % 60;

        int finalMinutes = penaltyMinutes + integerTime[0];
        int finalSeconds = penaltySeconds + integerTime[1];
        if (finalSeconds >= 60){
            finalMinutes = finalMinutes + 1;
            finalSeconds = finalSeconds%60;
        }

        String time;
        if (finalSeconds < 10){
            int[] addAZero = {0,finalSeconds};
            time = finalMinutes + ":" + addAZero[0] + addAZero[1];
        } else {
            time = finalMinutes + ":" + finalSeconds;
        }

        return new Athlete(number,name,country,new Hour(time),range1,range2,range3);
    }
}

class sortByLowestTime implements Comparator<Athlete>{
    @Override
    public int compare(Athlete a1, Athlete a2){
        if(a1.getTime().getComparableTime() > a2.getTime().getComparableTime()) {
            return 1;
        } else {
            return -1;
        }
    }
}

