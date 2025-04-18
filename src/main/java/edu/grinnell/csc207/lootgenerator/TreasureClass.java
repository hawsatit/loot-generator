/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.csc207.lootgenerator;

/**
 *
 * @author fui
 */
public class TreasureClass {
    private String className;
    private final String item1;
    private final String item2;
    private final String item3;
    
    /**
     * Initializes the TreasureClass
     * 
     * @param name name of the Treasure Class
     * @param item1 the first item drop
     * @param item2 the second item drop
     * @param item3 the third item drop
     */
    public TreasureClass(String name, String item1, String item2, String item3){
        this.className = name;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }
    
    public String getName() {
        return className;
    }
    
    public String getItem1(){
        return this.item1;
    }
    
    public String getItem2(){
        return this.item2;
    }
    
    public String getItem3(){
        return this.item3;
    }
            
}
