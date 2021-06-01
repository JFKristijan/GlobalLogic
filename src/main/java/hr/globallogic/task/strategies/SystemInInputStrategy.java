package hr.globallogic.task.strategies;

import hr.globallogic.task.InputStrategy;

import java.util.Scanner;

public class SystemInInputStrategy implements InputStrategy {
    private Scanner sc;
    public SystemInInputStrategy(){
        sc = new Scanner(System.in);
    }
    @Override
    public String getChars() {
        System.out.print("Please enter the characters for calculating frequency: ");
        return sc.nextLine();
    }

    @Override
    public String getInput() {
        System.out.printf("Please enter the input to calculate the frequency of: ");
        return sc.nextLine();
    }
}
