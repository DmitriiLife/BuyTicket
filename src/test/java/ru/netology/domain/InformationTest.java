package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.Manager;
import ru.netology.repository.Repository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InformationTest {
    private Repository repository = new Repository();
    private Manager manager = new Manager(repository);

    private Information first = new Information(1, 10, "led", "svo", 15);
    private Information second = new Information(2, 15, "svo", "led", 20);
    private Information third = new Information(3, 20, "led", "kzn", 25);
    private Information fourth = new Information(4, 25, "kzn", "led", 30);

    @Test
    void saveTicket() {
        manager.save(first);
        Information[] expected = {new Information(1, 10, "led", "svo", 15)};
        Information[] actual = repository.showAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByPrice() {
        Information[] expected = new Information[]{first, second, fourth};
        Information[] actual = new Information[]{second, first, fourth};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByFrom() {
        manager.save(fourth);
        manager.save(second);
        Information[] expected = {new Information(4, 25, "kzn", "led", 30),
                new Information(2, 15, "svo", "led", 20)};
        Information[] actual = manager.searchBy("led");
        assertArrayEquals(expected, actual);
    }
}

