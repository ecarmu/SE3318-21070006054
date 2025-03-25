package org.example;

import java.util.*;

public class Classroom {

    List<Student> studentsList = new ArrayList<>();

    /**
     * @param student to be added
     * @return nothing
     * requires: student != null
     * effects: Adds student to studentList if it is valid
     */
    public void addStudent(Student student){
        if(student != null)
        studentsList.add(student);
    }

    /**
     * @param student to be added
     * @return if found student, otherwise null
     * requires: student != null
     * effects: Finds the student at the studentList
     */
    public Student findStudent(Student student) {

        if(studentsList.contains(student))
            return studentsList.get(studentsList.indexOf(student));
        return null;
    }

    /**
     * @param name which a students has
     * @return if found student, otherwise null
     * requires: name != null
     * effects: Adds student to studentList if it is valid
     */
    public Student findStudent(String name) {
        for (Student student : studentsList){
            if(Objects.equals(name, student.name))
                return student;
        }

        return null;
    }

    /**
     * @param spell which a students has
     * @return if found student, otherwise null
     * requires: spell != null
     * effects: Adds student to studentList if it is valid
     */
    public Student findStudentBySpell(Spell spell){
        for (Student student : studentsList){
            if(student.knowsSpell(spell))
                return student;
        }

        return null;
    }

    /**
     * @param house which a students has
     * @return List which contains students that has the given house
     * requires: house!= null
     * effects: Adds student to studentList if it is valid
     */
    public List<Student> getStudentsByHouse(String house){
        List<Student> students = new ArrayList<>();
        for (Student student : studentsList){
            if(Objects.equals(student.house, house))
                students.add(student);
        }

        return students;
    }

    /**
     * @param
     * @return if found student, otherwise null
     * requires: spell != null
     * effects: Adds student to studentList if it is valid
     */
    public List<Student> getStudentsSortedByHouse(){
        List<Student> studentsListCopy = new ArrayList<>();

        for(Student student : studentsList)
            studentsListCopy.add(student);

        Collections.sort(studentsListCopy, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.house.compareTo(o2.house);
            }
        });

        return studentsListCopy;
    }
}
