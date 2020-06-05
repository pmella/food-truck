package com.test.foodtruck;

import java.net.MalformedURLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final FoodTruckController foodTruckController;

    public HomeController(FoodTruckController foodTruckController) {
        this.foodTruckController = foodTruckController;
    }

    @GetMapping("/home")
    public String home( @RequestParam(name="defaultLatitude", required=false, defaultValue="37.7806943774082") String defaultLatitude, 
                        @RequestParam(name="defaultLongitude", required=false, defaultValue="-122.409668813219") String defaultLongitude,
                        Model model) throws MalformedURLException {
        
        model.addAttribute("defaultLatitude", Double.parseDouble(defaultLatitude));
        model.addAttribute("defaultLongitude", Double.parseDouble(defaultLongitude));

        foodTruckController.get5NearbyFoodTrucks(model.getAttribute("defaultLatitude").toString() , model.getAttribute("defaultLongitude").toString());
        
        return "home";
	}

}