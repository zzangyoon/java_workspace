/*	4
	지금까지는 URL상의 자원을 가져올때, 그 대상을 이미지로 하였다
	ex) ImageIO.read() 등 실습...
	
	지금 이 실습에서는 이미지 뿐만아니라 원격지의 모든 종류의 자원을 대상으로 연결하여 스트림으로 데이터를 읽어보는 실습을 진행해본다
*/
package day1113.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLLoadApp {
	//웹상의 모든 자원을 대상으로, 연결 및 데이터를 읽어올 수 있는 객체
	URLConnection con;	//추상클래스 이므로, URL 객체로부터 인스턴스를 얻는다!
	HttpURLConnection http;
	URL url;
	FileOutputStream fos;
	
	public URLLoadApp() {
		try {
			url = new URL("https://image.shutterstock.com/z/stock-photo-galaxy-in-space-beauty-of-universe-black-hole-elements-furnished-by-nasa-593484761.jpg");
			
			//지정한 원격지의 자원과 연결을 시도!
			con = url.openConnection();
			http = (HttpURLConnection)con;
				
			//http의 자원을 GET방식으로 자원을 요청하자
			http.setRequestMethod("GET");
			
			//연결객체로부터 스트림을 얻어와서 데이터를 읽어보자!
			InputStream is = http.getInputStream();
			
			//파일로 저장해보자 (그냥 일반 디렉토리 res에 저장해보자)
			File file = new File("C:/workspace/java_workspace/SeProject/res/copy.jpg");
			fos = new FileOutputStream(file);
			
			//한바이트씩 읽어와서 출력스트림을 이용하여 파일에 쓰자
			int data = -1;	//처음에는 읽어들인 데이터가 없다고 가정
			
			while(true) {
				data = is.read();
				if(data==-1) break;
				fos.write(data);
			}
			System.out.println("인터넷상의 파일을 로컬로 저장완료했어요");
		} catch (MalformedURLException e) {
			e.printStackTrace();			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		new URLLoadApp();
	}
	
}
