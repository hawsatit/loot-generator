/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.csc207.lootgenerator;

/**
 *
 * @author fui
 */
public class Armour {
    private final String name;
    private int minVal;
    private int maxVal;

    /**
     * Initializes Armour
     *
     * @param name   name
     * @param minVal min value of armor
     * @param maxVal max value of armor
     */
    public Armour(String name, int minVal, int maxVal) {
        this.name = name;
        this.minVal = minVal;
        this.maxVal = maxVal;
    }

    /**
     * Returns the name
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the min value
     * 
     * @return int
     */
    public int getMin() {
        return minVal;
    }

    /**
     * Returns the max value
     * 
     * @return int
     */
    public int getMax() {
        return maxVal;
    }

}
