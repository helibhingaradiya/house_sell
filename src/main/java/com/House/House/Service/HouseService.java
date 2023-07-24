package com.House.House.Service;

import com.House.House.Model.AverageGroupByLocation;
import com.House.House.Model.House;
import com.House.House.Model.Response;
import com.House.House.Repository.HouseRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService {
    @Autowired
    private HouseRepository houseRepository;
    public List<House> saveALLHouse(List<House> houses) {
        return houseRepository.saveAll(houses);
    }

    public House createHouse(House house) {
        return houseRepository.save(house);
    }

    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    public ResponseEntity<Response> getMaxSalePrice() {
        Response response = new Response();
        ResponseEntity<Response> responseResponseEntity;
        try {
            Gson gson = new Gson();
            double max = houseRepository.getMaxSalePrice();
            response.setRequestBody(gson.toJson(max));
            response.setMessage("getting max Seling price!!");
            responseResponseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            responseResponseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseResponseEntity;
    }

    public ResponseEntity<Response> getMinSalePrice() {
        Response response = new Response();
        ResponseEntity<Response> responseResponseEntity;
        try {
            Gson gson = new Gson();
            double min = houseRepository.getMinSalePrice();
            response.setRequestBody(gson.toJson(min));
            response.setMessage("getting min Seling price!!");
            responseResponseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            responseResponseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseResponseEntity;
    }
    public ResponseEntity<Response> getAverageSalePriceOverall() {
        Response response = new Response();
        ResponseEntity<Response> responseResponseEntity;
        try {
            Gson gson = new Gson();
            double avg = houseRepository.getAverageSalePriceOverall();
            response.setRequestBody(gson.toJson(avg));
            response.setMessage("getting average Seling price!!");
            responseResponseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            responseResponseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseResponseEntity;
    }

    public ResponseEntity<Response> getAverageSalePerLocation() {
        Response response = new Response();
        ResponseEntity<Response> responseResponseEntity;
        try {
            Gson gson = new Gson();
            List<Object[]> list = houseRepository.getAverageSalePerLocation();
            List<AverageGroupByLocation> res = new ArrayList<>();
            for (Object[] objects : list) {
                AverageGroupByLocation averageGroupByLocation = new AverageGroupByLocation();
                averageGroupByLocation.setLocation(objects[0].toString());
                averageGroupByLocation.setAverage((Double) objects[1]);
                res.add(averageGroupByLocation);
            }
            response.setRequestBody(gson.toJson(res));
            response.setMessage("Getting Successfully!!!!");
            responseResponseEntity = new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e){
            responseResponseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseResponseEntity;
    }
}
