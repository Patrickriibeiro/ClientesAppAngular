package com.pro.ClienteApp.utils;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class BigDecimalConverter {

	public BigDecimal bigDecimalConverter(String valor) {
		
		if (valor != null) {
			valor = valor.replace(".", "").replace(",", ".");
			return new BigDecimal(valor);
		}
		return null;
	}

}
