package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {

    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.getCapacity() > this.roster.size()) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                this.roster.remove(player);
                return true;
            }
        }
        return false;
    }


    public int count() {
        return this.roster.size();
    }


    public void promotePlayer(String name) {
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equals(name)) {
                if (roster.get(i).getRank().equals("Trial")) {
                    roster.get(i).setRank("Member");
                    break;
                }
            }
        }
    }


    public void demotePlayer(String name) {
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equals(name)) {
                if (roster.get(i).getRank().equals("Member")) {
                    roster.get(i).setRank("Trial");
                    break;
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }


    public Player[] kickPlayersByClass(String clazz) {
        Player[] removed = roster.stream()
                .filter(p -> clazz.equals(p.getClazz())).toArray(Player[]::new);
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getClazz().equals(clazz)) {
                roster.remove(i);
                i--;
            }
        }
        return removed;
    }

    public String report() {
        StringBuilder build = new StringBuilder();
        build.append(String.format("Players in the guild: %s:\n", name));
        for (Player player : roster) {
            build.append(player).append("\n");
        }
        return build.toString();
    }
}
