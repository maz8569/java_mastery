DROP TABLE IF EXISTS employees;
CREATE TABLE employees
(
    employee_id   BIGINT       NOT NULL,
    first_name    VARCHAR(255) NULL,
    last_name     VARCHAR(255) NULL,
    department_id BIGINT       NULL,
    job_title     VARCHAR(255) NULL,
    CONSTRAINT pk_employees PRIMARY KEY (employee_id)
);