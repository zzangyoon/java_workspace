//9나혼자
package day1030.io;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Copy extends JFrame{
	JLabel la_ori;
	JLabel la_copy;
	JTextField t_ori;
	JTextField t_copy;
	JButton bt;
	
	public Copy() {
		la_ori = new JLabel("원본");
		la_copy = new JLabel("복사본");
		t_ori = new JTextField(15);
		t_copy = new JTextField(15);
		bt = new JButton("copy");
		
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Copy();
	}
}
