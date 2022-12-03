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

    @Test
    void address_set_once() {
        Person person = new Person();
        final String address = "123 Test Ln";

        person.setAddress(address);

        List<PersonAttribute> addressList = person.getPersonAttributeList().stream()
                .filter(attr -> UtilityConstants.PERSON_ADDRESS_LABEL.equals(attr.getLabel()))
                .collect(Collectors.toList());

        assertEquals(1, addressList.size());
        assertEquals(address, addressList.get(0).getValue());
    }

}