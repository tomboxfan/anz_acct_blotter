INSERT INTO user (id, name) VALUES
  (1, 'Tom'),
  (2, 'Sandy');

INSERT INTO account (id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance) VALUES
  (1, 1, 585309209, 'Savings', 'Current Account', '2018-11-08', 'SGD', 84327.51),
  (2, 1, 791066619, 'Current', 'Current Account', '2018-11-09', 'AUD', 88005.93),
  (3, 2, 321143048, 'Savings', 'Current Account', '2018-11-10', 'AUD', 38010.62),
  (4, 2, 347786244, 'Current', 'Current Account', '2018-11-11', 'SGD', 50664.65);

INSERT INTO transaction(id, account_id, value_date, debit_amount, credit_amount, debit_credit, transaction_narrative) VALUES
(1, 1, '2020-01-01', 100.1, null, 'Debit', 'Credit Card Payment'),
(2, 1, '2020-01-02', null, 10000.2, 'Credit', 'Salary'),
(3, 2, '2020-01-03', 200.3, null, 'Debit', 'Shopee'),
(4, 2, '2020-01-04', null, 10.4, 'Credit', 'Interests'),
(5, 3, '2020-01-05', 10.5, null, 'Debit', 'Credit Card Payment'),
(6, 3, '2020-01-06', null, 10000.6, 'Credit', 'Salary'),
(7, 4, '2020-01-07', 10.7, null, 'Debit', 'Shopee'),
(8, 4, '2020-01-08', null, 10.8, 'Credit', 'Interests');