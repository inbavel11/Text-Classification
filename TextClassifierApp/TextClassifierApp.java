import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleTextClassifierApp {
    private SimpleNaiveBayesClassifier classifier;

    public SimpleTextClassifierApp() {
        classifier = new SimpleNaiveBayesClassifier();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        // Create JFrame
        JFrame frame = new JFrame("Text Classifier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create components
        JTextField textField = new JTextField(20);
        JButton classifyButton = new JButton("Classify");
        JLabel resultLabel = new JLabel("Category: ");

        // Add ActionListener to button
        classifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                String category = classifier.classify(text);
                resultLabel.setText("Category: " + category);
            }
        });

        // Layout components
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter text:"));
        panel.add(textField);
        panel.add(classifyButton);
        panel.add(resultLabel);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleTextClassifierApp());
    }
}
