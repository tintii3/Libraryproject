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
    private boolean includeStudent;

    public boolean isIncludeStudent() {
        return includeStudent;
    }

    public void setIncludeStudent(boolean includeStudent) {
        this.includeStudent = includeStudent;
    }
}
