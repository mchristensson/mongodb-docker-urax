package org.mac.urax.service;

import org.mac.urax.model.PersonSearchResult;

public interface PersonServiceProvider {
    PersonSearchResult freeTextSearch(String query);
}
