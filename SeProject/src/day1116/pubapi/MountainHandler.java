/*	2.
	SAX Parsing 시 모든 node(요소, 텍스트 등 xml을 이루는 요소들을 일컬음) 마다 이벤트를 발생시켜주는 객체 
*/
package day1116.pubapi;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MountainHandler extends DefaultHandler{
	//발견되는 산이 있을때 VO로 생성 후, 그 VO를 담게될 벡터
	Vector<Mountain> mtList;
	Mountain mt;	//산의 정보 1건을 임시적으로 담을 변수
	
	//현재 실행부가 어느 위치를 지났는지를 알기 위한 변수
	boolean isMntnid;		
	boolean isMntnnm;	
	boolean isMntninfopoflc;	
	boolean isMntninfohght;
	
	/*메서드 오버라이드*/
	//xml 문서가 시작될때 호출되는 메서드
	public void startDocument() throws SAXException {
	
	}
	
	//시작태그를 만났을때 호출되는 메서드
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		System.out.print("<"+tag+">");	//여는 태그 출력
		
		if(tag.equals("items")) {		//여기서 벡터 만들고
			mtList = new Vector<Mountain>();
		}else if(tag.equals("item")) {	//여기서 VO 생성
			mt = new Mountain();
		}else if(tag.equals("mntnid")) {	//실행부가 아이디를 지나간다고 표시
			isMntnid = true;
		}else if(tag.equals("mntnnm")) {	//실행부가 산이름를 지나간다고 표시
			isMntnnm = true;
		}else if(tag.equals("mntninfopoflc")) {	//실행부가 산의 위치를 지나간다고 표시
			isMntninfopoflc=true;
		}else if(tag.equals("mntninfohght")) {	//실행부가 산의 높이를 지나간다고 표시
			isMntninfohght=true;
		}
		
		
	}
	
	//태그 사이의 텍스트를 만날때 호출되는 메서드
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch, start, length);
		System.out.print(data);
		
		//태그위치에 따른 데이터 담기
		if(isMntnid) {
			mt.setMntnid(Integer.parseInt(data));//산의 아이디 담기
		}else if(isMntnnm) {
			mt.setMntnnm(data);	//산의 이름
		}else if(isMntninfopoflc) {
			mt.setMntninfopoflc(data);	//산의 위치
		}else if(isMntninfohght) {
			mt.setMntninfohght(Integer.parseInt(data));	//산의 높이
		}
	}

	//닫는 태그를 만날때 호출되는 메서드
	public void endElement(String uri, String localName, String tag) throws SAXException {
		//System.out.print("</"+tag+">");	//닫는 태그 출력
		
		//데이터를 담은 후 실행부의 위치를 다시 초기화
		if(tag.equals("mntnid")) {	//실행부가 아이디를 지나간다고 표시
			isMntnid = false;
		}else if(tag.equals("mntnnm")) {	//실행부가 산이름를 지나간다고 표시
			isMntnnm = false;
		}else if(tag.equals("mntninfopoflc")) {	//실행부가 산의 위치를 지나간다고 표시
			isMntninfopoflc=false;
		}else if(tag.equals("mntninfohght")) {	//실행부가 산의 높이를 지나간다고 표시
			isMntninfohght=false;
		}else if(tag.equals("item")) {	//닫는 item을 만나면, 벡터에 VO 담기
			mtList.add(mt);
		}
	}
	
	//문서가 끝나면 확인해본다
	@Override
	public void endDocument() throws SAXException {
		//벡터에 담겨진 갯수 및 내용 출력
		System.out.println("검색된 산의 갯수는 "+mtList.size());
		
		for(int i=0; i<mtList.size(); i++) {
			Mountain obj = mtList.get(i);
			System.out.println("산 ID : "+obj.getMntnid());
			System.out.println("산이름 : " +obj.getMntnnm());
			System.out.println("산위치 : "+obj.getMntninfopoflc());
			System.out.println("산높이 : "+obj.getMntninfohght());
			System.out.println("-------------------------------------------------------");
		}
	}
	
	
}
