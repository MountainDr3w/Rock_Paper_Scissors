import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    //Add random
    Random rand = new Random();


    //Button Panel
    JPanel choicePanel;

    //Stats Panel
    JPanel statsPanel;
    int playerWins = 0;
    int computerWins = 0;
    int ties = 0;
    JTextField playerWinsCount = new JTextField(Integer.toString(playerWins));
    JTextField computerWinsCount = new JTextField(Integer.toString(computerWins));
    JTextField tiesCount = new JTextField(Integer.toString(ties));

    //Results Panel
    JPanel resultsPanel;
    JTextArea displayResults;

    //Quit button
    JPanel quitPanel;




    //Constructor
    public RockPaperScissorsFrame() {
        setTitle("Rock Paper Scissors Game");

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = (int) (screenSize.height * .60);
        int screenWidth = screenSize.width;

        // center frame in screen
        setSize((screenWidth)/ 2, screenHeight);
        setLocation(screenWidth / 4, screenHeight / 4);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createChoicePanel();
        createStatsPanel();
        createResultsPanel();
        createQuit();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //Add rest of the panels here

        mainPanel.add(choicePanel, BorderLayout.NORTH);
        mainPanel.add(statsPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(resultsPanel);
        bottomPanel.add(quitPanel);

        mainPanel.add(bottomPanel,BorderLayout.SOUTH);

        add(mainPanel);
    }

    /*
     - Title -

    JPanel with 4 buttons
    Button Rock with icon
    Button Paper with icon
    Button Scissors with icon
    Button quit
     */
    public void createChoicePanel(){
        choicePanel = new JPanel();
        choicePanel.setBackground(new Color(115, 36, 36));
        choicePanel.setLayout(new GridLayout(2,1));
        JLabel titleLabel = new JLabel("- Rock, Paper, Scissors! -");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 52));
        titleLabel.setForeground(new Color(0,0,0));
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);


        ImageIcon rock = new ImageIcon("src/Rock.png");
        Image rockImage = rock.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH);
        rock =  new ImageIcon(rockImage);
        ImageIcon paper = new ImageIcon("src/paper-sheet-png-paper-sheet-png-image-png-image-2848.png");
        Image paperImage = paper.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH);
        paper = new ImageIcon(paperImage);
        ImageIcon scissors = new ImageIcon("src/R.png");
        Image scissorsImage = scissors.getImage().getScaledInstance(200,150,Image.SCALE_SMOOTH);
        scissors = new ImageIcon(scissorsImage);

        JPanel buttonsPnl = new JPanel();
        buttonsPnl.setBackground(new Color(115, 36, 36));
        buttonsPnl.setLayout(new GridLayout(1,3, 10, 0));

        JButton rockBtn = new JButton(rock);
        rockBtn.setFocusPainted(false);
        rockBtn.setBackground(new Color(115, 36, 36));
        JButton paperBtn = new JButton(paper);
        paperBtn.setBackground(new Color(115, 36, 36));
        paperBtn.setFocusPainted(false);
        JButton scissorsBtn = new JButton(scissors);
        scissorsBtn.setBackground(new Color(115, 36, 36));
        scissorsBtn.setFocusPainted(false);

        // Set preferred size for buttons
        Dimension buttonSize = new Dimension(150, 200);
        rockBtn.setPreferredSize(buttonSize);
        paperBtn.setPreferredSize(buttonSize);
        scissorsBtn.setPreferredSize(buttonSize);

        //No Borders
        rockBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        paperBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scissorsBtn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        rockBtn.addActionListener((ActionEvent ae) -> throwItem(0));
        paperBtn.addActionListener((ActionEvent ae) -> throwItem(1));
        scissorsBtn.addActionListener((ActionEvent ae) -> throwItem(2));


        choicePanel.add(titleLabel);
        buttonsPnl.add(rockBtn);
        buttonsPnl.add(paperBtn);
        buttonsPnl.add(scissorsBtn);
        choicePanel.add(buttonsPnl);
    }

    public void createStatsPanel(){
        statsPanel = new JPanel();
        statsPanel.setBackground(new Color(115, 36, 36));
        statsPanel.setLayout(new GridLayout(1, 3, 5, 5));

        JLabel playerWinLabel = new JLabel("Player wins:");
        playerWinLabel.setForeground(new Color(0,0,0));
        playerWinLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        playerWinLabel.setVerticalAlignment(SwingConstants.CENTER);
        playerWinLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel computerWinLabel = new JLabel("Computer wins:");
        computerWinLabel.setForeground(new Color(0,0,0));
        computerWinLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        computerWinLabel.setVerticalAlignment(SwingConstants.CENTER);
        computerWinLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel tiesLabel = new JLabel("Ties:");
        tiesLabel.setForeground(new Color(0,0,0));
        tiesLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        tiesLabel.setVerticalAlignment(SwingConstants.CENTER);
        tiesLabel.setHorizontalAlignment(SwingConstants.CENTER);


        playerWinsCount.setEditable(false);
        playerWinsCount.setHorizontalAlignment(SwingConstants.CENTER);
        playerWinsCount.setBorder(BorderFactory.createEmptyBorder());
        playerWinsCount.setBackground(new Color(115, 36, 36));
        playerWinsCount.setForeground(new Color(0,0,0));
        playerWinsCount.setFont(new Font("Times New Roman",Font.BOLD,42));



        computerWinsCount.setEditable(false);
        computerWinsCount.setHorizontalAlignment(SwingConstants.CENTER);
        computerWinsCount.setBorder(BorderFactory.createEmptyBorder());
        computerWinsCount.setBackground(new Color(115, 36, 36));
        computerWinsCount.setForeground(new Color(0,0,0));
        computerWinsCount.setFont(new Font("Times New Roman",Font.BOLD,42));


        tiesCount.setEditable(false);
        tiesCount.setHorizontalAlignment(SwingConstants.CENTER);
        tiesCount.setBorder(BorderFactory.createEmptyBorder());
        tiesCount.setBackground(new Color(115, 36, 36));
        tiesCount.setForeground(new Color(0,0,0));
        tiesCount.setFont(new Font("Times New Roman",Font.BOLD,42));

        JPanel playerPanel = new JPanel(new GridLayout(2, 1));
        playerPanel.setBackground(new Color(115, 36, 36));
        playerPanel.add(playerWinLabel);
        playerPanel.add(playerWinsCount);
        playerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));

        JPanel computerPanel = new JPanel(new GridLayout(2,1));
        computerPanel.setBackground(new Color(115, 36, 36));
        computerPanel.add(computerWinLabel, BorderLayout.CENTER);
        computerPanel.add(computerWinsCount, BorderLayout.SOUTH);
        computerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));

        JPanel tiesPanel = new JPanel(new GridLayout(2,1));
        tiesPanel.setBackground(new Color(115, 36, 36));
        tiesPanel.add(tiesLabel, BorderLayout.CENTER);
        tiesPanel.add(tiesCount, BorderLayout.SOUTH);
        tiesPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));

        statsPanel.add(playerPanel);
        statsPanel.add(computerPanel);
        statsPanel.add(tiesPanel);
    }

    public void createResultsPanel(){
        resultsPanel = new JPanel();
        resultsPanel.setBackground(new Color(115, 36, 36));
        displayResults = new JTextArea(10,35);
        displayResults.setEditable(false);
        displayResults.setFont(new Font("Serif", Font.ITALIC, 20));
        displayResults.setBackground(new Color(74, 17, 17));
        displayResults.setBorder(BorderFactory.createEmptyBorder());
        displayResults.setForeground(new Color(255, 255, 255));


        JScrollPane scrollPane = new JScrollPane(displayResults);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        resultsPanel.add(scrollPane);
    }

    public void createQuit(){
        quitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        quitPanel.setBackground(new Color(115, 36, 36));
        JButton quitBtn = new JButton("Quit");
        quitBtn.setBackground(new Color(0,0,0));
        quitBtn.setForeground(new Color(255, 255, 255));
        quitBtn.setFocusPainted(false);

        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        quitPanel.add(quitBtn);
    }

    public void throwItem(int item){
        int computerItem = rand.nextInt(3);
        String[] winMessages = {
                "Rock breaks Scissors", // 0 beats 2
                "Paper covers Rock",    // 1 beats 0
                "Scissors cut Paper"    // 2 beats 1
        };


        //TODO: Make sure that each condition has it's own thing "Rock BREAKS Scissors"
        if(((item == 0) && (computerItem == 2)) || ((item == 1) && (computerItem == 0)) || ((item == 2) && (computerItem == 1))){
            playerWins++;
            playerWinsCount.setText(Integer.toString(playerWins));
            displayResults.append(winMessages[item] + "(Player wins) \n");
            //TODO: Add to stats panel

        } else if(((computerItem == 0) && (item == 2)) || ((computerItem == 1) && (item == 0)) || ((computerItem == 2) && (item == 1))){
            computerWins++;
            computerWinsCount.setText(Integer.toString(computerWins));
            displayResults.append(winMessages[computerItem] + "(Computer wins) \n");
            //TODO: Add to stats panel

        } else {
            ties++;
            tiesCount.setText(Integer.toString(ties));
            displayResults.append("It's a tie! \n");
            //TODO: Add to stats panel

        }
    }
}
