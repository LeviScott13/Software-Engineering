package dev1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class SiteManagerTest {
	SiteManager sm;
	LocalDateTime now = LocalDateTime.now();

	@Test
	void int_add_member_Normal_Text() {
		sm = new SiteManager();
		sm.addMember("fName", "lName", "screenName", "emailAddress@email.com");

		assertAll(() -> assertEquals(sm.getMembers().size(), 1),
				() -> assertEquals(sm.getMember("emailAddress@email.com").getFirstName(), "fName"),
				() -> assertEquals(sm.getMembers().get(0).getFirstName(), "fName"));
	}

	// @DisplayName("Try to remove employee at 0 when 5 employees exist")
	@Test
	void int_add_member_spaces_in_first_name() {
		sm = new SiteManager();
		sm.addMember("fNa  me", "lName", "screenName", "emailAddress@email.com");

		assertAll(() -> assertEquals(sm.getMembers().size(), 0),
				() -> assertEquals(sm.getMember("emailAddress@email.com"), null));
	}

	@Test
	void int_add_member_spaces_in_last_name() {
		sm = new SiteManager();
		sm.addMember("fName", "lN  ame", "screenName", "emailAddress@email.com");

		assertAll(() -> assertEquals(sm.getMembers().size(), 0),
				() -> assertEquals(sm.getMember("emailAddress@email.com"), null));
	}

	@Test
	void int_add_member_spaces_in_screen_name() {
		sm = new SiteManager();
		sm.addMember("fName", "lName", "scree n N ame", "emailAddress@email.com");

		assertAll(() -> assertEquals(sm.getMembers().size(), 0),
				() -> assertEquals(sm.getMember("emailAddress@email.com"), null));
	}

	@Test
	void int_add_member_spaces_in_eamil() {
		sm = new SiteManager();
		sm.addMember("fName", "lName", "screenName", "emailAd  dress@email.com");

		assertAll(() -> assertEquals(sm.getMembers().size(), 0),
				() -> assertEquals(sm.getMember("emailAd  dress@email.com"), null));
	}

	// *************************************************************************************************
	// getMember(String email)
	// *************************************************************************************************
	@Test
	void int_get_member_normal_text() {
		sm = new SiteManager();
		populateMembers(sm);

		assertAll(() -> assertEquals(sm.getMembers().size(), 5),
				() -> assertEquals(sm.getMember("catsAreAwsome@cats.net").getFirstName(), "Caroline"),
				() -> assertEquals(sm.getMember("BBrown@woohoo.com").getFirstName(), "Bob"),
				() -> assertEquals(sm.getMember("AdaAlyson@example.com").getFirstName(), "Ada"));
	}

	@Test
	void int_get_member_unusal_text() {
		sm = new SiteManager();
		populateMembers(sm);

		assertAll(() -> assertEquals(sm.getMembers().size(), 5),
				() -> assertEquals(sm.getMember("catsAr eAwsome@cats.net"), null),
				() -> assertEquals(sm.getMember("\t\tBBrown@woo\thoo.com"), null),
				() -> assertEquals(sm.getMember("   "), null));
	}

	// *************************************************************************************************
	// getMembers()
	// *************************************************************************************************
	@Test
	void int_get_members() {
		sm = new SiteManager();
		populateMembers(sm);

		assertAll(() -> assertEquals(sm.getMembers().size(), 5),
				() -> assertEquals(sm.getMembers().get(0).getFirstName(), "Ada"),
				() -> assertEquals(sm.getMembers().get(1).getFirstName(), "Randal"),
				() -> assertEquals(sm.getMembers().get(4).getFirstName(), "Zeta"));
	}

	// *************************************************************************************************
	// getMembers()
	// *************************************************************************************************
	@Test
	void int_get_members_searchable() {
		sm = new SiteManager();
		populateMembers(sm);

		assertAll(() -> assertEquals(sm.getMembers("a").size(), 4),
				() -> assertEquals(sm.getMembers("a").get(0).getFirstName(), "Ada"),
				() -> assertEquals(sm.getMembers("a").get(1).getFirstName(), "Randal"),
				() -> assertEquals(sm.getMembers("a").get(3).getFirstName(), "Zeta"));
	}

	void int_get_members_searchable_no_matches() {
		sm = new SiteManager();
		populateMembers(sm);

		assertAll(() -> assertEquals(sm.getMembers("aasdvasdvsvcas").size(), 0),
				() -> assertEquals(sm.getMembers("aasdvasdvsvcas"), null));
	}

	// *************************************************************************************************
	// addGroup()
	// *************************************************************************************************
	@Test
	void int_add_group_with_and_without_spaces() {
		sm = new SiteManager();

		sm.addGroup("Code Rocks", "Coding just freaking rocks doen't it?");
		sm.addGroup("Code Sux", "Why does coding suck so much?");
		sm.addGroup("SeaMonkies", "Just asking questions and giving ansers");
		sm.addGroup("ABC", "description");

		assertAll(() -> assertEquals(sm.getGroups().size(), 4),
				() -> assertEquals(sm.getGroups().get(0).getTitle(), "ABC"),
				() -> assertEquals(sm.getGroups().get(1).getTitle(), "Code Rocks"),
				() -> assertEquals(sm.getGroups().get(3).getTitle(), "SeaMonkies"));
	}

	// *************************************************************************************************
	// getGroups()
	// *************************************************************************************************
	@Test
	void int_get_groups() {
		sm = new SiteManager();

		populateGroups(sm);

		assertAll(() -> assertEquals(sm.getGroups().size(), 4),
				() -> assertEquals(sm.getGroups().get(0).getTitle(), "ABC"),
				() -> assertEquals(sm.getGroups().get(1).getTitle(), "Code Rocks"),
				() -> assertEquals(sm.getGroups().get(3).getTitle(), "SeaMonkies"));
	}

	// *************************************************************************************************
	// getGroup(String title)
	// *************************************************************************************************
	@Test
	void int_get_group_with_and_without_spaces() {
		sm = new SiteManager();

		populateGroups(sm);

		assertAll(() -> assertEquals(sm.getGroups().size(), 4),
				() -> assertEquals(sm.getGroup("ABC").getTitle(), "ABC"),
				() -> assertEquals(sm.getGroup("Code Rocks").getTitle(), "Code Rocks"),
				() -> assertEquals(sm.getGroup("SeaMonkies").getTitle(), "SeaMonkies"));
	}

	// *************************************************************************************************
	// getGroups(String text)
	// *************************************************************************************************
	@Test
	void int_get_groups_with_and_without_spaces() {
		sm = new SiteManager();

		populateGroups(sm);

		assertAll(() -> assertEquals(sm.getGroups("code").size(), 2),
				() -> assertEquals(sm.getGroups("AB").get(0).getTitle(), "ABC"),
				() -> assertEquals(sm.getGroups("Code Rocks").get(0).getTitle(), "Code Rocks"),
				() -> assertEquals(sm.getGroups("asking").get(0).getTitle(), "SeaMonkies"));
	}

	// *************************************************************************************************
	// getPopularGroups(int n)
	// *************************************************************************************************
	@Test
	void int_get_popular_groups_normal_number() {
		sm = new SiteManager();

		populateGroups(sm);
		populateMembers(sm);

		Question question = new Question("Title", "Question text goes here", now);
		Question question2 = new Question("Title2", "Question text goes here2", now);

		sm.getMember("BBrown@woohoo.com").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("catsAreAwsome@cats.net").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("BBrown@woohoo.com").joinGroup(sm.getGroup("ABC"), now);
		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("ABC"), now);
		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("Code Sux"), now);

		// System.out.println(sm.getPopularGroups(3).get(0).getTitle());
		// System.out.println(sm.getPopularGroups(4).get(1).getTitle());
		// System.out.println(sm.getPopularGroups(4).get(2).getTitle());
		// System.out.println(sm.getPopularGroups(4).get(3).getTitle());
		// System.out.println(sm.getPopularGroups(4).size());
		// sm.getMember("catsAreAwsome@cats.net").addQuestion(sm.getGroup("Code Rocks"),
		// question, now);

		assertAll(() -> assertEquals(sm.getPopularGroups(3).size(), 3),
				() -> assertEquals(sm.getPopularGroups(3).get(0).getTitle(), "Code Rocks"),
				() -> assertEquals(sm.getPopularGroups(3).get(1).getTitle(), "ABC"),
				() -> assertEquals(sm.getPopularGroups(3).get(2).getTitle(), "Code Sux"));
	}

	@Test
	void int_get_popular_groups_oversized_number() {
		sm = new SiteManager();

		populateGroups(sm);
		populateMembers(sm);

		Question question = new Question("Title", "Question text goes here", now);
		Question question2 = new Question("Title2", "Question text goes here2", now);

		sm.getMember("BBrown@woohoo.com").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("catsAreAwsome@cats.net").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("BBrown@woohoo.com").joinGroup(sm.getGroup("ABC"), now);
		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("ABC"), now);
		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("Code Sux"), now);

		// sm.getMember("catsAreAwsome@cats.net").addQuestion(sm.getGroup("Code Rocks"),
		// question, now);

		assertAll(() -> assertEquals(sm.getPopularGroups(30).size(), 4),
				() -> assertEquals(sm.getPopularGroups(30).get(0).getTitle(), "Code Rocks"),
				() -> assertEquals(sm.getPopularGroups(30).get(1).getTitle(), "ABC"),
				() -> assertEquals(sm.getPopularGroups(30).get(2).getTitle(), "Code Sux"));
	}

	@Test
	void int_get_popular_groups_negative_number() {
		sm = new SiteManager();

		populateGroups(sm);
		populateMembers(sm);

		Question question = new Question("Title", "Question text goes here", now);
		Question question2 = new Question("Title2", "Question text goes here2", now);

		sm.getMember("BBrown@woohoo.com").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("catsAreAwsome@cats.net").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("BBrown@woohoo.com").joinGroup(sm.getGroup("ABC"), now);
		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("ABC"), now);
		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("Code Sux"), now);

		// sm.getMember("catsAreAwsome@cats.net").addQuestion(sm.getGroup("Code Rocks"),
		// question, now);

		assertEquals(sm.getPopularGroups(-5).size(), 0);

	}

	// *************************************************************************************************
	// getActiveGroups(int n)
	// *************************************************************************************************
	@Test
	void int_get_Active_groups_normal_number() {
		sm = new SiteManager();

		populateGroups(sm);
		populateMembers(sm);

		Question question = new Question("Title", "Question text goes here", now);
		Question question2 = new Question("Title2", "Question text goes here2", now);
		Question question3 = new Question("Title3", "Question text goes here3", now);
		Question question4 = new Question("Title4", "Question text goes here4", now);
		Question question5 = new Question("Title5", "Question text goes here5", now);
		Question question6 = new Question("Title6", "Question text goes here6", now);

		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("ABC"), now);
		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("Code Sux"), now);

		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question2, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question3, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("ABC"), question4, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("ABC"), question5, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Sux"), question6, now);

		// sm.getMember("catsAreAwsome@cats.net").addQuestion(sm.getGroup("Code Rocks"),
		// question, now);

		assertAll(() -> assertEquals(sm.getActiveGroups(3).size(), 3),
				() -> assertEquals(sm.getActiveGroups(3).get(0).getTitle(), "Code Rocks"),
				() -> assertEquals(sm.getActiveGroups(3).get(1).getTitle(), "ABC"),
				() -> assertEquals(sm.getActiveGroups(3).get(2).getTitle(), "Code Sux"));
	}

	@Test
	void int_get_active_groups_oversized_number() {
		sm = new SiteManager();

		populateGroups(sm);
		populateMembers(sm);

		Question question = new Question("Title", "Question text goes here", now);
		Question question2 = new Question("Title2", "Question text goes here2", now);
		Question question3 = new Question("Title3", "Question text goes here3", now);
		Question question4 = new Question("Title4", "Question text goes here4", now);
		Question question5 = new Question("Title5", "Question text goes here5", now);
		Question question6 = new Question("Title6", "Question text goes here6", now);

		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("ABC"), now);
		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("Code Sux"), now);

		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question2, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question3, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("ABC"), question4, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("ABC"), question5, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Sux"), question6, now);

		// sm.getMember("catsAreAwsome@cats.net").addQuestion(sm.getGroup("Code Rocks"),
		// question, now);

		assertAll(() -> assertEquals(sm.getActiveGroups(30).size(), 4),
				() -> assertEquals(sm.getActiveGroups(30).get(0).getTitle(), "Code Rocks"),
				() -> assertEquals(sm.getActiveGroups(30).get(1).getTitle(), "ABC"),
				() -> assertEquals(sm.getActiveGroups(30).get(2).getTitle(), "Code Sux"));
	}

	@Test
	void int_get_active_groups_negative_number() {
		sm = new SiteManager();

		populateGroups(sm);
		populateMembers(sm);

		Question question = new Question("Title", "Question text goes here", now);
		Question question2 = new Question("Title2", "Question text goes here2", now);
		Question question3 = new Question("Title3", "Question text goes here3", now);
		Question question4 = new Question("Title4", "Question text goes here4", now);
		Question question5 = new Question("Title5", "Question text goes here5", now);
		Question question6 = new Question("Title6", "Question text goes here6", now);

		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("ABC"), now);
		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("Code Sux"), now);

		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question2, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question3, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("ABC"), question4, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("ABC"), question5, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Sux"), question6, now);

		assertEquals(sm.getPopularGroups(-5).size(), 0);

	}

	// *************************************************************************************************
	// getActiveMembers(int n)
	// *************************************************************************************************
	@Test
	void int_get_Active_members_normal_number() {
		sm = new SiteManager();

		populateGroups(sm);
		populateMembers(sm);

		Question question = new Question("Title", "Question text goes here", now);
		Question question2 = new Question("Title2", "Question text goes here2", now);
		Question question3 = new Question("Title3", "Question text goes here3", now);
		Question question4 = new Question("Title4", "Question text goes here4", now);
		Question question5 = new Question("Title5", "Question text goes here5", now);
		Question question6 = new Question("Title6", "Question text goes here6", now);

		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("BBrown@woohoo.com").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("catsAreAwsome@cats.net").joinGroup(sm.getGroup("Code Rocks"), now);

		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question2, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question3, now);
		sm.getMember("BBrown@woohoo.com").addQuestion(sm.getGroup("Code Rocks"), question4, now);
		sm.getMember("BBrown@woohoo.com").addQuestion(sm.getGroup("Code Rocks"), question5, now);
		sm.getMember("catsAreAwsome@cats.net").addQuestion(sm.getGroup("Code Rocks"), question6, now);

		// sm.getMember("catsAreAwsome@cats.net").addQuestion(sm.getGroup("Code Rocks"),
		// question, now);

		assertAll(() -> assertEquals(sm.getActiveMembers(3).size(), 3),
				() -> assertEquals(sm.getActiveMembers(3).get(0).getFirstName(), "Zeta"),
				() -> assertEquals(sm.getActiveMembers(3).get(1).getFirstName(), "Bob"),
				() -> assertEquals(sm.getActiveMembers(3).get(2).getFirstName(), "Caroline"));
	}

	@Test
	void int_get_active_members_oversized_number() {
		sm = new SiteManager();

		populateGroups(sm);
		populateMembers(sm);

		Question question = new Question("Title", "Question text goes here", now);
		Question question2 = new Question("Title2", "Question text goes here2", now);
		Question question3 = new Question("Title3", "Question text goes here3", now);
		Question question4 = new Question("Title4", "Question text goes here4", now);
		Question question5 = new Question("Title5", "Question text goes here5", now);
		Question question6 = new Question("Title6", "Question text goes here6", now);

		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("BBrown@woohoo.com").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("catsAreAwsome@cats.net").joinGroup(sm.getGroup("Code Rocks"), now);

		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question2, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question3, now);
		sm.getMember("BBrown@woohoo.com").addQuestion(sm.getGroup("Code Rocks"), question4, now);
		sm.getMember("BBrown@woohoo.com").addQuestion(sm.getGroup("Code Rocks"), question5, now);
		sm.getMember("catsAreAwsome@cats.net").addQuestion(sm.getGroup("Code Rocks"), question6, now);

		// sm.getMember("catsAreAwsome@cats.net").addQuestion(sm.getGroup("Code Rocks"),
		// question, now);

		assertAll(() -> assertEquals(sm.getActiveMembers(30).size(), 5),
				() -> assertEquals(sm.getActiveMembers(30).get(0).getFirstName(), "Zeta"),
				() -> assertEquals(sm.getActiveMembers(30).get(1).getFirstName(), "Bob"),
				() -> assertEquals(sm.getActiveMembers(30).get(2).getFirstName(), "Caroline"));
	}

	@Test
	void int_get_active_members_negative_number() {
		sm = new SiteManager();

		populateGroups(sm);
		populateMembers(sm);

		Question question = new Question("Title", "Question text goes here", now);
		Question question2 = new Question("Title2", "Question text goes here2", now);
		Question question3 = new Question("Title3", "Question text goes here3", now);
		Question question4 = new Question("Title4", "Question text goes here4", now);
		Question question5 = new Question("Title5", "Question text goes here5", now);
		Question question6 = new Question("Title6", "Question text goes here6", now);

		sm.getMember("Zaaffarack@zzzzz.zz").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("BBrown@woohoo.com").joinGroup(sm.getGroup("Code Rocks"), now);
		sm.getMember("catsAreAwsome@cats.net").joinGroup(sm.getGroup("Code Rocks"), now);

		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question2, now);
		sm.getMember("Zaaffarack@zzzzz.zz").addQuestion(sm.getGroup("Code Rocks"), question3, now);
		sm.getMember("BBrown@woohoo.com").addQuestion(sm.getGroup("Code Rocks"), question4, now);
		sm.getMember("BBrown@woohoo.com").addQuestion(sm.getGroup("Code Rocks"), question5, now);
		sm.getMember("catsAreAwsome@cats.net").addQuestion(sm.getGroup("Code Rocks"), question6, now);

		// sm.getMember("catsAreAwsome@cats.net").addQuestion(sm.getGroup("Code Rocks"),
		// question, now);

		assertEquals(sm.getActiveMembers(-5).size(), 0);

	}

	private void populateMembers(SiteManager temp) {
		temp.addMember("Caroline", "Charn", "ccQween", "catsAreAwsome@cats.net");
		temp.addMember("Bob", "Brown", "BbBrown", "BBrown@woohoo.com");
		temp.addMember("Ada", "Alyson", "AdaAlly", "AdaAlyson@example.com");
		temp.addMember("Randal", "Alyson", "RadAlly", "Rayson@example.com");
		temp.addMember("Zeta", "Zylon", "Zaaffarack", "Zaaffarack@zzzzz.zz");
	}

	private void populateGroups(SiteManager temp) {
		temp.addGroup("Code Rocks", "Coding just freaking rocks doen't it?");
		temp.addGroup("Code Sux", "Why does coding suck so much?");
		temp.addGroup("SeaMonkies", "Just asking questions and giving ansers");
		temp.addGroup("ABC", "description");
	}

}
