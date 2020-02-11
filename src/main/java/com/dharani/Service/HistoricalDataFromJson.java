package com.dharani.Service;

import com.dharani.Model.Data;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class HistoricalDataFromJson implements DataSource {

    public List<Data> getDataFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Data> dataList = null;
        try {
            dataList = objectMapper.readValue(new File("src/main/resources/data.json"), new TypeReference<List<Data>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    @Override
    public OptionalDouble getAverageRange(String start, String end, String ticker) {
        List<Data> pricesBetween = getDataFromJson();
        List<Double> averages = new ArrayList<>();
        //Using OHLC per day
        Iterator<Data> iter = pricesBetween.iterator();
        while (iter.hasNext()) {
            Data data = iter.next();
            double averagePerDay = ((data.getOpen()+data.getLow()+data.getHigh()+data.getAdjusted_close())/4);
            averages.add(averagePerDay);
            System.out.println(averagePerDay);
        }

        OptionalDouble value = averages.stream().mapToDouble(Double::doubleValue).average();
        return value;
    }
}
