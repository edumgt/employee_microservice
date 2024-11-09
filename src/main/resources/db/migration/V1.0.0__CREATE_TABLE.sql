CREATE TABLE IF NOT EXISTS employee(
    employee_id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(60) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    rg VARCHAR(12) NOT NULL UNIQUE,
    employee_email VARCHAR(60) NOT NULL UNIQUE,
    area_code VARCHAR(3) NOT NULL,
    cellphone_number VARCHAR(9) NOT NULL UNIQUE,
    active CHAR(1) NOT NULL,
    created_at DATETIME NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    updated_at DATETIME,
    updated_by VARCHAR(20)
)