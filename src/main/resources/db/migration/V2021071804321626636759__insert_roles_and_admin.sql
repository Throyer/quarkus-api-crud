INSERT INTO "role"
    ("name", "initials", "description")
VALUES
    ('ADMINISTRATOR', 'ADM', 'Administrator'),
    ('USER', 'USER', 'User');

INSERT INTO "user"
    ("name", "email", "password")
VALUES
    ('Admin', 'admin@email.com', '$2a$10$L9CP7W3JIKhVz5J/WiMP/.LEqvAMC915HxxON98MFtyJzXbIEnajS');

INSERT INTO "user_role"
    ("user_id", "role_id")
VALUES
    (
        (SELECT "id" FROM "user" WHERE "email" = 'admin@email.com'),
        (SELECT "id" FROM "role" WHERE "initials" = 'ADM')
    ),(
        (SELECT "id" FROM "user" WHERE "email" = 'admin@email.com'),
        (SELECT "id" FROM "role" WHERE "initials" = 'USER')
    );