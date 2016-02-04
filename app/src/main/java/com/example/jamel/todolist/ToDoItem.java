package com.example.jamel.todolist;

/**
 * Created by Jamel on 2/3/2016.
 */
public class ToDoItem {
    String name = null;
    String description = null;
    boolean selected = false;

    public ToDoItem(String name, String description, boolean selected) {
        super();
        this.name = name;
        this.description = description;
        this.selected = selected;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
