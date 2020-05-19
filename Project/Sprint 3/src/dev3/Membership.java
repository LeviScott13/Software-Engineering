package dev3;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Membership implements Comparable<Membership>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7584867945680860873L;
	private Member member;
	private List<Question> questions = new ArrayList<Question>();
	private Group group;
	private List<Answer> answers = new ArrayList<Answer>();

	private LocalDateTime dateJoined;
	private int points;

	public Membership(Member member, Group group) {

		this.member = member;
		this.group = group;
		dateJoined = LocalDateTime.now();
		points = 0;
	}

	protected LocalDateTime getDateJoined() {
		return dateJoined;
	}

	protected void joinGroup(Group group, LocalDateTime dateCreated) {
		this.group = group;
		this.dateJoined = dateCreated;
	}

	protected Group getGroup() {
		return group;
	}

	protected void addQuestion(Question question, LocalDateTime date) {
		questions.add(0, question);
		group.addQuestion(question, date);
		points++;
	}

	protected void addAnswer(Question question, Answer answer, LocalDateTime date) {
		for (int i = 0; i < questions.size(); i++) {
			if (question.equals(questions.get(i))) {
				questions.get(i).addAnswer(answer);
				answers.add(0, answer);
				group.addAnswer(question, answer, date);
				points++;
				return;
			}
		}
	}

	protected List<Question> getQuestions() {
		return questions;
	}

	protected List<Answer> getAnswers() {

		return answers;
	}

	protected Member getMember() {
		return member;
	}

	protected int getPoints() {
		return points;
	}

	public String toString() {
		return "Group: " + group + "\n" + "Member: " + member;
	}

	@Override
	public int compareTo(Membership other) {
		return points - other.getPoints();
	}
}
