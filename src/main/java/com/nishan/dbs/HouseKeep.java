/**
 * 
 */
package com.nishan.dbs;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nishan.dbs.repo.WeatherRepository;

import lombok.extern.log4j.Log4j2;

/**
 * @author nishandan.gobalakris
 *
 */
@Component
@Log4j2
public class HouseKeep {

	@Autowired
	WeatherRepository wRepo;

	@Scheduled(cron = "0 12 5 * * ?") //at 12:05 AM every day
	public void houseKeep() {
		log.info("houseKeep process start");

		try {

			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -3);

			wRepo.deleteByCreatedOnBefore(cal.getTime());

		} catch (Exception e) {
			log.error(e);
		}
	}

}
