package pl.buhl.api.service;

import pl.buhl.api.model.Insurance;

import java.util.List;


public interface InsuranceService {
    public List<Insurance> getAll();
    public void insert(String param);
    public void deleteAll();
}