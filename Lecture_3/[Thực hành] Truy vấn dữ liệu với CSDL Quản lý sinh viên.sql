SELECT * FROM quan_ly_sinh_vien.student;

select * from student where status = true;

select * from subject where credit < 10;

select student.StudentId, student.StudentName, class.ClassName from student
join class on student.ClassId = class.ClassID
where student.ClassID = 1;

select student.StudentId, student.StudentName, subject.subname, Mark.Mark
from student join mark on student.StudentId = Mark.StudentId join subject on mark.SubId = subject.SubId
where Mark.subid = 1;