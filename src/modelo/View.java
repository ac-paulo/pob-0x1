package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class View {
	private int id;
	private LocalDateTime datetime = LocalDateTime.now();
	private int note;
	private User user;
	private Video video;
	
	public View(int id, int note, User user, Video video) {
		this.id = id;
		this.note = note;
		this.user = user;
		this.video = video;
	}

	public String getUser() {
		return this.user.getEmail();
	}
	public User getUserObject() {
		return this.user;
	}

	public Video getVideo() {
		return this.video;
	}

	@Override
	public String toString() {
		return "View [id=" + id +
				", datetime=" + datetime.format(DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm:ss")) +
				", nota=" + note +
				"\n user=" + user.getEmail() + ", video=" + video.getNome() + "]";
	}

}
