package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager(10);
    private Movie first = new Movie(1, 1, "movie1", "genre1", "url1");
    private Movie second = new Movie(2, 2, "movie2", "genre2", "url2");
    private Movie third = new Movie(3, 3, "movie3", "genre3", "url3");
    private Movie fourth = new Movie(4, 4, "movie4", "genre4", "url4");
    private Movie fifth = new Movie(5, 5, "movie5", "genre5", "url5");
    private Movie sixth= new Movie(6, 6, "movie6", "genre6", "url6");
    private Movie seventh = new Movie(7, 7, "movie7", "genre7", "url7");
    private Movie eight = new Movie(8, 8, "movie8", "genre8", "url8");
    private Movie ninth = new Movie(9, 9, "movie9", "genre9", "url9");
    private Movie tenth = new Movie(10, 10, "movie10", "genre10", "url10");
    private Movie eleventh = new Movie(11, 11, "movie11", "genre11", "url11");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eight);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
    }

    @Test
    public void shouldAddMovie() {
        MovieManager manager = new MovieManager(10);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eight);
        manager.add(ninth);
        manager.add(tenth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{tenth,ninth,eight,seventh,sixth,fifth,fourth,third,second,first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 5;
        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eleventh,tenth,ninth,eight,seventh,sixth,fourth,third,second,first};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetAll() {
        MovieManager manager = new MovieManager(11);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eight);
        manager.add(ninth);
        manager.add(tenth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{tenth,ninth,eight,seventh,sixth,fifth,fourth,third,second,first};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldGetEmpty() {
        MovieManager manager = new MovieManager(13);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLessThanAll() {
        MovieManager manager = new MovieManager(9);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fifth,fourth,third,second,first};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetMoreThanAll() {
        MovieManager manager = new MovieManager(10);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eight);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eleventh,tenth,ninth,eight,seventh,sixth,fifth,fourth,third,second};

        assertArrayEquals(expected, actual);

    }


}
