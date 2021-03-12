package modelo;

import java.util.ArrayList;
import java.util.List;


public class Subject {
	private String word;
	private final List<Video> videos = new ArrayList<>();

	public Subject(String word) {
		this.word = word;
	}

	public String getWord() {
		return this.word;
	}

	public List<Video> getVideos() {
		return this.videos;
	}

	public void put(Video v) {
		this.videos.add(v);
	}

	public void setWord(String newWord) {
		this.word = newWord;
	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder("Subject [word=" + this.word);
		for(Video v : this.videos) {
			text.append(v.getNome());
		}
		text.append("]");
		return text.toString();
	}
}
