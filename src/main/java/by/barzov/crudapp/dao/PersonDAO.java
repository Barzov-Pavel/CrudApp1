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
        people.add(new Person(++peopleCount, "Tom"));
        people.add(new Person(++peopleCount, "Freddy"));
        people.add(new Person(++peopleCount, "Scarlet"));
        people.add(new Person(++peopleCount, "Vik"));
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
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
