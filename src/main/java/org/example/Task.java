package org.example;

import java.util.Date;

public class Task {
    public String title;
    public Date dueDate;
    public boolean completionStatus;

    /**
     * @param date: date given to understand that project is overdue or not at that date
     * _requires_: date must not be "null"
     * _effect_: if given date is after true is returned, otherwise false is returned
     */
    public boolean isOverdue(Date date){
        return date.after(dueDate);
    }

    /**
     * _requires_: nothing
     * _effect_: sets the completionStatus to true
     */
    public void setComplete(){
        completionStatus = true;
    }

    // inside org.example.Task
    @Override
    public String toString() {
        return title;
    }

}
