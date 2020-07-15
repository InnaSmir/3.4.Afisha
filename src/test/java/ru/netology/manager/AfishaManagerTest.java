package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;
    private Movie first = new Movie(1, 1, "movie1", "genre1", "url1");
    private Movie second = new Movie(2, 2, "movie2", "genre2", "url2");
    private Movie third = new Movie(3, 3, "movie3", "genre3", "url3");
    private Movie fourth = new Movie(4, 4, "movie4", "genre4", "url4");
    private Movie fifth = new Movie(5, 5, "movie5", "genre5", "url5");
    private Movie sixth= new Movie(6, 6, "movie6", "genre6", "url6");
    private Movie seventh = new Movie(7, 7, "movie7", "genre7", "url7");
    private Movie eighth = new Movie(8, 8, "movie8", "genre8", "url8");
    private Movie ninth = new Movie(9, 9, "movie9", "genre9", "url9");
    private Movie tenth = new Movie(10, 10, "movie10", "genre10", "url10");
    private Movie eleventh = new Movie(11, 11, "movie11", "genre11", "url11");


    @BeforeEach
    public void setUp() {
        doNothing().when(repository).save(first);
        doNothing().when(repository).save(second);
        doNothing().when(repository).save(third);
        doNothing().when(repository).save(fourth);
        doNothing().when(repository).save(fifth);
        doNothing().when(repository).save(sixth);
        doNothing().when(repository).save(seventh);
        doNothing().when(repository).save(eighth);
        doNothing().when(repository).save(ninth);
        doNothing().when(repository).save(tenth);
        doNothing().when(repository).save(eleventh);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
    }

    @Test
    public void shouldAddMovie() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Movie[] returned = new Movie[]{first,second,third,fourth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(fifth);

        manager.add(fifth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fourth,third,second,first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 5;
        Movie[] returned = new Movie[]{first,second,third,fourth,sixth,seventh,eighth,ninth,tenth,eleventh};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        repository.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eleventh,tenth,ninth,eighth,seventh,sixth,fourth,third,second,first};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetAll() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);


        Movie[] returned = new Movie[]{first,second,third,fourth,fifth,sixth,seventh,eighth};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eighth,seventh,sixth,fifth,fourth,third,second,first};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldGetEmpty() {
        Movie[] returned = new Movie[]{};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLessThanAll() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        Movie[] returned = new Movie[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fifth,fourth,third,second,first};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetMoreThanAll() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        Movie[] returned = new Movie[]{first,second,third,fourth,fifth,sixth,seventh,eighth,ninth,tenth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(eleventh);

        manager.add(eleventh);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{tenth,ninth,eighth,seventh,sixth,fifth,fourth,third,second,first};

        assertArrayEquals(expected, actual);

    }


}
