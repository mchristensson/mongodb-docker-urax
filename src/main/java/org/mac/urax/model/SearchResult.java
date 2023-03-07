package org.mac.urax.model;

import java.util.Collection;

public interface SearchResult<T> {
    Collection<T> getResult();

    void setCount(int i);
    int getCount();
}
