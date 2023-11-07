import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class wordcount {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        Map<String, Integer> wordCounts = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();

                line = line.trim();

                if (!line.isEmpty()) {
                    wordCounts.put(line, wordCounts.getOrDefault(line, 0) + 1);
                }
            }

            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }

            writer.close();

            System.out.println("Word counts have been written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}