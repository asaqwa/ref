package Games.Hippodrome;

import java.util.ArrayList;

public class Hippodrome {
    static Hippodrome game;
    private ArrayList<Horse> horses;
    public static void main(String[] args) {

        ArrayList<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            horses.add(new Horse(("horse "+i), 3, 0));
        }
        game = new Hippodrome(horses);
        game.run();

        game.printWinner();
    }

    public Horse getWinner() {
        Horse winner = horses.get(0);
        for (int i = 1; i < horses.size(); i++) {
            if (horses.get(i).getDistance() > winner.getDistance()) winner = horses.get(i);
        }
        return winner;
    }

    public void printWinner() {
        System.out.printf("Winner is %s!\n", getWinner().getName());
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n"); // nextFrame
        for (Horse horse : horses) {
            horse.print();
        }
    }

    public Hippodrome(ArrayList<Horse> horses) {
        this.horses = horses;
    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }
}
