package edu.grinnell.csc207.lootgenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reads loot-related data from files.
 *
 * @author fui
 */
public class LootReader {

    /**
     * Turns the monsters from the txt file into a list.
     *
     * @param file the file that contains all the possible monsters and stats for each monster
     * @return a list of Monster objects
     * @throws IOException if file reading fails
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
     * Turns the TreasureClasses from the txt file into a hash map.
     *
     * @param file the file that contains treasure class data
     * @return a map of treasure class names to TreasureClass objects
     * @throws IOException if file reading fails
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
     * Turns the Armours from the txt file into a hash map.
     *
     * @param file the file that contains Armour data
     * @return a map of Armour names to Armour objects
     * @throws IOException if file reading fails
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
     * Turns the Prefixes from the txt file into a list.
     *
     * @param file the file that contains Prefix data
     * @return a list of Prefix Affixes
     * @throws IOException if file reading fails
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
     * Turns the Suffixes from the txt file into a list.
     *
     * @param file the file that contains Suffix data
     * @return a list of Suffix Affixes
     * @throws IOException if file reading fails
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
