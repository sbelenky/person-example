package person.example.model;

import org.junit.jupiter.api.Test;
import person.example.common.UtilityConstants;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void address_not_set() {
        Person person = new Person();

        List<PersonAttribute> addressList = person.getPersonAttributeList().stream()
                .filter(attr -> UtilityConstants.PERSON_ADDRESS_LABEL.equals(attr.getLabel()))
                .collect(Collectors.toList());

        assertTrue(addressList.isEmpty());
    }

}