CREATE DATABASE todolist;

USE todolist;

CREATE TABLE task (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  date DATE NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO task (title, description, target_date)
VALUES ('Run Errands', 'To buy Kuih Lapis for family, Jean and Bryan', '2023-06-05');

INSERT INTO task (title, description, target_date)
VALUES ('JFSD Project Task', 'Complete Frontend and Backend structure for JFSD course', '2023-06-28');

INSERT INTO task (title, description, target_date)
VALUES ('JFSD Portfolio', 'To complete my Portfolio and upload to Github', '2023-05-30');

SELECT * FROM task;


