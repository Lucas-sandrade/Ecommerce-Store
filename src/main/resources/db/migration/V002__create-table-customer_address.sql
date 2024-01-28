CREATE TABLE customer_address (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         street VARCHAR(255),
                         city VARCHAR(255),
                         state VARCHAR(255),
                         postal_code VARCHAR(20),
                         customer_id BIGINT,
                         FOREIGN KEY (customer_id) REFERENCES customer(id)
);