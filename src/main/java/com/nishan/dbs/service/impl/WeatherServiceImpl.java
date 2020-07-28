/**
 * 
 */
package com.nishan.dbs.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nishan.dbs.model.City;
import com.nishan.dbs.service.WeatherService;

import lombok.extern.log4j.Log4j2;

/**
 * @author nishandan.gobalakris
 *
 */
@Service
@Component
@Log4j2
@PropertySource("classpath:application.properties")
public class WeatherServiceImpl implements WeatherService {

	@Value("${darksky.api.url}")
	private String apiURL;

	@Value("${darksky.api.secret}")
	private String apiSecret;
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	@Override
	public String getWeather(City city) {
		
		log.info("In getWeather");
		
		String apiRequest = apiURL + apiSecret + "/" + city.getLongt() +"," + city.getLatt() + "?exclude=currently,minutely,hourly,alerts,flags";
		log.info("apiRequest : " + apiRequest);
		
		String result = restTemplate().getForObject(apiRequest, String.class);
		
		return result;
	}

}
