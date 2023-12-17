package sit.int202.preexamsetup.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "employees")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
})
@ToString
public class Employee {
    @Id
    @Column(name = "employeeNumber")
    private Integer id;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    @ManyToOne
    @JoinColumn(name = "officeCode")
    private Office office;
    @ManyToOne
    @JoinColumn(name = "reportsTo")
    private Employee manager;
    private String jobTitle;
    private String password;
}
