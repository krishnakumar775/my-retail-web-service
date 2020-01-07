DROP TABLE IF EXISTS price;

CREATE TABLE price (
  id INTEGER PRIMARY KEY,
  value NUMBER NOT NULL,
  currency_code VARCHAR(250) NOT NULL

);

INSERT INTO price (id, value, currency_code) VALUES
  (13860428, 13.49, 'USD')