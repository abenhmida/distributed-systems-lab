CREATE TABLE outbox_events
(
    id             UUID PRIMARY KEY,
    aggregate_type VARCHAR(100) NOT NULL,
    aggregate_id   VARCHAR(100) NOT NULL,
    event_type     VARCHAR(100) NOT NULL,
    event_version  INTEGER      NOT NULL,
    payload        JSONB        NOT NULL,
    headers        JSONB,
    occurred_at    TIMESTAMP    NOT NULL,
    published_at   TIMESTAMP,
    retry_count    INTEGER      NOT NULL DEFAULT 0,
    next_retry_at  TIMESTAMP,
    created_at     TIMESTAMP    NOT NULL,
    updated_at     TIMESTAMP    NOT NULL
);

CREATE INDEX idx_outbox_pending
    ON outbox_events (
                      published_at,
                      next_retry_at
        );

CREATE INDEX idx_outbox_aggregate
    ON outbox_events (
                      aggregate_type,
                      aggregate_id
        );