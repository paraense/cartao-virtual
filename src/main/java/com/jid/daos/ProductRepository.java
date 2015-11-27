package com.jid.daos;

import com.jid.models.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by igor on 27/11/15.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByName(String name);
}
