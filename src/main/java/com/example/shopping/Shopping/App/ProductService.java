package com.example.shopping.Shopping.App;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getProduct(){
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        Optional<Product> productByName = productRepository.findByProductName(product.getProductName());

        if (productByName.isPresent()){
            throw new IllegalStateException("Product Already Exist");
        }

        productRepository.save(product);
    }


    public void deleteProduct(Long productId) {

        boolean exists = productRepository.existsById(productId);

        if (!exists){
            throw new IllegalStateException("Product Does Not Exist");
        }
        productRepository.deleteById(productId);

    }

    //The Update product method which is used in the product controller class with the Put Mapping type
    //This method uses the Transactional Annotation to update the fields in it.
    @Transactional
    public void updateProduct(Long productId, String productName,
                              BigDecimal productPrice,
                              String productBrand,
                              String productDescription) {

        // This class fetches the product ID from the product repository class using the find ID method
        Product product = productRepository
                .findById(productId)
                .orElseThrow(()-> new IllegalStateException("ID does not exist"));

        //Check for name not null, not empty and not the same as previous name
        if (productName != null && productName.length() > 0
                && !Objects.equals(product.getProductName(), productName)){
            product.setProductName(productName);
        }

        //Check whether product price isn't null empty and not same as previous one
        if (productPrice != null && !productPrice.equals(new BigDecimal("0"))
                && !Objects.equals(product.getProductPrice(), productPrice)){
            product.setProductPrice(productPrice);
        }

        //Check whether product brand isn't null empty and the new brand isn't equal to the old one
        if (productBrand != null && productBrand.length() > 0
                && !Objects.equals(product.getProductBrand(), productBrand)){
            product.setProductBrand(productBrand);
        }

        //Check is product description to be changed isn't empty and not the same
        if (productDescription != null && productDescription.length() > 0
                && !Objects.equals(product.getProductDescription(), productDescription)){
            product.setProductDescription(productDescription);
        }

    }
}
