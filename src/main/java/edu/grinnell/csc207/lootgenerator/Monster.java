
package edu.grinnell.csc207.lootgenerator;

/**
 * The class for the Monster data type
 * 
 * @author fui
 */
public class Monster {
    
    private final String className;
    private final String type;
    private final int level;
    private final String treasureClass;
    
    /**
     * Constructs a Monster
     *
     * @param name     Monster name
     * @param type          Monster type
     * @param level         Monster level
     * @param treasureClass Monster treasureClass
     */
    public Monster(String name, String type, int level, String treasureClass) {
        this.className = name;
        this.type = type;
        this.level = level;
        this.treasureClass = treasureClass;
    }

    /**
     * returns the name
     * 
     * @return String
     */
    public String getName() {
        return className;
    }

    /**
     * returns the type
     * 
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * returns the treasure class
     * 
     * @return String
     */
    public String getTreasureClass() {
        return treasureClass;
    }

    /**
     * returns the level
     * 
     * @return int
     */
    public int getLevel() {
        return level;
    }
    
}
