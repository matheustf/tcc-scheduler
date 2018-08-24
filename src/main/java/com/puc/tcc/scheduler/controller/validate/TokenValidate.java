package com.puc.tcc.scheduler.controller.validate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.puc.tcc.scheduler.consts.Constants;
import com.puc.tcc.scheduler.exceptions.SchedulerException;
import com.puc.tcc.scheduler.utils.Util;

@Component
public class TokenValidate {

	public void tokenValidate(String token) throws SchedulerException {
		String idCadastro = Util.getPagameterToken(token, "idCadastro");

		if (StringUtils.isBlank(idCadastro)) {
			throw new SchedulerException(HttpStatus.UNAUTHORIZED, Constants.UNAUTHORIZED);
		}

	}
	
	public void tokenSimpleValidate(String token) throws SchedulerException {
		if (StringUtils.isBlank(token)) {
			throw new SchedulerException(HttpStatus.UNAUTHORIZED, Constants.UNAUTHORIZED);
		}
	}

	public void tokenValidateCliente(String token, String idCliente) throws SchedulerException {
		String idCadastro = Util.getPagameterToken(token, "idCadastro");

		if (!isTokenCorreto(idCadastro, idCliente)) {
			throw new SchedulerException(HttpStatus.UNAUTHORIZED, Constants.UNAUTHORIZED);
		}

	}

	private boolean isTokenCorreto(String idCadastro, String idCliente) {
		return StringUtils.isNotBlank(idCadastro) && idCadastro.equals(idCliente);
	}

}
