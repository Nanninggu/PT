package com.example.HexagonalArchitecture.adapter.function.wheather;

import com.example.HexagonalArchitecture.adapter.config.Config;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WheatherToEmail {

    Config config = new Config();

    public String WheatherToEmailMethod() {

        try {
            // RSS 주소
            String rssUrl = "https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109";

            // HTTP 연결 생성
            HttpURLConnection con = (HttpURLConnection) new URL(rssUrl).openConnection();
            con.setRequestMethod("GET");

            // 응답 받기
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // XML 파싱
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(rssUrl);

            // 원하는 데이터 추출
            NodeList itemList = doc.getElementsByTagName("location");
            for (int i = 0; i < itemList.getLength(); i++) {
                Element item = (Element) itemList.item(i);
                String city = item.getElementsByTagName("city").item(0).getTextContent();
                if (city.equals("서울")) {
                    NodeList data = item.getElementsByTagName("data");

                    String tmEf = item.getElementsByTagName("tmEf").item(0).getTextContent();
                    String wf = item.getElementsByTagName("wf").item(0).getTextContent();
                    String tmn = item.getElementsByTagName("tmn").item(0).getTextContent();
                    String tmx = item.getElementsByTagName("tmx").item(0).getTextContent();

                    String return_value =
                            "서울 날씨 정보: ⚡ ⛅ ⭐ \uD83C\uDF08 " + "\n"
                                    + "------------------------------------------------" + "\n"
                                    + "날짜 및 시간 \uD83D\uDD62 : " + tmEf + "\n"
                                    + "날씨 \uD83D\uDD06 : " + wf + "\n"
                                    + "최저 기온 \uD83D\uDCA7 : " + tmn + "\n"
                                    + "최고 기온 ☀ : " + tmx + "\n"
                                    + "------------------------------------------------";
                    config.GetRerutnValueForEmail(return_value);
                    String valuecheck = config.GetRerutnValueForEmail(return_value);
                    System.out.println(valuecheck);

                    return return_value;
                }
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        return "Success";
    }
}