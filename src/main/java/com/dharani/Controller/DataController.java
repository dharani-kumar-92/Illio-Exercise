package com.dharani.Controller;

import com.dharani.Model.Data;
import com.dharani.Service.HistoricalDataFromJson;
import com.dharani.Service.HistoricalDataURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.OptionalDouble;

@RestController
public class DataController {

    @Autowired
    HistoricalDataURL historicalDataURL;

    @Autowired
    HistoricalDataFromJson historicalDataFromJson;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public OptionalDouble getBySimplePath() {
        return historicalDataURL.getAverageRange("","","");
    }

    @RequestMapping(value = "/getJson", method = RequestMethod.GET)
    public OptionalDouble getFromJson(){
        return historicalDataFromJson.getAverageRange("","","");
    }
}

