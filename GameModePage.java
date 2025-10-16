import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class GameModePage extends JFrame
{
    //JComps
    private JLabel titleLabel;
    private JButton classicButton, reverseButton, endlessButton, endlessReverseButton, speedBlitzButton, playerSwapButton;
    private JLabel classicDesc, reverseDesc, endlessDesc, endlessReverseDesc, speedBlitzDesc, playerSwapDesc;
    private JButton backButton;
    private JLabel unlockedTagLabel;

    private ImageIcon classicCheckmark, reverseCheckmark, endlessCheckmark, endlessReverseCheckmark;
    private JLabel classicCheckmarkLabel, reverseCheckmarkLabel, endlessCheckmarkLabel, endlessReverseCheckmarkLabel;

    //Non JComp
    public static boolean completedClassicMode, completedReverseMode, completedEndlessMode, completedEndlessReverse = false;

    public static int startingTime = 300;



    public GameModePage()
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

        JLabel titleLabel = new JLabel("Select Your Gamemode!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 36));
        titleLabel.setBounds(250, 15, 550, 50);
        titlePanel.add(titleLabel);

        classicButton = new JButton("😄 Classic Wordle");
        reverseButton = new JButton("🙃 Reversed Wordle");
        endlessButton = new JButton("∞ Endless Wordle");
        endlessReverseButton = new JButton("∞ Endless Reversed Wordle");
        speedBlitzButton = new JButton("⚡ Speed Blitz Wordle");
        playerSwapButton = new JButton("🔁 Player Swap Wordle");


        //Classic Button
        Font buttonFont = new Font("Helvetica", Font.BOLD, 30);
        classicButton.setFont(buttonFont);
        reverseButton.setFont(buttonFont);
        endlessButton.setFont(buttonFont);
        endlessReverseButton.setFont(new Font("Helvetica", Font.BOLD, 24));
        speedBlitzButton.setFont(buttonFont);
        playerSwapButton.setFont(buttonFont);
        

        classicButton.setBackground(new Color(0, 255, 30));
        classicButton.setForeground(Color.BLACK);
        classicButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        classicButton.setFocusPainted(false);
        classicButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        classicButton.setOpaque(true);

        classicButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                classicButton.setBackground(new Color(0, 200, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                classicButton.setBackground(new Color(0, 255, 30));
            }
        });


        //Reverse Button
        reverseButton.setBackground(new Color(255, 242, 64));
        reverseButton.setForeground(Color.BLACK);
        reverseButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reverseButton.setFocusPainted(false);
        reverseButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        reverseButton.setOpaque(true);

        reverseButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                reverseButton.setBackground(new Color(200, 200, 30));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                reverseButton.setBackground(new Color(255, 242, 64));
            }
        });


        //Endless Button
        endlessButton.setBackground(new Color(250, 0, 0));
        endlessButton.setForeground(Color.BLACK);
        endlessButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        endlessButton.setFocusPainted(false);
        endlessButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        endlessButton.setOpaque(true);

        endlessButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                endlessButton.setBackground(new Color(150, 0, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                endlessButton.setBackground(new Color(250, 0, 0));
            }
        });


        //Endless Reverse Button
        endlessReverseButton.setBackground(new Color(0, 0, 0));
        endlessReverseButton.setForeground(Color.WHITE);
        endlessReverseButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        endlessReverseButton.setFocusPainted(false);
        endlessReverseButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        endlessReverseButton.setOpaque(true);

        endlessReverseButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                endlessReverseButton.setBackground(new Color(75, 75, 75));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                endlessReverseButton.setBackground(new Color(0, 0, 0));
            }
        });



        //Time Blitz
        speedBlitzButton.setBackground(new Color(0, 130, 240));
        speedBlitzButton.setForeground(Color.BLACK);
        speedBlitzButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        speedBlitzButton.setFocusPainted(false);
        speedBlitzButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        speedBlitzButton.setOpaque(true);

        speedBlitzButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                speedBlitzButton.setBackground(new Color(0, 80, 180));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                speedBlitzButton.setBackground(new Color(0, 130, 240));
            }
        });



        //Player Swap
        playerSwapButton.setBackground(new Color(250, 80, 170));
        playerSwapButton.setForeground(Color.BLACK);
        playerSwapButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        playerSwapButton.setFocusPainted(false);
        playerSwapButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        playerSwapButton.setOpaque(true);

        playerSwapButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                playerSwapButton.setBackground(new Color(200, 30, 120));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                playerSwapButton.setBackground(new Color(250, 80, 170));
            }
        });



        //ActionListeners
        classicButton.addActionListener(e -> {
            WordlePage.classicEnabled = true;
            new WordlePage();
            dispose();
        });

        reverseButton.addActionListener(e -> {
            ReverseWordlePage.reverseEnabled = true;
            new ReverseWordlePage();
            dispose();
        });

        endlessButton.addActionListener(e -> {
            WordlePage.endlessEnabled = true;
            new WordlePage();
            dispose();
        });

        endlessReverseButton.addActionListener(e -> {
            ReverseWordlePage.endlessReverseEnabled = true;
            new ReverseWordlePage();
            dispose();
        });

        speedBlitzButton.addActionListener(e -> {
            SpeedBlitzPage.speedBlitzEnabled = true;
            new SpeedBlitzPage(startingTime);
            dispose();
        });

        playerSwapButton.addActionListener(e -> {
            PlayerSwapPage.playerSwapEnabled = true;
            new PlayerSwapInfoPage();
            dispose();
        });



        Font descFont = new Font("SansSerif", Font.PLAIN, 20);
        
        classicDesc = new JLabel("<html> Good ol' Classic Wordle featured on the New York Times. Figure out the word in 6 attempts by submitting other words to reveal the locations of the correct letters in the word. <html>", SwingConstants.CENTER);
        classicDesc.setFont(descFont);
        classicDesc.setForeground(Color.BLACK);
        classicDesc.setBackground(new Color(0, 0, 0, 200));
        classicDesc.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        reverseDesc = new JLabel("<html> A custom version of Wordle with a special twist. Figure out the word by filtering out the wrong letters and unscramble the correct ones without knowing the right order. <html>");
        reverseDesc.setFont(descFont);
        reverseDesc.setForeground(Color.BLACK);
        reverseDesc.setBackground(new Color(0, 0, 0, 200));
        reverseDesc.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        endlessDesc = new JLabel("<html> Don't like how you can only play 1 game of Wordle a day on the New York Times website? Play infinite rounds of Wordle here and see how far you get! <br> High Score: " + HomePage.classicHighScore + " rounds. <html>");
        endlessDesc.setFont(descFont);
        endlessDesc.setForeground(Color.BLACK);
        endlessDesc.setBackground(new Color(0, 0, 0, 200));
        endlessDesc.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        endlessReverseDesc = new JLabel("<html> Can't get enough of our special variant of Wordle because it's just that good? Play infinite rounds of Reversed Wordle and see how far you get! <br> High Score: " + HomePage.reverseHighScore + " rounds. <html>");
        endlessReverseDesc.setFont(descFont);
        endlessReverseDesc.setForeground(Color.BLACK);
        endlessReverseDesc.setBackground(new Color(0, 0, 0, 200));
        endlessReverseDesc.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        speedBlitzDesc = new JLabel("<html> Figure out as many words as you can in 5 minutes! Don't be reckless though, as every incorrect guess results in a 5 seconds deduction to your remaining time. Type quickly but carefully! <html>");
        speedBlitzDesc.setFont(descFont);
        speedBlitzDesc.setForeground(Color.BLACK);
        speedBlitzDesc.setBackground(new Color(0, 0, 0, 200));
        speedBlitzDesc.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        playerSwapDesc = new JLabel("<html> A 2 player version of Wordle! Player 1 decides a word for Player 2 to guess, and if they get it right, then Player 2 decides a word for Player 1 to guess. Keep swapping until somebody loses. <html>");
        playerSwapDesc.setFont(descFont);
        playerSwapDesc.setForeground(Color.BLACK);
        playerSwapDesc.setBackground(new Color(0, 0, 0, 200));
        playerSwapDesc.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        /////////////////////////////////////////////////////////////////////////
        
        classicButton.setBounds(100, 105, 350, 75);
        classicDesc.setBounds(75, 110, 430, 300);

        reverseButton.setBounds(560, 105, 350, 75);
        reverseDesc.setBounds(525, 110, 430, 300);

        endlessButton.setBounds(100, 370, 350, 75);
        endlessDesc.setBounds(75, 375, 430, 300);

        endlessReverseButton.setBounds(560, 370, 350, 75);
        endlessReverseDesc.setBounds(525, 375, 430, 300);

        speedBlitzButton.setBounds(100, 635, 350, 75);
        speedBlitzDesc.setBounds(75, 640, 430, 300);

        playerSwapButton.setBounds(560, 635, 350, 75);
        playerSwapDesc.setBounds(525, 640, 430, 300);

        background.add(classicButton);
        background.add(reverseButton);
        background.add(endlessButton);
        background.add(endlessReverseButton);
        background.add(classicDesc);
        background.add(reverseDesc);
        background.add(endlessDesc);
        background.add(endlessReverseDesc);
        background.add(speedBlitzButton);
        background.add(speedBlitzDesc);
        background.add(playerSwapButton);
        background.add(playerSwapDesc);



        //Checkmarks & Stars
        ImageIcon checkmark = loadScaledIcon("Images/Checkmark.jpg", 75, 75);
        JLabel easyCheckmarkLabel = new JLabel(checkmark); JLabel normalCheckmarkLabel = new JLabel(checkmark); JLabel hardCheckmarkLabel = new JLabel(checkmark); JLabel extremeCheckmarkLabel = new JLabel(checkmark);
        easyCheckmarkLabel.setBounds(60, 170, 75, 75); normalCheckmarkLabel.setBounds(500, 170, 75, 75); hardCheckmarkLabel.setBounds(60, 520, 75, 75); extremeCheckmarkLabel.setBounds(500, 520, 75, 75);
        this.add(easyCheckmarkLabel); this.add(normalCheckmarkLabel); this.add(hardCheckmarkLabel); this.add(extremeCheckmarkLabel);
        easyCheckmarkLabel.setVisible(false); normalCheckmarkLabel.setVisible(false); hardCheckmarkLabel.setVisible(false); extremeCheckmarkLabel.setVisible(false);

        if (completedClassicMode == true)
        {
            easyCheckmarkLabel.setVisible(true);
        }

        if (completedReverseMode == true)
        {
            normalCheckmarkLabel.setVisible(true);
        }

        if (completedEndlessMode == true)
        {
            hardCheckmarkLabel.setVisible(true);
        }

    

        unlockedTagLabel = new JLabel("<html> Unlocked after beating" + "<br>" + "the game in Hard Mode" + "<br>" + "with a perfect score. <html>");
        unlockedTagLabel.setFont(new Font("SansSerif", Font.PLAIN, 23));
        unlockedTagLabel.setHorizontalAlignment(SwingConstants.CENTER);
        unlockedTagLabel.setBackground(new Color(0, 0, 0));
        unlockedTagLabel.setForeground(new Color(250, 250, 250));
        unlockedTagLabel.setOpaque(true);
        unlockedTagLabel.setBounds(572, 620, 285, 130);
        background.add(unlockedTagLabel);
        unlockedTagLabel.setVisible(false);

        // extremeDescription.setVisible(false);
        // extremeButton.setEnabled(false);
        // if (perfectedHardMode == true)
        // {
        //     extremeDescription.setVisible(true);
        //     extremeButton.setEnabled(true);
        //     unlockedTagLabel.setVisible(false);
        // }


        
        // Back Button
        backButton = new JButton("Back To Menu");
        backButton.setFont(new Font("Helvetica", Font.BOLD, 25));
        backButton.setBackground(new Color(50, 100, 255));
        backButton.setForeground(Color.WHITE);
        // Position the button below the scroll pane
        int buttonWidth = 300;
        int buttonHeight = 60;
        int buttonX = (getWidth() - buttonWidth) / 2;
        int scrollY = 10 + 10 + 30; // Increased margin below title
        int scrollHeight = 400;
        int buttonY = scrollY + scrollHeight + 40; // Increased margin below scroll pane
        backButton.setBounds(buttonX, buttonY + 400, buttonWidth, buttonHeight);
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



    public static ImageIcon loadScaledIcon(String path, int width, int height)
    {
        ImageIcon icon = new ImageIcon(path);
        Image scaled = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }



    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(GameModePage::new);
    }
}