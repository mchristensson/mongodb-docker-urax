package org.mac.urax.ctrl;

import jakarta.servlet.http.HttpServletRequest;
import org.mac.urax.dao.ProductRepository;
import org.mac.urax.model.Greeting;
import org.mac.urax.model.PersonSearchResult;
import org.mac.urax.model.Product;
import org.mac.urax.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("publikt")
public class UraxRestController implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(UraxRestController.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private final PersonService personService;

    @Autowired
    private ProductRepository productRepository;

    public UraxRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/person/find")
    public PersonSearchResult findPerson(@RequestParam(value = "query", defaultValue = "") String queryName) {
        return personService.freeTextSearch(queryName);
    }

    /**
     * Searches for products in database
     *
     * @return Matching product entities
     */
    @GetMapping("/products")
    public @ResponseBody Iterable<Product> findProducts() {
        logger.debug("Rest-tjänst 'products' anropades...");
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            logger.error("An unknown error occured when searchind for products", e);
            return Collections.emptyList();
        }
    }


}

