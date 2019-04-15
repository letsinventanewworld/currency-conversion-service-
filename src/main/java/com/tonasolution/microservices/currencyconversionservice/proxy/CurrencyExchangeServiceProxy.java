package com.tonasolution.microservices.currencyconversionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tonasolution.microservices.currencyconversionservice.models.CurrencyConversionBean;

@FeignClient(name="currency-exchange-service", url="localhost:8000")
public interface CurrencyExchangeServiceProxy {
	

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retreiveExchangeValue(
				@PathVariable("from") String from, 
				@PathVariable("to") String to
			);
	
}
