ALTER TABLE student ADD constraint age CHECK (student.age>=16);
ALTER TABLE student ADD constraint studentName unique(name);
ALTER TABLE student ALTER COLUMN name SET NOT NULL;
alter table faculty add constraint unique_name_color unique(name,color);
ALTER TABLE student ALTER COLUMN age set default(20);
