package dev1;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MemberTest {
	
	@Test
	void testMemberNoTextFirstName(){
		String firstName = ""; 
		Member m1 = new Member(firstName, "last name", "screen name", "email address", LocalDateTime.now());
		assertEquals(firstName, m1.getFirstName());	
	}
	@Test
	void testMemberOnlySpacesFirstName(){
		String firstName = "   "; 
		Member m1 = new Member(firstName, "last name", "screen name", "email address", LocalDateTime.now());
		assertEquals(firstName, m1.getFirstName());	
	}
	@Test
	void testMemberNonPrintableCharactersFirstName(){
		String firstName = "\n\t\t"; 
		Member m1 = new Member(firstName, "last name", "screen name", "email address", LocalDateTime.now());
		assertEquals(firstName, m1.getFirstName());	
	}
	@Test
	void testMemberNoTextLastName(){
		String lastName = ""; 
		Member m1 = new Member("first name", lastName, "screen name", "email address", LocalDateTime.now());
		assertEquals(lastName, m1.getLastName());	
	}
	@Test
	void testMemberOnlySpacesLastName(){
		String lastName = "   "; 
		Member m1 = new Member("first name", lastName, "screen name", "email address", LocalDateTime.now());
		assertEquals(lastName, m1.getLastName());	
	}
	@Test
	void testMemberNonPrintableCharactersLastName(){
		String lastName = "\n\t\t"; 
		Member m1 = new Member("first name", lastName, "screen name", "email address", LocalDateTime.now());
		assertEquals(lastName, m1.getLastName());	
	}
	@Test
	void testMemberNoTextScreenName(){
		String screenName = ""; 
		Member m1 = new Member("first name", "last name", screenName, "email address", LocalDateTime.now());
		assertEquals(screenName, m1.getScreenName());	
	}
	@Test
	void testMemberOnlySpacesScreenName(){
		String screenName = "   "; 
		Member m1 = new Member("first name", "last name", screenName, "email address", LocalDateTime.now());
		assertEquals(screenName, m1.getScreenName());	
	}
	@Test
	void testMemberNonPrintableCharactersScreenName(){
		String screenName = "\n\t\t"; 
		Member m1 = new Member("first name", "last name", screenName, "email address", LocalDateTime.now());
		assertEquals(screenName, m1.getScreenName());	
	}
	@Test
	void testMemberNoTextEmailAddress(){
		String emailAddress = ""; 
		Member m1 = new Member("first name", "last name", "screen name", emailAddress, LocalDateTime.now());
		assertEquals(emailAddress, m1.getEmailAddress());	
	}
	@Test
	void testMemberOnlySpacesEmailAddress(){
		String emailAddress = "   "; 
		Member m1 = new Member("first name", "last name", "screen name", emailAddress, LocalDateTime.now());
		assertEquals(emailAddress, m1.getEmailAddress());	
	}
	@Test
	void testMemberNonPrintableCharactersEmailAddress(){
		String emailAddress = "\n\t\t"; 
		Member m1 = new Member("first name", "last name", "screen name", emailAddress, LocalDateTime.now());
		assertEquals(emailAddress, m1.getEmailAddress());	
	}
	@Test
	void testMemberNormalTextFirstNameLastNameScreenNameEmailAddress(){
		String firstName = "First Name", lastName = "Last Name", screenName = "Screen Name", emailAddress = "Email Address";
		Member m1 = new Member(firstName, lastName, screenName, emailAddress, LocalDateTime.now());
		
		assertAll(
				() -> assertEquals(firstName, m1.getFirstName()),
				() -> assertEquals(lastName, m1.getLastName()),
				() -> assertEquals(screenName, m1.getScreenName()),
				() -> assertEquals(emailAddress, m1.getEmailAddress())
				);
	}
	
	@Test
	void int_join_group_get_groups(){
		String firstName = "First Name", lastName = "Last Name", screenName = "Screen Name", emailAddress = "Email Address";
		Member m1 = new Member(firstName, lastName, screenName, emailAddress, LocalDateTime.now());
		Group group = new Group("Name","Description",LocalDateTime.now());
		Group group2 = new Group("Name2","Description2",LocalDateTime.now());
		Group group3 = new Group("Name3","Description3",LocalDateTime.now());
		m1.joinGroup(group, LocalDateTime.now());
		m1.joinGroup(group2, LocalDateTime.now());
		m1.joinGroup(group3, LocalDateTime.now());
		assertAll(
				() -> assertEquals(m1.getGroups().get(0),group),
				() -> assertEquals(m1.getGroups().size(),3),
				() -> assertEquals(group.getMembers().get(0),m1)
				);
	}
	
	@Test
	void int_get_groups_int_argument(){
		String firstName = "First Name", lastName = "Last Name", screenName = "Screen Name", emailAddress = "Email Address";
		Member m1 = new Member(firstName, lastName, screenName, emailAddress, LocalDateTime.now());
		Group group = new Group("Name1","Description",LocalDateTime.now());
		Group group2 = new Group("Name2","Description2",LocalDateTime.now());
		Group group3 = new Group("Name3","Description3",LocalDateTime.now());
		m1.joinGroup(group, LocalDateTime.now());
		m1.joinGroup(group2, LocalDateTime.now());
		m1.joinGroup(group3, LocalDateTime.now());
		
		
		Question question1 = new Question("First Question", "First Descripton", LocalDateTime.now());
		Question question2 = new Question("Second Question", "Question Descripton", LocalDateTime.now());
		
		Answer answer1 = new Answer(question1, "Answer1", LocalDateTime.now());
		Answer answer2 = new Answer(question1, "Answer2", LocalDateTime.now());
		Answer answer3 = new Answer(question2, "Answer3", LocalDateTime.now());
		
		
		m1.addQuestion(group, question1, LocalDateTime.now());
		m1.addQuestion(group2, question2, LocalDateTime.now());

		
		m1.addAnswer(group, question1, answer1, LocalDateTime.now());
		m1.addAnswer(group, question1, answer2, LocalDateTime.now());
		m1.addAnswer(group2, question1, answer3, LocalDateTime.now());
		
		
		assertAll(
				() -> assertEquals(m1.getGroups(3).get(0),group),
				() -> assertEquals(m1.getGroups(3).get(1),group2),
				() -> assertEquals(m1.getGroups(3).get(2),group3),
				() -> assertEquals(m1.getGroups(2).get(0),group),
				() -> assertEquals(m1.getGroups(2).get(1),group2),
				() -> assertEquals(m1.getGroups(3).size(),3),
				() -> assertEquals(m1.getGroups(2).size(),2)
				);
	}
	
	@Test
	void int_get_groups_negative_int_argument(){
		String firstName = "First Name", lastName = "Last Name", screenName = "Screen Name", emailAddress = "Email Address";
		Member m1 = new Member(firstName, lastName, screenName, emailAddress, LocalDateTime.now());
		Group group = new Group("Name1","Description",LocalDateTime.now());
		Group group2 = new Group("Name2","Description2",LocalDateTime.now());
		Group group3 = new Group("Name3","Description3",LocalDateTime.now());
		m1.joinGroup(group, LocalDateTime.now());
		m1.joinGroup(group2, LocalDateTime.now());
		m1.joinGroup(group3, LocalDateTime.now());
		
		
		Question question1 = new Question("First Question", "First Descripton", LocalDateTime.now());
		Question question2 = new Question("Second Question", "Question Descripton", LocalDateTime.now());
		
		Answer answer1 = new Answer(question1, "Answer1", LocalDateTime.now());
		Answer answer2 = new Answer(question1, "Answer2", LocalDateTime.now());
		Answer answer3 = new Answer(question2, "Answer3", LocalDateTime.now());
		
		
		m1.addQuestion(group, question1, LocalDateTime.now());
		m1.addQuestion(group2, question2, LocalDateTime.now());

		
		m1.addAnswer(group, question1, answer1, LocalDateTime.now());
		m1.addAnswer(group, question1, answer2, LocalDateTime.now());
		m1.addAnswer(group2, question1, answer3, LocalDateTime.now());
		
		
		assertEquals(m1.getGroups(-5),null);
	}
	
	@Test
	void int_get_groups_oversized_int_argument(){
		String firstName = "First Name", lastName = "Last Name", screenName = "Screen Name", emailAddress = "Email Address";
		Member m1 = new Member(firstName, lastName, screenName, emailAddress, LocalDateTime.now());
		Group group = new Group("Name1","Description",LocalDateTime.now());
		Group group2 = new Group("Name2","Description2",LocalDateTime.now());
		Group group3 = new Group("Name3","Description3",LocalDateTime.now());
		m1.joinGroup(group, LocalDateTime.now());
		m1.joinGroup(group2, LocalDateTime.now());
		m1.joinGroup(group3, LocalDateTime.now());
		
		
		Question question1 = new Question("First Question", "First Descripton", LocalDateTime.now());
		Question question2 = new Question("Second Question", "Question Descripton", LocalDateTime.now());
		
		Answer answer1 = new Answer(question1, "Answer1", LocalDateTime.now());
		Answer answer2 = new Answer(question1, "Answer2", LocalDateTime.now());
		Answer answer3 = new Answer(question2, "Answer3", LocalDateTime.now());
		
		
		m1.addQuestion(group, question1, LocalDateTime.now());
		m1.addQuestion(group2, question2, LocalDateTime.now());

		
		m1.addAnswer(group, question1, answer1, LocalDateTime.now());
		m1.addAnswer(group, question1, answer2, LocalDateTime.now());
		m1.addAnswer(group2, question1, answer3, LocalDateTime.now());
		
		System.out.println(m1.getGroups(30).size());
		
		
		assertAll(
				() -> assertEquals(m1.getGroups(30).get(0),group),
				() -> assertEquals(m1.getGroups(30).get(1),group2),
				() -> assertEquals(m1.getGroups(30).get(2),group3),
				() -> assertEquals(m1.getGroups(30).size(),3)
				);
	}
}