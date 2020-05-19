package dev3;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Member implements Comparable<Member>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3170551772486866292L;
	private LocalDateTime dateCreated;
	private String firstName;
	private String lastName;
	private String screenName;
	private String emailAddress;

	private List<Membership> memberships = new ArrayList<Membership>();

	private int points;

	public Member(String firstName, String lastName, String screenName, String emailAddress,
			LocalDateTime dateCreated) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.screenName = screenName;
		this.emailAddress = emailAddress;
		this.dateCreated = dateCreated;
		points = 0;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getScreenName() {
		return screenName;
	}

	public boolean joinGroup(Group group, LocalDateTime dateJoined) {

		for (int i = 0; i < memberships.size(); i++) {
			if (memberships.get(i).getGroup().getTitle().equals(group.getTitle())) {
				return false;
			}
		}

		Membership temp = new Membership(this, group);
		memberships.add(temp);
		group.addMembership(temp);
		return true;
	}

	public int getNumGroups() {
		return memberships.size();

	}

	public Group getGroup(String groupID) {

		for (int i = 0; i < getNumGroups(); i++) {
			if (memberships.get(i).getGroup().getTitle().equals(groupID)) {
				return memberships.get(i).getGroup();
			}
		}

		return null;

	}

	public List<Group> getGroups() {
		List<Group> temp = new ArrayList<>();

		for (int i = 0; i < getNumGroups(); i++) {
			temp.add(memberships.get(i).getGroup());
		}
		Collections.sort(temp);
		return temp;

	}

	public boolean addQuestion(Group group, Question question, LocalDateTime date) {

		// Find the membership that is associated with the
		// group they're trying to add a question to
		for (int i = 0; i < getNumGroups(); i++) {
			Membership temp = memberships.get(i);
			if (temp.getGroup().equals(group)) {
				temp.addQuestion(question, date);
				question.setMembership(temp);
				points++;
				return true;
			}
		}
		return false;
	}

	public LocalDateTime getDateJoined(Group group) {

		// find the membership associated with the group.
		for (int i = 0; i < memberships.size(); i++) {
			if (memberships.get(i).getGroup() == group) {
				return memberships.get(i).getDateJoined();
			}
		}
		return null;
	}

	public void addAnswer(Group group, Question question, Answer answer, LocalDateTime date) {
		for (int i = 0; i < getNumGroups(); i++) {
			Membership temp = memberships.get(i);
			if (temp.getGroup().equals(group)) {
				temp.addAnswer(question, answer, date);
				answer.setMembership(temp);
				points++;
				return;
			}
		}
	}

	public List<Question> getQuestions(Group group) {
		for (int i = 0; i < getNumGroups(); i++) {
			if (memberships.get(i).getGroup().equals(group)) {
				return memberships.get(i).getQuestions();
			}
		}
		return null;
	}

	public List<Question> getQuestions(Group group, int n) {
		List<Question> q1 = getQuestions(group);
		List<Question> returnable = new ArrayList<Question>();

		// for(int i = 0; i < getNumGroups(); i++) {
		// if(membership.get(i).getGroup().equals(group)) {
		// q1 = membership.get(i).getQuestions();

		// break;
		// }
		// }
		for (int j = q1.size() - n; j < q1.size(); j++) {
			returnable.add(q1.get(j));
		}
		return returnable;
	}

	public List<Answer> getAnswers(Group group) {
		for (int i = 0; i < getNumGroups(); i++) {
			if (memberships.get(i).getGroup().equals(group)) {
				// List<Answer> answers = membership.get(i).getAnswers();
				// Collections.sort(answers);
				return memberships.get(i).getAnswers();
			}
		}
		return null;
	}

	public List<Answer> getAnswers(Group group, int n) {
		List<Answer> a1 = getAnswers(group);
		List<Answer> returnable = new ArrayList<Answer>();
		for (int i = a1.size(); i < a1.size(); i++) {
			returnable.add(a1.get(i));
		}
		return returnable;
	}

	public String toString() {
		return "First Name: " + firstName + "\n" + "Last Name: " + lastName + "\n" + "Screen Name: " + screenName + "\n"
				+ "Email Address: " + emailAddress;

	}

	@Override
	public int compareTo(Member o) {
		if (o.getLastName().compareTo(lastName) == 0) {
			return firstName.compareTo(o.getFirstName());
		} else {
			return lastName.compareTo(o.getLastName());
		}
	}

	public List<Group> getGroups(int n) {
		Collections.sort(memberships);
		List<Group> returnable = new ArrayList<>();
		if (memberships.size() == 0 || n <= 0) {
			return null;
		} else if (n >= memberships.size()) {
			for (int i = 0; i < memberships.size(); i++) {
				returnable.add(memberships.get(i).getGroup());
			}
		} else {
			for (int i = memberships.size() - n; i < memberships.size(); i++) {
				returnable.add(memberships.get(i).getGroup());
			}
		}
		Collections.sort(returnable);
		return returnable;
	}

	protected int getPoints() {
		return points;
	}

	protected List<String> getFeedback(Question question) {
		return question.getFeedback();
	}

	protected List<String> getFeedback(Answer answer) {
		return answer.getFeedback();
	}

	protected void addFeedback(Question question, String text) {
		question.addFeedback(text);
	}

	protected void addFeedback(Answer answer, String text) {
		answer.addFeedback(text);
	}
}
