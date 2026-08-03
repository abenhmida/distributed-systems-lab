ALTER TABLE orders DROP total_amount;
ALTER TABLE orders DROP currency;

CREATE TABLE order_items
(
    id         BIGSERIAL PRIMARY KEY,
    order_id   UUID           NOT NULL,
    product_id VARCHAR(100)   NOT NULL,
    quantity   INTEGER        NOT NULL,
    unit_price NUMERIC(19, 2) NOT NULL,
    currency   VARCHAR(3)     NOT NULL,

    CONSTRAINT fk_order
        FOREIGN KEY (order_id)
            REFERENCES orders (id)
            ON DELETE CASCADE
);