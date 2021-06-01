package hr.globallogic.task.strategies;

import hr.globallogic.task.Counter;
import hr.globallogic.task.OutputStrategy;

public class OutputSystemOutStrategy implements OutputStrategy {


    @Override
    public void outputResults(Counter counter) {
        int totalFrequency = counter.getTotalFrequency();
        int inputLength = counter.getInputLength();
        counter.getFrequencies().forEach((k,v)->System.out.println(String.format("%s = %.2f (%d/%d)",k,v,k.getFrequency(),totalFrequency)));
        System.out.printf("TOTAL Frequency: %.2f (%d/%d)\n",totalFrequency/(double)inputLength,totalFrequency,inputLength);
    }
}
