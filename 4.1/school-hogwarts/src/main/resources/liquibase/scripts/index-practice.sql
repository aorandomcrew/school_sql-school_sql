-- liquibase formatted sql

-- changeset dbogomolov:2023-12-03-student_name_index
CREATE INDEX student_name_index ON student (name);

-- changeset dbogomolov:2023-12-03-faculty_name_color_index
CREATE INDEX faculty_index ON faculty (name, color);