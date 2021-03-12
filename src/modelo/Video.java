package modelo;

import java.util.ArrayList;
import java.util.List;


public class Video {
	private String link;
	private String name;
	private double media;
	private List<Subject> subjects = new ArrayList<>();
	private List<View> views = new ArrayList<>();

	
	public Video(String link, String nome) {
		this.link = link;
		this.name = nome;
	}

	public List<View> getViews() {
		return views;
	}

	public String getNome() {
		return name;
	}

	public void put(Subject a) {
		subjects.add(a);
	}
	public void put(View vis) {
		views.add(vis);
	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder("Video [" + (link != null ? "link=" + link + ", " : "") +
				(name != null ? "\n\tname=" + name + ", " : "")
				+ "\n\tmedia=" + media);
		text.append(", \n\tsubjects=[");
		for(Subject a : subjects) {
			text.append(a.getWord());
		}
		text.append("]");
		text.append("\n\tviews=[");
		for(View view : views) {
			text.append(view);
		}
		text.append("]");
		return text.toString();
	}

}
