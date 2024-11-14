CREATE TABLE users (
    id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username varchar NOT NULL,
    picture varchar NOT NULL
);

CREATE SEQUENCE user_id_seq start with 1 increment by 1;

CREATE TABLE decks (
    id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id integer NOT NULL,
    name varchar NOT NULL,
    description varchar NOT NULL,
    content jsonb NOT NULL,
    published bool default false,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL
);

CREATE SEQUENCE deck_id_seq start with 1 increment by 1;

CREATE TABLE tags (
    id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY ,
    name varchar
);

CREATE SEQUENCE tag_id_seq start with 1 increment by 1;

CREATE TABLE deck_reactions (
    user_id integer NOT NULL,
    deck_id integer NOT NULL
);

CREATE TABLE decks_tagged (
    deck_id integer NOT NULL,
    tag_id integer NOT NULL
);


ALTER TABLE decks
ADD CONSTRAINT DECKS_USER_ID_FK
FOREIGN KEY (user_id) REFERENCES users;


ALTER TABLE deck_reactions
ADD CONSTRAINT DECK_REACTIONS_DECK_ID_FK
FOREIGN KEY (deck_id) REFERENCES decks;

ALTER TABLE deck_reactions
ADD CONSTRAINT DECK_REACTIONS_USER_ID_FK
FOREIGN KEY (user_id) REFERENCES users;


ALTER TABLE decks_tagged
ADD CONSTRAINT DECKS_TAGGED_DECK_ID_FK
FOREIGN KEY (deck_id) REFERENCES decks;

ALTER TABLE decks_tagged
ADD CONSTRAINT DECKS_TAGGED_TAG_ID_FK
FOREIGN KEY (tag_id) REFERENCES tags;


