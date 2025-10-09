package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchables;
    private int count;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.count = 0;
    }

    public void add(Searchable searchable) {
        if (count < searchables.length) {
            searchables[count] = searchable;
            count++;
        } else {
            System.out.println("Невозможно добавить объект - поисковый движок заполнен");
        }
    }


    public Searchable[] search(String searchString) {
        if (searchString == null || searchString.trim().isEmpty()) {
            return new Searchable[0];
        }

        Searchable[] results = new Searchable[5];
        int resultsCount = 0;

        for (int i = 0; i < count && resultsCount < 5; i++) {
            Searchable searchable = searchables[i];
            if (searchable != null &&
                    searchable.getSearchTerm().toLowerCase().contains(searchString.toLowerCase())) {
                results[resultsCount] = searchable;
                resultsCount++;
            }
        }

        // Если найдено меньше 5 элементов, возвращаем массив без null в конце
        if (resultsCount < 5) {
            Searchable[] trimmedResults = new Searchable[resultsCount];
            System.arraycopy(results, 0, trimmedResults, 0, resultsCount);
            return trimmedResults;
        }

        return results;
    }


    public int getSize() {
        return count;
    }


    public int getCapacity() {
        return searchables.length;
    }
}