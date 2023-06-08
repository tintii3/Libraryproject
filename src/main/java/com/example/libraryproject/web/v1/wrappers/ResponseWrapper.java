package com.example.libraryproject.web.v1.wrappers;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseWrapper<T> {
    private T data;
    private ErrorWrapper error;
    private Boolean success = true;
    private int status;

    public ResponseWrapper(int status) {
        this.status = status;
    }

    public ResponseWrapper(Boolean success, int status) {
        this.success = success;
        this.status = status;
    }

    public ResponseWrapper(T data, int status) {
        this.data = data;
        this.status = status;
        this.success = this.setSuccess(status);
    }

    public ResponseWrapper(T data, Boolean success, int status) {
        this.data = data;
        this.success = success;
        this.status = status;
    }

    public ResponseWrapper(ErrorWrapper error, int status) {
        this.error = error;
        this.status = status;
        this.success = this.setSuccess(status);
    }

    private boolean setSuccess(int status) {
        return status >= 200 && status < 300;
    }

    public T getData() {
        return this.data;
    }

    public ErrorWrapper getError() {
        return this.error;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public int getStatus() {
        return this.status;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public void setError(final ErrorWrapper error) {
        this.error = error;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResponseWrapper)) {
            return false;
        } else {
            ResponseWrapper<?> other = (ResponseWrapper)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getStatus() != other.getStatus()) {
                return false;
            } else {
                label49: {
                    Object this$success = this.getSuccess();
                    Object other$success = other.getSuccess();
                    if (this$success == null) {
                        if (other$success == null) {
                            break label49;
                        }
                    } else if (this$success.equals(other$success)) {
                        break label49;
                    }

                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                Object this$error = this.getError();
                Object other$error = other.getError();
                if (this$error == null) {
                    if (other$error != null) {
                        return false;
                    }
                } else if (!this$error.equals(other$error)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ResponseWrapper;
    }

    public int hashCode() {
        //int PRIME = true;
        int result = 1;
        result = result * 59 + this.getStatus();
        Object $success = this.getSuccess();
        result = result * 59 + ($success == null ? 43 : $success.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        Object $error = this.getError();
        result = result * 59 + ($error == null ? 43 : $error.hashCode());
        return result;
    }


    public String toString() {
        return "ResponseWrapper(data=" + this.getData() + ", error=" + this.getError() + ", success=" + this.getSuccess() + ", status=" + this.getStatus() + ")";
    }

    public ResponseWrapper() {
    }
}
