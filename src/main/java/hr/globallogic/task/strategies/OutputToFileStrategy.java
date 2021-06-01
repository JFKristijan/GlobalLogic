package hr.globallogic.task.strategies;

import hr.globallogic.task.CharsLengthFrequency;
import hr.globallogic.task.Counter;
import hr.globallogic.task.OutputStrategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class OutputToFileStrategy implements OutputStrategy {
    private String fileName;
    public OutputToFileStrategy(String file){
        this.fileName=file;
    }

    @Override
    public void outputResults(Counter counter) {
        try (FileOutputStream os = new FileOutputStream(new File(fileName))) {
            int totalFrequency = counter.getTotalFrequency();
            int inputLength = counter.getInputLength();

            for (Map.Entry<CharsLengthFrequency, Double> entry : counter.getFrequencies().entrySet()) {
                CharsLengthFrequency k = entry.getKey();
                Double v = entry.getValue();
                os.write(String.format("%s = %.2f (%d/%d)\n", k, v, k.getFrequency(), totalFrequency).getBytes());
            }

            os.write(String.format("TOTAL Frequency: %.2f (%d/%d)\n",totalFrequency/(double)inputLength,totalFrequency,inputLength).getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
