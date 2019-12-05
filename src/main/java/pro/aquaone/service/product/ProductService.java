package pro.aquaone.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pro.aquaone.model.Product;
import pro.aquaone.repository.product.CrudProductRepository;

import java.util.List;

import static pro.aquaone.util.ValidationUtil.checkNotFoundWithId;

@Service
public class ProductService {
    private final CrudProductRepository repository;

    @Autowired
    public ProductService(CrudProductRepository repository){
        this.repository = repository;
    }

    public Product get(int id){
        return checkNotFoundWithId(repository.findById(id).orElse(null), id);
    }

    public void delete(int id){
        checkNotFoundWithId(repository.deleteProductById(id), id);
    }

    public Product create(Product product){
        Assert.notNull(product, "product must not be null");
        return repository.save(product);
    }

    public void update(Product product){
        Assert.notNull(product, "product must not be null");
        repository.save(product);
    }

    public List<Product> getAll(){
        return repository.findAll();
    }
}
