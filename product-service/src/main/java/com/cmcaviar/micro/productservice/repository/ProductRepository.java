package com.cmcaviar.micro.productservice.repository;

import com.cmcaviar.micro.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
