package person.example.model;

import person.example.common.UtilityConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        if (personAttributeList == null) {
            throw new IllegalStateException("Attributes are missing");
        }

        List<PersonAttribute> addressList = personAttributeList.stream()
                .filter(attr -> UtilityConstants.PERSON_ADDRESS_LABEL.equals(attr.getLabel()))
                .collect(Collectors.toList());

        if (addressList.isEmpty()) {
            PersonAttribute attribute = new PersonAttribute();
            attribute.setLabel(UtilityConstants.PERSON_ADDRESS_LABEL);
            attribute.setValue(address);
            personAttributeList.add(attribute);
        } else if (addressList.size() == 1) {
            addressList.get(0).setValue(address);
        } else {
            throw new IllegalStateException("Multiple addresses exist");
        }
    }
}
