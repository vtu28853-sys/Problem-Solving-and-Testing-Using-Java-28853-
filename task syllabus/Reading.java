import java.util.*;
import java.util.stream.*;

class Reading {
    String sensorId;
    double temperature;

    Reading(String sensorId, double temperature) {
        this.sensorId = sensorId;
        this.temperature = temperature;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Reading> readings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            double temp = sc.nextDouble();

            readings.add(new Reading(id, temp));
        }

        Map<String, Double> averages = readings.stream()
                .filter(r -> r.temperature > 50)
                .collect(Collectors.groupingBy(
                        r -> r.sensorId,
                        Collectors.averagingDouble(r -> r.temperature)
                ));

        averages.entrySet()
                .stream()
                .sorted(
                        Map.Entry.<String, Double>comparingByValue()
                                .reversed()
                                .thenComparing(Map.Entry.comparingByKey())
                )
                .forEach(e ->
                        System.out.printf("%s %.1f%n",
                                e.getKey(), e.getValue())
                );
    }
}