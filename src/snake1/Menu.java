package snake1;

import com.sun.deploy.util.LinkMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

public class Menu extends JFrame {
    private Font font = new Font("Arial", Font.BOLD, 38);




    public Menu() {
        initUI();
    }

    public final void initUI() {

        JPanel menu = new JPanel();
        getContentPane().add(menu);
        menu.setLayout(null);
        setTitle("Snake");

        JButton campaign_button = new JButton("Campaign");
        campaign_button.setBounds(450, 400, 300, 50);
        campaign_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.game_chose=false;
                dispose();
            }
        });

        JButton exit_button = new JButton("EXIT");
        exit_button.setBounds(450, 550, 300, 50);
        exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JButton rush_button = new JButton("Rush");
        rush_button.setBounds(450, 450, 300, 50);
        rush_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JButton survival_button = new JButton("Survival");
        survival_button.setBounds(450, 500, 300, 50);
        survival_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JLabel label = new JLabel("HS Snake");
        label.setPreferredSize(new Dimension(300,100));
        label.setFont(new Font("Serif", Font.PLAIN, 66));

        menu.add(campaign_button);
        menu.add(rush_button);
        menu.add(survival_button);
        menu.add(exit_button);
        menu.add(label);

        setSize(1224, 708);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }


}