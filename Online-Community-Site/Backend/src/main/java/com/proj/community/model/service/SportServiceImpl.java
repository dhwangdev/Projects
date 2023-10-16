package com.proj.community.model.service;

import java.util.List;

import com.proj.community.model.dto.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.community.model.dao.SportDao;

@Service
public class SportServiceImpl implements SportService{

	@Autowired
	private SportDao sportDao;

	@Override
	public List<Sport> searchByTitle(String word) {
		return sportDao.search(word);
	}

	@Override
	public List<Sport> getByCategory(String category, String target, String direction) {
		// TODO Auto-generated method stub
		return sportDao.readCategory(category, target, direction);
	}

	@Override
	public Sport get(int id) {
		// TODO Auto-generated method stub
		return sportDao.read(id);
	}

	@Override
	public boolean add(Sport sport) {
		// TODO Auto-generated method stub
		return sportDao.create(sport) == 1;
	}

	@Override
	public boolean modify(Sport sport) {
		// TODO Auto-generated method stub
		return sportDao.update(sport) == 1;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return sportDao.delete(id) == 1;
	}

	
	
	
	
	
}
