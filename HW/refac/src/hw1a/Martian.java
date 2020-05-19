package hw1a;

/**
 * This abstract class models a Martian.
 * @author dgibson
 *
 */
public abstract class Martian implements Cloneable, Comparable<Martian> {

	/**
	 * Every Martian has an id which is simply an integer.
	 */
	private int id;
	/**
	 *  Every Martian has an volume which is simply an integer.
	 */
	private int volume;

	/**
	 * Creates a Martian with the specified <code>id</code> and sets the <code>volume</code> to 1
	 * @param id
	 */
	public Martian(int id) {
		this.id = id;
		this.volume = 1;
	}

	/**
	 * Creates and returns a clone of the Martian
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * Two Martians are equal if their <code>id</code>’s are equal, regardless of whether they are <code>GreenMartian</code>s or <code>RedMartians</code>s.
	 */
	@Override
	public boolean equals(Object o) {
//		int m = (int)o;
//		return false;
		Martian m = (Martian)o;
		if(id == m.getId())
			return true;
		else
			return false;
	}

	/**
	 * Returns the <code>id</code> for the Martian.
	 * @return The id for the Martian.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the <code>volume</code> for the Martian.
	 * @return The volume for the Martian.
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * Set the <code>volume</code> for the Martian
	 * @param volume
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}

	/**
	 * Martian subclasses must implement this method to speak in the way that makes sense for them.
	 * @return The string that the Martian speaks.
	 */
	public abstract String speak();

	/**
	 * Returns a string like: “id=xxx, vol=yyy”, where xxx is the <code>id</code> and yyy is the <code>volume</code>.
	 */
	public String toString() {
		String msg = String.format("Martian id=%d vol=%d", id, volume);
		return msg;
	}

	/**
	 * Implelements Java’s <code>compareTo</code> so that Martians (either red or green) are compared based on
	 * their <code>id</code>’s which results in the usual ascending sorted order.
	 *
	 */
	@Override
	public int compareTo(Martian m) {
		return this.getId() - m.getId() ;
	}




}
