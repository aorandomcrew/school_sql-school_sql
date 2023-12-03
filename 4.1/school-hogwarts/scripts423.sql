--первый join
SELECT student.name, student.age, faculty.name
FROM student
JOIN faculty ON student.faculty_id = faculty.id
--второй join
SELECT student.name, student.age
FROM student
JOIN avatar on student.id = avatar.student_id;