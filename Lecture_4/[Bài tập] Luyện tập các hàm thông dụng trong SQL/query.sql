use quan_ly_sinh_vien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from subject
having Credit >= all(select max(credit) from subject);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select * from subject 
join mark on subject.SubId = Mark.Subid
having mark.mark >= all(select mark from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select *, avg(mark.mark) as avg_mark from student
left join mark on student.StudentId = mark.StudentId
group by student.StudentId
order by avg_mark desc;