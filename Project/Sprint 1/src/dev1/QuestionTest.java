package dev1;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuestionTest {
	@Test
	void testQuestionNoTextText(){
		String text = "";
		Question q1 = new Question("title", text, LocalDateTime.now());
		assertEquals(text, q1.getText());
	}
	@Test
	void testQuesionOnlySpacesText(){
		String text = "   ";
		Question q1 = new Question("title", text, LocalDateTime.now());
		assertEquals(text, q1.getText());
	}
	@Test
	void testQuestionNonPrintableCharactersText(){
		String text = "\n\t\t";
		Question q1 = new Question("title", text, LocalDateTime.now());
		assertEquals(text, q1.getText());
	}
	@Test
	void testQuestionNoTextTitle(){
		String title = "";
		Question q1 = new Question(title, "text", LocalDateTime.now());
		assertEquals(title, q1.getTitle());
	}
	@Test
	void testQuesionOnlySpacesTitle(){
		String title = "   ";
		Question q1 = new Question(title, "text", LocalDateTime.now());
		assertEquals(title, q1.getTitle());
	}
	@Test
	void testQuestionNonPrintableCharactersTitle(){
		String title = "\n\t\t";
		Question q1 = new Question(title, "text", LocalDateTime.now());
		assertEquals(title, q1.getTitle());
	}
	@Test
	void testQuestionNormalTextTextTitle(){
		String title = "Title", text = "Whats the question?";
		Question q1 = new Question(title, text, LocalDateTime.now());
		assertAll(
				() -> assertEquals(title, q1.getTitle()),
				() -> assertEquals(text, q1.getText())
				);
	}
	@Test
	void int_question_getFeedback() {
		String title = "Title", text = "Whats the question?";
		Question q1 = new Question(title, text, LocalDateTime.now());
		String feedback = "What an interesting question";
		q1.addFeedback(feedback);

		assertEquals(feedback, q1.getFeedback().get(0));
		
		
	}
}
