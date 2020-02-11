package com.dharani.Service;

import com.dharani.Model.Data;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Service
public class HistoricalDataURL implements DataSource {

    @Value("${base_url}")
    private String base_url;

    @Value("${api_token}")
    private String api_token;

    @Value("${period}")
    private String period;

    @Value("${fmt}")
    private String fmt;

    public String createURL(String from,String to,String ticker){
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        from="2019-01-01";
        to="2019-12-01";
        ticker= "AAPL.US";
        queryParams.add("api_token",api_token);
        queryParams.add("period",period);
        queryParams.add("fmt",fmt);
        queryParams.add("from",from.toString());
        queryParams.add("to",to.toString());

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(base_url+ticker).queryParams(queryParams);
        System.out.println(uriBuilder.toUriString());
        return uriBuilder.toUriString();
    }

    public OptionalDouble getAverageRange(String start, String end, String ticker){
        String urlInfo = createURL(start, end, ticker);
        List<Data> pricesBetween = getResponseFromURL(urlInfo);
        List<Double> averages = new ArrayList<>();
        //Using OHLC per day
        Iterator<Data> iter = pricesBetween.iterator();
        while (iter.hasNext()) {
            Data data = iter.next();
            double averagePerDay = ((data.getOpen()+data.getLow()+data.getHigh()+data.getAdjusted_close())/4);
            averages.add(averagePerDay);
        }
        OptionalDouble value = averages.stream().mapToDouble(Double::doubleValue).average();
        return value;
    }

    public List<Data> getResponseFromURL(String urlInfo){

        ObjectMapper objectMapper = new ObjectMapper();
        List<Data> dataList=null;
        try {
            URL url = new URL(urlInfo);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            String json = new Scanner(inStream, "UTF-8").useDelimiter("\\Z").next();
            dataList = objectMapper.readValue(json, new TypeReference<List<Data>>() {});

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }
}
