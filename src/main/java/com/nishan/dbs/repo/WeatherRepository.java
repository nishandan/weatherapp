	/**
 * 
 */
package com.nishan.dbs.repo;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.nishan.dbs.model.Weather;

/**
 * @author nishandan.gobalakris
 *
 */
public interface WeatherRepository extends MongoRepository<Weather, String> {

    @Transactional
    public void deleteByCreatedOnBefore(Date expiryDate);
	
}
