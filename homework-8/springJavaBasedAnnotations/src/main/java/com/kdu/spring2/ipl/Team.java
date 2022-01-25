package com.kdu.spring2.ipl;



public class Team {
    String teamName;
    Player player;
    public Team(Player player) {
        this.player = player;
    }

    public String getTeamName() {
        return teamName;
    }


    public Player getPlayer() {
        return player;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", player=" + player +
                '}';
    }
}
