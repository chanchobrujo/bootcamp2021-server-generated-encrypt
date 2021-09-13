package com.everisbootcamp.servergeneratedencrypt.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;

import reactor.core.publisher.Mono;

public class Service {
	public Mono<String> generatedNumber(int size){
		String chain = "";
		Random random = new Random();
		try {
			char[] digits = new char[size];
			digits[0] = (char) (random.nextInt(9) + '1');

			for (int i = 1; i < size; i++) 
				digits[i] = (char) (random.nextInt(10) + '0'); 

			chain = Long.parseLong(new String(digits)) + "";
		} catch (Exception e) { 
			return Mono.just(null);
		}
		return Mono.just(chain);
	}
	
	public Mono<String> encriptPassword(String password){ 
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			byte[] messageDigest = md.digest(password.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

			return Mono.just(hashtext);
		} catch (Exception e) {
			return Mono.just(null);
		}
	}
}
