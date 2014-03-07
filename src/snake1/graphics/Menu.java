package snake1.graphics;

import snake1.data.GameSettings;
import snake1.data.GameType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private static final Font font = new Font("Arial", Font.BOLD, 138);
    public static final Menu MENU = new Menu();

    public boolean isGameChosen() {
        return gameChosen;
    }

    private boolean gameChosen = false;

    private Menu() {
        initUI();
    }

    public final void initUI() {
        JPanel menu = new JPanel();
        getContentPane().add(menu);
        menu.setLayout(null);
        setTitle("Snake");

        JButton campaignButton = new JButton("Campaign");
        campaignButton.setBounds(450, 400, 300, 50);
        campaignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GameSettings.SETTINGS.setGame(GameType.CAMPAIGN);
                gameChosen = true;
            }
        });

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(450, 550, 300, 50);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JButton duelButton = new JButton("Duel");
        duelButton.setBounds(450, 450, 300, 50);
        duelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GameSettings.SETTINGS.setGame(GameType.DUEL);
                gameChosen = true;
            }
        });

        JButton survivalButton = new JButton("Survival");
        survivalButton.setBounds(450, 500, 300, 50);
        survivalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GameSettings.SETTINGS.setGame(GameType.SURVIVAL);
                gameChosen = true;
            }
        });

        JLabel label = new JLabel();
        label.setText("HS Snake");
        label.setFont(font);
        label.setBounds(150, 50, 900, 550);
        label.setOpaque(true);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);

        JLabel author = new JLabel();
        author.setText("Developed by G.Parakhonskiy");
        author.setFont(new Font("Arial", Font.ITALIC, 10));
        author.setBounds(250, 50, 940, 600);
        author.setOpaque(true);
        author.setVerticalAlignment(JLabel.BOTTOM);
        author.setHorizontalAlignment(JLabel.RIGHT);

        menu.add(campaignButton);
        menu.add(duelButton);
        menu.add(survivalButton);
        menu.add(exitButton);
        menu.add(label);
        menu.add(author);

        setSize(1224, 708);
        setLocationRelativeTo(null);
        setVisible(!gameChosen);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}


