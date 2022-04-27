
import java.util.ArrayList;

public class User {
	private String name;
	private String Email;
	private String password;

	
	public User(String name, String email, String password) {
		this.name = name;
		Email = email;
		this.password = password;
	}
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static User LinearSearch(ArrayList<User> users,String name , String password) {
		User user=null;
		for(int i=0; i<users.size();i++) {
			if(users.get(i).getName().equals(name) && users.get(i).getPassword().equals(password)) {
				user=users.get(i);
			}
		}
		return user;
	}
	public static boolean isntExist(String name) {
		ArrayList<User> users = conectDatabase.getUsers();
		name=name.toLowerCase();
		boolean r=true;
		for(int i =0 ; i<users.size();i++) {
			if(users.get(i).getName().toLowerCase().equals(name)) {
				r=false;
				break;
			}
		}
		return r;
	}
}
