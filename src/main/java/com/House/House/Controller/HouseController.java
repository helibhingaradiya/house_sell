package com.House.House.Controller;

import com.House.House.Model.House;
import com.House.House.Model.Response;
import com.House.House.Repository.HouseRepository;
import com.House.House.Service.HouseService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/house")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private HouseRepository houseRepository;

    @GetMapping("/getAll")
    public List<House> getAllHouses() {
        return houseService.getAllHouses();
    }

    @PostMapping("/addHouse")
    public House createHouse(@RequestBody String house_sell) {
        Gson gson = new Gson();
        House house = gson.fromJson(house_sell, House.class);
        return houseService.createHouse(house);
    }
    @PostMapping("/saveAllHouses")
    public List<House> saveALLHouse(@RequestBody List<House> houses) {
        return houseService.saveALLHouse(houses);
    }
    @GetMapping("/averageSalePriceOverall")
    public ResponseEntity<Response> getAverageSalePriceOverall() {

        return houseService.getAverageSalePriceOverall();
    }

    @GetMapping("/averageSalePricePerLocation")
    public ResponseEntity<Response> getAverageSalePerLocation() {
        return houseService.getAverageSalePerLocation();
    }

    @GetMapping("/maxSalePrice")
    public ResponseEntity<Response> getMaxSalePrice() {
        return houseService.getMaxSalePrice();
    }

    @GetMapping("/minSalePrice")
    public ResponseEntity<Response> getMinSalePrice() {

        return houseService.getMinSalePrice();
    }


}
