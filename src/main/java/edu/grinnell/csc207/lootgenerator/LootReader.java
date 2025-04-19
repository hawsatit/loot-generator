/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.csc207.lootgenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fui
 */
public class LootReader {
    
    /**
     * turns the monsters from the txt file into a list 
     * 
     * @param file the file that contains all the possible monsters and stats for each monster
     * @return List<Monster> a list of a Monster class
     * @throws IOException 
     */
    public static List<Monster> getMonster(String file) throws IOException {
         
        List<Monster> monsters = new ArrayList<>();

        BufferedReader buffer = new BufferedReader(new FileReader(file));

        String line;
        while ((line = buffer.readLine()) != null) {
            String[] difWords = line.split("\t");

            String name = difWords[0];
            String type = difWords[1];
            int level = Integer.parseInt(difWords[2]);
            String treasureClass = difWords[3];

            monsters.add(new Monster(name, type, level, treasureClass));
        }
        buffer.close();
        return monsters;
    }
    
    /**
     * turns the TreasureClasses from the txt into a hash map
     * 
     * @param file the file that contains all the possible treasure classes and stats for each 
     * @return Map<String, TreasureClass> a map of treasure class names to their corresponding TreasureClass objects
     * @throws IOException 
     */
    public static Map<String, TreasureClass> getTreasure(String file) throws IOException {
        Map<String, TreasureClass> treasure = new HashMap<>();

        BufferedReader buffer = new BufferedReader(new FileReader(file));

        String line;
        while ((line = buffer.readLine()) != null) {
            String[] difWords = line.split("\t");
            String name = difWords[0];
            treasure.put(name, new TreasureClass(name, difWords[1], difWords[2], difWords[3]));
        }
        buffer.close();
        return treasure;
    }
    
    /**
     * turns the Armours from the txt into a hash map
     * 
     * @param file the file that contains all the possible Armours and stats for each Armour
     * @return Map<String, Armour> a map of Armour names to their corresponding Armour class objects
     * @throws IOException 
     */
    public static Map<String, Armour> getArmour(String file) throws IOException {
        Map<String, Armour> armour = new HashMap<>();

        BufferedReader buffer = new BufferedReader(new FileReader(file));

        String line;
        while ((line = buffer.readLine()) != null) {
            String[] difWords = line.split("\t");
            String name = difWords[0];
            int min = Integer.parseInt(difWords[1]);
            int max = Integer.parseInt(difWords[2]);

            armour.put(name, new Armour(name, min, max));
        }
        buffer.close();
        return armour;
    }
    
    /**
     * turns the Prefixes from the txt into a list of those Prefixes
     * 
     * @param file the file that contains all the possible Prefixes and their stats
     * @return List<Affixes> the list of Prefix
     * @throws IOException 
     */
    public static List<Affixes> getPrefix(String file) throws IOException {
        List<Affixes> prefixes = new ArrayList<>();
        BufferedReader buffer = new BufferedReader(new FileReader(file));

        String line;
        while ((line = buffer.readLine()) != null) {
            String[] difWords = line.split("\t");
            String name = difWords[0];
            String modifiedStat = difWords[1];
            int min = Integer.parseInt(difWords[2]);
            int max = Integer.parseInt(difWords[3]);

            prefixes.add(new Affixes(name, modifiedStat, min, max));
        }
        buffer.close();
        return prefixes;
    }
    
    /**
     * turns the Suffix from the txt into a list of those Suffix
     * 
     * @param file the file that contains all the possible Suffix and their stats
     * @return List<Affixes> The list of Suffix
     * @throws IOException 
     */
    public static List<Affixes> getSuffix(String file) throws IOException {
        List<Affixes> suffixes = new ArrayList<>();
        BufferedReader buffer = new BufferedReader(new FileReader(file));

        String line;
        while ((line = buffer.readLine()) != null) {
            String[] difWords = line.split("\t");
            String name = difWords[0];
            String modifiedStat = difWords[1];
            int min = Integer.parseInt(difWords[2]);
            int max = Integer.parseInt(difWords[3]);

            suffixes.add(new Affixes(name, modifiedStat, min, max));
        }
        buffer.close();
        return suffixes;
    }
    
}
