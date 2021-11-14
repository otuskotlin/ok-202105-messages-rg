CREATE SCHEMA IF NOT EXISTS message;
CREATE
EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE message.messages
(
    uuid        UUID    NOT NULL,
    parent_uuid UUID    not NULL,
    payload     VARCHAR not NULL,
    from        VARCHAR not NULL,
    to          VARCHAR not NULL,
    updated  TIMESTAMPTZ NULL default now(),
    created TIMESTAMPTZ NULL default now(),
    CONSTRAINT message_pk PRIMARY KEY (uuid)
);