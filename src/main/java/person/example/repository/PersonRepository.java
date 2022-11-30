package person.example.repository;

import person.example.model.Person;

// Legacy interface, used in huge amount of places
public interface PersonRepository {

    Person findById(long id);

    void save(Person person);

}
