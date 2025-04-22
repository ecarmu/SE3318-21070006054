package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class SpellbookTest {

    private Spellbook spellbook;

    @BeforeEach
    void setUp() {
        spellbook = new Spellbook(new ArrayList<>());
        spellbook.allSpells.add(new Spell("Alohomora"));
        spellbook.allSpells.add(new Spell("Accio"));
        spellbook.allSpells.add(new Spell("Avada Kedavra"));
    }

    @Test
    void getSpellByValidIndex() {
        assertEquals("Alohomora", spellbook.getSpell(0).name);
    }

    @Test
    void getSpellByInvalidIndexShouldFail() {
        assertThrows(IndexOutOfBoundsException.class, () -> spellbook.getSpell(10));
    }

    @Test
    void getSpellsByPrefix_ExactMatch() {
        List<Spell> result = spellbook.getSpellsByPrefix("Alo");
        assertTrue(result.stream().anyMatch(spell -> spell.name.equals("Alohomora")));
    }

    @Test
    void getSpellsByPrefix_EmptyPrefix() {
        List<Spell> result = spellbook.getSpellsByPrefix("");
        assertEquals(3, result.size());
    }

    @Test
    void getSpellsByPrefix_NoMatch() {
        List<Spell> result = spellbook.getSpellsByPrefix("Zzz");
        assertTrue(result.isEmpty());
    }
}