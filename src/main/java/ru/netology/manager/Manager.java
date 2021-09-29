package ru.netology.manager;

import ru.netology.domain.Information;
import ru.netology.repository.Repository;

public class Manager {

    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void save(Information item) {
        repository.save(item);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Information[] searchBy(String text) {
        Information[] result = new Information[0];
        for (Information information : repository.showAll()) {
            if (matches(information, text)) {
                Information[] tmp = new Information[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = information;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Information information, String search) {
        if (information.getFrom().contains(search)) {
            return true;
        }
        if (information.getTo().contains(search)) {
            return true;
        }
        return false;
    }
}
