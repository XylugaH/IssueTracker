INSERT INTO  user VALUES (1,'admin','admin','$2a$11$MmNXphksqwYLE.eMGXW60eQgUnxlc6BtrvLeSYhrK42BkwJpJXcWC','admin@admin.com',2);

INSERT INTO  role VALUES (1,'ROLE_USER');
INSERT INTO  role VALUES (2,'ROLE_ADMIN');

INSERT INTO  status VALUES (1,'New');
INSERT INTO  status VALUES (2,'Assigned');
INSERT INTO  status VALUES (3,'In Progress');
INSERT INTO  status VALUES (4,'Resolved');
INSERT INTO  status VALUES (5,'Closed');
INSERT INTO  status VALUES (6,'Reopened');

INSERT INTO  resolution VALUES (1,'Fixed');
INSERT INTO  resolution VALUES (2,'Invalid');
INSERT INTO  resolution VALUES (3,'Wontfix');
INSERT INTO  resolution VALUES (4,'Worksforme');

INSERT INTO  priority VALUES (1,'Critical','Red');
INSERT INTO  priority VALUES (2,'Major','Orange');
INSERT INTO  priority VALUES (3,'Important','Blue');
INSERT INTO  priority VALUES (4,'Minor','Green');

INSERT INTO  type VALUES (1,'Cosmetic');
INSERT INTO  type VALUES (2,'Bug');
INSERT INTO  type VALUES (3,'Feature');
INSERT INTO  type VALUES (4,'Performance');

