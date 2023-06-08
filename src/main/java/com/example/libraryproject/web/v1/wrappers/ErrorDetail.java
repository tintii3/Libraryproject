package com.example.libraryproject.web.v1.wrappers;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErrorDetail {
    private String field;
    private Object value;
    private String issue;
    private String location;

    public ErrorDetail(String field, Object value, String issue) {
        this.field = field;
        this.value = value;
        this.issue = issue;
    }

    public String getField() {
        return this.field;
    }

    public Object getValue() {
        return this.value;
    }

    public String getIssue() {
        return this.issue;
    }

    public String getLocation() {
        return this.location;
    }

    public void setField(final String field) {
        this.field = field;
    }

    public void setValue(final Object value) {
        this.value = value;
    }

    public void setIssue(final String issue) {
        this.issue = issue;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ErrorDetail)) {
            return false;
        } else {
            ErrorDetail other = (ErrorDetail)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$field = this.getField();
                    Object other$field = other.getField();
                    if (this$field == null) {
                        if (other$field == null) {
                            break label59;
                        }
                    } else if (this$field.equals(other$field)) {
                        break label59;
                    }

                    return false;
                }

                Object this$value = this.getValue();
                Object other$value = other.getValue();
                if (this$value == null) {
                    if (other$value != null) {
                        return false;
                    }
                } else if (!this$value.equals(other$value)) {
                    return false;
                }

                Object this$issue = this.getIssue();
                Object other$issue = other.getIssue();
                if (this$issue == null) {
                    if (other$issue != null) {
                        return false;
                    }
                } else if (!this$issue.equals(other$issue)) {
                    return false;
                }

                Object this$location = this.getLocation();
                Object other$location = other.getLocation();
                if (this$location == null) {
                    if (other$location != null) {
                        return false;
                    }
                } else if (!this$location.equals(other$location)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ErrorDetail;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $field = this.getField();
        result = result * 59 + ($field == null ? 43 : $field.hashCode());
        Object $value = this.getValue();
        result = result * 59 + ($value == null ? 43 : $value.hashCode());
        Object $issue = this.getIssue();
        result = result * 59 + ($issue == null ? 43 : $issue.hashCode());
        Object $location = this.getLocation();
        result = result * 59 + ($location == null ? 43 : $location.hashCode());
        return result;
    }


    public String toString() {
        return "ErrorDetail(field=" + this.getField() + ", value=" + this.getValue() + ", issue=" + this.getIssue() + ", location=" + this.getLocation() + ")";
    }

    public ErrorDetail() {
    }

    public ErrorDetail(final String field, final Object value, final String issue, final String location) {
        this.field = field;
        this.value = value;
        this.issue = issue;
        this.location = location;
    }
}

