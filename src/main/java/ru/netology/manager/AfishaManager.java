package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;
    int returnMovies;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;

        this.returnMovies = 10;
    }

    public AfishaManager(int returnMovies) {
        this.returnMovies = returnMovies;

    }

    public void add(Movie item) {
        repository.save(item);
    }


    public Movie[] getAll() {
        int length = returnMovies;
        Movie[] items = repository.findAll();
        if (length > items.length) {
            length = items.length;
        }
        if (returnMovies <= 0) {
            length = items.length;
        }
        Movie[] result = new Movie[length];
        for (int i = 0; i < length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }


}
