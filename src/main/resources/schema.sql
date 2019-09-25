CREATE SEQUENCE IF NOT EXISTS user_id_seq;
CREATE SEQUENCE IF NOT EXISTS loan_id_seq;
CREATE SEQUENCE IF NOT EXISTS error_messages_id_seq;

CREATE TABLE IF NOT EXISTS user
(
    id         BIGINT      NOT NULL DEFAULT nextval('user_id_seq'),
    first_name VARCHAR(45) NOT NULL,
    last_name  VARCHAR(45) NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

CREATE TABLE loan
(
    id      BIGINT           NOT NULL DEFAULT nextval('loan_id_seq'),
    term    INTEGER          NOT NULL,
    amount  DOUBLE PRECISION NOT NULL,
    user_id BIGINT           NOT NULL,
    CONSTRAINT loan_pk PRIMARY KEY (id),
    CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE error_messages
(
    id      BIGINT       NOT NULL DEFAULT nextval('error_messages_id_seq'),
    code    VARCHAR(7)   NOT NULL,
    message VARCHAR(200) NOT NULL,
    CONSTRAINT error_messages_pk PRIMARY KEY (id)
);