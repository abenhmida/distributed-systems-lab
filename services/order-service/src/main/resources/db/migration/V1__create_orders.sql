CREATE TABLE orders
(
    id           UUID PRIMARY KEY,
    customer_id  VARCHAR(255)   NOT NULL,
    status       VARCHAR(30)    NOT NULL,
    total_amount NUMERIC(19, 2) NOT NULL,
    currency     VARCHAR(3)     NOT NULL,
    version      BIGINT         NOT NULL
);