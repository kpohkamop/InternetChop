package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }


    public void add(Searchable searchable) {
        searchables.add(searchable);
    }


    public Set<Searchable> search(String searchString) {
        if (searchString == null || searchString.trim().isEmpty()) {
            return new TreeSet<>(new SearchableComparator());
        }

        String lowerSearchTerm = searchString.toLowerCase();

        return searchables.stream()
                .filter(searchable -> searchable.getSearchTerm()
                        .toLowerCase()
                        .contains(lowerSearchTerm))
                .limit(5)
                .collect(Collectors.toCollection(() ->
                        new TreeSet<>(new SearchableComparator())));
    }

    public int getSize() {
        return searchables.size();
    }
}