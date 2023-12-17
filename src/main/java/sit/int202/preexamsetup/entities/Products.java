package sit.int202.preexamsetup.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
})
@ToString
public class Products {
    @Id
    @Column(name = "productCode")
    private String id;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private Integer quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal MSRP;
}
