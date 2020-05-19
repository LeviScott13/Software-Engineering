package dev1;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GroupTest {

	@Test
	void testGroupNoTextTitle(){
		String title = "";
		Group g1 = new Group(title, "description", LocalDateTime.now());
		assertEquals(title, g1.getTitle());
	}
	@Test
	void testGroupOnlySpacesTitle(){
		String title = "   ";
		Group g1 = new Group(title, "description", LocalDateTime.now());
		assertEquals(title, g1.getTitle());
	}
	@Test
	void testGroupNonPrintableCharactersTitle(){
		String title = "\n\t\t";
		Group g1 = new Group(title, "description", LocalDateTime.now());
		assertEquals(title, g1.getTitle());
	}
	@Test
	void testGroupNoTextDescription(){
		String description = "";
		Group g1 = new Group("title", description, LocalDateTime.now());
		assertEquals(description, g1.getDescription());
	}
	@Test
	void testGroupOnlySpacesDescription(){
		String description = "   ";
		Group g1 = new Group("title", description, LocalDateTime.now());
		assertEquals(description, g1.getDescription());
	}
	@Test
	void testGroupNonPrintableCharactersDescription(){
		String description = "\n\t\t";
		Group g1 = new Group("title", description, LocalDateTime.now());
		assertEquals(description, g1.getDescription());
	}
	@Test
	void testGroupNormalTextTitleDescription(){
		String title = "Title", description = "test cases";
		Group g1 = new Group(title, description, LocalDateTime.now());
		assertEquals(title, g1.getTitle());
		assertEquals(description, g1.getDescription());
	}
	
	@Test
	void int_getMember_from_email() {
		Member mem1 = new Member("Caroline", "Charn", "ccQween", "catsAreAwsome@cats.net", LocalDateTime.now());
		Member mem2 = new Member("Bob", "Brown", "BbBrown", "BBrown@woohoo.com", LocalDateTime.now());
		Member mem3 = new Member("Ada", "Alyson", "AdaAlly", "AdaAlyson@example.com", LocalDateTime.now());
		
		Group group = new Group("Goup Name", "Group Description", LocalDateTime.now());
		
		mem1.joinGroup(group, LocalDateTime.now());
		mem2.joinGroup(group, LocalDateTime.now());
		mem3.joinGroup(group, LocalDateTime.now());
		assertAll(
				() -> assertEquals(group.getMember("catsAreAwsome@cats.net"), mem1),
				() -> assertEquals(group.getMember("BBrown@woohoo.com"), mem2),
				() -> assertEquals(group.getMember("AdaAlyson@example.com"), mem3),
				() -> assertEquals(group.getMember("NonExistantEmail@example.com"), null)
				);
	}
	
	@Test
	void int_getMembers_sorts_alphabetical() {
		Member mem1 = new Member("Caroline", "Charn", "ccQween", "catsAreAwsome@cats.net", LocalDateTime.now());
		Member mem2 = new Member("Bob", "Brown", "BbBrown", "BBrown@woohoo.com", LocalDateTime.now());
		Member mem3 = new Member("Ada", "Alyson", "AdaAlly", "AdaAlyson@example.com", LocalDateTime.now());
		
		Group group = new Group("Goup Name", "Group Description", LocalDateTime.now());
		
		mem1.joinGroup(group, LocalDateTime.now());
		mem2.joinGroup(group, LocalDateTime.now());
		mem3.joinGroup(group, LocalDateTime.now());
		assertAll(
				() -> assertEquals(group.getMembers().get(0), mem3),
				() -> assertEquals(group.getMembers().get(1), mem2),
				() -> assertEquals(group.getMembers().get(2), mem1)
				);
	}
	
	@Test
	void int_getQuestions_sorts_newest() {
		Question question1 = new Question("First Question", "First Descripton", LocalDateTime.now());
		Question question2 = new Question("Second Question", "Second Descripton", LocalDateTime.now());
		Question question3 = new Question("Third Question", "Second Descripton", LocalDateTime.now());
		
		Group group = new Group("Goup Name", "Group Description", LocalDateTime.now());
		Member mem1 = new Member("Caroline", "Charn", "ccQween", "catsAreAwsome@cats.net", LocalDateTime.now());
		mem1.joinGroup(group, LocalDateTime.now());
		
		mem1.addQuestion(group, question1, LocalDateTime.now());
		mem1.addQuestion(group, question2, LocalDateTime.now());
		mem1.addQuestion(group, question3, LocalDateTime.now());

		//System.out.println(group.getQuestions().get(0).toString());
		
		assertAll(
				() -> assertEquals(group.getQuestions().get(0), question3),
				() -> assertEquals(group.getQuestions().get(1), question2),
				() -> assertEquals(group.getQuestions().get(2), question1)
				);
	}
	
	@Test
	void int_getAnswers_sorts_newest() {
		Question question1 = new Question("First Question", "First Descripton", LocalDateTime.now());
		Answer answer1 = new Answer(question1, "Answer1", LocalDateTime.now());
		Answer answer2 = new Answer(question1, "Answer1", LocalDateTime.now());
		Answer answer3 = new Answer(question1, "Answer1", LocalDateTime.now());
		
		
		Group group = new Group("Goup Name", "Group Description", LocalDateTime.now());
		Member mem1 = new Member("Caroline", "Charn", "ccQween", "catsAreAwsome@cats.net", LocalDateTime.now());
		mem1.joinGroup(group, LocalDateTime.now());
		
		mem1.addQuestion(group, question1, LocalDateTime.now());

		
		mem1.addAnswer(group, question1, answer1, LocalDateTime.now());
		mem1.addAnswer(group, question1, answer2, LocalDateTime.now());
		mem1.addAnswer(group, question1, answer3, LocalDateTime.now());
		
		assertAll(
				() -> assertEquals(group.getAnswers().get(0), answer3),
				() -> assertEquals(group.getAnswers().get(1), answer2),
				() -> assertEquals(group.getAnswers().get(2), answer1)
				);
	}
	
	@Test
	void int_getAnswers_int_arguement_sorts_newest() {
		Question question1 = new Question("First Question", "First Descripton", LocalDateTime.now());
		Answer answer1 = new Answer(question1, "Answer1", LocalDateTime.now());
		Answer answer2 = new Answer(question1, "Answer1", LocalDateTime.now());
		Answer answer3 = new Answer(question1, "Answer1", LocalDateTime.now());
		
		
		Group group = new Group("Goup Name", "Group Description", LocalDateTime.now());
		Member mem1 = new Member("Caroline", "Charn", "ccQween", "catsAreAwsome@cats.net", LocalDateTime.now());
		mem1.joinGroup(group, LocalDateTime.now());
		
		mem1.addQuestion(group, question1, LocalDateTime.now());

		
		mem1.addAnswer(group, question1, answer1, LocalDateTime.now());
		mem1.addAnswer(group, question1, answer2, LocalDateTime.now());
		mem1.addAnswer(group, question1, answer3, LocalDateTime.now());
		
		assertAll(
				() -> assertEquals(group.getAnswers(2).get(0), answer3),
				() -> assertEquals(group.getAnswers(2).get(1), answer2),
				() -> assertEquals(group.getAnswers(2).size(), 2)
				);
	}
	
	@Test
	void int_getActiveMembers_int_arguement_sorts_name() {
		Question question1 = new Question("First Question", "First Descripton", LocalDateTime.now());
		Answer answer1 = new Answer(question1, "Answer1", LocalDateTime.now());
		Answer answer2 = new Answer(question1, "Answer1", LocalDateTime.now());
		Answer answer3 = new Answer(question1, "Answer1", LocalDateTime.now());
		
		
		Group group = new Group("Goup Name", "Group Description", LocalDateTime.now());
		Member mem1 = new Member("Caroline", "Charn", "ccQween", "catsAreAwsome@cats.net", LocalDateTime.now());
		Member mem2 = new Member("Bob", "Brown", "BbBrown", "BBrown@woohoo.com", LocalDateTime.now());
		Member mem3 = new Member("Ada", "Alyson", "AdaAlly", "AdaAlyson@example.com", LocalDateTime.now());
		
		mem1.joinGroup(group, LocalDateTime.now());
		mem2.joinGroup(group, LocalDateTime.now());
		mem3.joinGroup(group, LocalDateTime.now());
		
		mem1.addQuestion(group, question1, LocalDateTime.now());

		
		mem1.addAnswer(group, question1, answer1, LocalDateTime.now());
		mem1.addAnswer(group, question1, answer2, LocalDateTime.now());
		mem2.addAnswer(group, question1, answer3, LocalDateTime.now());
		
		
		assertAll(
				() -> assertEquals(group.getActiveMembers(2).get(0), mem1),
				() -> assertEquals(group.getActiveMembers(2).get(1), mem2),
				() -> assertEquals(group.getActiveMembers(2).size(), 2)
				);
	}
	
	@Test
	void int_getActiveMembers_oversized_int_arguement_sorts_name() {
		Question question1 = new Question("First Question", "First Descripton", LocalDateTime.now());
		Answer answer1 = new Answer(question1, "Answer1", LocalDateTime.now());
		Answer answer2 = new Answer(question1, "Answer1", LocalDateTime.now());
		Answer answer3 = new Answer(question1, "Answer1", LocalDateTime.now());
		
		
		Group group = new Group("Goup Name", "Group Description", LocalDateTime.now());
		Member mem1 = new Member("Caroline", "Charn", "ccQween", "catsAreAwsome@cats.net", LocalDateTime.now());
		Member mem2 = new Member("Bob", "Brown", "BbBrown", "BBrown@woohoo.com", LocalDateTime.now());
		Member mem3 = new Member("Ada", "Alyson", "AdaAlly", "AdaAlyson@example.com", LocalDateTime.now());
		
		mem1.joinGroup(group, LocalDateTime.now());
		mem2.joinGroup(group, LocalDateTime.now());
		mem3.joinGroup(group, LocalDateTime.now());
		
		mem1.addQuestion(group, question1, LocalDateTime.now());

		
		mem1.addAnswer(group, question1, answer1, LocalDateTime.now());
		mem1.addAnswer(group, question1, answer2, LocalDateTime.now());
		mem2.addAnswer(group, question1, answer3, LocalDateTime.now());
		
		
		assertAll(
				() -> assertEquals(group.getActiveMembers(50).get(0), mem1),
				() -> assertEquals(group.getActiveMembers(50).get(1), mem2),
				() -> assertEquals(group.getActiveMembers(50).size(), 3)
				);
	}
	
	@Test
	void int_getActiveMembers_negative_int_arguement_sorts_name() {
		Question question1 = new Question("First Question", "First Descripton", LocalDateTime.now());
		Answer answer1 = new Answer(question1, "Answer1", LocalDateTime.now());
		Answer answer2 = new Answer(question1, "Answer1", LocalDateTime.now());
		Answer answer3 = new Answer(question1, "Answer1", LocalDateTime.now());
		
		
		Group group = new Group("Goup Name", "Group Description", LocalDateTime.now());
		Member mem1 = new Member("Caroline", "Charn", "ccQween", "catsAreAwsome@cats.net", LocalDateTime.now());
		Member mem2 = new Member("Bob", "Brown", "BbBrown", "BBrown@woohoo.com", LocalDateTime.now());
		Member mem3 = new Member("Ada", "Alyson", "AdaAlly", "AdaAlyson@example.com", LocalDateTime.now());
		
		mem1.joinGroup(group, LocalDateTime.now());
		mem2.joinGroup(group, LocalDateTime.now());
		mem3.joinGroup(group, LocalDateTime.now());
		
		mem1.addQuestion(group, question1, LocalDateTime.now());

		
		mem1.addAnswer(group, question1, answer1, LocalDateTime.now());
		mem1.addAnswer(group, question1, answer2, LocalDateTime.now());
		mem2.addAnswer(group, question1, answer3, LocalDateTime.now());
		
		
		assertEquals(group.getActiveMembers(-5), null);

	}
}
