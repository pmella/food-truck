package com.test.foodtruck;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class FoodTruckService {

    public Comparator<Map<String, String>> mapComparator = new Comparator<Map<String, String>>() {
        public int compare(Map<String, String> m1, Map<String, String> m2) {

            double p1 = Double.parseDouble(m1.get("distanceToVertex"));
            double p2 = Double.parseDouble(m2.get("distanceToVertex"));
            return p1 < p2 ? -1 : p1 == p2 ? 0 : 1;
        }
    };

    private final FoodTruckRepository repository;

    public FoodTruckService(final FoodTruckRepository repository) {
        this.repository = repository;
    }

    public FoodTruckRepository getRepository() {
        return repository;
    }

    public List<Map<String, String>> findTheListOfTheKNearbyFoodTrucks(final Point vertex, int k) {

        final List<Map<String, String>> list = repository.getList();

        if (list != null) {
            for (final Map<String, String> map : list) {
                final Point destination = new Point(Double.parseDouble(map.get("Latitude").toString()),
                        Double.parseDouble(map.get("Longitude").toString()));
                map.put("distanceToVertex", Haversine.distance(vertex.getLatitude(), vertex.getLongitude(), destination.getLatitude(), destination.getLongitude())+"");
            }
            Collections.sort(list, mapComparator);

            return list.subList(0, k);
        }
        else{
            throw new DataNotAvailableException();
        }
    }

}