package sit.int202.preexamsetup.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "offices")
@Setter
@Getter
@NamedQueries({
        @NamedQuery(name = "Office.findAll", query = "select o from Office o"),
        @NamedQuery(name = "Office.findById", query = "select o from Office o where o.id = :id"),
})
@ToString
public class Office {
    @Id
    @Column(name = "officeCode")
    private String id;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;
}
