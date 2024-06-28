package exercise.controller;

import java.util.List;
import java.util.Set;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.mapper.ProductMapper;
import exercise.model.Product;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.ProductRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    // BEGIN
    @GetMapping()
    public List<ProductDTO> index() {
        return productRepository.findAll().stream()
                .map(productMapper::map)
                .toList();
    }

    @GetMapping("/{id}")
    public ProductDTO show(@PathVariable long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        //product.getCategory();
        return productMapper.map(product);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@Valid @RequestBody ProductCreateDTO dto) {
        var productModel = productMapper.map(dto);
        try {
            productRepository.save(productModel);
        } catch (DataIntegrityViolationException e) {
            throw new ConstraintViolationException(null);
        }
        return productMapper.map(productModel);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO update(@Valid @RequestBody ProductUpdateDTO dto, @PathVariable long id) {
        var productForUpdate = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        productMapper.update(dto, productForUpdate);
        try {
            productRepository.save(productForUpdate);
        } catch (DataIntegrityViolationException e) {
            throw new ConstraintViolationException(null);
        }
        return productMapper.map(productForUpdate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
    // END
}
