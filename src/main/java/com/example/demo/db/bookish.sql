
-- Script of Genre
CREATE TABLE Genre
(
   GenreID           SMALLINT     NOT NULL  AUTO_INCREMENT               COMMENT 'PK for Genre'
  ,GenreName         VARCHAR(50)  NOT NULL                               COMMENT 'Genre Name'

  ,PRIMARY KEY (GenreID)
)
COMMENT = 'Book Genre'
;

-- Makes sure GenreName is unique
ALTER TABLE Genre
  ADD CONSTRAINT Genre_UK
  UNIQUE (GenreName)
;

-- Insert data
INSERT INTO Genre (GenreName) VALUES ('Fantasy');
INSERT INTO Genre (GenreName) VALUES ('Romance');
INSERT INTO Genre (GenreName) VALUES ('Mystery');
INSERT INTO Genre (GenreName) VALUES ('Thriller');
INSERT INTO Genre (GenreName) VALUES ('Horror');
INSERT INTO Genre (GenreName) VALUES ('Science Fiction');
INSERT INTO Genre (GenreName) VALUES ('Historical Fiction');
INSERT INTO Genre (GenreName) VALUES ('Nonfiction');
INSERT INTO Genre (GenreName) VALUES ('Dystopian');


-- Script of book

CREATE TABLE Book
(
   BookID            INTEGER      NOT NULL  AUTO_INCREMENT               COMMENT 'PK for Book'
  ,GenreID           SMALLINT     NOT NULL                               COMMENT 'FK for Genre'
  ,Title             VARCHAR(50)  NOT NULL                               COMMENT 'Book Title'
  ,PageCount         SMALLINT                                            COMMENT 'Page Count'

  ,PRIMARY KEY (BookID)
)
COMMENT = 'Book'
;

ALTER TABLE Book
  ADD CONSTRAINT book_fk_genre
  FOREIGN KEY (GenreID)
  REFERENCES Genre (GenreID)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT
;



-- Script of Review

CREATE TABLE Review
(
  ReviewID        INT            NOT NULL  AUTO_INCREMENT               COMMENT 'PK for Review'
  ,BookID         INT            NOT NULL                               COMMENT 'Book ID'
  ,ReviewText     VARCHAR(3500)  NOT NULL                               COMMENT 'Review Text'
  ,Rating         TINYINT        NOT NULL                               COMMENT 'Rating from 1 to 5'
  ,IsRecommended  BOOLEAN        NOT NULL                               COMMENT 'Whether the reviewer recommends the book'
  ,DatePosted     DATETIME       NOT NULL                               COMMENT 'Review creation date'


  ,PRIMARY KEY (ReviewID)
)
COMMENT = 'Book Review'
;


ALTER TABLE Review
  ADD CONSTRAINT Book_fk_Review
  FOREIGN KEY (BookID)
  REFERENCES Book (BookID)
;


ALTER TABLE Review
  ADD CONSTRAINT Review_Rating_CK
  CHECK (Rating BETWEEN 1 AND 5)
;

-- Script of Comment

CREATE TABLE Comment
(
  CommentID       INT            NOT NULL  AUTO_INCREMENT               COMMENT 'PK for Comment'
  ,ReviewID       INT            NOT NULL                               COMMENT 'Review ID'
  ,CommentText    VARCHAR(2500)  NOT NULL                               COMMENT 'Comment Text'
  ,DatePosted     DATETIME       NOT NULL                               COMMENT 'Comment creation date'


  ,PRIMARY KEY (CommentID)
)
COMMENT = 'Review Comment'
;


ALTER TABLE Comment
  ADD CONSTRAINT review_fk_comment
  FOREIGN KEY (ReviewID)
  REFERENCES Review (ReviewID)
;


-- Inserted some books

INSERT INTO Book (GenreID, Title, PageCount)
VALUES (1, 'The Hobbit', 250);

INSERT INTO Book (GenreID, Title, PageCount)
VALUES (1, 'Harry Potter and the Sorcerer''s Stone', 390);

INSERT INTO Book (GenreID, Title, PageCount)
VALUES (2, 'Pride and Prejudice', 234);

INSERT INTO Book (GenreID, Title, PageCount)
VALUES (3, 'The Silent Patient', 534);

INSERT INTO Book (GenreID, Title, PageCount)
VALUES (4, 'The Da Vinci Code', 264);

INSERT INTO Book (GenreID, Title, PageCount)
VALUES (5, 'Dracula', 768);

INSERT INTO Book (GenreID, Title, PageCount)
VALUES (6, 'Dune', 350);

INSERT INTO Book (GenreID, Title, PageCount)
VALUES (9, 'The Hunger Games', 123);

-- Inserted into reviews

INSERT INTO Review
(BookID, ReviewText, Rating, IsRecommended, DatePosted)
VALUES
(1, 'A very enjoyable fantasy book with a great adventure.', 5, TRUE, '2026-09-20 10:30:00');

INSERT INTO Review
(BookID, ReviewText, Rating, IsRecommended, DatePosted)
VALUES
(1, 'The story was good but some parts were slow.', 4, TRUE, '2026-09-21 14:15:00');

INSERT INTO Review
(BookID, ReviewText, Rating, IsRecommended, DatePosted)
VALUES
(2, 'A fun book with interesting characters.', 5, TRUE, '2026-09-22 09:45:00');

INSERT INTO Review
(BookID, ReviewText, Rating, IsRecommended, DatePosted)
VALUES
(3, 'I enjoyed the characters and the story.', 4, TRUE, '2026-09-23 16:20:00');

INSERT INTO Review
(BookID, ReviewText, Rating, IsRecommended, DatePosted)
VALUES
(4, 'The mystery was interesting but the ending was unexpected.', 3, FALSE, '2026-09-24 11:10:00');

INSERT INTO Review
(BookID, ReviewText, Rating, IsRecommended, DatePosted)
VALUES
(5, 'Very interesting mystery and historical information.', 5, TRUE, '2026-09-25 13:40:00');

INSERT INTO Review
(BookID, ReviewText, Rating, IsRecommended, DatePosted)
VALUES
(6, 'The book was a little slow but still interesting.', 3, FALSE, '2026-09-26 18:00:00');

INSERT INTO Review
(BookID, ReviewText, Rating, IsRecommended, DatePosted)
VALUES
(7, 'One of my favorite science fiction books.', 5, TRUE, '2026-09-27 09:25:00');


-- Inserted some comments
INSERT INTO Comment
(ReviewID, CommentText, DatePosted)
VALUES
(1, 'I agree, the adventure was really good.', '2026-09-21 10:00:00');

INSERT INTO Comment
(ReviewID, CommentText, DatePosted)
VALUES
(1, 'This is one of my favorite fantasy books too.', '2026-09-22 12:30:00');

INSERT INTO Comment
(ReviewID, CommentText, DatePosted)
VALUES
(2, 'I also thought some parts were slow.', '2026-09-22 15:20:00');

INSERT INTO Comment
(ReviewID, CommentText, DatePosted)
VALUES
(3, 'The characters were my favorite part.', '2026-09-23 11:15:00');

INSERT INTO Comment
(ReviewID, CommentText, DatePosted)
VALUES
(5, 'The ending surprised me too.', '2026-09-25 14:30:00');

INSERT INTO Comment
(ReviewID, CommentText, DatePosted)
VALUES
(8, 'I really like science fiction books.', '2026-09-28 10:45:00');
