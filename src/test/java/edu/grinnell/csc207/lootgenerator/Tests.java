package edu.grinnell.csc207.lootgenerator;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {

    private LootGenerator lootGenerator;
    private List<Monster> testMonsters;
    private Map<String, TreasureClass> testTreasureClasses;
    private Map<String, Armour> testArmours;
    private List<Affixes> testPrefixes;
    private List<Affixes> testSuffixes;

    public class LootGeneratorTest {

        @Test
        void testPickMonster() {
            List<Monster> testMonsters = new ArrayList<>();
            testMonsters.add(new Monster("TestMonster", "testType", 10, "testTC"));

            Monster selectedMonster = LootGenerator.pickMonster(testMonsters);
            assertNotNull(selectedMonster);
            assertEquals("TestMonster", selectedMonster.getName());
        }

        @Test
        void testFetchTreasureClass() {
            Map<String, TreasureClass> treasureClasses = new HashMap<>();
            treasureClasses.put("testTC", new TreasureClass("testTC", "item1", "item2", "item3"));

            TreasureClass tc = LootGenerator.fetchTreasureClass("testTC", treasureClasses);
            assertNotNull(tc);
            assertEquals("testTC", tc.getName());
        }

        @Test
        void testGenerateBaseItem() {
            Map<String, TreasureClass> treasureClasses = new HashMap<>();
            treasureClasses.put("testTC", new TreasureClass("testTC", "item1", "item2", "item3"));

            TreasureClass tc = treasureClasses.get("testTC");
            String baseItem = LootGenerator.generateBaseItem(tc, treasureClasses);

            assertTrue(List.of("item1", "item2", "item3").contains(baseItem));
        }

        @Test
        void testGenerateBaseStats() {
            Map<String, Armour> armours = new HashMap<>();
            armours.put("item1", new Armour("item1", 5, 10));

            String baseStats = LootGenerator.generateBaseStats("item1", armours);
            assertTrue(baseStats.startsWith("Defense:") || baseStats.equals("No stats available."));
        }

        @Test
        void testGenerateAffixesFormat() {
            List<Affixes> prefixes = List.of(new Affixes("Strong", "Strength", 1, 3));
            List<Affixes> suffixes = List.of(new Affixes("of Speed", "Speed", 1, 5));

            String item = "Chain Mail";
            String base = "Defense: 8";

            String result = LootGenerator.generateAffixesFormat(prefixes, suffixes, item, base);
            assertTrue(result.contains(item));
            assertTrue(result.contains("Defense: 8"));
        }
    }
}
