package com.test.foodtruck;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HaversineTest {

    @Test
    public void testHaversineCalculationBewtween2Coordinates(){
        double lat1 = 51.5007; 
		double lon1 = 0.1246; 
		double lat2 = 40.6892; 
		double lon2 = 74.0445; 
		assertEquals(Haversine.distance(lat1, lon1, lat2, lon2), 5574.840456848554); 

    }

    @Test
    public void testHaversineCalculationBewtween2EqualCoordinates(){
        double lat1 = -122.409668813219; 
		double lon1 = 37.7806943774082; 
		double lat2 = -122.409668813219; 
		double lon2 = 37.7806943774082; 
		assertEquals(Haversine.distance(lat1, lon1, lat2, lon2), 0); 

    }

}