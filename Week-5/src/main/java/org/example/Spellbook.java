package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Spellbook {
    List<Spell> allSpells = new ArrayList<>();


    public Spellbook(List<Spell> allSpells) {
        this.allSpells = allSpells;
    }

    /**
     *
     * @param index to reach the desired spell from allSpells at the right order
     * @return the spell
     * requires: index > 0
     * effects: gets the spell from allSpells
     */
    public Spell getSpell(int index){
        return allSpells.get(index);
    }

    /**
     * @param prefix string a spell will start with
     * @return spells which start with the given prefix
     * requires:
     * effects: finds the spells which starts with given prefix
     */
    public List<Spell> getSpellsByPrefix(String prefix){

        List<Spell> allSpellsCopy = new ArrayList<>(allSpells);

        allSpellsCopy.removeIf(spell -> !spell.name.startsWith(prefix));

        return allSpellsCopy;
    }
}
