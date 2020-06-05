package com.test.foodtruck;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodTruckController {

    private final FoodTruckService service;

    private final double defaultLatitude = 37.7806943774082;

    private final double defaultLongitude = -122.409668813219;

    public FoodTruckController(FoodTruckService service) {
        this.service = service;
    }

    public double getDefaultLongitude() {
        return defaultLongitude;
    }

    public double getDefaultLatitude() {
        return defaultLatitude;
    }

    @GetMapping("/get5NearbyFoodTrucks")
    public List<Map<String, String>> get5NearbyFoodTrucks(@RequestParam(value = "latitude", defaultValue = "0") String latitude,
            @RequestParam(value = "longitude", defaultValue = "0") String longitude) throws MalformedURLException {

        Point p = new Point(Double.parseDouble(latitude), Double.parseDouble(longitude));
        return service.findTheListOfTheKNearbyFoodTrucks(p, 5);
    }

    @PostMapping("/post5NearbyFoodTrucks")
    public List<Map<String, String>> post5NearbyFoodTrucks(@RequestBody Point p) throws MalformedURLException {
        return service.findTheListOfTheKNearbyFoodTrucks(p, 5);
    }

    

}