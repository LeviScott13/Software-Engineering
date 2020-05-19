package dev1;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnswerTest {

	@Test
	void testAnswerConstructorNoTextText() {
		String text = "";
		Answer a1 = new Answer(null, text, LocalDateTime.now());
		assertEquals(text, a1.getText());
	}

	@Test
	void testAnswerConstructorOnlySpacesText() {
		String text = "   ";
		Answer a1 = new Answer(null, text, LocalDateTime.now());
		assertEquals(text, a1.getText());
	}

	@Test
	void testAnswerConstructorNonPrintableCharactersText() {
		String text = "\n\t\t";
		Answer a1 = new Answer(null, text, LocalDateTime.now());
		assertEquals(text, a1.getText());
	}

	@Test
	void testAnswerConstructorNormalTextTitle() {
		String text = "I have all the answers";
		Answer a1 = new Answer(null, text, LocalDateTime.now());
		assertEquals(text, a1.getText());
	}

	@Test
	void testAnswerEquals() {
		String text = "I have all the answers";
		Answer a1 = new Answer(null, text, LocalDateTime.now());
		assertEquals(a1.equals(a1), true);
	}

	@Test
	void testAnswerEquals_not_Equal_value() {
		String text = "I have all the answers";
		Answer a1 = new Answer(null, text, LocalDateTime.now());
		assertEquals(a1.equals(new Answer(null, "wow", LocalDateTime.now())), false);
	}

	@Test
	void int_testAnswer_get_question() {
		String text = "I have all the answers";
		Question question = new Question("Question Title", "Question Body", LocalDateTime.now());
		Answer a1 = new Answer(question, text, LocalDateTime.now());
		assertEquals(a1.getQuestion(), question);
	}

	@Test
	void int_testAnswer_add_get_feedback() {
		String text = "I have all the answers";
		Question question = new Question("Question Title", "Question Body", LocalDateTime.now());
		Answer a1 = new Answer(question, text, LocalDateTime.now());
		text = "Awsome Answer";
		a1.addFeedback(text);
		assertEquals(a1.getFeedback().get(0), text);
	}
}
