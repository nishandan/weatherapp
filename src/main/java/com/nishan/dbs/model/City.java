package com.nishan.dbs.model;

import lombok.Getter;

@Getter
public enum City {

	Campbell(37.2876,-121.9424),
	Omaha(41.2565,-95.9345),
	Austin(30.2672,97.7431),
	Niseko(42.8048,140.6874),
	Nara(34.6851,135.8048),
	Jakarta(6.2088,106.8456);

	private final double longt;
	private final double latt;

	private City(double longt,double latt) {
		this.longt = longt;
		this.latt = latt;
	}

}
