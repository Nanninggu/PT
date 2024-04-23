package com.example.HexagonalArchitecture.adapter.function.wheather;

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
import java.net.URL;

public class GetInfoWheather {
    {

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
                    System.out.println("서울 날씨 정보:");
                    NodeList data = item.getElementsByTagName("data");
                    for (int j = 0; j < data.getLength(); j++) {
                        Element weatherData = (Element) data.item(j);
                        String tmEf = weatherData.getElementsByTagName("tmEf").item(0).getTextContent();
                        String wf = weatherData.getElementsByTagName("wf").item(0).getTextContent();
                        String tmn = weatherData.getElementsByTagName("tmn").item(0).getTextContent();
                        String tmx = weatherData.getElementsByTagName("tmx").item(0).getTextContent();
                        System.out.println("날짜 및 시간: " + tmEf);
                        System.out.println("날씨: " + wf);
                        System.out.println("최저 기온: " + tmn);
                        System.out.println("최고 기온: " + tmx);
                        System.out.println("--------------------------");
                    }
                }
            }

        } catch (IOException | ParserConfigurationException |
                 SAXException e) {
            e.printStackTrace();
        }
    }
}
