package guild;

public class Player {


    private String name;
    private  String clazz;
    private String rank;
    private  String description;


    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
        rank = "Trial";
        description = "n/a";
    }



    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }

    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    public void setDescription (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    @Override

    public  String toString() {
        return String.format("Player %s: %s\nRank: %s\nDescription: %s" , this.name, this.clazz, rank, description);
    }


}
