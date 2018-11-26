package com.netease.cloud.nsf.demo.stock.viewer.web.service.impl;

import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.netease.cloud.nsf.demo.stock.viewer.web.service.IRandomService;

@Service
public class RandomServiceImpl implements IRandomService{

	Random random = new Random();
	
	@Override
	public int getRandomNumber() {
		return random.nextInt();
	}

	@Override
	public String getRanomString() {
		return UUID.randomUUID().toString();
	}

}
