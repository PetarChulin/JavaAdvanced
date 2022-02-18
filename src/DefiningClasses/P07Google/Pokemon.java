package DefiningClassesExercise.P07Google;

public class Pokemon {
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public static Pokemon addPokemon(Person person, String[] data) {
        String pokemonName = data[2];
        String type = data[3];
        Pokemon pokemon = new Pokemon(pokemonName, type);
        person.getPokemon().add(pokemon);
        return pokemon;
    }

    public String toString() {
        return name + " " + type;
    }
}
