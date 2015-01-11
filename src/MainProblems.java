import javax.swing.*;
import java.awt.*;

public class MainProblems extends JFrame {
    JPanel jPanel = new JPanel();

    String[] problemTypeList = {"Logarithms", "Exponents"};
    Integer[] numDigitsList = {1, 2, 3, 4, 5};
    String calcAnswersBoxText = "Calculate Answers?";
    String generateButtonText = "Go";

    JComboBox<String> problemTypeDrpDwn = new JComboBox<>(problemTypeList);
    JLabel problemTypeLbl = new JLabel("Type of problem:");

    JComboBox<Integer> numDigitsDrpDwn = new JComboBox<>(numDigitsList);
    JLabel numDigitsLbl = new JLabel("Digits in problem:");

    JTextField numProblemsTF = new JTextField(5);
    JLabel numProblemsLbl = new JLabel("Number of problems:");

    JCheckBox calcAnswersBox = new JCheckBox(calcAnswersBoxText);
    JButton goButton = new JButton(generateButtonText);

    MainProblems(){
        super("Math Problem Generator");
        setSize(600, 200);
        setResizable(false);
        new ProblemGenerator();
        jPanel.setLayout(null);

        problemTypeDrpDwn.setMaximumSize(new Dimension(100, 25));
        numProblemsTF.setMaximumSize(new Dimension(100, 25));
        goButton.addActionListener(e -> {

            if (numProblemsTF.getText().length() == 0)
                System.out.println("problem value cannot be null");
            else {
                int parsedInput = 0;
                try {
                    parsedInput = Integer.parseInt(numProblemsTF.getText());
                }
                catch (java.lang.NumberFormatException exception){
                    JOptionPane.showMessageDialog(jPanel,exception + "\n\nOnly use numbers in the \"Number of problems\" field.","ERROR",JOptionPane.ERROR_MESSAGE);
                }

                ProblemGenerator.GenerateProblems((String) problemTypeDrpDwn.getSelectedItem(), parsedInput);
            }
        });

        addComponentsToPanel();
        setComponentBounds();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args){
        new MainProblems();

    }

    private void addComponentsToPanel(){
        jPanel.add(problemTypeDrpDwn);
        jPanel.add(problemTypeLbl);

        jPanel.add(numDigitsDrpDwn);
        jPanel.add(numDigitsLbl);

        jPanel.add(numProblemsTF);
        jPanel.add(numProblemsLbl);

        jPanel.add(calcAnswersBox);
        jPanel.add(goButton);
    }

    private void setComponentBounds(){
        problemTypeLbl.setBounds(5, 5, 100, 25);
        problemTypeDrpDwn.setBounds(5, 35, 100, 25);

        numDigitsLbl.setBounds(120, 5, 100, 25);
        numDigitsDrpDwn.setBounds(140, 35, 50, 25);

        numProblemsLbl.setBounds(235, 5, 120, 25);
        numProblemsTF.setBounds(255, 35, 50, 25);
        goButton.setBounds(540, 5, 50, 25);
        add(jPanel);
    }
}
