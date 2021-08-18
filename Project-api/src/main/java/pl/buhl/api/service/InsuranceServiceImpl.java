package pl.buhl.api.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.buhl.api.model.Insurance;
import pl.buhl.api.repository.InsuranceRepository;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService{

    @Autowired
    InsuranceRepository insuranceRepository;

    @Override
    public List<Insurance> getAll() {
        return insuranceRepository.findAll();
    }

    @Override
    public void insert(String param) {
        Gson gson = new Gson();
        Type userListType = new TypeToken<List<Insurance>>(){}.getType();
        List<Insurance> insurances = gson.fromJson(param, userListType);
        for(Insurance row : insurances) insuranceRepository.save(row);
    }

    @Override
    public void deleteAll() {
        insuranceRepository.deleteAll();;
    }

}
