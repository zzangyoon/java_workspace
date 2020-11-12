package day1028.graphic.color;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorPickerApp2 extends JFrame{
	
	Thumb[] list;
	Color[] color = {Color.RED, Color.ORANGE
			, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.pink};
	JPanel p_north;
	JPanel p_center;
	
	public ColorPickerApp2() {
		p_north = new JPanel();
		p_center = new JPanel();
		 list= new Thumb[7];
		 for(int i=0;i<list.length;i++) {
			 list[i] = new Thumb(color[i], p_center);			 
			 p_north.add(list[i]);
			 list[i].addMouseListener(list[i]);
		 }
		 p_center.setBackground(Color.BLACK);
		 
		 add(p_north, BorderLayout.NORTH);
		 add(p_center);
		 setSize(770,500);
		 setVisible(true);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ColorPickerApp2();

	}

}
