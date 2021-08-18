DROP TABLE IF EXISTS insurance;

CREATE TABLE insurance(
    id INT AUTO_INCREMENT PRIMARY KEY,
    policy_type VARCHAR(255) NULL,
    policy_sum INT NULL,
    name VARCHAR(255) NULL,
    surname VARCHAR(255) NULL,
    item VARCHAR(255) NULL
)