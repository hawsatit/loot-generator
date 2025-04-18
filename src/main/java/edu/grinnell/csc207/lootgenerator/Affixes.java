/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.csc207.lootgenerator;

/**
 *
 * @author fui
 */
public class Affixes {
    String name;
    String mod1code;
    int mod1min;
    int mod1max;
    
    /**
     * Initializes an affix
     * 
     * @param name     Name of the affix
     * @param mod1code the thing it modifies
     * @param mod1min   minimum value
     * @param mod1max   maximum value
     */
    public Affixes(String name, String mod1code, int mod1min, int mod1max) {
        this.name = name;
        this.mod1code = mod1code;
        this.mod1min = mod1min;
        this.mod1max = mod1max;
    }

    /**
     * Returns affix name
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns stat what it modifies
     * 
     * @return String
     */
    public String getmod() {
        return mod1code;
    }

    /**
     * Returns minimum modification value
     * 
     * @return int
     */
    public int getMin() {
        return mod1min;
    }

    /**
     * Returns maximum modification value
     * 
     * @return int
     */
    public int getMax() {
        return mod1max;
    }
}
