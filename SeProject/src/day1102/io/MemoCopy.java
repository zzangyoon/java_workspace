/* 1.
 	지난주에는 문서파일(영문)과 바이너리 파일(사진) 등을 복사해보았다
 	하지만, 문서파일의 경우 한글이 섞여 있을때 어떤 결과가 나오는지 테스트해본다!
 	
 	[스트림의 유형]
 	스트림의 기본은 1byte씩 처리하는 바이트 기반의 스트림이다
 	하지만, 스트림상으로 흐르는 데이터를 문자로 해석할 수 있는 스트림을 문자기반 스트림이라 한다
 	문자기반 스트림은 접미어가 -Reader, -Writer로 끝난다
 	
 */
package day1102.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MemoCopy {

	FileInputStream fis;
	FileOutputStream fos;
	
	FileReader reader;	//파일을 대상으로한 문자기반의 입력스트림
	FileWriter writer;	//파일을 대상으로한 문자기반의 출력스트림
	
	String path = "C:/workspace/java_workspace/SeProject/res/data/test.txt";
	String path2 = "C:/workspace/java_workspace/SeProject/res/data/test2.txt";
	
	public MemoCopy() {
		try {				
			//fis = new FileInputStream(path);
			//fos = new FileOutputStream(path2);	//파일출력스트림은 빈파일을 생성하는 특징이 있다
			reader = new FileReader(path);
			writer = new FileWriter(path2);
					
			
			//한 바이트씩 읽어들이면서 영문과 한글이 어떻게 되는지 관찰해보자
			//결론 : FileInputStream은 바이트 기반의 스트림이므로 1byte 씩만 해석할 수 있다
			//따라서 한글의 경우 2byte로 구성되어 있으므로, 복사는 성공하겠으나, 
			//스트림상에서 흐르는 데이터를 한글로 보고자 할때는 깨져서 보일 수 밖에 없다
			
			int data;
			while(true) {
				data = reader.read();	//	<--fis가 아니라 reader의 메서드 호출해야함
				if(data==-1)break;
				System.out.println((char)data);
				writer.write(data);		//	<--fos가 아니라 writer의 메서드 호출해야함
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		new MemoCopy();
	}
}
