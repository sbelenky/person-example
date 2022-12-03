package person.example.model;

import person.example.common.UtilityConstants;

import java.util.ArrayList;
import java.util.List;

// Legacy model class, used in huge amount of places
public class Person {

    private long id;

    private List<PersonAttribute> personAttributeList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Legacy getter method, used in huge amount of places
    public List<PersonAttribute> getPersonAttributeList() {
        return personAttributeList;
    }

    // Legacy setter method, used in huge amount of places
    public void setPersonAttributeList(List<PersonAttribute> personAttributeList) {
        this.personAttributeList = personAttributeList;
    }

    public void setAddress(String address) {
        PersonAttribute attribute = new PersonAttribute();
        attribute.setLabel(UtilityConstants.PERSON_ADDRESS_LABEL);
        attribute.setValue(address);
        personAttributeList.add(attribute);
    }
}
