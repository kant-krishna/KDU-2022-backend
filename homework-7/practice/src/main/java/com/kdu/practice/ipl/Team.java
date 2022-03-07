package com.kdu.practice.ipl;

public class Team {
    String name;
    Player player;
    public String getName() {
        return name;
    }

    void init() throws Exception{
        System.out.println("Printing from init of team.");
    }

    void destroy() throws Exception{
        System.out.println("This print indicates that the object space got cleaned. [Container destroyed] [Team]");
    }
    
}
