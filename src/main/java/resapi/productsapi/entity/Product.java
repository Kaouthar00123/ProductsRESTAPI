package resapi.productsapi.entity;

import jakarta.persistence.*;
import lombok.*;
import resapi.productsapi.dto.ProductDto;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "product_name")
    private String name;

    private float price;

    @Column(name = "product_categorie")
    private String categorie;

    private List<String> sizes;

    @Column(name = "product_src")
    private String src;
    @Column(name = "product_alt")
    private String alt;


    public Product (ProductDto productDto)
    {
        this.name = productDto.getName();
        this.price = productDto.getPrice();
        this.categorie = productDto.getCategorie();
        this.sizes = productDto.getSizes();
        this.src = productDto.getSrc();
        this.alt = productDto.getAlt();
    }
    public Product (Long id, ProductDto productDto)
    {
        this.id = id;
        this.name = productDto.getName();
        this.price = productDto.getPrice();
        this.categorie = productDto.getCategorie();
        this.sizes = productDto.getSizes();
        this.src = productDto.getSrc();
        this.alt = productDto.getAlt();
    }
}


