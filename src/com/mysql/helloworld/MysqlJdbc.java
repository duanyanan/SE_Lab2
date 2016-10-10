package com.mysql.helloworld;


import java.util.*;


public class MysqlJdbc {
	private Connect con = new Connect();
	private String name;
	private String ttitle;
	private String author_name;
	private boolean rs;
	
	private ArrayList<String> Title;
	private Book book=new Book();
	private Author author = new Author();
	
	private ArrayList<Book> resultBook = new ArrayList<Book>();
	private ArrayList<Author> resultAuthor = new ArrayList<Author>();
	
 	public String searchAuthor() 
	{
		con.GetDriver();
		con.Connection();
		System.out.println(name);
		setResultBook(con.SearchAuthor(name, resultAuthor));
		System.out.println(name);
		con.DisCon();
		return "ok";
	}
	

	public String searchBook()
	{
		con.GetDriver();
		con.Connection();
		setResultAuthor(con.SearchBook(name, resultBook));
		con.DisCon();
		return "book";
	}
	
	public String insertAuthor()
	{
		con.GetDriver();
		con.Connection();
		con.InsertAuthor(author);
		con.DisCon();
		return "insertAuthor";
	}
	
	
	public String insertBook()
	{
		con.GetDriver();
		con.Connection();
		rs = con.InsertBook(book.getISBN(), book.getTitle(), book.getAuthorID(), book.getPublisher(), book.getPublishDate(), book.getPrice());
		con.DisCon();
		if (rs == true)
			return "insertBook";
		else
			return "NoAuthor";
	}
	
	public String deleteBook()
	{
		con.GetDriver();
		con.Connection();
		System.out.println(book.getISBN());
		con.DeleteBook(book.getISBN());
		con.DisCon();
		return "deleteBook";
	}
	
	public String edit()
	{
		book.setISBN(name);
		book.setTitle(ttitle);
		System.out.println(ttitle);
		return "edit";
	}
	
	public String editBook()
	{
		con.GetDriver();
		con.Connection();
		con.EditBook(book, author);
		System.out.println(book.getISBN());
		con.DisCon();
		return "editBook";
	}
	
 	public String getName() 
	 {
        return name;
     }
	public void setName(String name) 
	 {
	    this.name = name;
	 }

	public ArrayList<String> getTitle() {
		return Title;
	}

	public void setTitle(ArrayList<String> title) {
		Title = title;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}

	public ArrayList<Book> getResultBook() {
		return resultBook;
	}

	public void setResultBook(ArrayList<Book> resultBook) {
		this.resultBook = resultBook;
	}

	public ArrayList<Author> getResultAuthor() {
		return resultAuthor;
	}

	public void setResultAuthor(ArrayList<Author> resultAuthor) {
		this.resultAuthor = resultAuthor;
	}

	public String getTtitle() {
		return ttitle;
	}

	public void setTtitle(String ttitle) {
		this.ttitle = ttitle;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	
}