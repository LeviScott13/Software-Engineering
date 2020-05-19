package dev1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersistenceManagerTest {
	// PersistenceManager p = new PersistenceManager();
	SiteManager s = new SiteManager();

	File file = new File(".\\Save.bin");

	@DisplayName("Save with only members added")
	@Test
	void test() throws IOException {
		s = new SiteManager();
		s.addMember("fName", "lName", "screenName", "emailAddress@exmaple.com");
		s.addMember("fName2", "lName2", "screenName2", "emailAddress2@exmaple.com");
		

		PersistenceManager.save(s, file);

		SiteManager s2 = PersistenceManager.read(file);

		assertEquals(s.getMembers().get(0).toString(), s2.getMembers().get(0).toString());

	}

	@DisplayName("Save with only groups added")
	@Test
	void test1() throws IOException {
		s = new SiteManager();
		s.addGroup("title", "description");
		s.addGroup("title2", "description2");

		PersistenceManager.save(s, file);

		SiteManager s2 = PersistenceManager.read(file);


		assertEquals(s.getGroups().get(0).toString(), s2.getGroups().get(0).toString());

	}

	@DisplayName("Save with members and groups added")
	@Test
	void test2() throws IOException {
		s = new SiteManager();
		s.addMember("fName", "lName", "screenName", "emailAddress@exmaple.com");
		s.addMember("fName2", "lName2", "screenName2", "emailAddress2@exmaple.com");
		s.addGroup("title", "description");
		s.addGroup("title2", "description2");

		// save to the file
		PersistenceManager.save(s, file);
		
		// reads from the file
		SiteManager s2 = PersistenceManager.read(file);


		assertEquals(s.getGroups().get(0).toString(), s2.getGroups().get(0).toString());
		assertEquals(s.getMembers().get(0).toString(), s2.getMembers().get(0).toString());
	}

	@DisplayName("Save with nothing added to SiteManager")
	@Test
	void test3() throws IOException {
		s = new SiteManager();

		// save to the file
		PersistenceManager.save(s, file);
		// reads from the file
		SiteManager s2 = PersistenceManager.read(file);



		assertEquals(s.getGroups().size(), 0);
		assertEquals(s.getMembers().size(), 0);
	}
}