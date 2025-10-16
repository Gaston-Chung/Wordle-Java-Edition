import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class PlayerSwapInfoPage extends JFrame
{
    //JComps
    private JLabel titleLabel;

    private JLabel desiredWordLabel;
    private JTextField enterWord;
    private JLabel requirementsLabel;
    private JButton startRoundButton;
    private SubmitButtonListener tfl1;
    private JButton backButton;
    private JLabel errorLabel;
    private JLabel player1PointsLabel, player2PointsLabel;


    //Non-JComps
    public static String playersChosenWord;
    public static String playerToSetString, playerToGuessString;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public PlayerSwapInfoPage()
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

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(150, 50, 250));
        titlePanel.setBounds(0, 0, 1000, 70);
        titlePanel.setLayout(null);
        this.add(titlePanel);

        JLabel titleLabel = new JLabel("Round Setup", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 36));
        titleLabel.setBounds(250, 15, 550, 50);
        titlePanel.add(titleLabel);



        Font setupFont = new Font("SansSerif", Font.PLAIN, 30);

        //If its player 1's turn rn
        if (HomePage.player1Turn == true)
        {
            playerToGuessString = "1";
            playerToSetString = "2";
        }

        //If its player 2's turn rn
        else if (HomePage.player1Turn == false)
        {
            playerToGuessString = "2";
            playerToSetString = "1";
        }

        desiredWordLabel = new JLabel("<html> Player " + playerToGuessString + ", Don't Look! <br> Player " + playerToSetString + ", Please Enter Your Desired Word: <html>");
        desiredWordLabel.setBounds(220, 120, 650, 100);
        desiredWordLabel.setFont(setupFont);
        desiredWordLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        background.add(desiredWordLabel);

        enterWord = new JTextField();
        enterWord.setBounds(310, 220, 400, 50);
        enterWord.setFont(new Font("Helvetica", Font.BOLD, 30));
        background.add(enterWord);

        requirementsLabel = new JLabel("<html> - Must be 5 letters long and only contain English letters <br> <br> - Cannot be profanity or non-English words <br> <html>");
        requirementsLabel.setBounds(315, 185, 400, 400);
        requirementsLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));
        requirementsLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        background.add(requirementsLabel);



        Font buttonFont = new Font("Helvetica", Font.BOLD, 25);

        startRoundButton = new JButton("Start Round");
        startRoundButton.setFont(buttonFont);
        startRoundButton.setBackground(new Color(0, 255, 30));
        startRoundButton.setForeground(Color.BLACK);
        startRoundButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        startRoundButton.setFocusPainted(false);
        startRoundButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        startRoundButton.setOpaque(true);

        startRoundButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                startRoundButton.setBackground(new Color(0, 200, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startRoundButton.setBackground(new Color(0, 255, 30));
            }
        });

        tfl1 = new SubmitButtonListener();
        startRoundButton.addActionListener(tfl1);

        startRoundButton.setBounds(250, 720, 250, 60);
        background.add(startRoundButton);
        
        
        
        // Back Button
        backButton = new JButton("Back To Menu");
        backButton.setFont(new Font("Helvetica", Font.BOLD, 25));
        backButton.setBackground(new Color(50, 100, 255));
        backButton.setForeground(Color.WHITE);
        int buttonWidth = 300; int buttonHeight = 60;
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        backButton.setOpaque(true);
        backButton.setBounds(515, 720, buttonWidth, buttonHeight);
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
            
            //Disable playerSwapFlag
            PlayerSwapPage.playerSwapEnabled = false;

            //Go back to gamemode page
            new GameModePage();
            dispose();
        });
        background.add(backButton);
        this.setVisible(true);



        errorLabel = new JLabel("", SwingConstants.CENTER);
        errorLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        errorLabel.setOpaque(true);
        errorLabel.setPreferredSize(new Dimension(180, 70));
        errorLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        errorLabel.setBounds(40, 900, 920, 70);
        errorLabel.setBackground(Color.RED);
        errorLabel.setForeground(Color.BLACK);
        background.add(errorLabel);
        errorLabel.setVisible(false); //By default, dont show it
    }



    public class SubmitButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == startRoundButton)
            {
                //First, collect info from text boxes
                playersChosenWord = enterWord.getText().toUpperCase();

                //Inputted word must be only 5 letters long
                if (playersChosenWord.length() != 5)
                {
                    String not5CharactersLongMsg = "Error: Word is not 5 letters long.";
                    errorLabel.setText(not5CharactersLongMsg);
                    errorLabel.setVisible(true);
                    playersChosenWord = ""; //Reset word to nothing

                    new javax.swing.Timer(3000, evt ->
                    {
                        ((Timer) evt.getSource()).stop();
                        errorLabel.setVisible(false);
                    }).start();
                }

                else
                {
                    if (HomePage.all5LetterEnglishWords.contains(playersChosenWord) == false)
                    {
                        String notEnglishWordMsg = "Error: " + playersChosenWord + " is not an English word.";
                        errorLabel.setText(notEnglishWordMsg);
                        errorLabel.setVisible(true);
                        playersChosenWord = ""; //Reset word to nothing

                        new javax.swing.Timer(3000, evt ->
                        {
                            ((Timer) evt.getSource()).stop();
                            errorLabel.setVisible(false);
                        }).start();
                    }

                    //Both word and name get accepted
                    else
                    {
                        new PlayerSwapPage();
                        dispose();
                    }
                }             
            }
        }
    }



    // Gradient Background Panel
    static class BackgroundPanel extends JPanel
    {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint gp = new GradientPaint(0, 0, new Color(0, 225, 255), 0, getHeight(), new Color(255, 230, 89));
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }



    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(PlayerSwapInfoPage::new);
    }
}