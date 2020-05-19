package hw1a;

/**
 * This class models a RedMartian which is a subclass of Martian
 * @author dgibson
 *
 */
public class RedMartian extends Martian {

	/**
	 * Creates a RedMartian with the specified <code>id</code>.
	 * @param id
	 */
	public RedMartian(int id) {
		super(id);
	}

	/**
	 * Returns a string like: “id=xxx, Rubldy Rock”, where xxx is the <code>id</code>.
	 */
	public String speak() {
		return "id=" + getId() + " Rubldy Rock";
	}

	/**
	 * Returns a string like: “Red Martian - id=xxx, vol=yyy”, where xxx is the <code>id</code> and yyy is the <code>volume</code>.
	 */
	@Override
	public String toString() {
		return "Red " + super.toString();
	}


}
