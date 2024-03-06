import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AfishaManagerTest {
    @Test
    public void testNewMovie() {
        AfishaManager manager = new AfishaManager();
        manager.newMovie("Film 1");
        manager.newMovie("Film 2");

        String[] expected = {"Film 1", "Film 2"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindAll() {
        AfishaManager manager = new AfishaManager();
        manager.newMovie("Film 1");
        manager.newMovie("Film 2");

        String[] expected = {"Film 1", "Film 2"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLast() {
        AfishaManager manager = new AfishaManager(5); //  последние 5 добавленных фильма
        manager.newMovie("Film 1");
        manager.newMovie("Film 2");
        manager.newMovie("Film 3");
        manager.newMovie("Film 4");
        manager.newMovie("Film 5");


        String[] expected = {"Film 5", "Film 4", "Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindLastLessFive() {
        AfishaManager manager = new AfishaManager(5); //  последние 5 добавленных фильма но их 3
        manager.newMovie("Film 1");
        manager.newMovie("Film 2");
        manager.newMovie("Film 3");


        String[] expected = {"Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastOverLimit() {
        // проверка порядка если больше
        AfishaManager manager = new AfishaManager(3);


        manager.newMovie("Film 1");
        manager.newMovie("Film 2");
        manager.newMovie("Film 3");
        manager.newMovie("Film 4");


        String[] expected = {"Film 4", "Film 3", "Film 2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}