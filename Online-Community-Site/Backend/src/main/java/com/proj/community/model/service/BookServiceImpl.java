package com.proj.community.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.community.model.dao.BookDao;
import com.proj.community.model.dto.Book;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;

	@Override
	public List<Book> getListByCategory(String category) {
		return bookDao.readCategory(category);
	}

	@Override
	public List<Book> search(String word) {
		return bookDao.search(word);
	}

	@Override
	public Book get(int id) {
		return bookDao.read(id);
	}

	@Override
	public boolean add(Book book) {
		return bookDao.create(book) == 1;
	}

	@Override
	public boolean modify(Book book) {
		return bookDao.update(book) == 1;
	}

	@Override
	public boolean remove(int id) {
		return bookDao.delete(id) == 1;
	}

	@Override
	public void getData(List<Book> bookList) {
		for (int i = 0; i < bookList.size(); i++) {
			bookDao.create(bookList.get(i));
		}
		
	}
	
	

	
	
}
