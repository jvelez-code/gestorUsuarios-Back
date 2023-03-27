package com.jaimetorres.repo.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;


@NoRepositoryBean
//@Repository
public interface IGenericContactRepo<T , ID> extends JpaRepository<T , ID>{

}
