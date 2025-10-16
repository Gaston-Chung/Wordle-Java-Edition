import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class InstructionsPage extends JFrame
{
    private JLabel instructionsTitleLabel;
    private JTextArea instructionsTextArea;
    private JButton backButton;


    
    public InstructionsPage()
    {
        // JFrame Setup
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Background Panel Setup
        BackgroundPanel background = new BackgroundPanel();
        background.setLayout(null); // Use null layout for absolute positioning
        this.setContentPane(background);

        // Title Label
        instructionsTitleLabel = new JLabel("How To Play"); //📜 
        instructionsTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 50));
        instructionsTitleLabel.setForeground(new Color(255, 215, 0));
        instructionsTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        instructionsTitleLabel.setOpaque(true);
        instructionsTitleLabel.setBackground(new Color(0, 0, 0, 180));
        // Center the title label horizontally and position it at the top
        int titleWidth = 600;
        int titleHeight = 80;
        int titleX = (getWidth() - titleWidth) / 2;
        int titleY = 30; // Original Y position
        instructionsTitleLabel.setBounds(titleX, titleY + 25, titleWidth, titleHeight);
        background.add(instructionsTitleLabel);

        // Instructions Text Area
        instructionsTextArea = new JTextArea();
        instructionsTextArea.setText("""
                    Welcome to Wordle: Java Edition!

                    Wordle is a word-guessing game where you try to figure out what the hidden 5-letter word is.

                    You submit other words to see if they share any letters in common, and if the placement of those letters are correct or not.

                    Green letters mean that the letter is in the right spot. Yellow letters mean that the letter is somewhere in the word, just not in that particular spot. White means the letter is not in the word at all.

                    This version of Wordle includes the original Wordle, as well as 5 new, special variations that I've come up with! Read their descriptions on the Gamemodes Page to learn more.

                    Good luck and have fun!
                    """);
        instructionsTextArea.setFont(new Font("SansSerif", Font.PLAIN, 22));
        instructionsTextArea.setForeground(Color.WHITE);
        instructionsTextArea.setBackground(new Color(0, 0, 0, 200));
        instructionsTextArea.setWrapStyleWord(true);
        instructionsTextArea.setLineWrap(true);
        instructionsTextArea.setEditable(false);
        instructionsTextArea.setFocusable(false);
        instructionsTextArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        instructionsTextArea.setBounds(100, 50, 100, 100);

        JScrollPane scrollPane = new JScrollPane(instructionsTextArea);
        // Position the scroll pane below the title, with increased margin
        int scrollWidth = 700;
        int scrollHeight = 400;
        int scrollX = (getWidth() - scrollWidth) / 2;
        int scrollY = titleY + titleHeight + 30; // Increased margin below title
        scrollPane.setBounds(scrollX - 15, scrollY + 50, scrollWidth + 25, scrollHeight + 140);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(true);
        scrollPane.setBackground(new Color(0, 0, 0, 200));
        background.add(scrollPane);


        // Back Button
        backButton = new JButton("Back To Menu");
        backButton.setFont(new Font("Helvetica", Font.BOLD, 25));
        backButton.setBackground(new Color(50, 100, 255));
        backButton.setForeground(Color.WHITE);
        // Position the button below the scroll pane
        int buttonWidth = 300;
        int buttonHeight = 60;
        int buttonX = (getWidth() - buttonWidth) / 2;
        int buttonY = scrollY + scrollHeight + 40; // Increased margin below scroll pane
        backButton.setBounds(buttonX, buttonY + 250, buttonWidth, buttonHeight);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        backButton.setOpaque(true);

        backButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setBackground(new Color(50, 150, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setBackground(new Color(50, 100, 255));
            }
        });

        backButton.addActionListener(e -> {
            new HomePage();
            dispose();
        });

        background.add(backButton);

        this.setVisible(true);
    }

    // Gradient Background Panel
    static class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint gp = new GradientPaint(0, 0, new Color(0, 0, 139), 0, getHeight(), new Color(70, 130, 180));
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(InstructionsPage::new);
    }
}