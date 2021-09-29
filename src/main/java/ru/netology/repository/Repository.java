package ru.netology.repository;

import ru.netology.domain.Information;

import java.util.Arrays;

public class Repository {

    private Information[] items = new Information[0];

    public void save(Information item) {
        int length = items.length + 1;
        Information[] tmp = new Information[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Information[] tmp = new Information[length];
        int index = 0;
        for (Information item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
            items = tmp;
        }
    }

    public Information[] findAll(String from, String to) {
        Information[] result = new Information[0];
        for (Information information : showAll()) {
            if (information.getTo().equals(from) && information.getFrom().equals(to)) {
                Information[] tmp = new Information[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = information;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Information[] showAll() {
        return items;
    }
}

