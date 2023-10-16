package com.proj.community.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.community.model.dao.ArticleDao;
import com.proj.community.model.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleDao articleDao;

	@Override
	public List<Article> search(String category, String searchTarget, String word) {
		return articleDao.search(category, searchTarget, word);
	}

	@Override
	public List<Article> getList() {
		return articleDao.readAll();
	}

	@Override
	public Article get(int id) {
		return articleDao.read(id);
	}

	@Override
	public boolean add(Article article) {
		return articleDao.create(article) == 1;
	}

	@Override
	public boolean modify(Article article) {
		return articleDao.update(article) == 1;
	}

	@Override
	public boolean remove(int id) {
		return articleDao.delete(id) == 1;
	}

	@Override
	public List<Article> searchByWriter(String nickname) {
		return articleDao.searchByWriter(nickname);
	}

	@Override
	public List<Article> getCategory(String category, String sortTarget) {
		return articleDao.readCategory(category, sortTarget);
	}
	
}
