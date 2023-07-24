import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testWhenFirstPlayerWin() {
        Player nikita = new Player(1, "Никита", 200);
        Player alexey = new Player(2, "Алексей", 100);
        Game game = new Game();

        game.register(nikita);
        game.register(alexey);
        int expected = 1;
        int actual = game.round("Никита", "Алексей");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player nikita = new Player(1, "Никита", 100);
        Player alexey = new Player(2, "Алексей", 200);
        Game game = new Game();

        game.register(nikita);
        game.register(alexey);
        int expected = 2;
        int actual = game.round("Никита", "Алексей");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenDraw() {
        Player nikita = new Player(1, "Никита", 200);
        Player alexey = new Player(2, "Алексей", 200);
        Game game = new Game();

        game.register(nikita);
        game.register(alexey);
        int expected = 0;
        int actual = game.round("Никита", "Алексей");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player nikita = new Player(1, "Никита", 200);
        Player alexey = new Player(2, "Алексей", 100);
        Game game = new Game();

        game.register(nikita);
        game.register(alexey);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Сергей", "Алексей")
        );
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player nikita = new Player(1, "Никита", 200);
        Player alexey = new Player(2, "Алексей", 100);
        Game game = new Game();

        game.register(nikita);
        game.register(alexey);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Никита", "Дмитрий")
        );
    }

    @Test
    public void testWhenBothPlayerNotExist() {
        Player nikita = new Player(1, "Никита", 200);
        Player alexey = new Player(2, "Алексей", 100);
        Game game = new Game();

        game.register(nikita);
        game.register(alexey);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Сергей", "Дмитрий")
        );
    }

}
