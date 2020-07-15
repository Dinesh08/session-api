CREATE SEQUENCE hibernate_sequence START 1;

CREATE TABLE session
(
  id             BIGSERIAL,
  tentative_dates       TIMESTAMP,
  account      VARCHAR(45),
  topic_name   VARCHAR(500),
  status      VARCHAR(45),
  author VARCHAR(100),
  reference_url VARCHAR(2000),
  CONSTRAINT session_pkey PRIMARY KEY (id)
);
