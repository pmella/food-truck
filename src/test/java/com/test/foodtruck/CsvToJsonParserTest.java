package com.test.foodtruck;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import org.junit.jupiter.api.Test;

public class CsvToJsonParserTest {

   @Test
   public void testCsvToJsonParsing() throws IOException {

      String path = "src/test/resources/database.csv";

      File file = new File(path);
      String absolutePath = file.getAbsolutePath();

      File input = new File(absolutePath);

      CsvSchema csv = CsvSchema.emptySchema().withHeader();
      CsvMapper csvMapper = new CsvMapper();
      MappingIterator<Map<String, String>> mappingIterator = csvMapper.reader().forType(Map.class).with(csv).readValues(input);
      List<Map<String, String>> list = mappingIterator.readAll();

      assertEquals(list.get(0).get("locationid"), "1334734");
      assertEquals(list.get(0).get("Latitude"), "37.7806943774082");
      assertEquals(list.get(0).get("Longitude"), "-122.409668813219");

      assertEquals(list.size(), 9);

   }
}