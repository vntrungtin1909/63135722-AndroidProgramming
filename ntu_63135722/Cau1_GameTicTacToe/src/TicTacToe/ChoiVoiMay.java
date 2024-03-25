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
                int m = i;
                int n = j;
                label.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                    	 if (over) {
                             if (label.getText().toString().equals(" ")) {
                                 label.setText(String.valueOf(turn));
                                 arr[m][n] = turn;
                                     label.setForeground(Color.blue);
                                     if (checkWinner() && winner.equals("X")) {
                                         luotDi.setText("X thắng");
                                         luotDi.setForeground(Color.blue);
                                         over = false;
                                     } else if (checkWinner() && winner.equals("O")) {
                                         luotDi.setText("O thắng");
                                         luotDi.setForeground(Color.red);
                                         over = false;
                                     } else if (!draw()) {
                                         luotDi.setText("Hòa");
                                         over = false;
                                     }
                                     if (over) {
                                    	 turn = 'O';
                                         May();
                                     }
                                 
                             } else {
                                 luotDi.setText("Chọn vị trí khác");
                             }
                         }
                     }
                });
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
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
        p.add(btnNew);

        add(p, BorderLayout.SOUTH);
        setVisible(true);
	}
	
	private static boolean checkWinner() {
		boolean win = false;
		if (arr[0][0] == arr[0][1] && arr[0][0] == arr[0][2] && arr[0][0] != 0) {
            win = true;
            winner = String.valueOf(arr[0][0]);
        } else if (arr[1][0] == arr[1][1] && arr[1][0] == arr[1][2] && arr[1][0] != 0) {
            win = true;
            winner = String.valueOf(arr[1][0]);
        } else if (arr[2][0] == arr[2][1] && arr[2][0] == arr[2][2] && arr[2][0] != 0) {
            win = true;
            winner = String.valueOf(arr[2][0]);
        } else if (arr[0][0] == arr[1][0] && arr[0][0] == arr[2][0] && arr[0][0] != 0) {
            win = true;
            winner = String.valueOf(arr[0][0]);
        } else if (arr[0][1] == arr[1][1] && arr[0][1] == arr[2][1] && arr[0][1] != 0) {
            win = true;
            winner = String.valueOf(arr[0][1]);
        } else if (arr[0][2] == arr[1][2] && arr[0][2] == arr[2][2] && arr[0][2] != 0) {
            win = true;
            winner = String.valueOf(arr[0][2]);
        } else if (arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2] && arr[0][0] != 0) {
            win = true;
            winner = String.valueOf(arr[0][0]);
        } else if (arr[2][0] == arr[1][1] && arr[2][0] == arr[0][2] && arr[2][0] != 0) {
            win = true;
            winner = String.valueOf(arr[2][0]);
        }
		return win;
	}
	
	private static boolean draw() {
		boolean draw = false;
		for (char[] a : arr) {
            for (char b : a) {
                if (b == 0) {
                    draw = true;
                    break;
                }
            }
        }
		return draw;
	}
	
	private static void reset() {
		
	}
	
	private static void May() {
		
	}

}
