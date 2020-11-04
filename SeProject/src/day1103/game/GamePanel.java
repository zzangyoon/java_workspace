//10
package day1103.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

//사실상 모든~ 게임의 그래픽처리는 패널이 담당하게 됨!
public class GamePanel extends JPanel{
	Thread loopThread;	//게임루프를 무한루프로 실행할 쓰레드!
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 900;
	
	Hero hero;
	Bullet bullet;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		createHero();		//주인공생성
		
		loopThread = new Thread(){
			public void run() {
				while(true) {
					gameLoop();
					try {
						Thread.sleep(10);	//10/1000초
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		loopThread.start();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;	//2D에 더 적합한 그래픽스 객체로 형변환!
		
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, WIDTH, HEIGHT);	//패널의 크기만큼 사각형이 채워진다(화면을 깨끗이 닦는 효과)
		
		render(g2);
		
		//g2.setColor(Color.RED);
		//g2.fillRect(x, y, 100, 45);
		
		
	}
	
	public void createHero() {
		hero = new Hero(200, 200, 50, 50, 0, 0);
	}
	
	//게임윈도우로부터 어떤 방향키가 눌렸는지를 전달받자
	public void moveKey(int key) {
		//37부터 시계방향으로...
		switch(key) {
			case KeyEvent.VK_LEFT:hero.velX=-2; break;
			case KeyEvent.VK_RIGHT:hero.velX=2; break;
			case KeyEvent.VK_UP:hero.velY=-2; break;
			case KeyEvent.VK_DOWN:hero.velY=2; break;
			case KeyEvent.VK_SPACE:fire();break;
		}
	}
	public void stopKey(int key) {
		//37부터 시계방향으로...
		switch(key) {
			case KeyEvent.VK_LEFT:hero.velX=0; break;
			case KeyEvent.VK_RIGHT:hero.velX=0; break;
			case KeyEvent.VK_UP:hero.velY=0; break;
			case KeyEvent.VK_DOWN:hero.velY=0; break;
		}
	}
	
	//총알발사
	public void fire() {
		bullet = new Bullet(hero.x, hero.y, 30, 30, 10, 10);
	}
	
	//물리량 변경
	public void tick() {
		hero.tick();
		if(bullet !=null)bullet.tick();
	}
	
	public void render(Graphics2D g2) {
		hero.render(g2);
		if(bullet !=null)bullet.render(g2);
	}
	
	//모든 게임의 tick(), render()를 호출! 즉 게임엔진
	public void gameLoop() {
		tick();
		this.repaint();

		//System.out.println("gameLoop() called...");
	}
}