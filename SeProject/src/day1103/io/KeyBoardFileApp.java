//1
package day1103.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class KeyBoardFileApp {
	String dir;
	FileWriter writer;
	
	public KeyBoardFileApp() {
		URL url = this.getClass().getClassLoader().getResource("res/");
		
		/*디렉토리 + 파일명
		try {
			URL url2 = new URL(url, "empty.txt");
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		}
		*/
		
		try {
			URL url2 = new URL(url, "empty.txt");	//디렉토리와 파일명 조합
			
			URI uri = url2.toURI();	//url을 uri로 변경
			System.out.println(uri);
			writer = new FileWriter(new File(uri));
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			URI uri = url.toURI();
			System.out.println(uri);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	
	}
	
	public void saveFile() {
		//키보드로부터 입력받은 데이터를 파일로 저장해본다
		//키보드 스트림은 System으로부터 얻어와야 한다!
		InputStream is = System.in;	//바이트 (영어)
		
		InputStreamReader reader = new InputStreamReader(is);	//문자기반 스트림으로 업그레이드!
		BufferedReader buffr = new BufferedReader(reader);	//버퍼기반의 문자입력스트림으로 업그레이드!
		
		//파일출력스트림 계열은 빈(empty) 파일을 생성해준다!
		
		
		//FileWriter writer = new FileWriter();
		
		String msg = null;
		
		
		try {
			msg = buffr.readLine();
			System.out.println(msg);	//모니터에 출력
			writer.write(msg);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
			
	public static void main(String[] args) {
		new KeyBoardFileApp().saveFile();
		
	}

}
