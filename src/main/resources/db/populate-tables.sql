DELETE FROM quim;
INSERT INTO quim (id, aboutMe, email, location, name, phone)
VALUES (1,'a very serious tech person', 'andre@helperz.com', 1, 'Andre Santos', 929299292 ),
       (2,'a fast errand person', 'hugo@helperz.com', 2, 'Hugo Amaral', 919199191 ),
       (3,'a very strong person', 'pedro@helperz.com', 1, 'Pedro Barros', 939399303 ),
       (4,'a very handy person', 'paulo@helperz.com', 0, 'Paulo Moutinho', 969699606 );

DELETE FROM misson;
INSERT INTO mission (description, location, skill, status, owner_id),
VALUES ('help me with shopping bags', 0, 0, 0, 1);

INSERT INTO mission (description, location, skill, status, owner_id),
VALUES ('help me with computer virus', 0, 0, 0, 2);

INSERT INTO mission (description, location, skill, status, owner_id),
VALUES ('help me with some old furniture', 0, 0, 0, 3);

INSERT INTO mission (description, location, skill, status, owner_id),
VALUES ('help me with mowning the lawn', 0, 0, 0, 1);