package ru.netology.manager.movie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void addNewMovieTest() {
        MovieManager manager = new MovieManager();
        manager.addNewMovie("Бладшот");
        manager.addNewMovie("Вперед");
        manager.addNewMovie("Джентльмены");

        String[] expected = {"Бладшот", "Вперед", "Джентльмены"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllWithoutMoviesTest() {
        MovieManager manager = new MovieManager();

        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastTenTest() {
        MovieManager manager = new MovieManager();
        manager.addNewMovie("I");
        manager.addNewMovie("II");
        manager.addNewMovie("III");
        manager.addNewMovie("IV");
        manager.addNewMovie("V");
        manager.addNewMovie("VI");
        manager.addNewMovie("VII");
        manager.addNewMovie("VIII");
        manager.addNewMovie("IX");
        manager.addNewMovie("X");
        manager.addNewMovie("XI");
        manager.addNewMovie("XII");

        String[] expected = {
                "XII",
                "XI",
                "X",
                "IX",
                "VIII",
                "VII",
                "VI",
                "V",
                "IV",
                "III"
        };
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findMoreLastTest() {
        MovieManager manager = new MovieManager(15);
        manager.addNewMovie("I");
        manager.addNewMovie("II");
        manager.addNewMovie("III");
        manager.addNewMovie("IV");
        manager.addNewMovie("V");
        manager.addNewMovie("VI");
        manager.addNewMovie("VII");
        manager.addNewMovie("VIII");
        manager.addNewMovie("IX");
        manager.addNewMovie("X");
        manager.addNewMovie("XI");
        manager.addNewMovie("XII");

        String[] expected = {
                "XII",
                "XI",
                "X",
                "IX",
                "VIII",
                "VII",
                "VI",
                "V",
                "IV",
                "III",
                "II",
                "I"
        };
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastZeroTest() {
        MovieManager manager = new MovieManager(0);
        manager.addNewMovie("I");
        manager.addNewMovie("II");
        manager.addNewMovie("III");
        manager.addNewMovie("IV");
        manager.addNewMovie("V");

        String[] expected = {};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastOneTest() {
        MovieManager manager = new MovieManager(1);
        manager.addNewMovie("I");
        manager.addNewMovie("II");
        manager.addNewMovie("III");
        manager.addNewMovie("IV");
        manager.addNewMovie("V");

        String[] expected = {"V"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastWrongTest() {
        MovieManager manager = new MovieManager(-1);
        manager.addNewMovie("I");
        manager.addNewMovie("II");
        manager.addNewMovie("III");
        manager.addNewMovie("IV");
        manager.addNewMovie("V");

        String[] expected = {};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}