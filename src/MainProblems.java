import javax.swing.*;
import java.awt.*;

public class MainProblems extends JFrame {

    static JLabel LABEL_PROBLEM_TYPE = new JLabel("Type of problem:");
    static JLabel LABEL_NUM_DIGITS = new JLabel("Digits in problem:");
    static JLabel LABEL_NUM_PROBLEMS = new JLabel("Number of problems:");

    static String STRING_CALC_ANSWERS = "Calculate answers?";
    static String STRING_GO = "Go";

    static Integer[] INT_NUM_DIGITS = {1, 2, 3, 4, 5};

    JComboBox problemTypeDrpDwn = new JComboBox<>(new String[]{"Logarithms", "Exponents"});
    JComboBox<Integer> numDigitsDrpDwn = new JComboBox<>(INT_NUM_DIGITS);
    JTextField numProblemsTF = new JTextField(5);
    JCheckBox calcAnswersBox = new JCheckBox(STRING_CALC_ANSWERS);
    JButton goButton = new JButton(STRING_GO);
    JPanel jPanel = new JPanel();

    MainProblems() {
        super("Math Problem Generator");
        setSize(600, 200);
        setResizable(false);
        new ProblemGenerator();
        jPanel.setLayout(null);

        problemTypeDrpDwn.setMaximumSize(new Dimension(100, 25));
        numProblemsTF.setMaximumSize(new Dimension(100, 25));
        goButton.addActionListener(e -> {

            if (numProblemsTF.getText().length() == 0)
                JOptionPane.showMessageDialog(jPanel,"The \"Number of problems\" field must not be empty.", "ERROR", JOptionPane.ERROR_MESSAGE);

            else {
                int parsedInput = 0;
                try {
                    parsedInput = Integer.parseInt(numProblemsTF.getText());
                }
                catch (java.lang.NumberFormatException exception){
                    JOptionPane.showMessageDialog(jPanel,"Only use numbers in the \"Number of problems\" field.","ERROR",JOptionPane.ERROR_MESSAGE);
                }

                ProblemGenerator.GenerateProblems((String) problemTypeDrpDwn.getSelectedItem(), parsedInput);
            }
        });

        addComponentsToPanel();
        setComponentBounds();

        add(jPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        updateComponentLoop(500);
    }

    public static void main(String[] args){
        new MainProblems();
    }

    private void updateComponentLoop(int delay){
        while(true){
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
    private void addComponentsToPanel(){
        jPanel.add(problemTypeDrpDwn);
        jPanel.add(LABEL_PROBLEM_TYPE);

        jPanel.add(numDigitsDrpDwn);
        jPanel.add(LABEL_NUM_DIGITS);

        jPanel.add(numProblemsTF);
        jPanel.add(LABEL_NUM_PROBLEMS);

        jPanel.add(calcAnswersBox);
        jPanel.add(goButton);
    }

    private void setComponentBounds(){
        LABEL_PROBLEM_TYPE.setBounds(5, 5, 100, 25);
        problemTypeDrpDwn.setBounds(5, 35, 100, 25);

        LABEL_NUM_DIGITS.setBounds(120, 5, 100, 25);
        numDigitsDrpDwn.setBounds(140, 35, 50, 25);

        LABEL_NUM_PROBLEMS.setBounds(235, 5, 120, 25);
        numProblemsTF.setBounds(255, 35, 50, 25);
        goButton.setBounds(540, 5, 50, 25);
    }
}
