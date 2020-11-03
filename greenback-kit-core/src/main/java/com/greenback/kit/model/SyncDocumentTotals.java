package com.greenback.kit.model;

import java.time.Instant;

public class SyncDocumentTotals {
    
    private Integer total;
    private Integer created;
    private Integer updated;
    private Integer staged;
    private Integer ignored;
    private Integer warnings;
    private Integer errors;
    private Instant warnedAt;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    public Integer getStaged() {
        return staged;
    }

    public void setStaged(Integer staged) {
        this.staged = staged;
    }

    public Integer getIgnored() {
        return ignored;
    }

    public void setIgnored(Integer ignored) {
        this.ignored = ignored;
    }
    
    public Integer getWarnings() {
        return warnings;
    }

    public void setWarnings(Integer warnings) {
        this.warnings = warnings;
    }

    public Integer getErrors() {
        return errors;
    }

    public void setErrors(Integer errors) {
        this.errors = errors;
    }
    
    public Instant getWarnedAt() {
        return warnedAt;
    }

    public void setWarnedAt(Instant warnedAt) {
        this.warnedAt = warnedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (total != null) {
            sb.append("total=").append(total);
        }
        if (created != null) {
            if (sb.length() > 0) { sb.append(", "); }
            sb.append("created=").append(created);
        }
        if (updated != null) {
            if (sb.length() > 0) { sb.append(", "); }
            sb.append("updated=").append(updated);
        }
        if (staged != null) {
            if (sb.length() > 0) { sb.append(", "); }
            sb.append("staged=").append(staged);
        }
        if (ignored != null) {
            if (sb.length() > 0) { sb.append(", "); }
            sb.append("ignored=").append(ignored);
        }
        if (warnings != null) {
            if (sb.length() > 0) { sb.append(", "); }
            sb.append("warnings=").append(warnings);
        }
        if (errors != null) {
            if (sb.length() > 0) { sb.append(", "); }
            sb.append("errors=").append(errors);
        }
        return sb.toString();
    }

    // helpers
    
    public void collectWarnedAt(Instant warnedAt) {
        if (warnedAt == null) {
            return;
        }
        if (this.warnedAt == null || warnedAt.isBefore(this.warnedAt)) {
            this.warnedAt = warnedAt;
        }
    }

    public void incrementTotal(int increment) {
        if (this.total == null) {
            this.total = increment;
        } else {
            this.total += increment;
        }
    }

    public void incrementCreated(int increment) {
        if (this.created == null) {
            this.created = increment;
        } else {
            this.created += increment;
        }
    }

    public void incrementUpdated(int increment) {
        if (this.updated == null) {
            this.updated = increment;
        } else {
            this.updated += increment;
        }
    }

    public void incrementStaged(int increment) {
        if (this.staged == null) {
            this.staged = increment;
        } else {
            this.staged += increment;
        }
    }

    public void incrementIgnored(int increment) {
        if (this.ignored == null) {
            this.ignored = increment;
        } else {
            this.ignored += increment;
        }
    }

    public void incrementWarnings(int increment) {
        if (increment != 0) {
            if (this.warnings == null) {
                this.warnings = increment;
            } else {
                this.warnings += increment;
            }
        }
    }

    public void incrementErrors(int increment) {
        if (increment != 0) {
            if (this.errors == null) {
                this.errors = increment;
            } else {
                this.errors += increment;
            }
        }
    }
    
}
