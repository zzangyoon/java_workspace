//6
package day1116.pubapi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class MTMain2 extends JFrame{
	//서쪽영역
	JPanel p_west;
	JTextField t_name;
	JTextField t_op1;
	JTextField t_op2;
	JTextField t_op3;
	JButton bt;
	
	JTable table;
	/*	JTable에서 지원하는 Vector 방식은 2차원배열 보다는 유연하지만 여전히 2차원배열의 구조를 유지하므로,
	  	TableModel을 이용한 벡터 및 VO를 종합해서 개발해보자	*/
	MountainModel model;
	JScrollPane scroll;
	
	//멤버변수로 파서 보유하기
	String apiKey = "";		//메모장에 있음!
	SAXParserFactory factory;
	SAXParser saxParser;
	Thread loadThread;	//네트워크상에서 xml을 불러올때 사용할 쓰레드, 버튼을 누를때마다 인스턴스 생성하여 네트워크 업무 시키자!!!
	InputStream is;	//xml 데이터를 담고있는 스트림 (@-5)
	MountainHandler mountainHandler;
	
	//파싱이 끝나면 닫아주기 위해 멤버변수로 선언함(@-6)
	HttpURLConnection conn;
	BufferedReader rd;
	
	public MTMain2() {
		//생성
		p_west = new JPanel();
		t_name = new JTextField();
		t_op1 = new JTextField();
		t_op2 = new JTextField();
		t_op3 = new JTextField();
		bt = new JButton("검색하기");

		//테이블모델을 이용한 개발방식으로 간다
		table = new JTable(model = new MountainModel());
		scroll = new JScrollPane(table);
		
		//생성자에서 쓰레드를 내부익명으로 처리하자
		/*	이 코드는 이제 하지 않는다. 최초에 생성자에서 한번만 생성해서 문제가 생긴다
		  	따라서 이 코드는 버튼 누를때 시점으로 내린다! (@-9)
		loadThread = new Thread() {
			public void run() {	//버튼을 누를때 이 쓰레드를 호출하자
				loadXML();
			}
		};
		*/
		
		//스타일 적용
		p_west.setPreferredSize(new Dimension(200,600));
		p_west.setBackground(Color.WHITE);
		t_name.setPreferredSize(new Dimension(190,30));
		t_op1.setPreferredSize(new Dimension(190,30));
		t_op2.setPreferredSize(new Dimension(190,30));
		t_op3.setPreferredSize(new Dimension(190,30));
		
		//부착
		p_west.add(t_name);
		p_west.add(t_op1);
		p_west.add(t_op2);
		p_west.add(t_op3);
		p_west.add(bt);
		
		add(p_west, BorderLayout.WEST);
		add(scroll);
		
		//버튼과 리스너 연결
		bt.addActionListener((e)->{
			//네트워크를 타고 데이터를 가져올때 메인쓰레드에서 진행하는게 좋을까? 좋지않다
			//loadXML();
			//버튼을 누를때마다 분신을 만들어 네트워크 업무를 처리하게 해야한다
			//따라서 버튼 누를때마다 쓰레드를 new 해야 한다!	(@-9)
			loadThread = new Thread() {
				public void run() {	//버튼을 누를때 이 쓰레드를 호출하자
					loadXML();
				}
			};			
			loadThread.start();		//xml로딩 쓰레드 호출
		});
		
		setVisible(true);
		setSize(900,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	//아직은 파싱하는 작업이라기 보다는 URL에서 xml을 가져오는 단계이다
	public void loadXML() {
		//여기에, 공공데이터 포털에서 공개한 소스코드를 붙여넣는다
		//아래의 코드를 모두 IOException으로 감싼다
        try {
			StringBuilder urlBuilder = new StringBuilder("http://openapi.forest.go.kr/openapi/service/trailInfoService/getforeststoryservice"); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+apiKey); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("mntnNm","UTF-8") + "=" + URLEncoder.encode(t_name.getText(), "UTF-8")); /*@-11 고정시키지 말고 검색할 수 있도록!!*/
			urlBuilder.append("&" + URLEncoder.encode("mntnHght","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
			urlBuilder.append("&" + URLEncoder.encode("mntnAdd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
			urlBuilder.append("&" + URLEncoder.encode("mntnInfoAraCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
			urlBuilder.append("&" + URLEncoder.encode("mntnInfoSsnCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
			urlBuilder.append("&" + URLEncoder.encode("mntnInfoThmCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
			URL url = new URL(urlBuilder.toString());
			conn = (HttpURLConnection) url.openConnection();	//@-6
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			    rd = new BufferedReader(new InputStreamReader(is=conn.getInputStream()));		//is= 붙여주기! (@-5)_
			} else {
			    rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			//아래의 코드는 화면에 출력하기 위한 코드이므로, 테스트가 끝나면 제거해야 한다
			//이유? read를 여기서 해버리면 이후의 라인에서는 스트림의 끝에 도달하게 되므로, 즉 사용전에 써버렸으므로...
			//파싱도 하기전에 소모시키지 말자!
			/*
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
			    sb.append(line);
			}
			*/
			/*	파싱이 끝난 후로 미루자! (@-6)
			rd.close();
			conn.disconnect();
			*/
			//제대로 불러와지는지 sb를 콘솔에 출력해보자
			//제대로 되므로 파싱용 메서드를 따로 정의하자 
			//System.out.println(sb.toString());
			
			parseData();	//이 시점부터 파싱 시작!
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*	주의) 지금 파싱할 데이터는 
	 	1) xml파일로 존재할까?
	 	2) 메모리상에서 텍스트로 존재할까?
	 	
	 	저번주 예제에서는 xml파일로 보유한 후 파싱했지만, 공공데이터 포털의 api는 메모리상에서 불러와 처리해야한다
	 	그래서 parsing 할때 오버로딩된 메서드를 잘 선택해야 한다
	*/
	public void parseData() {
		factory = SAXParserFactory.newInstance();	//팩토리 객체 생성(이 객체가 있어야 파서를 생성함)
		try {
			saxParser = factory.newSAXParser();	//파서생성
			saxParser.parse(is, mountainHandler = new MountainHandler());	//파싱시작
			
			//파싱이 끝나면 TableModel의 백체객터를 파싱한 결과로 얻은 벡터로 대체해버리면 된다!
			model.data = mountainHandler.mtList;
			table.updateUI();	//테이블 갱신
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(rd!=null) {
				try {
					rd.close();								//(@-6. 그리고 멤버변수로 선언해주기!)
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(conn!=null)conn.disconnect();	//(@-6. 그리고 멤버변수로 선언해주기!)
			}
		}
	}
	
	public static void main(String[] args) {
		new MTMain2();
	}
}
