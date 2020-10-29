package ua.alvin.springdemo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

 /*   @Transient
    private ArrayList<String> orderByOptions;*/
//    @Transient
//    private String orderBy;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Customer() {
//        orderBy = "id";
      /*  orderByOptions = new ArrayList<>();
        orderByOptions.add("id");
        orderByOptions.add("First name");
        orderByOptions.add("Last name");
        orderByOptions.add("Email");*/
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  /*  public ArrayList<String> getOrderByOptions() {
        return orderByOptions;
    }*/

}
