package com.greenback.kit.model;

import static com.greenback.kit.util.Utils.toIterable;
import java.time.Instant;

public class ConnectQuery extends Query<ConnectQuery> {
    
    protected Iterable<String> labels;
    protected Iterable<ConnectState> states;
    protected Iterable<ConnectType> types;
    protected Instant minCreatedAt;
    protected Instant maxCreatedAt;
    protected Instant minUpdatedAt;
    protected Instant maxUpdatedAt;

    public Iterable<String> getLabels() {
        return labels;
    }

    public ConnectQuery setLabels(Iterable<String> labels) {
        this.labels = labels;
        return this;
    }

    public ConnectQuery setLabels(String... labels) {
        this.labels = toIterable(labels);
        return this;
    }
    
    public Iterable<ConnectState> getStates() {
        return states;
    }

    public ConnectQuery setStates(Iterable<ConnectState> states) {
        this.states = states;
        return this;
    }
    
    public ConnectQuery setStates(ConnectState... states) {
        this.states = toIterable(states);
        return this;
    }

    public Iterable<ConnectType> getTypes() {
        return types;
    }

    public ConnectQuery setTypes(Iterable<ConnectType> types) {
        this.types = types;
        return this;
    }
    
    public ConnectQuery setTypes(ConnectType... types) {
        this.types = toIterable(types);
        return this;
    }

    public Instant getMinCreatedAt() {
        return minCreatedAt;
    }

    public ConnectQuery setMinCreatedAt(Instant minCreatedAt) {
        this.minCreatedAt = minCreatedAt;
        return this;
    }

    public Instant getMaxCreatedAt() {
        return maxCreatedAt;
    }

    public ConnectQuery setMaxCreatedAt(Instant maxCreatedAt) {
        this.maxCreatedAt = maxCreatedAt;
        return this;
    }

    public Instant getMinUpdatedAt() {
        return minUpdatedAt;
    }

    public ConnectQuery setMinUpdatedAt(Instant minUpdatedAt) {
        this.minUpdatedAt = minUpdatedAt;
        return this;
    }

    public Instant getMaxUpdatedAt() {
        return maxUpdatedAt;
    }

    public ConnectQuery setMaxUpdatedAt(Instant maxUpdatedAt) {
        this.maxUpdatedAt = maxUpdatedAt;
        return this;
    }

}