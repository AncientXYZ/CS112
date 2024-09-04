/** filename: Taxonomy.java
 *
 * @author phaskell@usfca.edu
 */


import java.util.ArrayList;


/** class TaxonomyTree stores user-provided organisms in
 * a non-binary tree, organized by the layers in the
 * taxonomy.
 * <br><br>
 * For this program, a "taxonomy" is a listing of
 * all of the components of an organism's scientific
 * classification, with each component separated by a colon (':').
 * For example:
 * <li>"Life:Animal:Chordate:Mammal:Rodent:Squirrel"</li>
 * <br>
 * The program saves each organism in a non-binary tree.
 * The program supports searching the tree to see if a requested
 * organism is contained in the tree.
 */
class TaxonomyTree {
	////
	//// Member classes
	////
	/** class Node stores a node in the taxonomy tree.
	 * It contains an ArrayList of child nodes.
	 */
	class Node {
		String name;
		ArrayList<Node> children;
		Node(String n) {
			name = n;
			children = new ArrayList<>();
		}
	}

	////
	//// Class variables
	////
	Node root;

	////
	//// Class methods
	////
	public TaxonomyTree() { root = new Node("Life"); }

	/** Add an organism to our taxonomy tree.
	 * @param s The scientific classification of our organism
	 */
	public void add(String s) {
		add(s, root);
	}

	private void add(String s, Node r) {
		final int indx = s.indexOf(":");
		String thisLevel = s;
		String predicate = null;

		if (indx >= 0) {
			thisLevel = s.substring(0, indx);
			predicate = s.substring(indx+1);
		}
		// See if 'thisLevel' already is a child of 'r'
		boolean found = false;
		for (Node n : r.children) {
			if (n.name.equals(thisLevel)) {
				found = true;
				if (predicate != null) {
					add(predicate, n);
				} else {
					// We already have this organism
					System.out.printf(">> Already have: %s <<\n", thisLevel);
				}
			}
		}
		if (!found) {
			Node newOne = new Node(thisLevel);
			r.children.add(newOne);
			if (predicate != null) {
				add(predicate, newOne);
			}
		}
	}

	/** Search our tree for the user-specified organism.
	 * @param s The scientific classification of the organism to search for
	 * @return <b>true</b> if the organism is found, else <b>false</b>
	 */
	public boolean find(String s) {
		return find(s, root);
	}

	private boolean find(String s, Node r) {
		final int indx = s.indexOf(":");
		String thisLevel = s;
		String predicate = null;
		if (indx >= 0) {
			thisLevel = s.substring(0, indx);
			predicate = s.substring(indx+1);
		}
		// See if 'thisLevel' is a child of 'r'.
		for (Node n : r.children) {
			if (n.name.equals(thisLevel)) { // found it!
				if (predicate != null) {
					return find(predicate, n);
				} else {
					return true; // matched all components of 's'
				}
			}
		}
		return false; // no match for component of 's' at 'r's level
	}
}

public class Taxonomy
{
	public static void main(String[] args) {
		TaxonomyTree tax = new TaxonomyTree();
		tax.add("Life:Animal:Chordate:Feline:Panthera:Lion");
		tax.add("Life:Animal:Chordate:Feline:Panthera:Cheetah");
		tax.add("Life:Animal:Chordate:Feline:Panthera:Leopard");
		tax.add("Life:Animal:Chordate:Canine:Coyote");
		tax.add("Life:Animal:Chordate:Canine:Wolf");
		tax.add("Life:Animal:Chordate:Canine:Dog");
		tax.add("Life:Animal:Chordate:Fish:Cod");
		tax.add("Life:Animal:Chordate:Fish:Salmon");
		tax.add("Life:Animal:Insect:Ant");
		tax.add("Life:Animal:Insect:Deerfly");
		tax.add("Life:Animal:Cnidaria:Starfish");
		tax.add("Life:Animal:Cnidaria:SeaAnemone");
		tax.add("Life:Plant:Angiosperm:Tree:Maple");
		tax.add("Life:Plant:Angiosperm:Tree:Maple"); // double
		tax.add("Life:Plant:Angiosperm:Tree:Maple"); // triple
		tax.add("Life:Plant:Angiosperm:Salvia:Rosemary");
		tax.add("Life:Plant:Angiosperm:Salvia:Sage");

		System.out.println(tax.find("Life:Animal:Chordate:Fish:Salmon"));
		System.out.println(tax.find("Life:Animal:Chordate:Salmon"));
	}
} // end Taxonomy