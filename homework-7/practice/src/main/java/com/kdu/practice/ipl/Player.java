package com.kdu.practice.ipl;


public class Player {
     private String name;
     Team team;

//    public String getName() {
//        return name;
//    }
//
    public void setName(String name) {
        this.name = name;
    }

    // parameterize constructor?? how will it work
    Player() {

    }

    void init() throws Exception{
        System.out.println("Printing from init of player.");
    }

    void destroy() throws Exception{
        System.out.println("This print indicates that the object space got cleaned. [Container destroyed][Player]");
    }
    //to string method basically explain the way how object will be printed,
    // for example if you simply print the object of any class it will show it like object@12s44g23  kind of
    // but if you have implemented the toString clearly it will print its output.

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
