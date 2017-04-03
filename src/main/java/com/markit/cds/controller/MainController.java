package com.markit.cds.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.markit.cds.cache.CacheLocalConfig;
import com.markit.cds.domain.City;

@RestController
public class MainController {

    private String cityId;
    private String checkInDate;
    private String checkOutDate;

    @RequestMapping(value = "/getAllCities", method = RequestMethod.GET)
    public List<City> fetchAvailableTables() throws IOException {
	List<City> cityList = MainController.readCsv();
	CacheLocalConfig.putInCache("cacheList", cityList);
	return cityList;
    }

    @RequestMapping(value = "/getPriceDetails", method = RequestMethod.GET)
    public List<City> fetchpriceDetails(String cityId, String checkInDate, String checkOutDate) throws IOException {
	
	try {
	    List<Object> test= new ArrayList<Object>();
	    URL url = new URL("http://developer.goibibo.com/api/cyclone/?app_id=4663135e&app_key=73a217a9461375e465dd4be077800f32&city_id=" + cityId
		    + "&check_in=" + checkInDate + "&check_out=" + checkOutDate + "");
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Accept", "application/json");

	    if (conn.getResponseCode() != 200) {
		throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	    }

	    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

	    String output;
	    System.out.println("Output from Server .... \n");
	    while ((output = br.readLine()) != null) {
		System.out.println(output);
		test.add(output);
	    }
	    CacheLocalConfig.putInCache("cacheListWithPrice", test);
	    conn.disconnect();

	} catch (MalformedURLException e) {

	    e.printStackTrace();

	} catch (IOException e) {

	    e.printStackTrace();

	}
	return null;

    }
    public List<City> fetchpriceDetailsByCity(){
	return null;
	
	
    }
    
    
    @SuppressWarnings("resource")
    public static List<City> readCsv() throws IOException {
	// open file input stream
	BufferedReader reader = new BufferedReader(new FileReader("city_list.csv"));

	// read file line by line
	String line = null;
	Scanner scanner = null;
	int index = 0;
	List<City> cityList = new ArrayList<>();

	while ((line = reader.readLine()) != null) {
	    City city = new City();
	    scanner = new Scanner(line);
	    scanner.useDelimiter(",");
	    while (scanner.hasNext()) {
		String data = scanner.next();
		if (index == 0)
		    city.setCityName(data.substring(1, data.length() - 1));
		else if (index == 1)
		    city.setCityId(data.substring(1, data.length() - 1));
		index++;
	    }
	    index = 0;
	    cityList.add(city);
	}

	// close reader
	reader.close();
	return cityList;
    }

    public String getCityId() {
	return cityId;
    }

    public String getCheckInDate() {
	return checkInDate;
    }

    public String getCheckOutDate() {
	return checkOutDate;
    }

    public void setCityId(String cityId) {
	this.cityId = cityId;
    }

    public void setCheckInDate(String checkInDate) {
	this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(String checkOutDate) {
	this.checkOutDate = checkOutDate;
    }
}
