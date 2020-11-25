package by.barzov.crudapp.dao;

import by.barzov.crudapp.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int peopleCount;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++peopleCount, "Tom", 25, "ljdsaj@ogo.ru"));
        people.add(new Person(++peopleCount, "Freddy", 56, "ldsjflk@ok.com"));
        people.add(new Person(++peopleCount, "Scarlet", 18, "lkjsdj@bp.ru"));
        people.add(new Person(++peopleCount, "Vik", 33, "dslj@tut.by"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public void create(Person person) {
        person.setId(++peopleCount);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person personForUpdate = show(id);
        personForUpdate.setName(person.getName());
        personForUpdate.setAge(person.getAge());
        personForUpdate.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
