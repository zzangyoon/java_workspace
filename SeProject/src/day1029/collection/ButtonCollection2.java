package day1029.collection;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonCollection2 extends JFrame implements ActionListener{
	JPanel p_north;
	JPanel p_center;
	JButton bt_make;
	JButton bt_bg;
	JButton bt1;
	
	public ButtonCollection2() {
		p_north = new JPanel();
		p_center = new JPanel();
		bt_make = new JButton("생성");
		bt_bg = new JButton("배경색");
		
		p_north.add(bt_make);
		p_north.add(bt_bg);
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		
	
		setSize(350,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void showList() {
		ArrayList<JButton> list = new ArrayList<JButton>();
		for(int i=0; i<list.size(); i++) {
			list.add(new JButton("버튼"+i));
			bt1 = list.get(i);
			System.out.println(bt1.getText());
		}
	}
	
	public void actionPerformed(ActionEvent e) {		
		showList();
	}
	
	public static void main(String[] args) {
		ButtonCollection2 bc2 = new ButtonCollection2();
		
	}

}
