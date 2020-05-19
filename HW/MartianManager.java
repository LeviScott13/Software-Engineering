package hw1a;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is used to manage martian objects.
 * @author dgibson
 *
 */
//public class MartianManager implements Cloneable {
public class MartianManager {
	/**
	 * Stores subclass instances of Martian.
	 */
	protected ArrayList<Martian> martians = new ArrayList<>();
	/**
	 * Stores Martain instances that implement ITeleporter.
	 */
	protected ArrayList<Teleporter> teleporters = new ArrayList<>();

	/**
	 * Add a <code>m</code> to {@link MartianManager#martians}
	 * @param m The Martian to be added
	 * @return <code>true</code> if successful, otherwise <code>false</code>
	 */
	public boolean addMartian(Martian m) {

		if( !martians.contains(m)) {
			martians.add(m);
			if(m instanceof GreenMartian) {
				teleporters.add( (GreenMartian)m );
			}
			return true;
		}
		return false;
	}

	/**
	 * Creates a clone of this MartianManager instance; warning: this requires a deep copy.
	 *
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		MartianManager cman = new MartianManager();
		for(Martian m: martians) {
			cman.addMartian((Martian)m.clone());
		}
		return cman;
	}

	/**
	 * Returns the number of Martains in {@link MartianManager#martians}.
	 * @return The number of Martains in {@link MartianManager#martians}.
	 */
	public int getNumMartians() {
		return martians.size();
	}

	public int getNumTeleporters() {
		return teleporters.size();
	}

	/**
	 * Returns the <code>i</code>th Martian in {@link MartianManager#martians}.
	 * @param i
	 * @return
	 */
	public Martian getMartianAt(int i) {
//		if( (i<0) || (i>=martians.size()))
//			return null;
//		return martians.get(i);
		return null;
	}

	public Teleporter getTeleporterAt(int i) {
		if( (i<0) || (i>=teleporters.size()))
			return null;
		return teleporters.get(i);
	}

	/**
	 * Returns the Martian in {@link MartianManager#martians} that has an <code>id</code>
	 * closest to the <code>id</code> supplied; Note: “closest” doesn’t mean the next martian,
	 * For example, if you have ids: 6, 9, 13, 18 and you call the method with 10,
	 * then the martian with id=9 should be returned.
	 * @param id
	 * @return
	 */
	public Martian getMartianClosestToId(int id) {
		Martian closest = null;
		int minDist = Integer.MAX_VALUE;
		for(Martian m: martians) {
			int dist = Math.abs(m.getId() - id);
//			int dist = m.getId() - id;			
			if( dist < minDist ) {
				minDist = dist;
				closest = m;
			}
		}
		return closest;
	}

	public double getAverageId() {
		double sum = 0.0;
		for(Martian m : martians) {
			sum += m.getId();
		}
		return sum/martians.size();
	}
	
	/**
	 * @param martian
	 * @return
	 */
	public Martian getMartianClosestToId(Martian martian) {
		return getMartianClosestToId(martian.getId());
	}

	/**
	 * @return
	 */
	public String groupSpeak() {
		StringBuilder msg = new StringBuilder();
		for(Martian m: martians) {
			msg.append(m.speak() + "\n");
		}
		return msg.toString();
	}

	/**
	 * @param dest
	 * @return
	 */
	public String groupTeleport(String dest) {
		StringBuilder msg = new StringBuilder();
		for(Teleporter t: teleporters) {
			msg.append(t.teleport(dest) + "\n");
		}
		return msg.toString();
	}

	/**
	 *
	 */
	public void obliterateTeleporters() {
		for(Teleporter t: teleporters) {
			martians.remove((Martian)t);
		}
		teleporters.clear();
	}

	public Martian getMartianWithId(int id) {
		Martian dummy = new GreenMartian(id);
		int loc = martians.indexOf(dummy);

		if(loc != -1) {
			return martians.get(loc);
		}
		return null;
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean removeMartian(int id) {
		Martian dummy = new GreenMartian(id);
		int loc = martians.indexOf(dummy);

		if( loc == -1 )
			return false;

		Martian m = martians.get(loc);

		martians.remove(loc);

		if( m instanceof GreenMartian) {
			Teleporter tele = (Teleporter)m;
			teleporters.remove(tele);
		}
		return true;
	}


	/**
	 * @return
	 */
	public ArrayList<Martian> sortedMartians() {
		ArrayList<Martian> sorted = (ArrayList<Martian>)martians.clone();
		Collections.sort(sorted);
		return sorted;
	}
}
