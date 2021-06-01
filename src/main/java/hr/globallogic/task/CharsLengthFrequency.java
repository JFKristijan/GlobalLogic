package hr.globallogic.task;

import java.util.HashSet;
import java.util.Objects;


public class CharsLengthFrequency {
    private HashSet<Character> chars;
    private int length;
    private int frequency;

    public CharsLengthFrequency(int length){
        this.length=length;
        chars = new HashSet<>();
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
        return "{"+ chars +
                ", " + length +
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
