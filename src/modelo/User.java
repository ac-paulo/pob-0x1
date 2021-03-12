package modelo;

import java.util.ArrayList;
import java.util.List;


public class User {
	private String email;
	private List<View> views = new ArrayList<>();

	public List<View> getViews() {
		return this.views;
	}

	public User(String email) {
		this.email = email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}
	
	public void put(View vis) {
		this.views.add(vis);
	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder("User '" + email + "'");
		
		text.append("\n\t View=[");
		for(View view : views) {
			text.append("\n\t" + view);
		}
		text.append("]");
		return text.toString();
	}
}
