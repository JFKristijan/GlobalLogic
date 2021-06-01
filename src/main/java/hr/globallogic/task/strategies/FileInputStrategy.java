package hr.globallogic.task.strategies;

import hr.globallogic.task.InputStrategy;

import java.io.*;

public class FileInputStrategy implements InputStrategy {
    private String chars;
    private String input;

    public FileInputStrategy(String inputFile){
        try {
            FileInputStream is = new FileInputStream(new File(inputFile));
            String read = new String(is.readAllBytes());
            is.close();

            String[] split = read.split("\n");
            chars = split[0];

            StringBuilder sb = new StringBuilder();

            for(int i = 1 ; i < split.length ; i++){
                sb.append(split[i]).append(" ");
            }

            input=sb.toString();

        } catch (IOException e) {
            System.out.println("Failed to open file" + inputFile);
            System.exit(1);
        }
    }

    @Override
    public String getChars() {
        return chars;
    }

    @Override
    public String getInput() {



        return input;
    }

}
