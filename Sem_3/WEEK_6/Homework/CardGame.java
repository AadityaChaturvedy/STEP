package Homework;

class Game {
    String genre;

    public Game(String genre) { this.genre = genre; }

    @Override
    public String toString() { return "Game: " + genre; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game g = (Game)o;
        return genre.equals(g.genre);
    }
    @Override
    public int hashCode() { return genre.hashCode(); }
}

class CardGame extends Game {
    int numCards;

    public CardGame(String genre, int numCards) {
        super(genre);
        this.numCards = numCards;
    }

    @Override
    public String toString() { return super.toString() + ", Cards: " + numCards; }
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof CardGame)) return false;
        CardGame cg = (CardGame)o;
        return numCards == cg.numCards;
    }
    @Override
    public int hashCode() { return super.hashCode() + numCards; }

    public static void main(String[] args) {
        Game g1 = new Game("Strategy");
        CardGame cg1 = new CardGame("Strategy", 52);
        CardGame cg2 = new CardGame("Strategy", 52);
        CardGame cg3 = new CardGame("Strategy", 32);

        System.out.println(g1);
        System.out.println(cg1);

        System.out.println("cg1 equals cg2? " + cg1.equals(cg2));
        System.out.println("cg1 equals cg3? " + cg1.equals(cg3));
    }
}