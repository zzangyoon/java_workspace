package com.swingmall.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.swingmall.board.QnA;
import com.swingmall.cart.Cart;
import com.swingmall.home.Home;
import com.swingmall.member.Login;
import com.swingmall.member.MyPage;
import com.swingmall.member.RegistForm;
import com.swingmall.product.Product;
import com.swingmall.product.ProductDetail;
import com.swingmall.util.db.DBManager;

public class ShopMain extends JFrame{
	//상수 선언
	public static final int WIDTH=1200;
	public static final int HEIGHT=900;	
	
	//최상위 페이지들
	public static final int HOME = 0;	
	public static final int PRODUCT = 1;	
	public static final int QNA = 2;	
	public static final int MYPAGE = 3;	
	public static final int LOGIN = 4;	

	//하위페이지
	public static final int PRODUCT_DETAIL = 5;
	public static final int MEMBER_REGIST = 6;
	public static final int CART = 7;
	
	JPanel user_container;	//관리자, 사용자 화면을 구분지을 수 있는 컨테이너
	
	JPanel p_content;	//여기에 모든 페이지가 미리 붙어져 있을것임. 추후 showPage 메서드로 보여질지 여부 결정
	
	JPanel p_navi;	//웹사이트의 주 메뉴를 포함할 컨테이너 패널
	String[] navi_title = {"Home", "Product", "QnA", "MyPage", "Login"};
	public JButton[] navi = new JButton[navi_title.length];	//[][][][][] 배열생성
	
	//페이지 구성
	Page[] page = new Page[8];	//최상위페이지들
	
	JLabel la_footer;	//윈도우 하단의 카피라이트 영역
	DBManager dbManager;
	Connection con;
	
	//로그인 상태인지 여부를 알수있는 변수
	private boolean hasSession=false;
	
	public ShopMain() {
		dbManager = new DBManager();
		user_container = new JPanel();
		p_content = new JPanel();
		p_navi = new JPanel();
		la_footer = new JLabel("SwingMall All rights reserved", SwingConstants.CENTER);	//카피라이트	//가운데정렬
		
		con = dbManager.connect();
		if(con==null) {
			JOptionPane.showMessageDialog(this, "데이터베이스에 접속할 수 없습니다");
			System.exit(0);
		}else {
			this.setTitle("SwingShop에 오신걸 환영합니다");
		}
		
		//메인네비게이션 생성
		for(int i=0; i<navi.length; i++) {
			navi[i] = new JButton(navi_title[i]);
			p_navi.add(navi[i]);	//패널에 네비게이션 부착
		}
		
		//페이지 구성
		page[0] = new Home(this);	//shopMain을 넘겨야함
		//프로젝트할때는 page[1][0] 이렇게 이차원배열로 가는게 좋을듯!
		page[1] = new Product(this);	//shopMain을 넘겨야함
		page[2] = new QnA(this);	//shopMain을 넘겨야함
		page[3] = new MyPage(this);	//shopMain을 넘겨야함
		page[4] = new Login(this);	//shopMain을 넘겨야함
		page[5] = new ProductDetail(this);
		page[6] = new RegistForm(this);	//회원가입 폼
		page[7] = new Cart(this);	//장바구니
		
		//스타일 적용
		user_container.setPreferredSize(new Dimension(WIDTH, HEIGHT-50));
		user_container.setBackground(Color.WHITE);
		//p_navi.setPreferredSize(new Dimension(WIDTH, 50));
		la_footer.setPreferredSize(new Dimension(WIDTH, 50));
		la_footer.setFont(new Font("Arial Black", Font.BOLD, 19));
		
		//조립
		user_container.setLayout(new BorderLayout());
		user_container.add(p_navi, BorderLayout.NORTH);
		
		//모든 페이지를 미리 붙여놓자!
		for(int i=0; i<page.length; i++) {
			p_content.add(page[i]);
		}
		
		user_container.add(p_content);	//센터에 페이지 부착
		
		this.add(user_container);
		this.add(la_footer, BorderLayout.SOUTH);
		
		//showPage(5);
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);
		
		//프레임과 리스너 연결
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dbManager.disConnect(con);
				System.exit(0);
			}
		});
		
		//네이게이션 버튼과 리스너 연결
		for(int i=0; i<navi.length; i++) {
			navi[i].addActionListener((e)->{
				Object obj = e.getSource();
				if(obj ==navi[0]) {	//home
					showPage(0);
				}else if(obj ==navi[1]) {	//product
					showPage(1);
				}else if(obj ==navi[2]) {	//member
					showPage(2);
				}else if(obj ==navi[3]) {	//order
					//mypage는 무조건 보여줘서는 안되고, 로그인한 사람에게만 보여줘야함
					//로그인 상태가 아니라면 욕!
					if(hasSession==false) {
						JOptionPane.showMessageDialog(ShopMain.this, "로그인이 필요한 서비스입니다");
					}else {
						showPage(3);						
					}
				}else if(obj ==navi[4]) {	//board
					//로그인을 요청할지, 로그아웃을 요청할지를 구분하자
					//hasSession의 값이 true 일때는 로그인한 상태이므로, 로그아웃을 요청
					if(hasSession) {
						int ans = JOptionPane.showConfirmDialog(ShopMain.this, "로그아웃 하시겠습니까?");
						
						if(ans==JOptionPane.OK_OPTION) {	//'예'를 눌렀을때
							Login loginPage = (Login)page[ShopMain.LOGIN];
							loginPage.logout();
						}
					}else {
						showPage(4);	//로그인						
					}
				}
			});
		}
		
	}
	
	//보여질 페이지와 안보여질 페이지를 설정하는 메서드
	public void showPage(int showIndex) {	//매개변수로는 보여주고 싶은 페이지 넘버를 넘긴다
		for(int i=0; i<page.length; i++) {	//모든 페이지를 대상으로
			if(i == showIndex) {
				page[i].setVisible(true);	//보여질 페이지
			}else {
				page[i].setVisible(false);	//안보여질 페이지
			}
		}
		
	}
	
	//보여질 컨텐츠와 가려질 컨텐츠를 제어하는 메서드
	public void addRemoveContent(Component removeObj, Component addObj) {
		this.remove(removeObj);	//제거될 자(패널)
		this.add(addObj);	//부착될 자(패널)
		
		((JPanel)addObj).updateUI();
	}
	
	public DBManager getDbManager() {
		return dbManager;
	}

	public Connection getCon() {
		return con;
	}

	public static void main(String[] args) {
		new ShopMain();
	}

	public Page[] getPage() {
		return page;
	}

	public boolean isHasSession() {
		return hasSession;
	}

	public void setHasSession(boolean hasSession) {
		this.hasSession = hasSession;
	}
	
}
