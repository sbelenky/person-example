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

    @Test
    void address_set_multiple_times() {
        Person person = new Person();

        final String address1 = "1 Test Ln";
        final String address2 = "2 Test Ln";

        person.setAddress(address1);
        person.setAddress(address2);

        List<PersonAttribute> addressList = person.getPersonAttributeList().stream()
                .filter(attr -> UtilityConstants.PERSON_ADDRESS_LABEL.equals(attr.getLabel()))
                .collect(Collectors.toList());

        assertEquals(1, addressList.size());
        assertEquals(address2, addressList.get(0).getValue());
    }

    @Test
    void legacy_code_makes_multiple_addresses() {
        Person person = new Person();

        final String address1 = "1 Test Ln";
        final String address2 = "2 Test Ln";
        final String address3 = "3 Test Ln";

        List<PersonAttribute> personAttributeList = person.getPersonAttributeList();

        PersonAttribute personAttribute1 = new PersonAttribute();
        personAttribute1.setLabel(UtilityConstants.PERSON_ADDRESS_LABEL);
        personAttribute1.setValue(address1);

        PersonAttribute personAttribute2 = new PersonAttribute();
        personAttribute2.setLabel(UtilityConstants.PERSON_ADDRESS_LABEL);
        personAttribute2.setValue(address2);

        personAttributeList.add(personAttribute1);
        personAttributeList.add(personAttribute2);

        assertThrows(IllegalStateException.class,
                () -> person.setAddress(address3),
                "Multiple addresses exist");
    }

}