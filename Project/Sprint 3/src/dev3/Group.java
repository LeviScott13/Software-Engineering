package dev3;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Group implements Comparable<Group>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1115863306220991945L;

	private List<Membership> memberships = new ArrayList<Membership>();

	private List<Question> questions = new ArrayList<Question>();

	private List<Answer> answers = new ArrayList<Answer>();

	private LocalDateTime dateCreated;
	private String title;
	private String description;
	private int points;

	public Group(String title, String description, LocalDateTime dateCreated) {
		this.title = title;
		this.description = description;
		this.dateCreated = dateCreated;
		points = 0;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getNumMembers() {
		return memberships.size();
	}

	public Member getMember(String emailAddress) {

		for (int i = 0; i < memberships.size(); i++) {
			if (memberships.get(i).getMember().getEmailAddress().equals(emailAddress)) {
				return memberships.get(i).getMember();
			}
		}

		return null;
	}

	public List<Member> getMembers() {
		List<Member> temp = new ArrayList<>();
		for (int i = 0; i < memberships.size(); i++) {
			temp.add(memberships.get(i).getMember());
		}
		Collections.sort(temp);
		return temp;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public List<Question> getQuestions(int n) {
		List<Question> q2 = new ArrayList<Question>();
		for (int i = 0; i < n; i++) {
			q2.add(questions.get(i));
		}
		return q2;
	}

	public List<Answer> getAnswers() {
		return answers;

	}

	public List<Answer> getAnswers(int n) {
		List<Answer> answers2 = new ArrayList<Answer>();
		for (int i = 0; i < n; i++) {
			answers2.add(answers.get(i));
		}
		return answers2;
	}

	public String toString() {
		return "Group Name: " + title + "\n" + "Description: " + description + "\n" + "Date Created: "
				+ getDateCreated();
	}

	protected void addQuestion(Question question, LocalDateTime date) {
		questions.add(0, question);
		points++;
	}

	protected void addAnswer(Question question, Answer answer, LocalDateTime date) {
		for (int i = 0; i < questions.size(); i++) {
			if (questions.get(i).equals(question)) {
				questions.get(i).addAnswer(answer);
				answers.add(0, answer);
				points++;
				return;
			}
		}

	}

	protected void addMembership(Membership newMem) {
		memberships.add(newMem);
	}

	protected boolean equals(Group other) {
		if (other.toString().equals(toString())) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Group o) {
		// if(o.getTitle().)
		return title.compareTo(o.getTitle());
	}

	public List<Member> getActiveMembers(int n) {
		
		List<Membership> temp = new ArrayList<>();
		if (memberships.size() == 0 || n <= 0) {
			return null;
		} 
		
		for(int i = 0; i < memberships.size(); i++) {
			temp.add(memberships.get(i));
		}
		
		List<Member> returnable = new ArrayList<Member>();
		int maxIndex;
		
		for (int i = 0; i < temp.size() - 1; i++) {
			maxIndex = i;
			for (int j = i + 1; j < temp.size(); j++) {
				if (temp.get(j).getPoints() > temp.get(maxIndex).getPoints()) {
					maxIndex = j;
				}
				Membership tempGroup = temp.get(i);
				temp.set(i, temp.get(maxIndex));
				temp.set(maxIndex, tempGroup);
			}
		}

		if (n > temp.size()) {
			
			for (int i = 0; i < temp.size(); i++) {
				returnable.add(temp.get(i).getMember());
			}
			return returnable;
		}

		for (int i = 0; i < n; i++) {
			returnable.add(temp.get(i).getMember());
		}
		
		return returnable;
	}

	protected int getPoints() {
		return points;
	}
}
