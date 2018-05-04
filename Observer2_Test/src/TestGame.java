import java.util.Vector;

public class TestGame {

    public static void main(String[] args) {
        Game game1 = new Game("LA-Chic");
        Game game2 = new Game("Wash-Bos");
        Game game3 = new Game("Pits-Mem");

        Vector<Game> games = new Vector<Game>();

        games.add(game1);
        games.add(game2);
        games.add(game3);

        new Thread(game1).start();
        new Thread(game2).start();
        new Thread(game3).start();

        Viewer viewer1 = new Viewer("John", games);
        Viewer viewer2 =  new Viewer("David", games);


    }
}
