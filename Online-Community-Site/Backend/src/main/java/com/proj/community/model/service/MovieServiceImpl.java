package com.proj.community.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.community.model.dao.MovieDao;
import com.proj.community.model.dto.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao movieDao;

	@Override
	public Movie get(int id) {
		return movieDao.read(id);
	}

	@Override
	public boolean add(Movie movie) {
		return movieDao.insert(movie) == 1;
	}

	@Override
	public boolean modify(Movie movie) {
		return movieDao.update(movie) == 1;
	}

	@Override
	public boolean remove(int id) {
		return movieDao.delete(id) == 1;
	}

	@Override
	public List<Movie> SearchByTitle(String word) {
		return movieDao.searchByTitle(word);
	}

	@Override
	public List<Movie> getList() {
		return movieDao.readAll();
	}

	@Override
	public void getData(List<Movie> movieList) {
		for (int i = 0; i < movieList.size(); i++) {
			movieDao.insert(movieList.get(i));
		}
	}
}
