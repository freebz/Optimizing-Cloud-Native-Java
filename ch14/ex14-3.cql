CREATE TABLE IF NOT EXISTS demoTable (id INT PRIMARY KEY);
ALTER TABLE demoTable ADD newField INT;
CREATE INDEX myIndex ON demoTable (newField);
INSERT INTO demoTable (id, newField) VALUES (1, 2);
SELECT * FROM demoTable WHERE newField = 2;
SELECT COUNT(*) FROM demoTable;
DELETE FROM demoTable WHERE newField = 2;