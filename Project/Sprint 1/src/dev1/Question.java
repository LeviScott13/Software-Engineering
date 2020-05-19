package dev1;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Question extends Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8195579895648835272L;
	private List<Answer> answers = new ArrayList<Answer>();
	private String title;


	public Question(String title, String text, LocalDateTime date) {
		super(text, date);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addAnswer(Answer answer) {
		if (!alreadyUsed(answer)) {
			answers.add(answer);
		}
	}

	public List<Answer> getAnswers() {
		return answers;

	}

	public String toString() {
		return "Question Title: " + title + "\n" + "Question: " + text;
	}

	protected boolean alreadyUsed(Answer ans) {

		for (int i = 0; i < answers.size(); i++) {
			if (answers.get(i).equals(ans)) {
				return true;
			}
		}

		return false;
	}

	protected boolean equals(Question other) {
		if (other.toString().equals(toString())) {
			return true;
		}
		return false;
	}

}