package com.project.Controller;

import com.project.Model.Data;
import com.project.Service.Dataservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.OptionalDouble;

@RestController
public class DataController {

    @Autowired
    Dataservice dataservice;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getBySimplePath(@RequestParam String from,@RequestParam String to) {
        return dataservice.getData(from,to,"");
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteData() {
        return dataservice.deleteRepo();
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Data> getData() {
        return dataservice.queryDatabase();
    }
    @RequestMapping(value = "/getAverage", method = RequestMethod.GET)
    public OptionalDouble getAverageValue(){
        return dataservice.getAverageRange();
    }
}

