
package edu.grinnell.csc207.lootgenerator;

/**
 * The class for the Treasure data type
 * 
 * @author fui
 */
public class TreasureClass {
    private final String className;
    private final String item1;
    private final String item2;
    private final String item3;

    /**
     * Initializes the TreasureClass.
     * 
     * @param name name of the Treasure Class
     * @param item1 the first item drop
     * @param item2 the second item drop
     * @param item3 the third item drop
     */
    public TreasureClass(String name, String item1, String item2, String item3) {
        this.className = name;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    /**
     * Returns the name of the TreasureClass.
     * 
     * @return String
     */
    public String getName() {
        return className;
    }

    /**
     * Returns the first possible drop.
     * 
     * @return String
     */
    public String getItem1() {
        return this.item1;
    }

    /**
     * Returns the second possible drop.
     * 
     * @return String
     */
    public String getItem2() {
        return this.item2;
    }

    /**
     * Returns the third possible drop.
     * 
     * @return String
     */
    public String getItem3() {
        return this.item3;
    }
}
