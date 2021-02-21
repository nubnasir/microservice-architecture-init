-- create user table
CREATE TABLE user (
    id              bigint auto_increment,
    user_name       varchar(50),
    email           varchar(80),
    user_password   varchar(1000),
    enable          boolean,
    user_scope      varchar(10),
    primary key(id)
)

INSERT INTO USER VALUES(1, 'user1', 'nubnasir@gmail.com', '{bcrypt}$2a$10$Qb3gk.e.ml19mQeTFf9lP.8EUQ52cpayqOshoDJh0ROHlelQ/pNgu', true, 'USER');


CREATE TABLE oauth_client_details (
    client_id               VARCHAR(255),
    resource_ids            VARCHAR(255),
    client_secret           VARCHAR(255),
    scope                   VARCHAR(255),
    authorized_grant_types  VARCHAR(255),
    web_server_redirect_uri VARCHAR(255),
    authorities             VARCHAR(255),
    access_token_validity   INTEGER,
    refresh_token_validity  INTEGER,
    additional_information  VARCHAR(4096),
    autoapprove             varchar(100),
    primary key (client_id)
);

CREATE TABLE oauth_client_token (
    token_id          VARCHAR(255),
    token             BLOB,
    authentication_id VARCHAR(255),
    user_name         VARCHAR(255),
    client_id         VARCHAR(255)
);

CREATE TABLE oauth_access_token (
    token_id          VARCHAR(255),
    token             BLOB,
    authentication_id VARCHAR(255),
    user_name         VARCHAR(255),
    client_id         VARCHAR(255),
    authentication    BLOB,
    refresh_token     VARCHAR(255)
);

CREATE TABLE oauth_refresh_token (
    token_id       VARCHAR(255),
    token          BLOB,
    authentication BLOB
);

CREATE TABLE oauth_code (
    code           VARCHAR(255),
    authentication BLOB
);