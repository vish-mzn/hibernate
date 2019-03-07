package com.Project.Dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.Project.Model.Book;

public class BookDAO extends BaseEntity
{
	public BookDAO(){
		
	}
	
	public Boolean createBook(Book b)
	{
		try 
		{
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
			closeEntityManagerFactory();
		}
		return true;
	}
	
	public void deleteBook(int id)
	{
		try
		{
			em = getEntityManager();
			em.getTransaction().begin();
			Book book = em.find(Book.class, id);
			if(book!=null){
				em.remove(book);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
			closeEntityManagerFactory();
		}
		
	}
	
	public List<Book> listAllBooks()
	{
		List<Book> list = null;
		try
		{
			em = getEntityManager();
			TypedQuery<Book> query = em.createQuery("from Book", Book.class);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
			closeEntityManagerFactory();
		}
		return list;
	}

	public Book getBook(int id) 
	{
		Book b = null;
		try {
			em = getEntityManager();
			b = em.find(Book.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
			closeEntityManagerFactory();
		}
		return b;
	}

	public void updateBook(int id, String title, String author, float price) 
	{
		try 
		{
			em = getEntityManager();
			em.getTransaction().begin();
			Book updateBook = em.find(Book.class, id);
			updateBook.setTitle(title);
			updateBook.setAuthor(author);
			updateBook.setPrice(price);
			//em.merge(updateBook);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
			closeEntityManagerFactory();
		}
	}
	
}
