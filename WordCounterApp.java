import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class WordCounterApp extends JFrame {
    private JLabel label;
    private JTextArea textArea;
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        result = prime * result + ((textArea == null) ? 0 : textArea.hashCode());
        result = prime * result + ((countButton == null) ? 0 : countButton.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WordCounterApp other = (WordCounterApp) obj;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        if (textArea == null) {
            if (other.textArea != null)
                return false;
        } else if (!textArea.equals(other.textArea))
            return false;
        if (countButton == null) {
            if (other.countButton != null)
                return false;
        } else if (!countButton.equals(other.countButton))
            return false;
        return true;
    }

    private final JButton countButton;

    public WordCounterApp() {
        super("Word Counter");

        label = new JLabel("Enter your text:");
        textArea = new JTextArea(10, 30);
        countButton = new JButton("Count Words");

      
        setLayout(new BorderLayout());

        
        add(label, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(countButton, BorderLayout.SOUTH);

        countButton.addActionListener((var e) -> {
            String text = textArea.getText();
            int wordCount = countWords(text);
            JOptionPane.showMessageDialog(WordCounterApp.this,
                    "Number of words: " + wordCount);
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    public WordCounterApp(JButton countButton) throws HeadlessException {
        this.countButton = countButton;
    }

    public WordCounterApp(JButton countButton, GraphicsConfiguration gc) {
        super(gc);
        this.countButton = countButton;
    }

    private int countWords(String text) {
        String trimmedText = text.trim();
        if (trimmedText.isEmpty()) {
            return 0;
        }
        
        String[] words = trimmedText.split("\\s+");
        return words.length;
    }

  
    public static void main(String[] args) {
        SwingUtilities.invokeLater(WordCounterApp::new);
    }

    public JButton getCountButton() {
        return countButton;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
}
