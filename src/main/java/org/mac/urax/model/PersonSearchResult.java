package org.mac.urax.model;

import java.util.Collection;
import java.util.List;

public class PersonSearchResult implements SearchResult<PersonData> {

    private List<PersonData> result;
    private int count;

    @Override
    public Collection<PersonData> getResult() {
        return this.result;
    }

    @Override
    public void setCount(int i) {
        this.count = i;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    public void setResult(List<PersonData> result) {
        this.result = result;
    }
}
