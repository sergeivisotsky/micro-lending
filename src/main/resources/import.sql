INSERT INTO "user" VALUES (1, 'John', 'Smith');
INSERT INTO "user" VALUES (2, 'Sergei', 'Visotsky');
INSERT INTO "user" VALUES (3, 'Tommy', 'Brown');

INSERT INTO loan VALUES (1, 20, 120.00, '192.168.0.0.1', 1);
INSERT INTO loan VALUES (2, 5, 50.98, '192.168.0.0.2', 1);
INSERT INTO loan VALUES (3, 3, 40.09, '192.168.0.0.3', 1);

INSERT INTO error_messages VALUES (1, 'USR_001', 'User with this ID not found');
INSERT INTO error_messages VALUES (2, 'USR_002', 'User has not done any loan');
INSERT INTO error_messages VALUES (3, 'LON_001', 'Loan cannot be made before 00:00');
INSERT INTO error_messages VALUES (4, 'LON_002', 'Loan amount is greater than max allowed loan amount');