import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class conectDatabase {
	private static String user ="root";
	private static String password="";
	private static String host="jdbc:mysql://localhost/database_of_the_project";
	
	private static Connection connect() throws SQLException {
		return DriverManager.getConnection(host,user,password);
	
	}
	public static void data() {
		try {
			Connection co = conectDatabase.connect();
			Statement ss =co.createStatement();
//			User A= new User("Omar Hosny","omar@gmail.com","Omar4444");
//			ss.execute("insert into users values('"+A.getName()+"','"+A.getPassword()+"','"+A.getEmail()+"')");
//			ss.execute("create table books(id int not null , name varchar(30) not null , type varchar(30) not null , price double not null)");
//			ss.execute("insert into books values(1,'anyThing','history',299.9)");
//			System.out.println("ok");price
			co.close();
			ss.close();
		} catch (SQLException e) {
			System.out.print(e.getMessage());

		}
	}
	public static ArrayList<User> getUsers(){
		ArrayList<User> users = new ArrayList<>();
		Connection co;
		try {
			co = conectDatabase.connect();
			Statement ss =co.createStatement();
			ResultSet r;
			r=ss.executeQuery("select * from users");
			while(r.next()) {
				users.add(new User(r.getString("name"),r.getString("Email"),r.getString("password")));
			}
			co.close();
			ss.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	public static void addUser(User A) {
		try {
			Connection co = conectDatabase.connect();
			Statement ss =co.createStatement();
			ss.execute("insert into users values('"+A.getName()+"','"+A.getPassword()+"','"+A.getEmail()+"')");
			co.close();
			ss.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*----------------------------------------- Books table -------------------------------*/
	public static ArrayList<Book> getBooks(){
		ArrayList<Book> books = new ArrayList<>();
		Connection co;
		try {
			co = conectDatabase.connect();
			Statement ss =co.createStatement();
			ResultSet r;
			r=ss.executeQuery("select * from books");
			while(r.next()) {
				books.add(new Book(r.getInt("id"),r.getString("name"),r.getString("type"),r.getDouble("price")));
			}
			co.close();
			ss.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	public static ArrayList<String> getBooksNames(){
		ArrayList<String> books = new ArrayList<>();
		Connection co;
		try {
			co = conectDatabase.connect();
			Statement ss =co.createStatement();
			ResultSet r;
			r=ss.executeQuery("select * from books");
			while(r.next()) {
				books.add(r.getString("name"));
			}
			co.close();
			ss.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	public static void addBook(Book A) {
		try {
			Connection co = conectDatabase.connect();
			Statement ss =co.createStatement();
			String query = "insert into books values("+A.getId()+",'"+A.getName()+"','"+A.getType()+"',"+A.getPrice()+")";
			ss.execute(query);
			co.close();
			ss.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void TRUNCATE_BOOKS_TABLE() {
		try {
			Connection co = conectDatabase.connect();
			Statement ss =co.createStatement();
			String query = "TRUNCATE TABLE books";
			ss.execute(query);
			co.close();
			ss.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void removeBook(int id) {
		try {
			Connection co = conectDatabase.connect();
			Statement ss =co.createStatement();
			String query = "DELETE FROM books WHERE id = "+id;
			ss.execute(query);
			co.close();
			ss.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void updateBook(int id,String name,String type,double price) {
		try {
			Connection co = conectDatabase.connect();
			Statement ss =co.createStatement();
			
			String query = "UPDATE `books` SET `name`='"+name+"',`type`='"+type+"',`price`="+price+" Where id = "+id;
			ss.execute(query);
			co.close();
			ss.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void sort_books() {
		try {
			Connection co = conectDatabase.connect();
			Statement ss =co.createStatement();
			for(int i=0; i<getBooks().size();i++) {
				String query = "UPDATE `books` SET `id` = '"+(i+1)+"' WHERE `books`.`id` = "+getBooks().get(i).getId();
				ss.execute(query);
			}
			co.close();
			ss.close();
		}catch(Exception e) {
			
		}
	}
}
