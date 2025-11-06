package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private List<Searchable> searchables;

    public SearchEngine(int capacity) {
        this.searchables = new ArrayList<>(capacity);
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Map<String, Searchable> search(String searchString) {
        Map<String, Searchable> results = new TreeMap<>();

        if (searchString == null || searchString.trim().isEmpty()) {
            return results;
        }

        for (Searchable searchable : searchables) {
            if (searchable != null &&
                    searchable.getSearchTerm().toLowerCase().contains(searchString.toLowerCase())) {
                results.put(searchable.getName(), searchable);
            }
        }

        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.trim().isEmpty()) {
            throw new BestResultNotFound("Поисковый запрос не может быть пустым");
        }

        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String searchTerm = searchable.getSearchTerm().toLowerCase();
                String searchLower = search.toLowerCase();

                int count = countOccurrences(searchTerm, searchLower);

                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = searchable;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящих результатов для поискового запроса: '" + search + "'");
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String substring) {
        if (text == null || substring == null || substring.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        int substringIndex = text.indexOf(substring, index);

        while (substringIndex != -1) {
            count++;
            index = substringIndex + substring.length();
            substringIndex = text.indexOf(substring, index);
        }

        return count;
    }

    public int getSize() {
        return searchables.size();
    }

    public int getCapacity() {
        return Integer.MAX_VALUE;
    }
}
