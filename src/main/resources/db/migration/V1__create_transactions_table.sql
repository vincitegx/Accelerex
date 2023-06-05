CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    sender_account_number VARCHAR(255) NOT NULL,
    receiver_account_number VARCHAR(255) NOT NULL,
    sender_name VARCHAR(255) NOT NULL,
    receiver_name VARCHAR(255) NOT NULL,
    reference_no VARCHAR(255) NOT NULL,
    amount DECIMAL(19, 2) NOT NULL,
    currency_code VARCHAR(255) NOT NULL,
    charge DECIMAL(19, 2),
    narration VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    transaction_type VARCHAR(255) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE SEQUENCE transaction_id_sequence;

ALTER TABLE transactions ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id);

