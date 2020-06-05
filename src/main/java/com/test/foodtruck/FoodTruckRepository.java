package com.test.foodtruck;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

@Repository
public class FoodTruckRepository {

    private List<Map<String, String>> list = null;

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodTruckRepository.class);

    @Value("${database.url}")
    private String urlString;

    @PostConstruct
    @Scheduled(fixedDelay = 5000)
    private void loadData() {

        LOGGER.info("retrieving data from source.");

        try {

            final URL url = new URL(getUrlString());
            final InputStream input = url.openStream();
            final CsvSchema csv = CsvSchema.emptySchema().withHeader();
            final CsvMapper csvMapper = new CsvMapper();
            final MappingIterator<Map<String, String>> mappingIterator = csvMapper.reader().forType(Map.class).with(csv)
                    .readValues(input);
            this.setList(mappingIterator.readAll());
            LOGGER.info("data successfully retrieved.");
        } catch (Exception e) {
            LOGGER.error("error retrieving data.", e);
        }

    }

    public String getUrlString() {
        return urlString;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    public List<Map<String, String>> getList() {
        return list;
    }

    public void setList(final List<Map<String, String>> list) {
        this.list = list;
    }

}