package day1028.graphic.color;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorPickerApp extends JFrame{
	JPanel p_container;
	JPanel p_red;
	JPanel p_orange;
	JPanel p_yellow;
	JPanel p_green;
	JPanel p_blue;
	JPanel p_navy;
	JPanel p_purple;
	JPanel p_color;

	public ColorPickerApp() {
		p_container = new JPanel();
		p_red = new JPanel();
		p_orange = new JPanel();
		p_yellow = new JPanel();
		p_green = new JPanel();
		p_blue = new JPanel();
		p_navy = new JPanel();
		p_purple = new JPanel();
		p_color = new JPanel();
		
		p_container.add(p_red);
		p_container.add(p_orange);
		p_container.add(p_yellow);
		p_container.add(p_green);
		p_container.add(p_blue);
		p_container.add(p_navy);
		p_container.add(p_purple);
		
		add(p_container, BorderLayout.NORTH);
		add(p_color, BorderLayout.CENTER);

		
		p_red.setPreferredSize(new Dimension(100, 100));
		p_orange.setPreferredSize(new Dimension(100, 100));
		p_yellow.setPreferredSize(new Dimension(100, 100));
		p_green.setPreferredSize(new Dimension(100, 100));
		p_blue.setPreferredSize(new Dimension(100, 100));
		p_navy.setPreferredSize(new Dimension(100, 100));
		p_purple.setPreferredSize(new Dimension(100, 100));
		p_container.setPreferredSize(new Dimension(700,100));
		p_color.setPreferredSize(new Dimension(700,400));
		
		p_red.setBackground(Color.RED);
		p_orange.setBackground(Color.ORANGE);
		p_yellow.setBackground(Color.YELLOW);
		p_green.setBackground(Color.GREEN);
		p_blue.setBackground(Color.CYAN);
		p_navy.setBackground(Color.BLUE);
		p_purple.setBackground(Color.MAGENTA);
		
		p_color.setBackground(Color.BLACK);
		
		
		
		
		setSize(800,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ColorPickerApp();
	}
}
