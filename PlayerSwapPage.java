import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;



public class PlayerSwapPage extends JFrame
{
    //------------ JComps ------------

    //Title & BG
    private JLabel titleLabel;
    public BackgroundPanel background;
    
    //Entering Text
    private JTextField enterText;
    private JButton submitAnswerButton;
    private TextFieldListener tfl1;

    //Hint
    private JButton hintButton;
    private HintButtonListener hbl1;
    private JLabel hintLabel;

    //Restart
    private JButton restartButton;
    private RestartButtonListener rbl;

    //Error
    private JLabel errorLabel;

    //Points
    private JLabel scoreLabel;

    //------------ Non-JComps ------------

    //Strings
    public static String currentWord;
    public String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String hintText;

    //Trackers
    public static int attemptsCounter = 0;
    public static int currentRound = 1;
    public static int highscore;

    //Fonts
    public Font tileFont = new Font("SansSerif", Font.BOLD, 50);
    public Font keyboardFont = new Font("SansSerif", Font.BOLD, 25);

    //Arrays For Letters
    public boolean [] statusArray = new boolean[5];
    public ArrayList <Integer> incorrectLetters = new ArrayList<Integer>();
    public boolean [] partialStatusArray = new boolean[5];
    
    //Individual Letters
    public JLabel qLabel, wLabel, eLabel, rLabel, tLabel, yLabel, uLabel, iLabel, oLabel, pLabel, aLabel, sLabel, dLabel, fLabel, gLabel, hLabel, jLabel, kLabel, lLabel, zLabel, xLabel, cLabel, vLabel, bLabel, nLabel, mLabel;
    public boolean qLock, wLock, eLock, rLock, tLock, yLock, uLock, iLock, oLock, pLock, aLock, sLock, dLock, fLock, gLock, hLock, jLock, kLock, lLock, zLock, xLock, cLock, vLock, bLock, nLock, mLock = false;

    //Other
    int a, x = 250; int b, y = 100; int c = 75;

    public ArrayList <String> previousWords = new ArrayList<String>();

    public static int player1Points, player2Points;
    public static boolean playerSwapEnabled;
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public PlayerSwapPage()
    {
        currentWord = PlayerSwapInfoPage.playersChosenWord;
        System.out.println("The random word is: " + currentWord);

        
        // JFrame Setup
        this.setSize(1000, 1100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        // Background Panel Setup
        background = new BackgroundPanel();
        background.setLayout(null); // Use null layout for absolute positioning
        this.setContentPane(background);

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(150, 50, 250));
        titlePanel.setBounds(0, 0, 1000, 80);
        titlePanel.setLayout(null);
        this.add(titlePanel);

        titleLabel = new JLabel("What Word Is This?", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 36));
        titleLabel.setBounds(250, 15, 550, 50);
        titlePanel.add(titleLabel);


        
        submitAnswerButton = new JButton("Submit Answer");
        submitAnswerButton.setFont(new Font("Helvetica", Font.BOLD, 30));
        submitAnswerButton.setBackground(new Color(0, 255, 30));
        submitAnswerButton.setForeground(Color.BLACK);
        submitAnswerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitAnswerButton.setFocusPainted(false);
        submitAnswerButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        submitAnswerButton.setOpaque(true);
        submitAnswerButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                submitAnswerButton.setBackground(new Color(0, 200, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                submitAnswerButton.setBackground(new Color(0, 255, 30));
            }
        });

        tfl1 = new TextFieldListener();
        submitAnswerButton.addActionListener(tfl1);

        submitAnswerButton.setBounds(515, 700, 250, 60);
        background.add(submitAnswerButton);



        enterText = new JTextField();
        enterText.setBounds(215, 700, 250, 60);
        enterText.setFont(new Font("Helvetica", Font.BOLD, 30));
        background.add(enterText);



        hintButton = new JButton("Free Hint!");
        hintButton.setFont(new Font("Helvetica", Font.BOLD, 30));
        hintButton.setBackground(new Color(255, 135, 245));
        hintButton.setForeground(Color.BLACK);
        hintButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        hintButton.setFocusPainted(false);
        hintButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        hintButton.setOpaque(true);
        hintButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                hintButton.setBackground(new Color(200, 70, 200));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hintButton.setBackground(new Color(255, 135, 245));
            }
        });

        hbl1 = new HintButtonListener();
        hintButton.addActionListener(hbl1);

        hintButton.setBounds(100, 785, 250, 70);
        background.add(hintButton);



        //Hint Label
        hintLabel = new JLabel("", SwingConstants.CENTER);
        hintLabel.setFont(new Font("Helvetica", Font.BOLD, 22));
        hintLabel.setOpaque(true);
        hintLabel.setPreferredSize(new Dimension(180, 70));
        hintLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        hintLabel.setBounds(100, 870, 250, 70);
        hintLabel.setBackground(Color.WHITE);
        hintLabel.setForeground(Color.BLACK);
        background.add(hintLabel);



        // Restart Button
        restartButton = new JButton("Back"); //🔄
        restartButton.setFont(new Font("Helvetica", Font.BOLD, 25));
        restartButton.setBounds(775, 115, 160, 40);
        restartButton.setBackground(new Color(255, 90, 0));
        restartButton.setForeground(Color.BLACK);
        restartButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        restartButton.setFocusPainted(false);
        restartButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        restartButton.setOpaque(true);
        rbl = new RestartButtonListener();
        restartButton.addActionListener(rbl);

        restartButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                restartButton.setBackground(new Color(200, 100, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                restartButton.setBackground(new Color(250, 100, 0));
            }
        });

        this.add(restartButton);



        errorLabel = new JLabel("", SwingConstants.CENTER);
        errorLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        errorLabel.setOpaque(true);
        errorLabel.setPreferredSize(new Dimension(180, 70));
        errorLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        errorLabel.setBounds(40, 980, 920, 70);
        errorLabel.setBackground(Color.RED);
        errorLabel.setForeground(Color.BLACK);
        background.add(errorLabel);
        errorLabel.setVisible(false); //By default, dont show it



        //Showing Player's Points
        scoreLabel = new JLabel(("Score: " + player1Points + "-" + player2Points), SwingConstants.CENTER);
        scoreLabel.setBounds(45, 115, 160, 40);
        scoreLabel.setFont(new Font("Helvetica", Font.BOLD, 22));
        scoreLabel.setOpaque(true);
        scoreLabel.setPreferredSize(new Dimension(180, 70));
        scoreLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        scoreLabel.setBackground(Color.WHITE);
        scoreLabel.setForeground(Color.BLACK);
        background.add(scoreLabel);


        makeKeyboard();
        
        
    } //End of Constructor



    //ActionListener for JTextField
    public class TextFieldListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //Reset Array values so that you don't get different letters to be correct as long as they're in the same position
            statusArray[0] = false; statusArray[1] = false; statusArray[2] = false; statusArray[3] = false; statusArray[4] = false;
            partialStatusArray[0] = false; partialStatusArray[1] = false; partialStatusArray[2] = false; partialStatusArray[3] = false; partialStatusArray[4] = false;

            if (attemptsCounter == 5)
            {
                //Lock JComponents once all 6 attempts have been used
                enterText.setEnabled(false);
                submitAnswerButton.setEnabled(false);

                new javax.swing.Timer(1500, evt ->
                {
                    ((Timer) evt.getSource()).stop();

                    if ((statusArray[0] == true) && (statusArray[1] == true) && (statusArray[2] == true) && (statusArray[3] == true) && (statusArray[4] == true))
                    {
                        //
                    }
                    
                    else
                    {
                        //GameResults page is only generated if someone LOSES by getting all 5 attempts wrong, otherwise keep generating more games (that's why Cntl+F this brings only 1 result)
                        new GameResultsPage();

                        //Resetting Points
                        player1Points = 0;
                        player2Points = 0;

                        submitAnswerButton.setEnabled(false);
                        hintButton.setEnabled(false);

                        //Attempts Reset
                        attemptsCounter = 0;
                        dispose();
                    }

                }).start();
            }

            String guessedWordOld = enterText.getText();
            String guessedWord = guessedWordOld.toUpperCase();
            enterText.setText(""); //Clear the text box after every attempt

            //Inputted word must be only 5 letters long
            if (guessedWord.length() != 5)
            {
                String not5CharactersLongMsg = "Error: Word is not 5 letters long.";
                errorLabel.setText(not5CharactersLongMsg);
                errorLabel.setVisible(true);

                new javax.swing.Timer(3000, evt ->
                {
                    ((Timer) evt.getSource()).stop();
                    errorLabel.setVisible(false);
                }).start();
            }

            else
            {
                if (validateWord(guessedWord) == false)
                {
                    String nonLettersDetectedMsg = "Error: Word contains non-letter characters.";
                    errorLabel.setText(nonLettersDetectedMsg);
                    errorLabel.setVisible(true);

                    new javax.swing.Timer(3000, evt ->
                    {
                        ((Timer) evt.getSource()).stop();
                        errorLabel.setVisible(false);
                    }).start();
                }

                //After the inputted word has passed all these tests, then actually accept the word
                else
                {
                    if (HomePage.all5LetterEnglishWords.contains(guessedWord) == false)
                    {
                        String notEnglishWordMsg = "Error: Text inputted is not an English word.";
                        errorLabel.setText(notEnglishWordMsg);
                        errorLabel.setVisible(true);

                        new javax.swing.Timer(3000, evt ->
                        {
                            ((Timer) evt.getSource()).stop();
                            errorLabel.setVisible(false);
                        }).start();
                    }

                    else
                    {
                        if (previousWords.contains(guessedWord))
                        {
                            String previouslyUsedWordMsg = "Error: You already used the word " + guessedWord + " before, please enter a new word.";
                            errorLabel.setText(previouslyUsedWordMsg);
                            errorLabel.setVisible(true);

                            new javax.swing.Timer(3000, evt ->
                            {
                                ((Timer) evt.getSource()).stop();
                                errorLabel.setVisible(false);
                            }).start();
                        }

                        else
                        {
                            //Need to check the word's correctness before I make the letter panels, since the tile colors depend on the answer's correctness
                            checkWordCorrectness(guessedWord);
                            makeLetterPanels(guessedWord);
                            attemptsCounter++; //Increment attemptsCounter

                            //Adding Word to Arraylist of previously used words
                            previousWords.add(guessedWord);
                        }
                    }
                }
            }
        }
    }



    public void checkWordCorrectness(String playersWord)
    {
        //Checking Yellows
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                char playersWordCharTracker = playersWord.charAt(j);
                String playersWordCharTrackerStr = String.valueOf(playersWordCharTracker).toUpperCase(); //P in PANTS

                char currentWordCharTracker = currentWord.charAt(i);
                String currentWordCharTrackerStr = String.valueOf(currentWordCharTracker).toUpperCase(); //B in BLAST

                if (playersWordCharTrackerStr.equals(currentWordCharTrackerStr))
                {
                    partialStatusArray[j] = true; //This needs to be J not I, since you could have 2 partial letters in a row (yellow) but then the I value is still the same, PSA[i] where i=0 -> PSA[0] = true and then PSA[0] = true again which doesn't result in any color change
                }
            }
        }

        //Checking Greens
        for (int i = 0; i < 5; i++)
        {
            //Tracking each of the characters for both the player's word and the actual correct word
            char playersWordCharTracker = playersWord.charAt(i);
            String playersWordCharTrackerStr = String.valueOf(playersWordCharTracker).toUpperCase();

            char currentWordCharTracker = currentWord.charAt(i);
            String currentWordCharTrackerStr = String.valueOf(currentWordCharTracker).toUpperCase();

            if (playersWordCharTrackerStr.equals(currentWordCharTrackerStr))
            {
                statusArray[i] = true;
            }

            else //Need this here to set the values back to false if the user enters a word with wrong letters
            {
                statusArray[i] = false;
            }
        }

        //If the player guessed the word correctly
        if ((statusArray[0] == true) && (statusArray[1] == true) && (statusArray[2] == true) && (statusArray[3] == true) && (statusArray[4] == true))
        {
            submitAnswerButton.setEnabled(false);
            hintButton.setEnabled(false);

            new javax.swing.Timer(1500, evt ->
            {
                ((Timer) evt.getSource()).stop();

                //If it was player 1's turn right now
                if (HomePage.player1Turn == true)
                {
                    player1Points++; //Reward points
                    //let player 2 decide the word this time, then create a new game
                    HomePage.player1Turn = false;
                }

                //Else if it was player 2's turn right now
                else if (HomePage.player1Turn == false)
                {
                    player2Points++;
                    HomePage.player1Turn = true;
                }

                //Attempts Reset
                attemptsCounter = 0;

                //Create new game
                new PlayerSwapInfoPage();
                dispose();

            }).start();
        }

        //Update Score Label
        scoreLabel.setText("Score: " + player1Points + "-" + player2Points);
    }



    public class HintButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == hintButton)
            {
                //Get the correct letters the user currently has
                for (int i = 0; i < 5; i++)
                {
                    if (statusArray[i] == false)
                    {
                        incorrectLetters.add(i); //Keep just the INDEX positions of all the INCORRECT answers, I need to know WHICH LETTER POSITIONS they user needs as a hint right now (Ex: 1, 2, 5)
                    }
                }

                int randomNumber = (int) (Math.random() * incorrectLetters.size()); //Pick a random number out of the pool (1, 2, 5), so this will generate a random number from 1-3, and then retrieve the actual number at that INDEX
                int pickedNumber = incorrectLetters.get(randomNumber);

                String answer = currentWord;
                char hintCharOld = answer.charAt(pickedNumber);
                String hintChar = String.valueOf(hintCharOld);

                String prefix = "";
                if (pickedNumber + 1 == 1) { prefix = "first"; }
                if (pickedNumber + 1 == 2) { prefix = "second"; }
                if (pickedNumber + 1 == 3) { prefix = "third"; }
                if (pickedNumber + 1 == 4) { prefix = "fourth"; }
                if (pickedNumber + 1 == 5) { prefix = "fifth"; }
                hintText = "The " + prefix + " letter is " + hintChar + ".";
                hintLabel.setText(hintText);

                hintButton.setEnabled(false); //Lock the button since they only got 1 hint
            }
        }
    }



    public void makeLetterPanels(String text)
    {
        JLabel [] tilesArray = new JLabel [5]; //Array to hold all 30 JLabels
        int x = 250; //Need to re-initialize this one so that the x-value gets restarted per row, since it needs to revert to 250 every column
        
        for (int j = 0; j<5; j++)
        {
            tilesArray[j] = new JLabel(String.valueOf((text.charAt(j))), SwingConstants.CENTER);
            tilesArray[j].setFont(tileFont);
            tilesArray[j].setOpaque(true);
            tilesArray[j].setPreferredSize(new Dimension(60, 60));
            tilesArray[j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            tilesArray[j].setBounds(x, y, c, c);
            tilesArray[j].setBackground(Color.WHITE);
            tilesArray[j].setForeground(Color.BLACK);

            //Check if letters are partially correct - YELLOW
            if (partialStatusArray[j] == true)
            {
                tilesArray[j].setBackground(Color.YELLOW);

                if (((text.charAt(j)) == 'Q') && (qLock == false)) { qLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'W') && (wLock == false)) { wLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'E') && (eLock == false)) { eLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'R') && (rLock == false)) { rLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'T') && (tLock == false)) { tLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'Y') && (yLock == false)) { yLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'U') && (uLock == false)) { uLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'I') && (iLock == false)) { iLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'O') && (oLock == false)) { oLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'P') && (pLock == false)) { pLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'A') && (aLock == false)) { aLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'S') && (sLock == false)) { sLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'D') && (dLock == false)) { dLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'F') && (fLock == false)) { fLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'G') && (gLock == false)) { gLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'H') && (hLock == false)) { hLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'J') && (jLock == false)) { jLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'K') && (kLock == false)) { kLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'L') && (lLock == false)) { lLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'Z') && (zLock == false)) { zLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'X') && (xLock == false)) { xLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'C') && (cLock == false)) { cLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'V') && (vLock == false)) { vLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'B') && (bLock == false)) { bLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'N') && (nLock == false)) { nLabel.setBackground(Color.YELLOW); }
                if (((text.charAt(j)) == 'M') && (mLock == false)) { mLabel.setBackground(Color.YELLOW); }
            }

            //Check if letters are correct - GREEN
            if (statusArray[j] == true)
            {
                tilesArray[j].setBackground(Color.GREEN);

                if ((text.charAt(j)) == 'Q') { qLabel.setBackground(Color.GREEN); qLock = true;}
                if ((text.charAt(j)) == 'W') { wLabel.setBackground(Color.GREEN); wLock = true;}
                if ((text.charAt(j)) == 'E') { eLabel.setBackground(Color.GREEN); eLock = true;}
                if ((text.charAt(j)) == 'R') { rLabel.setBackground(Color.GREEN); rLock = true;}
                if ((text.charAt(j)) == 'T') { tLabel.setBackground(Color.GREEN); tLock = true;}
                if ((text.charAt(j)) == 'Y') { yLabel.setBackground(Color.GREEN); yLock = true;}
                if ((text.charAt(j)) == 'U') { uLabel.setBackground(Color.GREEN); uLock = true;}
                if ((text.charAt(j)) == 'I') { iLabel.setBackground(Color.GREEN); iLock = true;}
                if ((text.charAt(j)) == 'O') { oLabel.setBackground(Color.GREEN); oLock = true;}
                if ((text.charAt(j)) == 'P') { pLabel.setBackground(Color.GREEN); pLock = true;}
                if ((text.charAt(j)) == 'A') { aLabel.setBackground(Color.GREEN); aLock = true;}
                if ((text.charAt(j)) == 'S') { sLabel.setBackground(Color.GREEN); sLock = true;}
                if ((text.charAt(j)) == 'D') { dLabel.setBackground(Color.GREEN); dLock = true;}
                if ((text.charAt(j)) == 'F') { fLabel.setBackground(Color.GREEN); fLock = true;}
                if ((text.charAt(j)) == 'G') { gLabel.setBackground(Color.GREEN); gLock = true;}
                if ((text.charAt(j)) == 'H') { hLabel.setBackground(Color.GREEN); hLock = true;}
                if ((text.charAt(j)) == 'J') { jLabel.setBackground(Color.GREEN); jLock = true;}
                if ((text.charAt(j)) == 'K') { kLabel.setBackground(Color.GREEN); kLock = true;}
                if ((text.charAt(j)) == 'L') { lLabel.setBackground(Color.GREEN); lLock = true;}
                if ((text.charAt(j)) == 'Z') { zLabel.setBackground(Color.GREEN); zLock = true;}
                if ((text.charAt(j)) == 'X') { xLabel.setBackground(Color.GREEN); xLock = true;}
                if ((text.charAt(j)) == 'C') { cLabel.setBackground(Color.GREEN); cLock = true;}
                if ((text.charAt(j)) == 'V') { vLabel.setBackground(Color.GREEN); vLock = true;}
                if ((text.charAt(j)) == 'B') { bLabel.setBackground(Color.GREEN); bLock = true;}
                if ((text.charAt(j)) == 'N') { nLabel.setBackground(Color.GREEN); nLock = true;}
                if ((text.charAt(j)) == 'M') { mLabel.setBackground(Color.GREEN); mLock = true;}
            }

            if ((statusArray[j] == false) && (partialStatusArray[j] == false))
            {
                if ((text.charAt(j)) == 'Q') { qLabel.setBackground(Color.GRAY); qLock = true;}
                if ((text.charAt(j)) == 'W') { wLabel.setBackground(Color.GRAY); wLock = true;}
                if ((text.charAt(j)) == 'E') { eLabel.setBackground(Color.GRAY); eLock = true;}
                if ((text.charAt(j)) == 'R') { rLabel.setBackground(Color.GRAY); rLock = true;}
                if ((text.charAt(j)) == 'T') { tLabel.setBackground(Color.GRAY); tLock = true;}
                if ((text.charAt(j)) == 'Y') { yLabel.setBackground(Color.GRAY); yLock = true;}
                if ((text.charAt(j)) == 'U') { uLabel.setBackground(Color.GRAY); uLock = true;}
                if ((text.charAt(j)) == 'I') { iLabel.setBackground(Color.GRAY); iLock = true;}
                if ((text.charAt(j)) == 'O') { oLabel.setBackground(Color.GRAY); oLock = true;}
                if ((text.charAt(j)) == 'P') { pLabel.setBackground(Color.GRAY); pLock = true;}
                if ((text.charAt(j)) == 'A') { aLabel.setBackground(Color.GRAY); aLock = true;}
                if ((text.charAt(j)) == 'S') { sLabel.setBackground(Color.GRAY); sLock = true;}
                if ((text.charAt(j)) == 'D') { dLabel.setBackground(Color.GRAY); dLock = true;}
                if ((text.charAt(j)) == 'F') { fLabel.setBackground(Color.GRAY); fLock = true;}
                if ((text.charAt(j)) == 'G') { gLabel.setBackground(Color.GRAY); gLock = true;}
                if ((text.charAt(j)) == 'H') { hLabel.setBackground(Color.GRAY); hLock = true;}
                if ((text.charAt(j)) == 'J') { jLabel.setBackground(Color.GRAY); jLock = true;}
                if ((text.charAt(j)) == 'K') { kLabel.setBackground(Color.GRAY); kLock = true;}
                if ((text.charAt(j)) == 'L') { lLabel.setBackground(Color.GRAY); lLock = true;}
                if ((text.charAt(j)) == 'Z') { zLabel.setBackground(Color.GRAY); zLock = true;}
                if ((text.charAt(j)) == 'X') { xLabel.setBackground(Color.GRAY); xLock = true;}
                if ((text.charAt(j)) == 'C') { cLabel.setBackground(Color.GRAY); cLock = true;}
                if ((text.charAt(j)) == 'V') { vLabel.setBackground(Color.GRAY); vLock = true;}
                if ((text.charAt(j)) == 'B') { bLabel.setBackground(Color.GRAY); bLock = true;}
                if ((text.charAt(j)) == 'N') { nLabel.setBackground(Color.GRAY); nLock = true;}
                if ((text.charAt(j)) == 'M') { mLabel.setBackground(Color.GRAY); mLock = true;}
            }

            background.add(tilesArray[j]);
            x += 100;

        } //End of For Loop

        background.repaint();
        y += 100;
    }


    
    public void makeKeyboard()
    {
        int firstX = 410; int newfirstX = 438; int new2firstX = 438; int firstY = 785;

        qLabel = new JLabel("Q", SwingConstants.CENTER);
        qLabel.setFont(keyboardFont);
        qLabel.setOpaque(true);
        qLabel.setPreferredSize(new Dimension(45, 45));
        qLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        qLabel.setBounds(firstX, firstY, 45, 45);
        qLabel.setBackground(Color.WHITE);
        qLabel.setForeground(Color.BLACK);
        background.add(qLabel);

        wLabel = new JLabel("W", SwingConstants.CENTER);
        wLabel.setFont(keyboardFont);
        wLabel.setOpaque(true);
        wLabel.setPreferredSize(new Dimension(45, 45));
        wLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        wLabel.setBounds(firstX += 55, firstY, 45, 45);
        wLabel.setBackground(Color.WHITE);
        wLabel.setForeground(Color.BLACK);
        background.add(wLabel);

        eLabel = new JLabel("E", SwingConstants.CENTER);
        eLabel.setFont(keyboardFont);
        eLabel.setOpaque(true);
        eLabel.setPreferredSize(new Dimension(45, 45));
        eLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        eLabel.setBounds(firstX += 55, firstY, 45, 45);
        eLabel.setBackground(Color.WHITE);
        eLabel.setForeground(Color.BLACK);
        background.add(eLabel);

        rLabel = new JLabel("R", SwingConstants.CENTER);
        rLabel.setFont(keyboardFont);
        rLabel.setOpaque(true);
        rLabel.setPreferredSize(new Dimension(45, 45));
        rLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        rLabel.setBounds(firstX += 55, firstY, 45, 45);
        rLabel.setBackground(Color.WHITE);
        rLabel.setForeground(Color.BLACK);
        background.add(rLabel);

        tLabel = new JLabel("T", SwingConstants.CENTER);
        tLabel.setFont(keyboardFont);
        tLabel.setOpaque(true);
        tLabel.setPreferredSize(new Dimension(45, 45));
        tLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        tLabel.setBounds(firstX += 55, firstY, 45, 45);
        tLabel.setBackground(Color.WHITE);
        tLabel.setForeground(Color.BLACK);
        background.add(tLabel);

        yLabel = new JLabel("Y", SwingConstants.CENTER);
        yLabel.setFont(keyboardFont);
        yLabel.setOpaque(true);
        yLabel.setPreferredSize(new Dimension(45, 45));
        yLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        yLabel.setBounds(firstX += 55, firstY, 45, 45);
        yLabel.setBackground(Color.WHITE);
        yLabel.setForeground(Color.BLACK);
        background.add(yLabel);

        uLabel = new JLabel("U", SwingConstants.CENTER);
        uLabel.setFont(keyboardFont);
        uLabel.setOpaque(true);
        uLabel.setPreferredSize(new Dimension(45, 45));
        uLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        uLabel.setBounds(firstX += 55, firstY, 45, 45);
        uLabel.setBackground(Color.WHITE);
        uLabel.setForeground(Color.BLACK);
        background.add(uLabel);

        iLabel = new JLabel("I", SwingConstants.CENTER);
        iLabel.setFont(keyboardFont);
        iLabel.setOpaque(true);
        iLabel.setPreferredSize(new Dimension(45, 45));
        iLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        iLabel.setBounds(firstX += 55, firstY, 45, 45);
        iLabel.setBackground(Color.WHITE);
        iLabel.setForeground(Color.BLACK);
        background.add(iLabel);
        
        oLabel = new JLabel("O", SwingConstants.CENTER);
        oLabel.setFont(keyboardFont);
        oLabel.setOpaque(true);
        oLabel.setPreferredSize(new Dimension(45, 45));
        oLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        oLabel.setBounds(firstX += 55, firstY, 45, 45);
        oLabel.setBackground(Color.WHITE);
        oLabel.setForeground(Color.BLACK);
        background.add(oLabel);

        pLabel = new JLabel("P", SwingConstants.CENTER);
        pLabel.setFont(keyboardFont);
        pLabel.setOpaque(true);
        pLabel.setPreferredSize(new Dimension(45, 45));
        pLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        pLabel.setBounds(firstX += 55, firstY, 45, 45);
        pLabel.setBackground(Color.WHITE);
        pLabel.setForeground(Color.BLACK);
        background.add(pLabel);

        //////////////////////////////// 2nd Row ////////////////////////////////////

        aLabel = new JLabel("A", SwingConstants.CENTER);
        aLabel.setFont(keyboardFont);
        aLabel.setOpaque(true);
        aLabel.setPreferredSize(new Dimension(45, 45));
        aLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        aLabel.setBounds(newfirstX, firstY+=55, 45, 45);
        aLabel.setBackground(Color.WHITE);
        aLabel.setForeground(Color.BLACK);
        background.add(aLabel);

        sLabel = new JLabel("S", SwingConstants.CENTER);
        sLabel.setFont(keyboardFont);
        sLabel.setOpaque(true);
        sLabel.setPreferredSize(new Dimension(45, 45));
        sLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        sLabel.setBounds(newfirstX += 55, firstY, 45, 45);
        sLabel.setBackground(Color.WHITE);
        sLabel.setForeground(Color.BLACK);
        background.add(sLabel);

        dLabel = new JLabel("D", SwingConstants.CENTER);
        dLabel.setFont(keyboardFont);
        dLabel.setOpaque(true);
        dLabel.setPreferredSize(new Dimension(45, 45));
        dLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        dLabel.setBounds(newfirstX += 55, firstY, 45, 45);
        dLabel.setBackground(Color.WHITE);
        dLabel.setForeground(Color.BLACK);
        background.add(dLabel);

        fLabel = new JLabel("F", SwingConstants.CENTER);
        fLabel.setFont(keyboardFont);
        fLabel.setOpaque(true);
        fLabel.setPreferredSize(new Dimension(45, 45));
        fLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fLabel.setBounds(newfirstX += 55, firstY, 45, 45);
        fLabel.setBackground(Color.WHITE);
        fLabel.setForeground(Color.BLACK);
        background.add(fLabel);

        gLabel = new JLabel("G", SwingConstants.CENTER);
        gLabel.setFont(keyboardFont);
        gLabel.setOpaque(true);
        gLabel.setPreferredSize(new Dimension(45, 45));
        gLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        gLabel.setBounds(newfirstX += 55, firstY, 45, 45);
        gLabel.setBackground(Color.WHITE);
        gLabel.setForeground(Color.BLACK);
        background.add(gLabel);

        hLabel = new JLabel("H", SwingConstants.CENTER);
        hLabel.setFont(keyboardFont);
        hLabel.setOpaque(true);
        hLabel.setPreferredSize(new Dimension(45, 45));
        hLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        hLabel.setBounds(newfirstX += 55, firstY, 45, 45);
        hLabel.setBackground(Color.WHITE);
        hLabel.setForeground(Color.BLACK);
        background.add(hLabel);

        jLabel = new JLabel("J", SwingConstants.CENTER);
        jLabel.setFont(keyboardFont);
        jLabel.setOpaque(true);
        jLabel.setPreferredSize(new Dimension(45, 45));
        jLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        jLabel.setBounds(newfirstX += 55, firstY, 45, 45);
        jLabel.setBackground(Color.WHITE);
        jLabel.setForeground(Color.BLACK);
        background.add(jLabel);

        kLabel = new JLabel("K", SwingConstants.CENTER);
        kLabel.setFont(keyboardFont);
        kLabel.setOpaque(true);
        kLabel.setPreferredSize(new Dimension(45, 45));
        kLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        kLabel.setBounds(newfirstX += 55, firstY, 45, 45);
        kLabel.setBackground(Color.WHITE);
        kLabel.setForeground(Color.BLACK);
        background.add(kLabel);

        lLabel = new JLabel("L", SwingConstants.CENTER);
        lLabel.setFont(keyboardFont);
        lLabel.setOpaque(true);
        lLabel.setPreferredSize(new Dimension(45, 45));
        lLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        lLabel.setBounds(newfirstX += 55, firstY, 45, 45);
        lLabel.setBackground(Color.WHITE);
        lLabel.setForeground(Color.BLACK);
        background.add(lLabel);

        //////////////////////////////// 3rd Row ////////////////////////////////////
        
        zLabel = new JLabel("Z", SwingConstants.CENTER);
        zLabel.setFont(keyboardFont);
        zLabel.setOpaque(true);
        zLabel.setPreferredSize(new Dimension(45, 45));
        zLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        zLabel.setBounds(new2firstX += 55, firstY+=55, 45, 45);
        zLabel.setBackground(Color.WHITE);
        zLabel.setForeground(Color.BLACK);
        background.add(zLabel);

        xLabel = new JLabel("X", SwingConstants.CENTER);
        xLabel.setFont(keyboardFont);
        xLabel.setOpaque(true);
        xLabel.setPreferredSize(new Dimension(45, 45));
        xLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        xLabel.setBounds(new2firstX += 55, firstY, 45, 45);
        xLabel.setBackground(Color.WHITE);
        xLabel.setForeground(Color.BLACK);
        background.add(xLabel);

        cLabel = new JLabel("C", SwingConstants.CENTER);
        cLabel.setFont(keyboardFont);
        cLabel.setOpaque(true);
        cLabel.setPreferredSize(new Dimension(45, 45));
        cLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cLabel.setBounds(new2firstX += 55, firstY, 45, 45);
        cLabel.setBackground(Color.WHITE);
        cLabel.setForeground(Color.BLACK);
        background.add(cLabel);

        vLabel = new JLabel("V", SwingConstants.CENTER);
        vLabel.setFont(keyboardFont);
        vLabel.setOpaque(true);
        vLabel.setPreferredSize(new Dimension(45, 45));
        vLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        vLabel.setBounds(new2firstX += 55, firstY, 45, 45);
        vLabel.setBackground(Color.WHITE);
        vLabel.setForeground(Color.BLACK);
        background.add(vLabel);

        bLabel = new JLabel("B", SwingConstants.CENTER);
        bLabel.setFont(keyboardFont);
        bLabel.setOpaque(true);
        bLabel.setPreferredSize(new Dimension(45, 45));
        bLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        bLabel.setBounds(new2firstX += 55, firstY, 45, 45);
        bLabel.setBackground(Color.WHITE);
        bLabel.setForeground(Color.BLACK);
        background.add(bLabel);

        nLabel = new JLabel("N", SwingConstants.CENTER);
        nLabel.setFont(keyboardFont);
        nLabel.setOpaque(true);
        nLabel.setPreferredSize(new Dimension(45, 45));
        nLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        nLabel.setBounds(new2firstX += 55, firstY, 45, 45);
        nLabel.setBackground(Color.WHITE);
        nLabel.setForeground(Color.BLACK);
        background.add(nLabel);

        mLabel = new JLabel("M", SwingConstants.CENTER);
        mLabel.setFont(keyboardFont);
        mLabel.setOpaque(true);
        mLabel.setPreferredSize(new Dimension(45, 45));
        mLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        mLabel.setBounds(new2firstX += 55, firstY, 45, 45);
        mLabel.setBackground(Color.WHITE);
        mLabel.setForeground(Color.BLACK);
        background.add(mLabel);
    }



    public void makeEmptyTiles()
    {
        JLabel [] tilesArray = new JLabel [30]; //Array to hold all 30 JLabels
        int a = 250;
        int letterTracker = 0;
        int columnTracker = 0; //increments every time this method is called
        
        for (int j = 0; j<5; j++)
        {
            tilesArray[j] = new JLabel();
            tilesArray[j].setFont(tileFont);
            tilesArray[j].setOpaque(true);
            //tilesArray[j].setBackground();
            tilesArray[j].setPreferredSize(new Dimension(60, 60));
            tilesArray[j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            tilesArray[j].setBounds(a, b, c, c);
            background.add(tilesArray[j]);
            a += 100;
            letterTracker++;
        }

        background.repaint();
        b += 100;
    }



    public boolean validateWord(String someWord)
    {
        boolean acceptableWord = true; //Bruh I need to initialize acceptableWord to true inside the method and not the class because if this line is in the class, then it only gets set to true ONCE at the beginning, and the moment it gets set to false, it never comes back to true, which is why I need to re-initialize it every time I call this method

        for (int i = 0; i < 5; i++)
        {
            char currentChar = someWord.charAt(i);
            String convertedCurrentChar = (String.valueOf(currentChar)).toUpperCase(); //Converting from char to String, and then making it all lowercase

            if (alphabet.contains(convertedCurrentChar) == false) //If there is a non-letter character detected, discard
            {
                acceptableWord = false;
                //System.out.println("Issue character: " + convertedCurrentChar + ".");
                break;
            }
        }

        return acceptableWord;
    }



    public class RestartButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == restartButton)
            {
                //Resetting Points
                player1Points = 0;
                player2Points = 0;

                //Reset Timer
                playerSwapEnabled = false;

                new GameModePage();
                dispose();
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
}