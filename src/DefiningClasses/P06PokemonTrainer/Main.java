package JADVDefiningClasses.P06PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String input = s.nextLine();

        Map<String, Trainer> trainers = new LinkedHashMap<>();


        while (!input.equals("Tournament")) {

            String trainerName = input.split(" ")[0];
            String pokemonName = input.split(" ")[1];
            String element = input.split(" ")[2];
            int health = Integer.parseInt(input.split(" ")[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);

            trainers.putIfAbsent(trainerName, new Trainer());

            trainers.get(trainerName).addPokemon(pokemon);

            input = s.nextLine();
        }
        input = s.nextLine();

        while (!input.equals("End")) {

            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
                for (Pokemon pokemon : entry.getValue().getCollection()) {
                    if (pokemon.getElement().equals(input)) {
                        entry.getValue().addBadges();
                        break;
                    } else {
                        pokemon.decreaseHealth();
                    }
                }
            }
            for (Map.Entry<String, Trainer> value : trainers.entrySet()) {
                value.getValue().getCollection().removeIf(pokemon -> pokemon.getHealth() <= 0);
            }
            input = s.nextLine();
        }
        trainers.entrySet().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getValue().countBadges(), b1.getValue().countBadges()))
                .forEach(trainer -> {
                    System.out.printf("%s %d %d\n" , trainer.getKey(), trainer.getValue().countBadges()
                            , trainer.getValue().countPokemons());
                });
    }
}
