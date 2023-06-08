package com.example.libraryproject.web.v1.wrappers;
import java.util.Set;

public class IdCollection {
    private Set<Integer> ids;

    public static IdCollectionBuilder builder() {
        return new IdCollectionBuilder();
    }

    public Set<Integer> getIds() {
        return this.ids;
    }

    public void setIds(final Set<Integer> ids) {
        this.ids = ids;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof IdCollection)) {
            return false;
        } else {
            IdCollection other = (IdCollection)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$ids = this.getIds();
                Object other$ids = other.getIds();
                if (this$ids == null) {
                    if (other$ids != null) {
                        return false;
                    }
                } else if (!this$ids.equals(other$ids)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof IdCollection;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $ids = this.getIds();
        result = result * 59 + ($ids == null ? 43 : $ids.hashCode());
        return result;
    }

    public String toString() {
        return "IdCollection(ids=" + this.getIds() + ")";
    }

    public IdCollection() {
    }

    public IdCollection(final Set<Integer> ids) {
        this.ids = ids;
    }

    public static class IdCollectionBuilder {
        private Set<Integer> ids;

        IdCollectionBuilder() {
        }

        public IdCollectionBuilder ids(final Set<Integer> ids) {
            this.ids = ids;
            return this;
        }

        public IdCollection build() {
            return new IdCollection(this.ids);
        }

        public String toString() {
            return "IdCollection.IdCollectionBuilder(ids=" + this.ids + ")";
        }
    }
}

