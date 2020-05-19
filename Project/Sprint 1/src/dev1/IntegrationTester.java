package dev1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDateTime;
import java.util.*;

import org.junit.jupiter.api.Test;

public class IntegrationTester {

	// because the user does not supply the date, only one date is used in testing
	LocalDateTime x = LocalDateTime.now();

	// normal submission reused in many tests
	String test1[] = { "Wallace", "Coleman", "ColemanW", "WLC@example.com" };
	Member m1 = new Member(test1[0], test1[1], test1[2], test1[3], x);

	// empty submission
	String test2[] = { "", "", "", "" };
	Member m2 = new Member(test2[0], test2[1], test2[2], test2[3], x);

	// spaces submission
	String test3[] = { "  ", "  ", "  ", "  " };
	Member m3 = new Member(test3[0], test3[1], test3[2], test3[3], x);

	// nonprintable characters submission
	String test4[] = { "Wall\nace", "Cole\nman", "\n\t", "\n\t" };
	Member m4 = new Member(test4[0], test4[1], test4[2], test4[3], x);

	// groups
	// normal groups
	Group group = new Group("groupName", "Description", x);
	Group group2 = new Group("group2Name", "Description2", x);
	// Group wgroup = new Group("wgroupName", "wDescription", x);

	// empty submission group
	Group groupEmpty = new Group("", "", x);

	// Spaces submission
	Group groupSpaces = new Group("  ", "  ", x);

	@Test
	void testMemberJoinGroups() {
		// Joining groups

		List<Group> groupList = new ArrayList<>();
		groupList.add(group);
		groupList.add(group2);
		// groupList.add(wgroup);

		// m1.joinGroup(wgroup, x);

		m1.joinGroup(group2, x);
		m1.joinGroup(group, x);
		// m1.joinGroup(wgroup, x);

		// Add questions
		Question question1_1 = new Question("Title", "Question", x);
		Question question1_2 = new Question("Title2", "Question2", x);
		Question question2_1 = new Question("Title3", "Question3", x);
		m1.addQuestion(group, question1_1, x);
		m1.addQuestion(group, question1_2, x);
		m1.addQuestion(group2, question2_1, x);
		List<Question> group1Q = new ArrayList<>();
		group1Q.add(question1_1);
		group1Q.add(question1_2);

		// Add answers
		Answer answer1_1 = new Answer(question1_1, "Question 1 Answer 1", x);
		Answer answer1_2 = new Answer(question1_1, "Question 1 Answer 2", x);
		Answer answer2_1 = new Answer(question1_2, "Question 2 Answer 1", x);
		Answer answer3_1 = new Answer(question2_1, "Question 3 Answer 1", x);
		List<Answer> answers = new ArrayList<>();
		answers.add(answer1_1);
		answers.add(answer1_2);
		answers.add(answer2_1);

		m1.addAnswer(group, question1_1, answer1_1, x);
		m1.addAnswer(group, question1_1, answer1_2, x);

		m1.addAnswer(group, question1_2, answer2_1, x);
		m1.addAnswer(group2, question2_1, answer3_1, x);

		// Basic Variables
		assertNotNull(m1);
		assertEquals(test1[0], m1.getFirstName());
		assertEquals(test1[1], m1.getLastName());
		assertEquals(test1[2], m1.getScreenName());
		assertEquals(test1[3], m1.getEmailAddress());
		assertEquals(x, m1.getDateCreated());

		// Group variables
		assertEquals(groupList, m1.getGroups());
		assertEquals(groupList.size(), m1.getNumGroups());

		assertEquals(group, m1.getGroup(group.getTitle()));

		// Membership
		assertNotNull(m1.getDateJoined(group2));

		// Question variables
		assertEquals(group1Q, m1.getQuestions(group));

		// Answer variables
		assertEquals(answers, m1.getAnswers(group));

		// m1.getGroups();

	}

	@Test
	void testQuestion() {
		LocalDateTime x = LocalDateTime.now();
		Question question1 = new Question("Question Title", "Question", x);
		Answer answer1 = new Answer(question1, "Answer 1", x);
		Answer answer2 = new Answer(question1, "Answer 2", x);
		List<Answer> answers = new ArrayList<>();
		answers.add(answer1);
		answers.add(answer2);

		question1.addAnswer(answer1);
		question1.addAnswer(answer2);

		assertEquals(answers, question1.getAnswers());

		System.out.println(question1.toString());

	}

	@Test
	void testAnswer() {
		String title = "Speed";
		String text = "Who is the faster? Flash or Superman? ";
		String answer = "Flash";
		LocalDateTime date = LocalDateTime.now();

		Question question = new Question(title, text, date);

		LocalDateTime date1 = LocalDateTime.now();
		Answer a1 = new Answer(question, answer, date1);

		assertNotNull(a1);
		assertEquals(question, a1.getQuestion());

		assertNotNull(a1.toString());
		System.out.println(a1.toString());
	}

	@Test
	void testGroup() {

		String title = "Coders";
		String description = "Focus on software stuff";
		LocalDateTime date = LocalDateTime.now();
		Group g1 = new Group(title, description, date);

		assertNotNull(g1);
		assertEquals("Coders", g1.getTitle());
		assertEquals("Focus on software stuff", g1.getDescription());
		assertEquals(date, g1.getDateCreated());
	}

}