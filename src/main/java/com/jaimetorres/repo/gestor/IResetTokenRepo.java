package com.jaimetorres.repo.gestor;

import com.jaimetorres.model.gestor.ResetToken;

public interface IResetTokenRepo extends IGenericRepo<ResetToken, Integer>{
	
	//from ResetToken rt where rt.token = :?
	ResetToken findByToken(String token);

}
