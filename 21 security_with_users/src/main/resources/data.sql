INSERT INTO users (username, password, enabled)
VALUES
('user', '$2a$14$jQIfNov.zkgtzOd/aaBPleSm5B6IhUuklvhrxtdZiDEtoeWWMsHpC', TRUE),
('admin', '$2a$14$jQIfNov.zkgtzOd/aaBPleSm5B6IhUuklvhrxtdZiDEtoeWWMsHpC', TRUE),
('peter', '$2a$14$jQIfNov.zkgtzOd/aaBPleSm5B6IhUuklvhrxtdZiDEtoeWWMsHpC', TRUE);

INSERT INTO authorities (username, authority)
VALUES
('user', 'ROLE_USER'),
('peter', 'ROLE_USER'),
('admin', 'ROLE_USER'),
('admin', 'ROLE_ADMIN');