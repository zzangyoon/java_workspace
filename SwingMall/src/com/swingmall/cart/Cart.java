/*
	장바구니 페이지를 정의한다
*/
package com.swingmall.cart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.swingmall.main.Page;
import com.swingmall.main.ShopMain;

public class Cart extends Page{
	JPanel bt_container;	//버튼을 묶어줄 컨테이너
	JButton bt_pay;	//결제단계로 바꾸기
	JButton bt_del;	//장바구니 비우기
	
	//장바구니 역할을 할 컬렉션 프레임웍 객체를 선언
	HashMap<Integer, CartVO> cartList;
	JPanel p_content;	//Cart에 직접붙이지 말고, 아이템들을 붙일 컨테이너 준비한다
		
	public Cart(ShopMain shopMain) {
		super(shopMain);
		
		cartList = new HashMap<Integer, CartVO>();
		
		//this.setBackground(Color.BLACK);
		bt_container = new JPanel();
		bt_pay = new JButton("결제하기");
		bt_del = new JButton("장바구니 비우기");
	
		//스타일
		bt_container.setPreferredSize(new Dimension(ShopMain.WIDTH, 115));
		bt_container.setBackground(Color.PINK);
		
		getCartList();
		
		bt_container.add(bt_pay);
		bt_container.add(bt_del);
		add(bt_container, BorderLayout.SOUTH);
		
	}
	
	//장바구니에 넣기
	public void addCart(CartVO vo) {	//상품 1건을 장바구니에 추가하기!
		cartList.put(vo.getProduct_id(), vo);	//key와 값을 저장
	}
	
	//장바구니 삭제하기
	public void removeCart(int product_id) {	//상품 1건을 장바구니에서 제거하기
		cartList.remove(product_id);
	}
	
	//장바구니 비우기
	public void removeAll() {	//모든 상품을 장바구니에서 제거하기
		
	}
	
	//장바구니 수량 변경
	public void updateCart(CartVO vo) {
		//해쉬맵에 들어있는 객체 중 해당 객체를 찾아내어 vo교체!
		//cartList.replace(vo.getEa(), v)
		CartVO obj = cartList.get(vo.getProduct_id());	//검색!
		obj = vo;	//기존 해쉬맵이 가지고 있던 vo를 찾아내어 주소 변경
	}
	
	//장바구니 목록 가져오기 (주의 : 맵은 순서가 없는 집합이므로 먼저 일렬로 늘어뜨려야 한다.. 그 후 접근)
	public void getCartList() {
		Set<Integer> set = cartList.keySet();	//키들을 set으로 반환받는다... 즉 맵은 한번에 일렬로 늘어서는 것이 아니라, set으로 먼저 key를 가져와야함
																//순서없는 숫자
		Iterator<Integer> it = set.iterator();	//순서 있는 숫자
		
		//add()하기 전에 기존에 붙어있던 모든 컴포넌트는 제거
		int count = 0;
		if(p_content!=null) {	//존재한다면.. 기존것 지우자
			this.remove(p_content);	//제거
			this.revalidate();
			this.updateUI();
			this.repaint();
		}
		
		//동적으로 생성
		p_content = new JPanel();
		p_content.setPreferredSize(new Dimension(ShopMain.WIDTH-350, 600));
		
		while(it.hasNext()) {	//요소가 있는 동안...
			int key = it.next();	//요소를 추출
			System.out.println("key : "+key);
			CartVO vo = cartList.get(key);
			
			//디자인을 표현하는 CartItem에 CartVO의 정보를 채워넣자!
			CartItem item = new CartItem(vo);
			//제거하기버튼
			item.bt_del.addActionListener((e)->{
				if(JOptionPane.showConfirmDialog(Cart.this, "장바구니에서 삭제하시겠어요?")==JOptionPane.OK_OPTION) {
					removeCart(vo.getProduct_id());	//지금 내가 선택한 아이템의 pk					
					getCartList();
				}
			});
			
			item.bt_update.addActionListener((e)->{
				if(JOptionPane.showConfirmDialog(Cart.this, "장바구니를 수정하시겠어요?")==JOptionPane.OK_OPTION) {
					int ea = Integer.parseInt(item.t_ea.getText());	//수정한 갯수
					vo.setEa(ea);		//변경된 갯수를 vo에 반영한 후에 전달
					updateCart(vo);
					getCartList();
				}
			});
			
			p_content.add(item);	//Cart에 직접 붙이지 말고, 동적으로 생성한 p_content에 붙이자
			count++;
			//add(item);
		}
		add(p_content);	//Cart에 p_content를 동적으로 추가
		this.updateUI();
	}
	
}
