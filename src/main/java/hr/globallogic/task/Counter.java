package hr.globallogic.task;

import java.util.*;


public class Counter {
    private static final String SPECIALCHARSREGEX = "[!\"#\\$%&\'()*+,-./:;<=>?@[\\\\]\\^_`\\{\\|}~ ]";
    private int totalFrequency;
    private List<CharsLengthFrequency> charLengthList;
    private InputStrategy is;
    private OutputStrategy os;
    private int inputLength;

    public Counter(InputStrategy is,OutputStrategy os){
        this.is=is;
        this.os=os;
    }

    private void count(String chars, String toCount){
        chars = chars.toLowerCase();
        toCount=toCount.trim().replaceAll(SPECIALCHARSREGEX," ").toLowerCase();
        String[] split = toCount.split("\\s+");
        this.inputLength=toCount.replace(" ","").length();
        this.totalFrequency=0;
        charLengthList = new ArrayList<>();


        for(String word : split){
            int wordLength = word.length();
            CharsLengthFrequency charsLengthFrequencyForWord = new CharsLengthFrequency(wordLength);

            for(int i = 0 ; i < wordLength ; i++){
                char charactedInWord = word.charAt(i);

                if(chars.indexOf(charactedInWord)!=-1){
                    charsLengthFrequencyForWord.addChar(charactedInWord);
                    totalFrequency++;
                }

            }

            if(!charsLengthFrequencyForWord.isEmpty()){
                CharsLengthFrequency curr = charLengthList.stream().filter(e->e.equals(charsLengthFrequencyForWord)).findFirst().orElse(null);

                if(curr==null){
                    charLengthList.add(charsLengthFrequencyForWord);
                }else {
                    curr.setFrequency(curr.getFrequency()+ charsLengthFrequencyForWord.getFrequency());
                }
            }

        }
        Collections.sort(charLengthList,Comparator.comparing(CharsLengthFrequency::getFrequency).thenComparing(CharsLengthFrequency::getChars));
    }

    public void count(){
        String chars = is.getChars();
        String input = is.getInput();
        count(chars,input);
        os.outputResults(this);
    }

    public int getTotalFrequency() {
        return totalFrequency;
    }

    public List<CharsLengthFrequency> getCharLengthList() {
        return charLengthList;
    }

    public Map<CharsLengthFrequency,Double> getFrequencies(){
        Map<CharsLengthFrequency,Double> mapFrequencies = new LinkedHashMap<>();
        charLengthList.forEach(e->mapFrequencies.put(e,e.getFrequency()/(double)totalFrequency));

        return mapFrequencies;
    }

    public int getInputLength() {
        return inputLength;
    }
}
