CREATE TABLE users (
    id INT(7) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50) UNIQUE,
    password VARCHAR(50),
    created_on TIMESTAMP
);

CREATE TABLE profiles (

    id INT(7) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    userId INT(7) UNSIGNED NOT NULL UNIQUE REFERENCES users(id),
    firstName TEXT NOT NULL,
    lastName TEXT NOT NULL,
    created_on TIMESTAMP

);

CREATE TABLE posts (
    id INT(7) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    profileId INT(7) UNSIGNED NOT NULL REFERENCES profiles(id),
    title TEXT,
    content TEXT
);

CREATE TABLE categories (
    id INT(7) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(23)
);

CREATE TABLE posts_categories (
    postId INT(7) UNSIGNED NOT NULL REFERENCES posts(id),
    categoryId INT(7) UNSIGNED NOT NULL REFERENCES categories(id) 
);

-- INSTERTING USERS

INSERT INTO users (email, password, created_on)
    VALUES ('gabe@test.com', 'pass123', CURRENT_TIMESTAMP);
    
    
INSERT INTO users (email, password, created_on)
    VALUES ('cliff@test.com', 'pass123', CURRENT_TIMESTAMP);
    
    
INSERT INTO users (email, password, created_on)
    VALUES ('arnell@test.com', 'pass123', CURRENT_TIMESTAMP);
    

-- INSTERTING PROFILES

INSERT INTO profiles (userId, firstNAme, lastName, created_on)
    VALUES(1, "Gabe", "S.", CURRENT_TIMESTAMP);

INSERT INTO profiles (userId, firstNAme, lastName, created_on)
    VALUES(2, "Cliff", "C.", CURRENT_TIMESTAMP);
    
INSERT INTO profiles (userId, firstNAme, lastName, created_on)
    VALUES(3, "Arnell", "M.", CURRENT_TIMESTAMP);
    
    
-- INSTERTING POSTS

INSERT INTO posts (profileId, title, content) 
    VALUES (1, "Python coding", "gabe testing");
    

INSERT INTO posts (profileId, title, content) 
    VALUES (1, "Java!", "gabe testing");
    

INSERT INTO posts (profileId, title, content) 
    VALUES (2, "SQL", "cliff testing");

INSERT INTO posts (profileId, title, content) 
    VALUES (2, "Java", "cliff testing");


INSERT INTO posts (profileId, title, content) 
    VALUES (3, "SQL", "arnell testing");
    
    
INSERT INTO posts (profileId, title, content) 
    VALUES (3, "Python", "arnell testing");

INSERT INTO posts (profileId, title, content) 
    VALUES (3, "Java", "arnell testing");
    
-- INSERTING CATEGORIES


INSERT INTO categories (category) VALUES ("programing"); 

INSERT INTO categories (category) VALUES ("SQL"); 

INSERT INTO categories (category) VALUES ("Java"); 

INSERT INTO categories (category) VALUES ("Python"); 

-- INSERTING POST_CATEGORIES

INSERT INTO posts_categories (postId, categoryId) VALUES (1, 1);
INSERT INTO posts_categories (postId, categoryId) VALUES (1, 4);
INSERT INTO posts_categories (postId, categoryId) VALUES (2, 1);
INSERT INTO posts_categories (postId, categoryId) VALUES (2, 3);
INSERT INTO posts_categories (postId, categoryId) VALUES (3, 1);
INSERT INTO posts_categories (postId, categoryId) VALUES (3, 2);
INSERT INTO posts_categories (postId, categoryId) VALUES (4, 1);
INSERT INTO posts_categories (postId, categoryId) VALUES (4, 3);
INSERT INTO posts_categories (postId, categoryId) VALUES (5, 1);
INSERT INTO posts_categories (postId, categoryId) VALUES (5, 2);
INSERT INTO posts_categories (postId, categoryId) VALUES (6, 1);
INSERT INTO posts_categories (postId, categoryId) VALUES (6, 4);
INSERT INTO posts_categories (postId, categoryId) VALUES (7, 1);
INSERT INTO posts_categories (postId, categoryId) VALUES (7, 3);