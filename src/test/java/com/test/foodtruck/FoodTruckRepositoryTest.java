package com.test.foodtruck;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FoodTruckRepositoryTest {

    @Autowired
    private FoodTruckRepository foodTruckRepository;

    @Test
    public void testGetList() {

        List<Map<String, String>> list = foodTruckRepository.getList();

        assertEquals(list.get(0).get("locationid"), "1334734");
        assertEquals(list.get(0).get("Latitude"), "37.7806943774082");
        assertEquals(list.get(0).get("Longitude"), "-122.409668813219");

        assertEquals(list.size(), 9);

    }

}