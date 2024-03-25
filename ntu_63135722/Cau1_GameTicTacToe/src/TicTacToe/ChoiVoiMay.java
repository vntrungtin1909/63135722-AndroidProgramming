package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ChoiVoiMay extends JFrame {

	private static final long serialVersionUID = 1L;
    private static char turn = 'X';
    private static JLabel luotDi;
    private static ArrayList<JLabel> ds = new ArrayList<JLabel>();
    private static String winner = " ";
    private static char[][] arr = new char[3][3];
    private static boolean over = true;
	
	public ChoiVoiMay() {
		setTitle("Tic Tac Toe");
        setSize(320, 470);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setBackground(Color.white);

        JLabel tieuDe = new JLabel("Tic Tac Toe");
        tieuDe.setBackground(Color.white);
        tieuDe.setOpaque(true);
        tieuDe.setHorizontalAlignment(SwingConstants.CENTER);
        tieuDe.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        tieuDe.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(tieuDe, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 7, 7));
        panel.setBackground(Color.black);

        luotDi = new JLabel("Chơi với máy");
        luotDi.setHorizontalAlignment(SwingConstants.CENTER);
        luotDi.setBackground(Color.white);
        luotDi.setOpaque(true);
        luotDi.setFont(new Font("Tahoma", Font.BOLD, 25));
        luotDi.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JLabel label = new JLabel(" ");
                label.setOpaque(true);
                label.setBackground(Color.white);
                label.setFont(new Font("Tahoma", Font.BOLD, 60));
                label.setHorizontalAlignment(SwingConstants.CENTER);
               
                ds.add(label);
                panel.add(label);
            }
        }

        add(panel, BorderLayout.CENTER);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        p.add(luotDi);

        JButton btnNew = new JButton("Trò chơi mới");
        btnNew.setBackground(Color.black);
        btnNew.setForeground(Color.white);
        btnNew.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        p.add(btnNew);

        add(p, BorderLayout.SOUTH);
        setVisible(true);
	}

}
