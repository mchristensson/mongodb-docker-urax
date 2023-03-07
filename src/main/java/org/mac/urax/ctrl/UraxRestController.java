package org.mac.urax.ctrl;

import org.mac.urax.model.Greeting;
import org.mac.urax.model.PersonSearchResult;
import org.mac.urax.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("publikt")
public class UraxRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private final PersonService personService;

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
}
