//1
package day1116.pubapi;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

//코드를 붙여넣고, 클래스명은 MountainApp으로 바꾸기
/*	이제 아래의 샘플코드에서 내가 보유한 api key로 바꿔야 한다
	api key 복사해 오기!
*/
public class MountainApp {
    public static void main(String[] args) throws IOException {
    	//키값 복사해서 넣기
    	String apiKey = "";	//메모장에 있음!
    	
    	//'서비스키' 대신에 apiKey 넣기!
    	//주의할 점은 아래의 StingBuilder에 적힌 주소가, 공공데이터포털 개발자의 실수로 가끔 옳지 않을 수 있다
    	//그래서 주소를 비교해보는것이 중요! (같아야 한다)
    	//http://openapi.forest.go.kr/openapi/service/trailInfoService/getforeststoryservice (홈페이지 기재 url)
    	//http://openapi.forest.go.kr/openapi/service/trailInfoService/getforeststoryservice (샘플코드 url)
    	//잘 나오긴 하지만 식별성이 떨어지므로 이클립스 xml 문서로 복사해서 쓰자
    	//이제 이 xml을 파싱하자. 아래의 xml은 그냥 xml이기 떄문에 원하는 데이터로 재가공 하자... 클래스하나 만들어서
        StringBuilder urlBuilder = new StringBuilder("http://openapi.forest.go.kr/openapi/service/trailInfoService/getforeststoryservice"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+apiKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("mntnNm","UTF-8") + "=" + URLEncoder.encode("지리산", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("mntnHght","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("mntnAdd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("mntnInfoAraCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("mntnInfoSsnCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("mntnInfoThmCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}
