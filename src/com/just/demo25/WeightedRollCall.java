package com.just.demo25;

import java.io.*;
import java.util.*;

public class WeightedRollCall {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo25\\person.txt");
        File weightedFile = new File("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo25\\weightedFile.txt");
        HashMap<String, Double> weights = new HashMap<>();

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s;
        ArrayList<String> persons = new ArrayList<>();
        while ((s = bufferedReader.readLine()) != null) {
            persons.add(s.split("-")[0]);
        }
        bufferedReader.close();

        if (weightedFile.exists()) {
            FileReader weightedFileReader = new FileReader(weightedFile);
            BufferedReader weightedBufferedReader = new BufferedReader(weightedFileReader);
            String s1;
            while ((s1 = weightedBufferedReader.readLine()) != null) {
                weights.put(s1.split(",")[0], Double.parseDouble(s1.split(",")[1]));
            }
            weightedBufferedReader.close();
        } else {
            for (String person : persons) {
                weights.put(person, 1.0 / persons.size());
            }
        }

        Random random = new Random();
        double aDouble = random.nextDouble() / persons.size();
        Collections.shuffle(persons);
        double oldWeight = 0.0;
        while ((oldWeight = weights.get(persons.get(0))) < aDouble) {
            Collections.shuffle(persons);
        }
        double newWeight = oldWeight / 2.0;
        double v = (oldWeight - newWeight) / (persons.size() - 1.0);
        weights.put(persons.get(0), newWeight);

        FileWriter weightedFileWriter = new FileWriter(weightedFile);
        BufferedWriter weightedBufferedWriter = new BufferedWriter(weightedFileWriter);
        Set<Map.Entry<String, Double>> entries = weights.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            double value = entry.getValue();
            if (!entry.getKey().equals(persons.get(0))) {
                value += v;
            }
            weightedBufferedWriter.write(entry.getKey() + "," + value);
            weightedBufferedWriter.newLine();
        }
        weightedBufferedWriter.close();

    }
}
