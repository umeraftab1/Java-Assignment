DROP TABLE IF EXISTS PAYMENT_PLANS;
DROP TABLE IF EXISTS PAYMENT_METHODS;

CREATE TABLE PAYMENT_METHODS (
  payment_method_id INT PRIMARY KEY,
  name VARCHAR(250) DEFAULT NULL,
  display_name VARCHAR(250) DEFAULT NULL,
  payment_type VARCHAR(250) DEFAULT NULL
);

CREATE TABLE PAYMENT_PLANS (
  payment_plan_id INT PRIMARY KEY,
  net_amount DOUBLE DEFAULT NULL,
  tax_amount DOUBLE DEFAULT NULL,
  gross_amount DOUBLE DEFAULT NULL,
  currency VARCHAR(250) DEFAULT NULL,
  duration VARCHAR(250) DEFAULT NULL,
  payment_method_id INT
);

INSERT INTO PAYMENT_METHODS (payment_method_id, name, display_name, payment_type) VALUES
  (11, 'credit card', 'Credit card', 'CREDIT_CARD'),
  (12, 'alfa_lb', 'Alfa Lebanon', 'MOBILE_CARRIER'),
  (13, 'voucher', 'Voucher', 'VOUCHER');

INSERT INTO PAYMENT_PLANS (payment_plan_id, net_amount, tax_amount, gross_amount, currency, duration, payment_method_id) VALUES
  (21, 5.99, 0, 5.99, 'USD', 'Month', 11),
  (22, 5.99, 0, 5.99, 'USD', 'Month', 12),
  (23, 10, 0, 10, 'SAR', 'Week', 12);
