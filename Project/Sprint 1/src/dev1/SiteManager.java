package dev1;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class SiteManager implements Serializable {

	private static final long serialVersionUID = -3181391831438805922L;

	ArrayList<Member> members = new ArrayList<>();
	ArrayList<Group> groups = new ArrayList<>();

	LocalDateTime now;

	public SiteManager() {

	}

	public boolean addMember(String fName, String lName, String screenName, String emailAddress) {

		if (fName.contains(" ")) {
			return false;
		}
		if (lName.contains(" ")) {
			return false;
		}
		if (screenName.contains(" ")) {
			return false;
		}
		if (emailAddress.contains(" ") || !emailAddress.contains("@")) {
			return false;
		}

		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getScreenName().equals(screenName)
					|| members.get(i).getEmailAddress().equals(emailAddress)) {
				return false;
			}
		}

		now = LocalDateTime.now();
		Member mem = new Member(fName, lName, screenName, emailAddress, now);
		members.add(mem);
		return true;
	}

	public Member getMember(String email) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getEmailAddress().equals(email)) {
				return members.get(i);
			}
		}
		return null;
	}

	public List<Member> getMembers() {
		Collections.sort(members);
		return members;
	}

	public List<Member> getMembers(String text) {
		List<Member> memb = new ArrayList<>();

		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getFirstName().contains(text)) {
				memb.add(members.get(i));
				continue;
			}
			if (members.get(i).getLastName().contains(text)) {
				memb.add(members.get(i));
				continue;
			}
			if (members.get(i).getScreenName().contains(text)) {
				memb.add(members.get(i));
				continue;
			}
			if (members.get(i).getEmailAddress().contains(text)) {
				memb.add(members.get(i));
				continue;
			}
		}
		Collections.sort(memb);
		return memb;
	}

	public boolean addGroup(String title, String description) {

		for (int i = 0; i < groups.size(); i++) {
			if (groups.get(i).getTitle().equalsIgnoreCase(title) || groups.get(i).getDescription().equals(description))
				return false;
		}

		now = LocalDateTime.now();
		Group gr = new Group(title, description, now);
		groups.add(gr);
		return true;
	}

	public List<Group> getGroups() {
		Collections.sort(groups);
		return groups;
	}

	public Group getGroup(String title) {
		for (int i = 0; i < groups.size(); i++) {
			if (groups.get(i).getTitle().equalsIgnoreCase(title)) {
				return groups.get(i);
			}
		}
		return null;
	}

	public List<Group> getGroups(String text) {
		List<Group> returnable = new ArrayList<>();

		for (int i = 0; i < groups.size(); i++) {
			if (groups.get(i).getTitle().toLowerCase().contains(text.toLowerCase())
					|| groups.get(i).getDescription().toLowerCase().contains(text.toLowerCase())) {
				returnable.add(groups.get(i));
			}
		}

		if (returnable.size() == 0) {
			return null;
		}
		Collections.sort(returnable);
		return returnable;
	}

	public List<Group> getPopularGroups(int n) {

		List<Group> returnable = new ArrayList<>(groups);
//		 List<Group> returnable = new ArrayList<Group>();
//		 int maxIndex;
//
//		 for (int i = 0; i < groups.size(); i++) {
//		 	temp.add(groups.get(i));
//		}
//
//		for (int i = 0; i < temp.size() - 1; i++) {
//			maxIndex = i;
//			for (int j = i + 1; j < temp.size(); j++) {
//				if (temp.get(j).getNumMembers() > temp.get(maxIndex).getNumMembers()) {
//					maxIndex = j;
//				}
//		 		Group tempGroup = temp.get(i);
//		 		temp.set(i, temp.get(maxIndex));
//				temp.set(maxIndex, tempGroup);
//		 	}
//		 }
//
//		 if (n > temp.size()) {
//		 	return temp;
//		 }
//
//		 for (int i = 0; i < n; i++) {
//		 	returnable.add(temp.get(i));
//		 }
//		returnable.stream().ma ;
		return returnable;
	}

	public List<Group> getActiveGroups(int n) {
		List<Group> temp = new ArrayList<Group>();
		List<Group> returnable = new ArrayList<Group>();
		int maxIndex;

		for (int i = 0; i < groups.size(); i++) {
			temp.add(groups.get(i));
		}

		for (int i = 0; i < temp.size() - 1; i++) {
			maxIndex = i;
			for (int j = i + 1; j < temp.size(); j++) {
				if (temp.get(j).getPoints() > temp.get(maxIndex).getPoints()) {
					maxIndex = j;
				}
				Group tempGroup = temp.get(i);
				temp.set(i, temp.get(maxIndex));
				temp.set(maxIndex, tempGroup);
			}
		}

		if (n > temp.size()) {
			return temp;
		}

		for (int i = 0; i < n; i++) {
			returnable.add(temp.get(i));
		}

		return returnable;
	}

	public List<Member> getActiveMembers(int n) {
		List<Member> temp = new ArrayList<Member>();
		List<Member> returnable = new ArrayList<Member>();
		int maxIndex;

		for (int i = 0; i < members.size(); i++) {
			temp.add(members.get(i));
		}

		for (int i = 0; i < temp.size() - 1; i++) {
			maxIndex = i;
			for (int j = i + 1; j < temp.size(); j++) {
				if (temp.get(j).getPoints() > temp.get(maxIndex).getPoints()) {
					maxIndex = j;
				}
				Member tempGroup = temp.get(i);
				temp.set(i, temp.get(maxIndex));
				temp.set(maxIndex, tempGroup);
			}
		}

		if (n > temp.size()) {
			return temp;
		}

		for (int i = 0; i < n; i++) {
			returnable.add(temp.get(i));
		}

		return returnable;
	}
}
