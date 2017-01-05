package it.alarit.api.service;

import org.springframework.stereotype.Service;

import it.alarit.api.model.AbstractModel;

@Service
public class GenericService {
	
	public <T extends AbstractModel> T findById(T t, final Long id) throws Exception{
		if(id == null) throw new NullPointerException();
		return t;
	}
	
	public <T extends AbstractModel> T save(T t){
		return t;
	}
	
	public <T extends AbstractModel> void delete(T t) throws Exception{
		if(t.getId() == null) throw new NullPointerException();
	}
	
}