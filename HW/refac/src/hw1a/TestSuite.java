package hw1a;

import java.util.ArrayList;
import java.util.Arrays;

public class TestSuite {

	public static ArrayList<String> test01() {
		// Test2 1 - Martian.equals()
		ArrayList<String> results = new ArrayList<>();

		RedMartian r3 = new RedMartian(2);
		GreenMartian g1 = new GreenMartian(11);
		GreenMartian g4 = new GreenMartian(2);

		results.add("Martian.equals()");  // Description
		results.add("5.0");  // Problem worth (points)
		try{
			results.add("r3.equals(g1)= " + (r3.equals(g1)));
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		try{
			results.add("r3.equals(g4)= " + (r3.equals(g4)));
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		return results;
	}

	public static ArrayList<String> test02() {
		// Test2 02 - Martian.compareTo()
		ArrayList<String> results = new ArrayList<>();

		RedMartian r1 = new RedMartian(8);
		RedMartian r2 = new RedMartian(18);
		RedMartian r3 = new RedMartian(2);
		GreenMartian g1 = new GreenMartian(11);
		GreenMartian g2 = new GreenMartian(4);
		GreenMartian g3 = new GreenMartian(10);
		GreenMartian g4 = new GreenMartian(2);

		results.add("Martian.compareTo()");
		results.add("5");  // Problem worth (points)
		try{
			results.add("r3.compareTo(g1)= " + (r3.compareTo(g1)));
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		try{
			results.add("r3.compareTo(g4)= " + (r3.compareTo(g4)));
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		try{
			results.add("r2.compareTo(g3)= " + (r2.compareTo(g3)));
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		return results;
	}

	public static ArrayList<String> test03() throws CloneNotSupportedException {
		// Test2 03 - Martian.clone()
		ArrayList<String> results = new ArrayList<>();

		Martian m = new RedMartian(83);
		m.setVolume(44);
		Martian mClone = (Martian)m.clone();
		mClone.setVolume(77);

		results.add("Martian.clone()");
		results.add("5");  // Problem worth (points)
		try{
			results.add(String.format("m.getVolume()=%d, mClone.getVolume()=%d", m.getVolume(), mClone.getVolume()));
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		return results;
	}

	public static ArrayList<String> test04() throws CloneNotSupportedException {
		// Test2 04 - MartianManager.addMartian()
		ArrayList<String> results = new ArrayList<>();

		RedMartian r1 = new RedMartian(8);
		RedMartian r2 = new RedMartian(18);
		RedMartian r3 = new RedMartian(2);

		GreenMartian g1 = new GreenMartian(11);
		GreenMartian g2 = new GreenMartian(4);
		GreenMartian g3 = new GreenMartian(10);
		GreenMartian g4 = new GreenMartian(2);
		MartianManager mm = new MartianManager();

		results.add("MartianManager.addMartian()");
		results.add("5");  // Problem worth (points)
		StringBuilder detRes = new StringBuilder();
		try{
			// Add some reds
			detRes.append("mm.addMartian(r1)=" + mm.addMartian(r1) + ", ");
			detRes.append("mm.addMartian(r2)=" + mm.addMartian(r2) + ", ");
			detRes.append("mm.addMartian(r3)=" + mm.addMartian(r3));
			results.add(detRes.toString());
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		detRes = new StringBuilder();
		try{
			// Add some greens
			detRes.append("mm.addMartian(g1)=" + mm.addMartian(g1) + ", ");
			detRes.append("mm.addMartian(g2)=" + mm.addMartian(g2) + ", ");
			detRes.append("mm.addMartian(g3)=" + mm.addMartian(g3));
			results.add(detRes.toString());
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		detRes = new StringBuilder();
		try{
			// Add a duplicate
			detRes.append("mm.addMartian(g4)=" + mm.addMartian(g4));
			results.add(detRes.toString());
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		return results;
	}

	public static ArrayList<String> test05() throws CloneNotSupportedException {
		// Test2 05 - MartianManager.getMartianAt()
		ArrayList<String> results = new ArrayList<>();

		RedMartian r1 = new RedMartian(8);
		RedMartian r2 = new RedMartian(18);
		RedMartian r3 = new RedMartian(2);

		GreenMartian g1 = new GreenMartian(11);
		GreenMartian g2 = new GreenMartian(4);
		GreenMartian g3 = new GreenMartian(10);
		GreenMartian g4 = new GreenMartian(2);
		MartianManager mm = new MartianManager();
		mm.addMartian(r1); mm.addMartian(g3); mm.addMartian(r3); mm.addMartian(r2); mm.addMartian(g2);

		results.add("MartianManager.getMartianAt()");
		results.add("5");  // Problem worth (points)
		try{
			results.add("mm.getMartianAt(2).getId()=" + mm.getMartianAt(2).getId());
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		try{
			results.add("mm.getMartianAt(99)=" + mm.getMartianAt(99));
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		return results;
	}

	public static ArrayList<String> test06() throws CloneNotSupportedException {
		// Test2 06 - MartianManager.getTeleporterAt()
		ArrayList<String> results = new ArrayList<>();

		RedMartian r1 = new RedMartian(8);
		RedMartian r2 = new RedMartian(18);
		RedMartian r3 = new RedMartian(2);

		GreenMartian g1 = new GreenMartian(11);
		GreenMartian g2 = new GreenMartian(4);
		GreenMartian g3 = new GreenMartian(10);
		GreenMartian g4 = new GreenMartian(2);
		MartianManager mm = new MartianManager();
		mm.addMartian(r1); mm.addMartian(g3); mm.addMartian(r3); mm.addMartian(r2); mm.addMartian(g2);

		results.add("MartianManager.getTeleporterAt()");
		results.add("5");  // Problem worth (points)
		try{
			GreenMartian gm = ((GreenMartian)mm.getTeleporterAt(1));
			results.add("((GreenMartian)mm.getTeleporterAt(1)).getId()=" + gm.getId());
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		try{
			results.add("mm.getTeleporterAt(99)=" + mm.getTeleporterAt(99));
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		return results;
	}

	public static ArrayList<String> test07() throws CloneNotSupportedException {
		// Test2 07 - MartianManager.getMartianWithId()
		ArrayList<String> results = new ArrayList<>();

		RedMartian r1 = new RedMartian(8);
		RedMartian r2 = new RedMartian(18);
		RedMartian r3 = new RedMartian(2);

		GreenMartian g1 = new GreenMartian(11);
		GreenMartian g2 = new GreenMartian(4);
		GreenMartian g3 = new GreenMartian(10);
		GreenMartian g4 = new GreenMartian(2);
		MartianManager mm = new MartianManager();
		mm.addMartian(r1); mm.addMartian(g3); mm.addMartian(r3); mm.addMartian(r2); mm.addMartian(g2);

		results.add("MartianManager.getMartianWithId()");
		results.add("5");  // Problem worth (points)
		try{
			results.add("mm.getMartianWithId(10).getId()=" + mm.getMartianWithId(10).getId());
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		try{
			results.add("mm.getMartianWithId(99)=" + mm.getMartianWithId(99));
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		return results;
	}

	public static ArrayList<String> test08() throws CloneNotSupportedException {
		// Test2 08 - MartianManager.getMartianClosestToId()
		ArrayList<String> results = new ArrayList<>();

		RedMartian r1 = new RedMartian(8);
		RedMartian r2 = new RedMartian(18);
		RedMartian r3 = new RedMartian(2);

		GreenMartian g1 = new GreenMartian(11);
		GreenMartian g2 = new GreenMartian(4);
		GreenMartian g3 = new GreenMartian(10);
		GreenMartian g4 = new GreenMartian(2);
		MartianManager mm = new MartianManager();
		mm.addMartian(r1); mm.addMartian(r2); mm.addMartian(r3);
		mm.addMartian(g1); mm.addMartian(g2); mm.addMartian(g3);

		results.add("MartianManager.getMartianClosestToId()");
		results.add("5");  // Problem worth (points)
		try{
			results.add("mm.getMartianClosestToId(7).getId()=" + mm.getMartianClosestToId(7).getId());
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		try{
			results.add("mm.getMartianClosestToId(12).getId()=" + mm.getMartianClosestToId(12).getId());
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		return results;
	}

	public static ArrayList<String> test09() throws CloneNotSupportedException {
		// Test2 09 - MartianManager.removeMartian()
		ArrayList<String> results = new ArrayList<>();

		RedMartian r1 = new RedMartian(8);
		RedMartian r2 = new RedMartian(18);
		RedMartian r3 = new RedMartian(2);

		GreenMartian g1 = new GreenMartian(11);
		GreenMartian g2 = new GreenMartian(4);
		GreenMartian g3 = new GreenMartian(10);
		GreenMartian g4 = new GreenMartian(2);
		MartianManager mm = new MartianManager();
		mm.addMartian(r1); mm.addMartian(r2); mm.addMartian(r3);
		mm.addMartian(g1); mm.addMartian(g2); mm.addMartian(g3);

		results.add("MartianManager.removeMartian()");
		results.add("5");  // Problem worth (points)
		try{
			results.add(String.format("mm.removeMartian(18)=%s, mm.getNumMartians()=%d", mm.removeMartian(18), mm.getNumMartians()));
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		try{
			results.add(String.format("mm.removeMartian(99)=%b, mm.getNumMartians()=%d", mm.removeMartian(99), mm.getNumMartians()));
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		try{
			results.add(String.format("mm.removeMartian(4)=%b, mm.getNumMartians()=%d, "
					+ "mm.getNumTeleporters()=%d", mm.removeMartian(4), mm.getNumMartians(),
					mm.getNumTeleporters()));
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}
		return results;
	}

	public static ArrayList<String> test10() throws CloneNotSupportedException {
		// Test2 10 - MartianManager.sortedMartians()
		ArrayList<String> results = new ArrayList<>();

		RedMartian r1 = new RedMartian(8);
		RedMartian r2 = new RedMartian(18);
		RedMartian r3 = new RedMartian(2);

		GreenMartian g1 = new GreenMartian(11);
		GreenMartian g2 = new GreenMartian(4);
		GreenMartian g3 = new GreenMartian(10);
		GreenMartian g4 = new GreenMartian(2);
		MartianManager mm = new MartianManager();
		mm.addMartian(r1); mm.addMartian(r2); mm.addMartian(r3);
		mm.addMartian(g1); mm.addMartian(g2); mm.addMartian(g3);

		results.add("MartianManager.sortedMartians()");
		results.add("5");  // Problem worth (points)
		try{
			ArrayList<Martian> sortedMartians = mm.sortedMartians();
			ArrayList<Integer> ids = new ArrayList<>();
			for(Martian m : sortedMartians) ids.add(m.getId());
			results.add("mm.getMartianAt(0).getId()=" + mm.getMartianAt(0).getId() + ", mm.sortedMartians()= " + ids);
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		return results;
	}

	public static ArrayList<String> test11() throws CloneNotSupportedException {
		// Test2 11 - MartianManager.obliterateTeleporters()
		ArrayList<String> results = new ArrayList<>();

		RedMartian r1 = new RedMartian(8);
		RedMartian r2 = new RedMartian(18);
		RedMartian r3 = new RedMartian(2);

		GreenMartian g1 = new GreenMartian(11);
		GreenMartian g2 = new GreenMartian(4);
		GreenMartian g3 = new GreenMartian(10);
		GreenMartian g4 = new GreenMartian(2);
		MartianManager mm = new MartianManager();
		mm.addMartian(r1); mm.addMartian(r2); mm.addMartian(r3);
		mm.addMartian(g1); mm.addMartian(g2); mm.addMartian(g3);

		results.add("MartianManager.obliterateTeleporters()");
		results.add("5");  // Problem worth (points)
		try{
			mm.obliterateTeleporters();
			results.add("mm.getNumTeleporters()=" + mm.getNumTeleporters());
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		return results;
	}

	public static ArrayList<String> test12() throws CloneNotSupportedException {
		// Test2 12 - MartianManager.clone()
		ArrayList<String> results = new ArrayList<>();

		RedMartian r1 = new RedMartian(8);
		RedMartian r2 = new RedMartian(18);
		RedMartian r3 = new RedMartian(2);

		GreenMartian g1 = new GreenMartian(11);
		GreenMartian g2 = new GreenMartian(4);
		GreenMartian g3 = new GreenMartian(10);
		GreenMartian g4 = new GreenMartian(2);
		MartianManager mm = new MartianManager();
		mm.addMartian(r1); mm.addMartian(r2); mm.addMartian(r3);
		mm.addMartian(g1); mm.addMartian(g2); mm.addMartian(g3);

		results.add("MartianManager.clone()");
		results.add("5");  // Problem worth (points)
		try{
			MartianManager mmClone = (MartianManager)mm.clone();
			Martian mClone = mmClone.getMartianAt(0);
			mClone.setVolume(999);

			StringBuilder detRes = new StringBuilder();
			detRes.append("mm.getMartianAt(0).getVolume()=" + mm.getMartianAt(0).getVolume() + ", ");
			detRes.append("mClone.getVolume()=" + mClone.getVolume());
			results.add(detRes.toString());
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		return results;
	}

	public static ArrayList<String> test13() {
		// Test2 13 - Martian.toString()
		ArrayList<String> results = new ArrayList<>();

		RedMartian r1 = new RedMartian(8);
		GreenMartian g1 = new GreenMartian(11);


		results.add("Martian.toString()");
		results.add("5");  // Problem worth (points)
		try{
			results.add("r1 contains id=8 = " + r1.toString().contains("8"));
			results.add("r1 contains vol=1 = " + r1.toString().contains("1"));
			results.add("g1 contains id=8 = " + g1.toString().contains("11"));
			results.add("g1 contains vol=1 = " + g1.toString().contains("1"));
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		return results;
	}

	public static ArrayList<String> test14() {
		// Test2 14 - MartianManager.groupSpeak()
		ArrayList<String> results = new ArrayList<>();

		RedMartian r1 = new RedMartian(8);
		RedMartian r3 = new RedMartian(2);
		GreenMartian g2 = new GreenMartian(4);
		GreenMartian g3 = new GreenMartian(10);
		MartianManager mm = new MartianManager();

		mm.addMartian(r1); mm.addMartian(g3); mm.addMartian(r3); mm.addMartian(g2);

		results.add("MartianManager.groupSpeak()");
		results.add("5");  // Problem worth (points)
		try{
			String grpSpk = mm.groupSpeak();
			int[] countsIds = new int[4];
			countsIds[0] = countOccurrences(grpSpk,"8");
			countsIds[1] = countOccurrences(grpSpk,"2");
			countsIds[2] = countOccurrences(grpSpk,"10");
			countsIds[3] = countOccurrences(grpSpk,"4");
			int countGs = countOccurrences(grpSpk," G");
			int countgs = countOccurrences(grpSpk," g");
			int countRs = countOccurrences(grpSpk," R");
			int countrs = countOccurrences(grpSpk," r");
			results.add("countsIds=" + Arrays.toString(countsIds));
			results.add("countGs=" + (countGs+countgs) + ", countRs=" + (countRs+countrs));
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		return results;
	}

	public static ArrayList<String> test15() {
		// Test2 15 - MartianManager.Teleport(\"Orck\")
		ArrayList<String> results = new ArrayList<>();

		RedMartian r1 = new RedMartian(8);
		RedMartian r3 = new RedMartian(2);
		GreenMartian g2 = new GreenMartian(4);
		GreenMartian g3 = new GreenMartian(10);
		MartianManager mm = new MartianManager();

		mm.addMartian(r1); mm.addMartian(g3); mm.addMartian(r3); mm.addMartian(g2);

		results.add("MartianManager.Teleport(\"Orck\")");
		results.add("5");  // Problem worth (points)
		try{
			String grpTel = mm.groupTeleport("Orck");
			int[] countsIds = new int[4];
			countsIds[0] = countOccurrences(grpTel,"8");
			countsIds[1] = countOccurrences(grpTel,"2");
			countsIds[2] = countOccurrences(grpTel,"10");
			countsIds[3] = countOccurrences(grpTel,"4");
			int countOrcks = countOccurrences(grpTel," Orck");
			int countorcks = countOccurrences(grpTel," orck");

			results.add("countsIds=" + Arrays.toString(countsIds));
			results.add("count Orcks=" + (countOrcks+countorcks));
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		return results;
	}

	public static ArrayList<String> test16() {
		// Test2 16 - MartianManager.Teleport(\"Orck\")
		ArrayList<String> results = new ArrayList<>();

		RedMartian r1 = new RedMartian(8);
		RedMartian r3 = new RedMartian(2);
		GreenMartian g2 = new GreenMartian(4);
		GreenMartian g3 = new GreenMartian(12);
		MartianManager mm = new MartianManager();

		mm.addMartian(r1); mm.addMartian(g3); mm.addMartian(r3); mm.addMartian(g2);

		results.add("MartianManager.getAverageId()");
		results.add("5");  // Problem worth (points)
		try{
			results.add("%d " + mm.getAverageId() + " %tp 1.0 mm.getAverageId()=" + mm.getAverageId());
//			results.add("%d " + acnt.getBalance() + " %tp 1.0 acnt.getBalanace()=" + bal);			
		}
		catch(RuntimeException e) {
			results.add(e.toString());
		}

		return results;
	}

	private static int countOccurrences(String source, String lookFor) {
		int loc = 0;
		int count = 0;
		while(loc<source.length()) {
			int pos = source.indexOf(lookFor, loc);
			if(pos >= 0) {
				count++;
				loc=pos+1;
			}
			else {
				return count;
			}
		}
		return 0;
	}


}
