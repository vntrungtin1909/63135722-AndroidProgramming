package TicTacToe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Menu() {
		setTitle("Welcome to TicTacToe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chọn chế độ chơi");
		lblNewLabel.setBounds(105, 34, 230, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Chơi 2 người");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Choi2Nguoi().setVisible(true);

			}
		});
		btnNewButton.setBounds(105, 97, 230, 43);
		contentPane.add(btnNewButton);
		
		JButton btnChiViMy = new JButton("Chơi với máy");
		btnChiViMy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChoiVoiMay().setVisible(true);
				setVisible(false);
			}
		});
		btnChiViMy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChiViMy.setBounds(105, 176, 230, 43);
		contentPane.add(btnChiViMy);
	}
}
