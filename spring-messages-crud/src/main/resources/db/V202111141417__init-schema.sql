CREATE SCHEMA IF NOT EXISTS message;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE message.messages
(
    uuid        UUID    NOT NULL,
    parent_uuid UUID    not NULL,
    payload     VARCHAR not NULL,
    from_id        UUID  NULL,
    to_id          UUID  NULL,
    updated  TIMESTAMPTZ NULL default now(),
    created TIMESTAMPTZ NULL default now(),
    CONSTRAINT message_pk PRIMARY KEY (uuid)
);