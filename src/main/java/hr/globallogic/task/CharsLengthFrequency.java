package hr.globallogic.task;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;


public class CharsLengthFrequency {
    private HashSet<Character> chars;
    private int length;
    private int frequency;
    private String charsToSort;

    public CharsLengthFrequency(int length,String charsToSort){
        this.length=length;
        chars = new HashSet<>();
        this.charsToSort=charsToSort;
    }

    public void addChar(char toAdd){
        chars.add(toAdd);
        frequency++;
    }

    public boolean isEmpty(){
        return chars.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharsLengthFrequency that = (CharsLengthFrequency) o;
        return length == that.length && Objects.equals(chars, that.chars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chars, length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for( int i = 0 ; i < charsToSort.length() ; i++){
            char c = charsToSort.charAt(i);
            if(chars.contains(c)) {
                sb.append(c);
                sb.append(",");
            }

        }
        sb.setLength(sb.length()-1);
        return "{("+ sb.toString()+
                "), " + length +
                '}';
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getChars() {
        return chars.toString().replaceAll("[\\[\\]]","");
    }

}
