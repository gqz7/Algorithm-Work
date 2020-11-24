-- SELECT * 
--   FROM users;

-- SELECT * 
--   FROM profiles;


-- SELECT * 
--   FROM posts;

-- SELECT * FROM profiles JOIN users ON profiles.userId = users.id

-- SELECT * FROM posts where profileId != 1

-- SELECT * FROM posts where profileId = (SELECT id FROM profiles WHERE firstName = "Cliff"); 

-- SELECT * FROM posts where profileId = ( SELECT id FROM users WHERE id = 3 );

-- SELECT * FROM posts where profileId = 
--     (SELECT profiles.id FROM profiles JOIN users on profiles.userId = users.id WHERE users.id = 1)

-- SELECT posts.* FROM posts LEFT JOIN profiles on profiles.userId = 2
-- (SELECT id FROM profiles WHERE id = 1); 

-- SELECT * FROM posts RIGHT JOIN profiles ON posts.profileId = profiles.id;
-- SELECT posts.id, title, content, firstName, lastName FROM posts RIGHT JOIN profiles ON posts.profileId = profiles.id;

-- SELECT * from posts_categories
-- p.id, title, content, category

-- SELECT * from categories

SELECT * from posts p
    JOIN posts_categories pc on (p.id = pc.postId)
    JOIN categories c on (pc.categoryId = c.id)