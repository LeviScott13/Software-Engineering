package dev3;

import java.io.Serializable;
import java.time.LocalDateTime;
//import java.util.*;

public class Answer extends Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2114252470342475020L;
	private Question question;

	public Answer(Question question, String text, LocalDateTime date) {
		super(text, date);
		this.question = question;
	}

	public Question getQuestion() {
		return question;

	}

	protected boolean equals(Answer ans) {

		if (text.equals(ans.getText())) {
			return true;
		}

		return false;
	}

	public String toString() {
		return ("Answer: " + text);

	}

}