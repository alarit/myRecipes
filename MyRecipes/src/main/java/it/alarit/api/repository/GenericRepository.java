package it.alarit.api.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import it.alarit.api.model.AbstractModel;

@NoRepositoryBean
public interface GenericRepository<T extends AbstractModel, PK extends Serializable> extends JpaRepository<T, PK> {
	
	@Transactional(readOnly = true)
	public T findOneById(@Param("id") PK id);
	
	@Transactional(readOnly = true)
	@Query("FROM #{#entityName} t ")
	public List<T> findAll();

}
