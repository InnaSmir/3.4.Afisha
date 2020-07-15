package ru.netology.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AfishaRepositoryTest {

    private AfishaRepository repository = new AfishaRepository();
    private Movie first = new Movie(1, 1, "movie1", "genre1", "url1");
    private Movie second = new Movie(2, 2, "movie2", "genre2", "url2");
    private Movie third = new Movie(3, 3, "movie3", "genre3", "url3");
    private Movie fourth = new Movie(4, 4, "movie4", "genre4", "url4");
    private Movie fifth = new Movie(5, 5, "movie5", "genre5", "url5");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
    }

    @Test
    public void shouldFindAll() {
        Movie[] actual = repository.findAll();
        Movie[] expected = {first,second,third,fourth,fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        repository.removeAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 3;

        repository.removeById(idToRemove);

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first,second,fourth,fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByIdIfExists() {
        int idToFind = 4;
        Movie actual = repository.findById(idToFind);
        Movie expected = fourth;

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindByIdIfNotExists() {
        int idToFind = 6;

        Movie actual = repository.findById(idToFind);
        Movie expected = null;

        assertEquals(expected, actual);
    }

    }


