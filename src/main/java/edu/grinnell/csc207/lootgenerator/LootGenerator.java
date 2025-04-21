package edu.grinnell.csc207.lootgenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The helper functions for the driver and the driver.
 * 
 * @author fui
 */
public class LootGenerator {
    /**
     * The path to the dataset (either the small or large set).
     */
    private static final String DATA_SET = "data/small";

    /**
     * Picks a random monster from a list of monsters.
     * 
     * @param monsters a List of monsters
     * @return a randomly selected Monster
     */
    public static Monster pickMonster(List<Monster> monsters) {
        int n = (int) (Math.random() * monsters.size());
        return monsters.get(n);
    }

    /**
     * Gives the TreasureClass of the name passed in.
     * 
     * @param tcName The name of the TreasureClass trying to fetch
     * @param treasureClasses The map of treasure class names to TreasureClass objects
     * @return the TreasureClass corresponding to tcName
     */
    public static TreasureClass fetchTreasureClass(
        String tcName, Map<String, TreasureClass> treasureClasses
    ) {
        TreasureClass tc = treasureClasses.get(tcName);
        if (tc == null) {
            throw new IllegalArgumentException("Unknown Treasure Class: " + tcName);
        } else {
            return tc;
        }
    }

    /**
     * Randomly gets the base item. If the selected one from the TreasureClass is a
     * TreasureClass, then perform this on that TreasureClass until the base item is given.
     * 
     * @param treasureClass The TreasureClass you are trying to get the item from
     * @param treasureClasses all the possible treasureClasses
     * @return the name of the base item dropped
     */
    public static String generateBaseItem(
        TreasureClass treasureClass, Map<String, TreasureClass> treasureClasses
    ) {
        int n = (int) (Math.random() * 3);

        String item = switch (n) {
            case 0 -> treasureClass.getItem1();
            case 1 -> treasureClass.getItem2();
            case 2 -> treasureClass.getItem3();
            default -> null;
        };

        if (treasureClasses.containsKey(item)) {
            return generateBaseItem(treasureClasses.get(item), treasureClasses);
        } else {
            return item;
        }
    }

    /**
     * Generate Stats for the item as a string, based on the armour passed in.
     * 
     * @param baseItem The name of the item
     * @param armours The armour value of the item
     * @return base stats of the item as a string
     */
    public static String generateBaseStats(
        String baseItem, Map<String, Armour> armours
    ) {
        Armour armour = armours.get(baseItem);
        if (armour != null) {
            int defense = (int) (
                Math.random()
                * (armour.getMax() - armour.getMin() + 1)
                + armour.getMin()
            );
            return "Defense: " + defense;
        }
        return "No stats available.";
    }

    /**
     * Generates the suffix and prefix as a string based on the suffix and prefix
     * passed in as Affixes (random value between min and max). Formats the message.
     * 
     * @param prefixes the prefixes of the item 
     * @param suffixes the suffixes of the item
     * @param item The name of the item with affixes
     * @param base The base stats string
     * @return formatted string describing the item with affixes and stats
     */
    public static String generateAffixesFormat(
        List<Affixes> prefixes, List<Affixes> suffixes, String item, String base
    ) {
        Random rand = new Random();
        String prefix = "";
        String suffix = "";
        String prefixStats = "";
        String suffixStats = "";

        if (rand.nextBoolean()) {
            int prefixIndex = (int) (Math.random() * prefixes.size());
            Affixes selectedPrefix = prefixes.get(prefixIndex);
            int value = (int) (
                Math.random()
                * (selectedPrefix.getMax() - selectedPrefix.getMin() + 1)
                + selectedPrefix.getMin()
            );
            prefix = selectedPrefix.getName();
            prefixStats = value + " " + selectedPrefix.getMod();
        }

        if (rand.nextBoolean()) {
            int suffixIndex = (int) (Math.random() * suffixes.size());
            Affixes selectedSuffix = suffixes.get(suffixIndex);
            int value = (int) (
                Math.random()
                * (selectedSuffix.getMax() - selectedSuffix.getMin() + 1)
                + selectedSuffix.getMin()
            );
            suffix = selectedSuffix.getName();
            suffixStats = value + " " + selectedSuffix.getMod();
        }

        return prefix + (prefix.isEmpty() ? "" : " ") + item + " " + suffix + "\n"
            + base + (prefixStats.isEmpty() && suffixStats.isEmpty() ? "" : "\n")
            + (prefixStats.isEmpty() ? "" : prefixStats + " ")
            + (suffixStats.isEmpty() ? "" : suffixStats);
    }

    /**
     * The main driver for the loot generator.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Boolean playing = true;
        while (playing) {
            // Initialize data for each round
            List<Monster> monsters = new ArrayList<>();
            Map<String, TreasureClass> treasureClasses = new HashMap<>();
            Map<String, Armour> armours = new HashMap<>();
            List<Affixes> prefixes = new ArrayList<>();
            List<Affixes> suffixes = new ArrayList<>();

            try {
                // Load data
                monsters = LootReader.getMonster(DATA_SET + "/monstats.txt");
                treasureClasses = LootReader.getTreasure(DATA_SET + "/TreasureClassEx.txt");
                armours = LootReader.getArmour(DATA_SET + "/armor.txt");
                prefixes = LootReader.getPrefix(DATA_SET + "/MagicPrefix.txt");
                suffixes = LootReader.getSuffix(DATA_SET + "/MagicSuffix.txt");
            } catch (IOException e) {
                System.err.println("Error loading data: " + e.getMessage());
                return;
            }

            LootGenerator generator = new LootGenerator();

            String userResponse = "";

            // Picks a random monster
            Monster selectedMonster = generator.pickMonster(monsters); 
            System.out.println("Fighting " + selectedMonster.getName() + "...");

            // Fetch the TC and then generate the item dropped
            String treasureClassName = selectedMonster.getTreasureClass();
            TreasureClass tc = fetchTreasureClass(treasureClassName, treasureClasses);
            String baseItem = generateBaseItem(tc, treasureClasses);
            System.out.println("You have slain " + selectedMonster.getName() + "!");
            System.out.println(selectedMonster.getName() + " dropped:\n");

            // Generate Stats for that item
            String baseStats = generateBaseStats(baseItem, armours);

            // Generate affixes (prefixes and suffixes) and formats the print
            String affixes = generateAffixesFormat(prefixes, suffixes, baseItem, baseStats);
            System.out.println(affixes);

            // Ask the user if they wish to fight again
            while (true) {
                System.out.print("Fight again [y/n]? ");
                userResponse = scanner.nextLine().toLowerCase();

                // Re-prompt if input is invalid
                if (userResponse.equals("y") || userResponse.equals("n")) {
                    break;
                } else {
                    System.out.println(
                        "Invalid response. Please enter 'y' to fight again or 'n' to quit."
                    );
                }
            }

            // Continue if the user chooses to fight again
            if (userResponse.equals("n")) {
                System.out.println("Thanks for playing!");
                playing = false;
            }
        }
    }
}
