import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;



public class IPL {

    static String[] teamNames = {"CSK", "MI", "RR", "RCB", "SRH", "PBKS", "DC", "KKR"};
    static String[] venueNames = {"CHENNAI", "MUMBAI", "JAIPUR", "BENGALURU", "HYDERABAD", "CHANDIGARH", "DELHI", "KOLKATA"};
    static ArrayList<Team> teams = new ArrayList<>();
    static ArrayList<Match> matches = new ArrayList<>();

    public static void filterBowlers(String teamName, Integer minWickets) {
        int index = List.of(teamNames).indexOf(teamName);
        Team team = teams.get(index);
        for (Player p : team.squad) {
            if (p.wickets >= minWickets) {
                p.display();
            }
        }
    }

    public static void searchPlayersByName(String key) {
        if(key == null) {
            System.out.println("You should have entered valid key");
            return;
        }
        for (Team team : teams) {
            for (Player player : team.squad) {
                if (player.playerName.contains(key)) {
                    player.display();
                }
            }
        }
    }





    public static void gettingTopPerformers() {
        ArrayList<Player> top3Batsmen = getTopPlayersByRole("BATSMEN");
        ArrayList<Player> top3Bowler = getTopPlayersByRole("BOWLER");
        ArrayList<Player> top3AllRounder = getTopPlayersByRole("ALL ROUNDER");
        displayArrayList(top3Batsmen);
    }

    static void displayArrayList(ArrayList<Player> players) {
        for (Player player : players) {
            player.display();
        }
    }

    public static ArrayList<Player> getTopPlayersByRole(String role) {
        Stack<Player> top3 = new Stack<>();
        ArrayList<Player> result = new ArrayList<>();
        for (Team team : teams) {
            for (Player p : team.squad) {
                if (p.role.equals(role)) {
                    if (top3.size() == 0) {
                        top3.push(p);
                    } else {
                        Stack<Player> temp = new Stack<>();
                        while (!top3.isEmpty() && top3.peek().runs < p.runs) {
                            temp.push(top3.pop());
                        }
                        temp.push(p);
                        while (!temp.isEmpty()) {
                            top3.push(temp.pop());
                        }
                        while (top3.size() > 3) {
                            top3.pop();
                        }
                    }
                }
            }
        }
        while (!top3.isEmpty()) {
            result.add(top3.pop());
        }
        return result;
    }

    public static void bestPossiblePerformance() {
        HashMap<Team, Double> mapTeamToPredictedScore = new HashMap<>();
        for (Team team : teams) {
            Comparator<Player> cmp = Comparator.comparing(Player::getRuns);
            team.squad.sort(cmp.reversed());
            Double predictedScore = 0.0;
            int i = 0;
            for (Player p : team.squad) {
                while (i < 11) {
                    i++;
                    predictedScore += p.averageRuns;
                }
            }
            mapTeamToPredictedScore.put(team, predictedScore);
        }

        Map<Team, Double> sorted = mapTeamToPredictedScore
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        int i = 0;
        for (Map.Entry<Team, Double> entry : sorted.entrySet()) {
            if (i == 6) {
                System.out.println("Runner: " + entry.getKey().teamName + " Predicted Score: " + entry.getValue());
            }
            if (i == 7) {
                System.out.println("Winner: " + entry.getKey().teamName + " Predicted Score: " + entry.getValue());
            } else {
                i++;
            }
        }
    }


    public static void nextGenerationPlayers() {
        for (Team team : teams) {
            System.out.println("\n" + team.teamName + ":");
            for (Player player : team.squad) {
                if (((player.runs > 100) || (player.wickets > 10)) && (player.matches < 15)) {
                    player.display();
                }
            }
        }
    }

    public static void matchFixtures() {
        int k = 1;
        for (int i = 0; i < 7; i++) {
            for (int j = i + 1; j < 8; j++) {
                Match match = new Match(k, teams.get(i), teams.get(j));
                matches.add(match);
                k++;
            }
        }
        ArrayList<Match> reversedMatches = new ArrayList<>();
        for (Match match : matches) {
            Match match1 = new Match(k, match.secondTeam, match.firstTeam);
            reversedMatches.add(match1);
            k++;
        }
        matches.addAll(reversedMatches);
    }


    public static void csvWriter() {

        try (PrintWriter writer = new PrintWriter("Matches.csv")) {

            StringBuilder sb = new StringBuilder();
            int n = 1;
            Collections.shuffle(matches);
            for (Match match : matches) {
                match.matchCount = n;
                sb.append(match.matchCount);
                sb.append(',');
                sb.append(match.firstTeam.teamName);
                sb.append(',');
                sb.append(match.secondTeam.teamName);
                sb.append(',');
                sb.append(match.venue.venueName);
                sb.append('\n');
                n++;
            }
            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) throws FileNotFoundException {

        for (int i = 0; i < 8; i++) {
            Team newTeam = new Team(teamNames[i], venueNames[i]);
            teams.add(newTeam);
        }
        Scanner scan = new Scanner(new File("IPL_2021_data.csv"));
        scan.useDelimiter("\n");
        scan.next();
        while (scan.hasNext()) {
            String line = scan.next();
            String[] rowInDataset = line.split(",");
            for (Team team : teams) {
                if (team.teamName.equals(rowInDataset[1])) {
                    Player newPlayer = new Player(rowInDataset);
                    team.squad.add(newPlayer);
                    break;
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name of team: ");
        String teamName = sc.next();
        int index = List.of(teamNames).indexOf(teamName);
        Team team = teams.get(index);
        System.out.println("Forty Wicket-taker for " + teamName +" are:");
        filterBowlers(teamName, 40);
        System.out.println("Highest Wicket-taker for " + teamName +" is:");
        team.getHighestWicketTakerOfTeam();
        System.out.println("Highest Run-scorer for " + teamName +" is:");
        team.getHighestRunScorerOfTeam();
        System.out.println("Top performers of session are: ");
        gettingTopPerformers();
        System.out.println("Next Generation Players:");
        nextGenerationPlayers();
        System.out.println("If we predict the score of all the teams in an average match based on the data given:");
        bestPossiblePerformance();
        System.out.println("Enter keywords to search for players:");
        searchPlayersByName(sc.next().toUpperCase(Locale.ROOT));
        matchFixtures();
        csvWriter();
    }
}

class Match {
    Integer matchCount;
    Team firstTeam;
    Team secondTeam;
    Venue venue;
    Match(Integer matchCount, Team a, Team b) {
        this.matchCount = matchCount;
        this.firstTeam = a;
        this.secondTeam = b;
        this.venue = a.homeGround;
    }
    void displayMatch() {
        System.out.println(this.matchCount + " " + this.firstTeam + " " + this.secondTeam + " " + this.venue);
    }
    Venue getVenue() {
        return this.venue;
    }
}
class Player {
    String playerName;
    String role;
    Integer matches;
    Integer runs;
    Double averageRuns;
    Double strikeRate;
    Integer wickets;
    Player(String[] temp) {
        this.playerName = temp[0].toUpperCase(Locale.ROOT);
        this.role = temp[2];
        this.matches = Integer.parseInt(temp[3]);
        this.runs = Integer.parseInt(temp[4]);
        this.averageRuns = Double.parseDouble(temp[5]);
        this.strikeRate = Double.parseDouble(temp[6]);
        this.wickets = Integer.parseInt(temp[7]);
    }
    Integer getRuns() {
        return this.runs;
    }
    void display() {
        System.out.println(this.playerName + " " + this.role + " " + this.runs + " " + this.averageRuns + " " + this.wickets + " " + this.matches + " " + this.strikeRate);
    }

}

class Team {
    String teamName;
    ArrayList<Player> squad;
    Venue homeGround;
    Team(String teamName, String venueName) {
        Venue newVenue = new Venue(venueName);
        this.teamName = teamName;
        this.homeGround = newVenue;
        this.squad = new ArrayList<>();
    }
    public void getHighestRunScorerOfTeam() {

        Integer maxTillNow = 0;
        Player bestScorer = null;
        for (Player player : this.squad) {
            if (player.runs >= maxTillNow) {
                bestScorer = player;
                maxTillNow = player.runs;
            }
        }
        assert bestScorer != null;
        bestScorer.display();

    }
    public void getHighestWicketTakerOfTeam() {

        Integer maxTillNow = 0;
        Player bestBowler = null;
        for (Player player : this.squad) {
            if (player.wickets >= maxTillNow) {
                bestBowler = player;
                maxTillNow = player.wickets;
            }
        }
        assert bestBowler != null;
        bestBowler.display();
    }
    void addPlayer(Player player) {
        squad.add(player);
    }
    void removePlayer(Player player){
        squad.removeIf(p -> p.equals(player));
    }
}

class Venue {
    String venueName;
    Venue(String name) {
        this.venueName = name;
    }
    String getVenueName() {
        return this.venueName;
    }
}
