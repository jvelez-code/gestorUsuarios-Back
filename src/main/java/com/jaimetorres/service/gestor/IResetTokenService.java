package com.jaimetorres.service.gestor;

import com.jaimetorres.model.gestor.ResetToken;

public interface IResetTokenService {

	ResetToken findByToken(String token);
	
	void guardar(ResetToken token);
	
	void eliminar(ResetToken token);

}
