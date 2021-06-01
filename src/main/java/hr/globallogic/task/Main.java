package hr.globallogic.task;

import hr.globallogic.task.strategies.FileInputStrategy;
import hr.globallogic.task.strategies.OutputSystemOutStrategy;
import hr.globallogic.task.strategies.SystemInInputStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Counter c = new Counter(new SystemInInputStrategy(),new OutputSystemOutStrategy());
        c.count();
    }
}
