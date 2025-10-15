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

        if (resultsCount < 5) {
            Searchable[] trimmedResults = new Searchable[resultsCount];
            System.arraycopy(results, 0, trimmedResults, 0, resultsCount);
            return trimmedResults;
        }

        return results;
    }

    // Новый метод для поиска наиболее подходящего элемента
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.trim().isEmpty()) {
            throw new BestResultNotFound("Поисковый запрос не может быть пустым");
        }

        Searchable bestMatch = null;
        int maxCount = 0;

        for (int i = 0; i < count; i++) {
            Searchable searchable = searchables[i];
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

    // Вспомогательный метод для подсчета вхождений подстроки
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
        return count;
    }

    public int getCapacity() {
        return searchables.length;
    }
}
