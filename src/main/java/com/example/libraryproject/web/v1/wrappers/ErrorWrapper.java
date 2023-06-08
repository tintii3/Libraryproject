package com.example.libraryproject.web.v1.wrappers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.FieldError;

@JsonInclude(Include.NON_NULL)
public class ErrorWrapper {
    private String name;
    private String message;
    private Object target;
    @JsonFormat(
            shape = Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss"
    )
    private LocalDateTime timestamp = LocalDateTime.now();
    private List<ErrorDetail> details = new ArrayList();
    private String debugId;
    private String path;

    public ErrorWrapper(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public ErrorWrapper(String name, String message, Object target) {
        this.name = name;
        this.message = message;
        this.target = target;
    }

    public ErrorWrapper(String name, String message, Object target, List<ErrorDetail> details) {
        this.name = name;
        this.message = message;
        this.target = target;
        this.details = details;
    }

    public void addErrorDetails(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addErrorDetail);
    }

    private void addErrorDetail(FieldError fieldError) {
        this.details.add(new ErrorDetail(fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage()));
    }

    public static ErrorWrapperBuilder builder() {
        return new ErrorWrapperBuilder();
    }

    public String getName() {
        return this.name;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getTarget() {
        return this.target;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public List<ErrorDetail> getDetails() {
        return this.details;
    }

    public String getDebugId() {
        return this.debugId;
    }

    public String getPath() {
        return this.path;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setTarget(final Object target) {
        this.target = target;
    }

    @JsonFormat(
            shape = Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss"
    )
    public void setTimestamp(final LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setDetails(final List<ErrorDetail> details) {
        this.details = details;
    }

    public void setDebugId(final String debugId) {
        this.debugId = debugId;
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public String toString() {
        return "ErrorWrapper(name=" + this.getName() + ", message=" + this.getMessage() + ", target=" + this.getTarget() + ", timestamp=" + this.getTimestamp() + ", details=" + this.getDetails() + ", debugId=" + this.getDebugId() + ", path=" + this.getPath() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ErrorWrapper)) {
            return false;
        } else {
            ErrorWrapper other = (ErrorWrapper)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95: {
                    Object this$name = this.getName();
                    Object other$name = other.getName();
                    if (this$name == null) {
                        if (other$name == null) {
                            break label95;
                        }
                    } else if (this$name.equals(other$name)) {
                        break label95;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$target = this.getTarget();
                Object other$target = other.getTarget();
                if (this$target == null) {
                    if (other$target != null) {
                        return false;
                    }
                } else if (!this$target.equals(other$target)) {
                    return false;
                }

                label74: {
                    Object this$timestamp = this.getTimestamp();
                    Object other$timestamp = other.getTimestamp();
                    if (this$timestamp == null) {
                        if (other$timestamp == null) {
                            break label74;
                        }
                    } else if (this$timestamp.equals(other$timestamp)) {
                        break label74;
                    }

                    return false;
                }

                label67: {
                    Object this$details = this.getDetails();
                    Object other$details = other.getDetails();
                    if (this$details == null) {
                        if (other$details == null) {
                            break label67;
                        }
                    } else if (this$details.equals(other$details)) {
                        break label67;
                    }

                    return false;
                }

                Object this$debugId = this.getDebugId();
                Object other$debugId = other.getDebugId();
                if (this$debugId == null) {
                    if (other$debugId != null) {
                        return false;
                    }
                } else if (!this$debugId.equals(other$debugId)) {
                    return false;
                }

                Object this$path = this.getPath();
                Object other$path = other.getPath();
                if (this$path == null) {
                    if (other$path != null) {
                        return false;
                    }
                } else if (!this$path.equals(other$path)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ErrorWrapper;
    }

    public int hashCode() {
        //int PRIME = true;
        int result = 1;
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $target = this.getTarget();
        result = result * 59 + ($target == null ? 43 : $target.hashCode());
        Object $timestamp = this.getTimestamp();
        result = result * 59 + ($timestamp == null ? 43 : $timestamp.hashCode());
        Object $details = this.getDetails();
        result = result * 59 + ($details == null ? 43 : $details.hashCode());
        Object $debugId = this.getDebugId();
        result = result * 59 + ($debugId == null ? 43 : $debugId.hashCode());
        Object $path = this.getPath();
        result = result * 59 + ($path == null ? 43 : $path.hashCode());
        return result;
    }

    public ErrorWrapper() {
    }

    public ErrorWrapper(final String name, final String message, final Object target, final LocalDateTime timestamp, final List<ErrorDetail> details, final String debugId, final String path) {
        this.name = name;
        this.message = message;
        this.target = target;
        this.timestamp = timestamp;
        this.details = details;
        this.debugId = debugId;
        this.path = path;
    }

    public static class ErrorWrapperBuilder {
        private String name;
        private String message;
        private Object target;
        private LocalDateTime timestamp;
        private List<ErrorDetail> details;
        private String debugId;
        private String path;

        ErrorWrapperBuilder() {
        }

        public ErrorWrapperBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public ErrorWrapperBuilder message(final String message) {
            this.message = message;
            return this;
        }

        public ErrorWrapperBuilder target(final Object target) {
            this.target = target;
            return this;
        }

        @JsonFormat(
                shape = Shape.STRING,
                pattern = "dd-MM-yyyy hh:mm:ss"
        )
        public ErrorWrapperBuilder timestamp(final LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorWrapperBuilder details(final List<ErrorDetail> details) {
            this.details = details;
            return this;
        }

        public ErrorWrapperBuilder debugId(final String debugId) {
            this.debugId = debugId;
            return this;
        }

        public ErrorWrapperBuilder path(final String path) {
            this.path = path;
            return this;
        }

        public ErrorWrapper build() {
            return new ErrorWrapper(this.name, this.message, this.target, this.timestamp, this.details, this.debugId, this.path);
        }

        public String toString() {
            return "ErrorWrapper.ErrorWrapperBuilder(name=" + this.name + ", message=" + this.message + ", target=" + this.target + ", timestamp=" + this.timestamp + ", details=" + this.details + ", debugId=" + this.debugId + ", path=" + this.path + ")";
        }
    }
}

