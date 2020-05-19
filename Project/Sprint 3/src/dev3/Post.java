package dev3;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
//import java.util.*;

public abstract class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8876656368439599536L;
	protected Membership membership;
	protected String text;
	protected LocalDateTime date;
	protected ArrayList<String> feedback;

	public Post(String text, LocalDateTime date) {
		this.text = text;
		this.date = date;
		feedback = new ArrayList<String>();
	}

	public String getText() {
		return text;

	}

	public LocalDateTime getDate() {
		return date;

	}

	public void setText(String text) {
		this.text = text;
	}

	public Member getAuthor() {
		return membership.getMember();

	}

	public Group getGroup() {
		return membership.getGroup();

	}

	protected void setMembership(Membership membership) {
		this.membership = membership;
	}

	protected Membership getMembership() {
		return membership;

	}

	public void addFeedback(String feedback) {
		this.feedback.add(feedback);
	}

	public List<String> getFeedback() {
		return feedback;
	}

}