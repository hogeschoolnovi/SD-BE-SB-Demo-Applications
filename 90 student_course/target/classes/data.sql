INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('bart', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('peter', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('bart', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('peter', 'ROLE_USER');

INSERT INTO course (code, name) VALUES ('SPR', 'Springboot');
INSERT INTO course (code, name) VALUES ('DON', 'Database Ontwikkeling');

INSERT INTO students (first_name, last_name, student_nr)
VALUES
 ('Tom', 'de Boer', '345674')
,('Yassine', 'Azdad', '123124')
,('Debby', 'Huismans', '452235')
,('Jay', 'Richardson', '467892')
,('Maninder', 'Singh', '745631')
,('Ilias', 'al Gris', '928345')
,('Eghbol', 'Sarwar', '372940')
,('Bart', 'Heijenk', '344611')
,('Quincy', 'Soerkarso', '946389')
,('Asare', 'Twum', '329573');

INSERT INTO student_course_results (course_id, student_id, date, score)
VALUES
 ('1', '1', '2020-10-10', '9')
,('1', '2', '2020-10-10', '8')
,('1', '3', '2020-10-10', '7')
,('2', '1', '2020-10-15', '9')
,('2', '3', '2020-10-15', '8')
,('2', '4', '2020-10-15', '9')
,('2', '5', '2020-10-15', '8');
