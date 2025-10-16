import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class GameResultsPage extends JFrame
{
    //JComps
    private JButton playAgainButton;



    public GameResultsPage()
    {
        this.setTitle("Game Results");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null); // Center on screen

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(0, 200, 255));
        titlePanel.setBounds(0, 0, 1000, 80);
        titlePanel.setLayout(null);
        this.add(titlePanel);

        JLabel titleLabel = new JLabel("📊 Game Results 📊", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
        titleLabel.setBounds(300, 15, 400, 50);
        titlePanel.add(titleLabel);
        this.add(titlePanel);

        playAgainButton = new JButton("🔄 Play Again");
        playAgainButton.setFont(new Font("SansSerif", Font.BOLD, 28));
        playAgainButton.setBounds(375, 600, 250, 70);
        playAgainButton.addActionListener(new ButtonListener());
        playAgainButton.setBackground(Color.WHITE);
        playAgainButton.setForeground(Color.BLACK);
        playAgainButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        playAgainButton.setFocusPainted(false);
        playAgainButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        playAgainButton.setOpaque(true);

        this.add(playAgainButton);

        playAgainButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                playAgainButton.setBackground(new Color(200, 200, 200));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                playAgainButton.setBackground(new Color(255,255,255));
            }
        });
        


        //Generating the right result pages
        if (PlayerSwapPage.playerSwapEnabled == true)
        {
            showPlayerSwapResultsPage();
        }

        else if ((WordlePage.endlessEnabled == true) || (ReverseWordlePage.endlessReverseEnabled == true))
        {
            showEndlessScreen();
        }

        else if ( (WordlePage.playerVictory == true) || (ReverseWordlePage.playerVictory == true) )
        {
            showWinScreen();
        }

        //False ones go last
        else if ((WordlePage.playerVictory == false) || (ReverseWordlePage.playerVictory == false))
        {
            showLossScreen();
        }

        WordlePage.classicEnabled = false;
        ReverseWordlePage.reverseEnabled = false;
        WordlePage.endlessEnabled = false;
        ReverseWordlePage.endlessReverseEnabled = false;
        PlayerSwapPage.playerSwapEnabled = false;

        WordlePage.currentRound = 1;

        setVisible(true);
    }



    private void showWinScreen()
    {
        getContentPane().setBackground(Color.YELLOW);

        JPanel winPanel = new JPanel();
        winPanel.setLayout(null);
        winPanel.setBounds(0, 80, 1000, 720);
        winPanel.setBackground(Color.YELLOW);

        JLabel winLabel = new JLabel("🎉 You Won! 🥳", SwingConstants.CENTER);
        winLabel.setFont(new Font("SansSerif", Font.BOLD, 60));
        winLabel.setOpaque(true);
        winLabel.setBackground(Color.GREEN);
        winLabel.setBounds(250, 60, 500, 80);
        winPanel.add(winLabel);

        if (WordlePage.classicEnabled == true)
        {
            JLabel scoreLabel = new JLabel(("You guessed the word in " + (WordlePage.attemptsCounter) + " attempts."), SwingConstants.CENTER);
            scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
            scoreLabel.setOpaque(true);
            scoreLabel.setBackground(Color.GREEN);
            scoreLabel.setBounds(150, 180, 700, 70);
            winPanel.add(scoreLabel);
        }

        else if (ReverseWordlePage.reverseEnabled == true)
        {
            JLabel scoreLabel = new JLabel(("You guessed the word in " + (ReverseWordlePage.attemptsCounter) + " attempts."), SwingConstants.CENTER);
            scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
            scoreLabel.setOpaque(true);
            scoreLabel.setBackground(Color.GREEN);
            scoreLabel.setBounds(150, 180, 700, 70);
            winPanel.add(scoreLabel);
        }

        this.add(winPanel);
    }



    private void showEndlessScreen()
    {
        getContentPane().setBackground(Color.YELLOW);

        JPanel winPanel = new JPanel();
        winPanel.setLayout(null);
        winPanel.setBounds(0, 80, 1000, 720);
        winPanel.setBackground(Color.YELLOW);

        if (WordlePage.endlessEnabled == true)
        {
            JLabel winLabel = new JLabel(("The word was " + WordlePage.currentWord + "."), SwingConstants.CENTER);
            winLabel.setFont(new Font("SansSerif", Font.BOLD, 40));
            winLabel.setOpaque(true);
            winLabel.setBackground(Color.GREEN);
            winLabel.setBounds(250, 60, 500, 80);
            winPanel.add(winLabel);

            JLabel scoreLabel = new JLabel(("You made it to Round " + (WordlePage.currentRound) + "! The high score is: " + HomePage.classicHighScore + "."), SwingConstants.CENTER);
            scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
            scoreLabel.setOpaque(true);
            scoreLabel.setBackground(Color.GREEN);
            scoreLabel.setBounds(150, 180, 720, 70);
            winPanel.add(scoreLabel);

            JLabel newHighScoreLabel = new JLabel(("New High Score!"), SwingConstants.CENTER);
            newHighScoreLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
            newHighScoreLabel.setOpaque(true);
            newHighScoreLabel.setBackground(Color.MAGENTA);
            newHighScoreLabel.setBounds(150, 280, 720, 70);
            winPanel.add(newHighScoreLabel);

            newHighScoreLabel.setVisible(HomePage.newHighScoreFlag);
        }

        else if (ReverseWordlePage.endlessReverseEnabled == true)
        {
            JLabel winLabel = new JLabel(("The word was " + ReverseWordlePage.currentWord + "."), SwingConstants.CENTER);
            winLabel.setFont(new Font("SansSerif", Font.BOLD, 60));
            winLabel.setOpaque(true);
            winLabel.setBackground(Color.GREEN);
            winLabel.setBounds(250, 60, 500, 80);
            winPanel.add(winLabel);

            JLabel scoreLabel = new JLabel(("You guessed the word in " + (ReverseWordlePage.currentRound) + "! The high score is: " + HomePage.reverseHighScore + "."), SwingConstants.CENTER);
            scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
            scoreLabel.setOpaque(true);
            scoreLabel.setBackground(Color.GREEN);
            scoreLabel.setBounds(150, 180, 720, 70);
            winPanel.add(scoreLabel);
        }

        this.add(winPanel);
    }


    private void showLossScreen()
    {
        getContentPane().setBackground(Color.BLACK);

        JPanel lossPanel = new JPanel();
        lossPanel.setLayout(null);
        lossPanel.setBounds(0, 80, 1000, 720);
        lossPanel.setBackground(Color.BLACK);

        JLabel lossLabel = new JLabel("💀 You Lost! 😔", SwingConstants.CENTER);
        lossLabel.setFont(new Font("SansSerif", Font.BOLD, 60));
        lossLabel.setOpaque(true);
        lossLabel.setBackground(Color.RED);
        lossLabel.setForeground(Color.WHITE);
        lossLabel.setBounds(250, 60, 500, 80);
        lossPanel.add(lossLabel);

        if (WordlePage.classicEnabled == true)
        {
            JLabel scoreLabel = new JLabel(("The word was: " + WordlePage.currentWord), SwingConstants.CENTER);
            scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
            scoreLabel.setOpaque(true);
            scoreLabel.setBackground(Color.RED);
            scoreLabel.setForeground(Color.WHITE);
            scoreLabel.setBounds(300, 180, 400, 70);
            lossPanel.add(scoreLabel);
        }

        else if (ReverseWordlePage.reverseEnabled == true)
        {
            JLabel scoreLabel = new JLabel(("The word was: " + ReverseWordlePage.currentWord), SwingConstants.CENTER);
            scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
            scoreLabel.setOpaque(true);
            scoreLabel.setBackground(Color.RED);
            scoreLabel.setForeground(Color.WHITE);
            scoreLabel.setBounds(300, 180, 400, 70);
            lossPanel.add(scoreLabel);
        }

        this.add(lossPanel);
    }



    private void showPlayerSwapResultsPage()
    {
        getContentPane().setBackground(Color.YELLOW);

        JPanel winPanel = new JPanel();
        winPanel.setLayout(null);
        winPanel.setBounds(0, 80, 1000, 720);
        winPanel.setBackground(Color.YELLOW);

        JLabel winLabel = new JLabel(("Player " + PlayerSwapInfoPage.playerToSetString + " wins!"), SwingConstants.CENTER);
        winLabel.setFont(new Font("SansSerif", Font.BOLD, 60));
        winLabel.setOpaque(true);
        winLabel.setBackground(Color.GREEN);
        winLabel.setBounds(250, 60, 500, 80);
        winPanel.add(winLabel);

        JLabel scoreLabel = new JLabel(("The word was " + PlayerSwapInfoPage.playersChosenWord + "."), SwingConstants.CENTER);
        scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        scoreLabel.setOpaque(true);
        scoreLabel.setBackground(Color.GREEN);
        scoreLabel.setBounds(150, 180, 700, 70);
        winPanel.add(scoreLabel);

        this.add(winPanel);
    }



    public class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == playAgainButton)
            {
                dispose();
                new HomePage();
            }
        }
    }

    public static void main(String[] args)
    {
        new GameResultsPage();
    }
}