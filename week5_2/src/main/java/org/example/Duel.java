package org.example;

import java.util.Random;

public class Duel {


    /**
     * @param s1 student 1
     * @param s2 student 2
     * @param spell spell object
     * require: s1 != null and s2 != null and spell != null
     * effect: starts a duel, either one of the students end up winning or it ends up as a draw
     */
    public static void start(Student s1, Student s2, Spell spell){

        boolean isStudentOneKnows = s1.knowsSpell(spell);
        boolean isStudentTwoKnows = s2.knowsSpell(spell);

        if(isStudentOneKnows == isStudentTwoKnows){
            if(isStudentOneKnows) {
                Random random = new Random();
                int randomWithNextInt = random.nextInt();

                if(randomWithNextInt % 2 == 0)
                    System.out.println(s1 + " is winner!");
                else
                    System.out.println(s2 + " is winner!");
            }
            else
                System.out.println("draw");
        }
        else{
            if(isStudentOneKnows)
                System.out.println(s1 + " is winner!");
            else
                System.out.println(s2 + " is winner!");
        }
    }

}
