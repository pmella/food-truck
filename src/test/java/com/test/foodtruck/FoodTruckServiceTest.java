package com.test.foodtruck;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FoodTruckServiceTest {

    @Autowired
    private FoodTruckService foodTruckService;

    @Test
    public void testFindTheListOfThe5NearbyFoodTrucks() {

        Point vertex = new Point(37.7806943774082, -122.41);
        List<Map<String, String>> list = foodTruckService.findTheListOfTheKNearbyFoodTrucks(vertex, 5);

        System.out.println(list.get(0).get("distanceToVertex"));
        System.out.println(list.get(1).get("distanceToVertex"));
        System.out.println(list.get(2).get("distanceToVertex"));
        System.out.println(list.get(3).get("distanceToVertex"));
        System.out.println(list.get(4).get("distanceToVertex"));

        assert(Double.parseDouble(list.get(0).get("distanceToVertex")) <= Double.parseDouble(list.get(1).get("distanceToVertex")));
        assert(Double.parseDouble(list.get(1).get("distanceToVertex")) <= Double.parseDouble(list.get(2).get("distanceToVertex")));
        assert(Double.parseDouble(list.get(2).get("distanceToVertex")) <= Double.parseDouble(list.get(3).get("distanceToVertex")));
        assert(Double.parseDouble(list.get(3).get("distanceToVertex")) <= Double.parseDouble(list.get(4).get("distanceToVertex")));
    }
}