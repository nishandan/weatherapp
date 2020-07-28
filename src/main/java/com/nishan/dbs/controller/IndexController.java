package com.nishan.dbs.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nishan.dbs.model.City;
import com.nishan.dbs.model.Weather;
import com.nishan.dbs.repo.WeatherRepository;
import com.nishan.dbs.service.WeatherService;

import lombok.extern.log4j.Log4j2;


@Controller
@RequestMapping({ "/", "/index" })
@Log4j2
public class IndexController {

	@Autowired
	WeatherService wService;

	@Autowired
	WeatherRepository wRepo;

	@GetMapping
	public String main(Model model) {
		model.addAttribute("weather", new Weather());
		return "index";
	}

	@PostMapping
	public String save(Weather weather, Model model) {

		try {

			Optional<Weather> res = wRepo.findById(weather.getCity());

			if (!res.isPresent()) {
				log.info("Record is NOT available on DB. Call the APi to get the data");
				
				// call the API
				String apiRes = wService.getWeather(City.valueOf(weather.getCity()));
				
				weather.setTemp(apiRes);
				weather.setCreatedOn(new Date());
				
				wRepo.save(weather);
				
			}else {
				log.info("Record is available on DB");
				weather.setTemp(res.get().getTemp());
			}

			model.addAttribute("weather", weather);
			
			return "saved";

		}catch (Exception e) {
			log.error(e);
			return "error";
		}
	}
}