package JADVDefiningClasses.P06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

//    name, number of badges, and a collection of pokemon

    public String name;
    public int badges;
    public List<Pokemon> collection;

    public Trainer() {
        this.badges = 0;
        collection = new ArrayList<>();
    }
    public void addPokemon(Pokemon pokemon) {
        this.collection.add(pokemon);
    }

    public void remove(Pokemon pokemon) {
        this.collection.remove(pokemon);
    }
    public void addBadges () {
        this.badges++;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public int countBadges () {
        return this.badges;
    }

    public int countPokemons() {
        return this.collection.size();
    }

    public List<Pokemon> getCollection() {
        return collection;
    }

    public void setCollection(List<Pokemon> collection) {
        this.collection = collection;
    }
}
