drop table teacher if exists ;

CREATE TABLE public.teacher(
    id SERIAL primary key NOT NULL,
    name character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    password character varying(100) NOT NULL,
    photo character varying(100) NOT NULL,
    created_at TIMESTAMP
);

INSERT INTO teacher (name,email,password,photo,created_at)
VALUES('Fulani Perez', 'fulanito@gmail.com', 'Chafed234', 'https://avatarfiles.alphacoders.com/105/105223.jpg',CURRENT_TIMESTAMP);

CREATE TABLE public.course(
    id SERIAL primary key NOT NULL,
    name character varying(100) NOT NULL,
    teacher_id integer NOT NULL
);

INSERT INTO course (id, name, teacher_id)
VALUES (1,"Java",1);

CREATE TABLE public.language(
    id SERIAL primary key NOT NULL,
    name character varying(100) NOT NULL,
    created_at TIMESTAMP
);

INSERT INTO language (id, name, created_at)
VALUES (1,'Java',CURRENT_TIMESTAMP);

INSERT INTO language (id, name, created_at)
VALUES (2,'React',CURRENT_TIMESTAMP);


CREATE TABLE public.teacher_language(
    teacher_id integer NOT NULL,
    language_id integer NOT NULL
);

INSERT INTO teacher_language(teacher_id,language_id) VALUES (1,1);
INSERT INTO teacher_language(teacher_id,language_id) VALUES (1,2);

