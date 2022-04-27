
public class Operation {
	private int count;
	private Book b;
	public Operation(String name , int count) {
		this.count=count;
		this.b=Book.LinearSeach(name);
	}
	public String getFatora() {
		return "\nName : "+b.getName()+"\nnum : "+count+"\n>> "+b.getPrice()*count+
				"\n----------------------------------------------";
	}
	public double getTotal() {
		return b.getPrice()*count;
	}
}
