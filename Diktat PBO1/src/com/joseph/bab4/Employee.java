/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab4;

public class Employee {
    protected String name;
    private String id;

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return "Name : "+name+"\n"+
               "Id : "+id;
    }
}
