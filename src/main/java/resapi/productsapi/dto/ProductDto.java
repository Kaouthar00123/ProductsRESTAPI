package resapi.productsapi.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import resapi.productsapi.entity.Product;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {

    private Long id;

    private String name;

    private float price;

    private String categorie;

    private List<String> sizes;

    private String src;

    private String alt;

    public ProductDto (String name, float price, String categorie, List<String> sizes, String src,String alt)
    {
        this.name = name;
        this.price = price;
        this.categorie = categorie;
        this.sizes = sizes;
        this.src = src;
        this.alt = alt;
    }

    public ProductDto (Product product)
    {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.categorie = product.getCategorie();
        this.sizes = product.getSizes();
        this.src = product.getSrc();
        this.alt = product.getAlt();
    }
}
