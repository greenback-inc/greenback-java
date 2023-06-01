package com.greenback.kit.model;

public class AutoExportResult {
    private Integer total;
    private Integer created;
    private Integer updated;
    private Integer unmapped;
    private Integer matched;
    private Integer skipped;
    private Integer failed;

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

    public Integer getMatched() {
        return matched;
    }

    public void setMatched(Integer matched) {
        this.matched = matched;
    }

    public Integer getSkipped() {
        return skipped;
    }

    public void setSkipped(Integer skipped) {
        this.skipped = skipped;
    }

    public Integer getFailed() {
        return failed;
    }

    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    public Integer getUnmapped() {
        return unmapped;
    }

    public void setUnmapped(Integer unmapped) {
        this.unmapped = unmapped;
    }

    @Override
    public String toString() {
        return "AutoExportResult{" +
            "total=" + total +
            ", created=" + created +
            ", updated=" + updated +
            ", unmapped=" + unmapped +
            ", matched=" + matched +
            ", failed=" + failed +
            ", skipped=" + skipped +
            '}';
    }
}
