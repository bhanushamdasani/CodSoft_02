import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculatorGUI extends JFrame {

    private JTextField subjectsField;
    private JTextArea resultArea;

    public StudentGradeCalculatorGUI() {
        setTitle("Student Grade Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel subjectsLabel = new JLabel("Enter the number of subjects:");
        subjectsField = new JTextField(10);

        JButton calculateButton = new JButton("Calculate Grades");
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        add(subjectsLabel);
        add(subjectsField);
        add(calculateButton);
        add(resultArea);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrades();
            }
        });
    }

    private void calculateGrades() {
        try {
            int numOfSubjects = Integer.parseInt(subjectsField.getText());

            int totalMarks = 0;
            for (int i = 1; i <= numOfSubjects; i++) {
                String input = JOptionPane.showInputDialog("Enter marks obtained in subject " + i + ":");
                int marks = Integer.parseInt(input);
                totalMarks += marks;
            }

            double averagePercentage = (double) totalMarks / numOfSubjects;

            char grade;
            if (averagePercentage >= 90) {
                grade = 'A';
            } else if (averagePercentage >= 80) {
                grade = 'B';
            } else if (averagePercentage >= 70) {
                grade = 'C';
            } else if (averagePercentage >= 60) {
                grade = 'D';
            } else if (averagePercentage >= 50) {
                grade = 'E';
            } else {
                grade = 'F';
            }

            String result = "Total Marks: " + totalMarks + "\n" +
                            "Average Percentage: " + averagePercentage + "%\n" +
                            "Grade: " + grade;

            resultArea.setText(result);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number of subjects and marks.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentGradeCalculatorGUI calculatorGUI = new StudentGradeCalculatorGUI();
            calculatorGUI.setSize(400, 300);
            calculatorGUI.setVisible(true);
        });
    }
}
