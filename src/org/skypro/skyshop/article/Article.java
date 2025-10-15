package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String content;

    public Article(String title, String content) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Заголовок статьи не может быть пустым или состоять только из пробелов");
        }
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Содержание статьи не может быть пустым или состоять только из пробелов");
        }
        this.title = title;
        this.content = content;
    }

    @Override
    public String getName() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String toString() {
        return title + "\n" + content + "\n";
    }
}