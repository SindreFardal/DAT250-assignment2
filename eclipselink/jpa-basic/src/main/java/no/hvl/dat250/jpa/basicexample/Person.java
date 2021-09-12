package no.hvl.dat250.jpa.basicexample;

import lombok.Data;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;


@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
//    @JoinTable(name="PERSON_ADDRESS",
//    joinColumns=
//        @JoinColumn(name="id", referencedColumnName="id")
//    )
    private final List<Address> addresses = new ArrayList<>();

    @OneToMany
    private final List<CreditCard> creditcards = new ArrayList<>();

}