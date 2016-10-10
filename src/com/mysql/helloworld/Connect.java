package com.mysql.helloworld;

import java.sql.*;
import java.util.*;

public class Connect {
	Connection connect = null;
	public void GetDriver()
	{
    	String driver = "com.mysql.jdbc.Driver";
    	try {
			Class.forName(driver);
			System.out.println("driver!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     //¼ÓÔØMYSQL JDBCÇý¶¯³ÌÐò   
	}
	
	public void Connection()
	{
		String url = "jdbc:mysql://exjvrdcpvkbl.rds.sae.sina.com.cn:10394/bookdb";
	   	String root = "root";
	   	String password = "802396";
	    try {
			connect = DriverManager.getConnection(url,root,password);
			System.out.println("connect!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void DisCon()
	{
		if (connect != null)
		{
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Database close!");
		}
		else
			System.out.println("lalala");
	}
	
	public void CreateBookTable()
	{
		String book = "create table book("+
    			"ISBN char(13) not null primary key,"+
    			"Title char(55) not null,"+
    			"AuthorID char(55) not null,"+
    			"Publisher char(55),"+
    			"PublishDate char(55),"+
    			"Price char(55),"+
    			"foreign key(AuthorID) references author(AuthorID))";
    	PreparedStatement pstmt;
		try {
			pstmt = connect.prepareStatement(book);
			pstmt.executeUpdate(book);
			System.out.println("book!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void CreateAuthorTable()
	{
		String author = "create table author("
				+ "AuthorID char(55) not null primary key,"
				+ "Name char(55) not null,"
				+ "Age int,"
				+ "Country char(100))";
		PreparedStatement pstmt;
		try {
			pstmt = connect.prepareStatement(author);
			pstmt.executeUpdate(author);
			System.out.println("author!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void InsertAuthor(Author newAuthor)
	{
		String insert = "INSERT INTO `author`(`AuthorID`, `Name`, `Age`, `Country`) VALUES (?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = connect.prepareStatement(insert);
			pstmt.setString(1, newAuthor.getAuthorID());
			pstmt.setString(2, newAuthor.getName());
			pstmt.setInt(3, newAuthor.getAge());
			pstmt.setString(4, newAuthor.getCountry());
			pstmt.executeUpdate();
			System.out.println("inserta!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean SearchAuthorName(String author)
	{
		String search = "SELECT  `Name` FROM `author` WHERE `Name`=?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = connect.prepareStatement(search);
			pstmt.setString(1, author);
			rs = pstmt.executeQuery();
			System.out.println("search!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		boolean result = false;
		try {
			result=rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Book> SearchAuthor(String author_name, ArrayList<Author> resultAuthor)
	{
		String search = " select * from `author` inner join `book` on `author`.`authorID`=`book`.`authorID` where `author`.`Name`=?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<Book> resultBook = new ArrayList<Book>();
		try {
			pstmt = connect.prepareStatement(search);
			pstmt.setString(1, author_name);
			rs = pstmt.executeQuery();
			System.out.println("search&print!");
			System.out.println(author_name);
			System.out.println("lalalala");
			String preID = null;
			while(rs.next())
			{
				Author author = new Author();
				Book book = new Book();
				System.out.println("lalala!");
				String ID = rs.getString("AuthorID");
				book.setAuthorID(rs.getString("AuthorID"));
				String name = rs.getString("Name");
				System.out.println(name);
				if (preID == null || !preID.equals(ID))
				{
					author.setAuthorID(rs.getString("AuthorID"));
					author.setName(rs.getString("Name"));
					preID = ID;
				}
				String t = rs.getString("Title");
				book.setTitle(rs.getString("Title"));
				String code = rs.getString("ISBN");
				book.setISBN(rs.getString("ISBN"));
				String P = rs.getString("Publisher");
				book.setPublisher(rs.getString("Publisher"));
				String pd = rs.getString("PublishDate");
				book.setPublishDate(rs.getString("PublishDate"));
				String money = rs.getString("Price");
				book.setPrice(rs.getString("Price"));
				int age = rs.getInt("Age");
				author.setAge(rs.getInt("Age"));
				String country = rs.getString("Country");
				author.setCountry(rs.getString("Country"));
				resultAuthor.add(author);
				resultBook.add(book);
				
				System.out.print(ID+'\t');
				System.out.print(code+'\t');
				System.out.print(t+'\t');
				System.out.print(P+'\t');
				System.out.print(pd+'\t');
				System.out.print(money+'\t');
				System.out.print(name+'\t');
				System.out.print(age);
				System.out.print('\t');
				System.out.print(country+'\n');

			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultBook;
	}


	
	public boolean InsertBook(String ISBN,String title,String ID,String publisher,String publishdate,String price)
	{
		PreparedStatement pstmt,st;
		ResultSet rs = null;
		try {
			st=connect.prepareStatement("select `AuthorID` from `author` where `AuthorID`=?");
			st.setString(1, ID);
			rs = st.executeQuery();
			if(!rs.next())
				return false;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		String insert = "INSERT INTO `book`(`ISBN`, `Title`, `AuthorID`, `Publisher`, `PublishDate`, `Price`) values(?,?,?,?,?,?)";
		
		
		try {
			pstmt = connect.prepareStatement(insert);
			pstmt.setString(1, ISBN);
			pstmt.setString(2, title);
			pstmt.setString(3, ID);
			pstmt.setString(4, publisher);
			pstmt.setString(5, publishdate);
			pstmt.setString(6, price);
			pstmt.executeUpdate();
			System.out.println("insertb!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public ArrayList<Author> SearchBook(String title,ArrayList<Book> resultBook)
	{
		
		ArrayList<Author> resultAuthor = new ArrayList<Author>();
		String search = "select * from `book` inner join `author` on `author`.`authorID`=`book`.`authorID` where `book`.`Title`=?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = connect.prepareStatement(search);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			
			
			while(rs.next())
			{
				Author author = new Author();
				Book book = new Book();
				System.out.println("lalala!");
				String ID = rs.getString("AuthorID");
				book.setAuthorID(rs.getString("AuthorID"));
				System.out.print(ID+'\t');
				author.setAuthorID(ID);
				author.setAuthorID(rs.getString("AuthorID"));
				System.out.print(author.getAuthorID() +'\t');
				String t = rs.getString("Title");
				book.setTitle(rs.getString("Title"));
				String code = rs.getString("ISBN");
				book.setISBN(rs.getString("ISBN"));
				String P = rs.getString("Publisher");
				book.setPublisher(rs.getString("Publisher"));
				String pd = rs.getString("PublishDate");
				book.setPublishDate(rs.getString("PublishDate"));
				String money = rs.getString("Price");
				book.setPrice(rs.getString("Price"));
				String name = rs.getString("Name");
				author.setName(rs.getString("Name"));
				int age = rs.getInt("Age");
				author.setAge(rs.getInt("Age"));
				String country = rs.getString("Country");
				author.setCountry(rs.getString("Country"));
				resultAuthor.add(author);
				resultBook.add(book);
				
				System.out.print(ID+'\t');
				System.out.print(code+'\t');
				System.out.print(t+'\t');
				System.out.print(P+'\t');
				System.out.print(pd+'\t');
				System.out.print(money+'\t');
				System.out.print(name+'\t');
				System.out.print(age);
				System.out.print('\t');
				System.out.print(country+'\n');
			}
			rs.close();
			System.out.println("Bsearch&print!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultAuthor;
	}

	public void DeleteBook(String ISBN)
	{
		String delete = "delete from `book` where `ISBN`=?";
		PreparedStatement pstmt;
		try {
			pstmt = connect.prepareStatement("drop primary key");
			pstmt = connect.prepareStatement(delete);
			pstmt.setString(1, ISBN);
			pstmt.executeUpdate();
			pstmt = connect.prepareStatement("add primary key(`ISBN`)");
			System.out.println("deleteb!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void EditBook(Book book,Author author)
	{
		String edit = "update `book` inner join `author` on `author`.`AuthorID`=`book`.`AuthorID` set `author`.`Name`=?,`book`.`Publisher`=?,`book`.`PublishDate`=?,`book`.`Price`=? where `book`.`ISBN`=? and `author`.`AuthorID`=`book`.`AuthorID`";
		PreparedStatement pstmt;
		try {
			pstmt = connect.prepareStatement(edit);
			pstmt.setString(1, author.getName());
			pstmt.setString(2, book.getPublisher());
			pstmt.setString(3, book.getPublishDate());
			pstmt.setString(4, book.getPrice());
			pstmt.setString(5, book.getISBN());
			pstmt.executeUpdate();
			System.out.println("EDITb!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
