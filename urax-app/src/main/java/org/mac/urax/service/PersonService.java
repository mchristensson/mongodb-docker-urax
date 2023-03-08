package org.mac.urax.service;

import org.mac.urax.model.PersonSearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PersonService implements PersonServiceProvider {
    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
    @Override
    public PersonSearchResult freeTextSearch(String query) {
        logger.debug("Söker efter person '{}'...", query);
        PersonSearchResult result = new PersonSearchResult();
        result.setResult(Collections.emptyList());
        result.setCount(0);
        return result;
    }
}
