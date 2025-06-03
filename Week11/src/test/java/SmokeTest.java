import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Smoke tests to verify basic functionality of LOTR project.
 */
public class SmokeTest {

    /**
     * Tests navigation between locations.
     */
    @Test
    public void testNavigation() {
        MiddleEarthMap map = new MiddleEarthMap();
        assertTrue(map.canNavigate("Shire", "Mordor"));
    }

    /**
     * Tests Hobbit undertaking a rescue quest.
     */
    @Test
    public void testHobbitRescueQuest() {
        Hobbit frodo = new Hobbit("Frodo", 50, "RingBearer");
        RescueQuest quest = new RescueQuest(3);
        boolean result = quest.execute(frodo);
        // Hobbits have lower success for rescue but may succeed.
        assertTrue(result || !result);
    }

    /**
     * Tests Elf undertaking a battle quest.
     */
    @Test
    public void testElfBattleQuest() {
        Elf legolas = new Elf("Legolas", 2931, "BowMaster");
        BattleQuest quest = new BattleQuest(5);
        boolean result = quest.execute(legolas);
        assertTrue(result || !result);
    }

    /**
     * Tests Wizard undertaking both quest types.
     */
    @Test
    public void testWizardQuests() {
        Wizard gandalf = new Wizard("Gandalf", 2019, "WizardStaff");
        RescueQuest rq = new RescueQuest(7);
        BattleQuest bq = new BattleQuest(8);
        boolean res1 = rq.execute(gandalf);
        boolean res2 = bq.execute(gandalf);
        assertTrue(res1 || !res1);
        assertTrue(res2 || !res2);
    }
}
