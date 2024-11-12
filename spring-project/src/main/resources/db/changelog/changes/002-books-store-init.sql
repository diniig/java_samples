CREATE TABLE IF NOT EXISTS authors (
	id int4 NOT NULL,
	"name" varchar(50) NOT NULL,
	CONSTRAINT author_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS books (
	id int4 NOT NULL,
	"name" varchar(50) NOT NULL,
	author_id int4 NOT NULL,
	CONSTRAINT book_pk PRIMARY KEY (id),
	CONSTRAINT books_to_author_fk FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE
);