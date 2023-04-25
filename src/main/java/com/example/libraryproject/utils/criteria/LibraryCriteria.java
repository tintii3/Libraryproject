package com.example.libraryproject.utils.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true, fluent = true)
public class LibraryCriteria {
    private boolean includeBook;

    public boolean isIncludeBook() {
        return includeBook;
    }

    public void setIncludeBook(boolean includeBook) {
        this.includeBook = includeBook;
    }
}
