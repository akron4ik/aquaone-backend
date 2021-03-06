package pro.aquaone.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pro.aquaone.model.Category;
import pro.aquaone.model.Product;
import pro.aquaone.service.category.CategoryService;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/categories", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriesController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    CategoryService categoryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Category> getAll() {
        return categoryService.getAll();
    }
}
