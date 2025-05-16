package com.jaimetorres.repo.gestor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
//@Repository
public interface IGenericRepo<T , ID> extends JpaRepository<T , ID>{

}
