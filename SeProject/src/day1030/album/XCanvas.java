//3
package day1030.album;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class XCanvas extends Canvas{
	private Toolkit kit = Toolkit.getDefaultToolkit();
	private Image img;	//은닉화 시킨후, 게터 세터 준비시키기 > 복잡해지므로 src로 받자!
	private String src;
	
	public XCanvas(String src) {
		img = kit.getImage(src);
		img = img.getScaledInstance(660, 450, Image.SCALE_SMOOTH);		//660, 450 상수로 바꾸기!!! 내가하기
		setPreferredSize(new Dimension(660, 450));
		setBackground(Color.GRAY);
	}
	

	//우측마우스 > source > generate getter and setter > src 체크!
	public String getSrc() {
		return src;
	}



	public void setSrc(String src) {
		img = kit.getImage(src);
		img = img.getScaledInstance(660, 450, Image.SCALE_SMOOTH);
		this.src = src;
	}



	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	
	}

}
