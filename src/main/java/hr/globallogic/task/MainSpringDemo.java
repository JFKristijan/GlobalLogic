package hr.globallogic.task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainSpringDemo extends JFrame {
    private JTextArea textArea;
    private JTextField charsField;
    private JTextField inputField;
    private Counter counter;
    private InputStrategy is = new InputStrategy() {
        @Override
        public String getChars() {
            return charsField.getText();
        }

        @Override
        public String getInput() {
            return inputField.getText();
        }
    };
    private OutputStrategy os = new OutputStrategy() {
        @Override
        public void outputResults(Counter counter) {
            int totalFrequency = counter.getTotalFrequency();
            int inputLength = counter.getInputLength();
            StringBuilder sb = new StringBuilder();
            counter.getFrequencies().forEach((k,v)->sb.append(String.format("%s = %.2f (%d/%d)\n",k,v,k.getFrequency(),totalFrequency)));
            sb.append(String.format("TOTAL Frequency: %.2f (%d/%d)\n",totalFrequency/(double)inputLength,totalFrequency,inputLength));
            textArea.setText(sb.toString());
        }
    };

    public MainSpringDemo(){
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        textArea=new JTextArea();
        textArea.setEditable(false);
        charsField=new JTextField();
        inputField=new JTextField();
        counter= new Counter(is,os);


        JPanel topPane = new JPanel();

        topPane.setLayout(new GridLayout(3,2));

        topPane.add(new JLabel("Characters to count frequency:"));
        topPane.add(charsField);

        topPane.add(new JLabel("String from which to count:"));
        topPane.add(inputField);

        JButton jb = new JButton("Calculate frequency");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter.count();
            }
        });
        getRootPane().setDefaultButton(jb);
        topPane.add(new JLabel());
        topPane.add(jb);

        c.add(topPane,BorderLayout.PAGE_START);
        c.add(new JScrollPane(textArea),BorderLayout.CENTER);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Demo application");
        setSize(400,400);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new MainSpringDemo().setVisible(true));
    }
}
