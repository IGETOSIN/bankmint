set mode MySQL;
--SET SCHEMA recordautomation;
CREATE TABLE if not exists tbl_task1 (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  digits VARCHAR(250) NOT NULL,
  counts int(11) NOT NULL
);

ALTER TABLE tbl_task1
ADD UNIQUE (digits);

