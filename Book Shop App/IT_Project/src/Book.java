import java.util.ArrayList;

public class Book {
	private int id;
	private String name;
	private String type;
	private double price;
	
	
	
	public Book(int id, String name, String type, double price) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
	}


	public Book(String name, String type, double price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public static Book LinearSeach(String name) {
		ArrayList <Book> books=conectDatabase.getBooks();
		Book b = null;
		for(int i =0 ; i<books.size();i++) {
			if(books.get(i).getName().equals(name)) {
				b= books.get(i);
			}
		}
		return b;
	}
}
