package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>(); // Заменяем List на HashSet
    }

    /**
     * Добавляет новый объект типа Searchable в множество
     */
    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    /**
     * Поиск по множеству Searchable, возвращает отсортированный Set
     */
    public Set<Searchable> search(String searchString) {
        if (searchString == null || searchString.trim().isEmpty()) {
            return new TreeSet<>(new SearchableComparator());
        }

        Set<Searchable> results = new TreeSet<>(new SearchableComparator());
        String lowerSearchTerm = searchString.toLowerCase();

        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().toLowerCase().contains(lowerSearchTerm)) {
                results.add(searchable);
            }

            // Ограничиваем количество результатов (опционально)
            if (results.size() >= 5) {
                break;
            }
        }

        return results;
    }

    /**
     * Возвращает количество элементов в поисковом движке
     */
    public int getSize() {
        return searchables.size();
    }
}