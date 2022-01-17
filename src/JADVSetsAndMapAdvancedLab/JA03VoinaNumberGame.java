package JADVSetsAndMapAdvancedLab;

import java.util.*;


public class JA03VoinaNumberGame {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);


        int turn = 50;
        String[] input = s.nextLine().split(" ");

        LinkedHashSet<Integer> firstPlayer = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondPlayer = new LinkedHashSet<>();

        getCardsFirst(input, firstPlayer);
        input = s.nextLine().split(" ");
        getCardsSecond(input, secondPlayer);
        while (turn-- > 0 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {

            int firstCard = getCard(firstPlayer);
            int secondCard = getCard(secondPlayer);
            firstPlayer.remove(firstCard);
            secondPlayer.remove(secondCard);
            if (firstCard > secondCard) {
                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);
            } else if (firstCard < secondCard) {
                secondPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }

        }
        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (firstPlayer.size() < secondPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static void getCardsSecond(String[] input, LinkedHashSet<Integer> secondPlayer) {
        for (String card : input) {
            secondPlayer.add(Integer.parseInt(card));
        }
    }

    private static void getCardsFirst(String[] input, LinkedHashSet<Integer> firstPlayer) {
        for (String card : input) {
            firstPlayer.add(Integer.parseInt(card));
        }
    }

    private static int getCard(LinkedHashSet<Integer> deck) {
        for (int cards : deck) {
            return cards;
        }
        return 0;
    }

}
