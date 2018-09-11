package io.pivotal.workshop.domain;


import javax.persistence.*;

@Entity
@Table()
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "first_name", nullable = false)
    String firstName;

    @Column(name= "last_name", nullable = false)
    String lastName;

    Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddresss() {
        return address;
    }

    public void setAddresss(Address addresss) {
        this.address = addresss;
    }
}
