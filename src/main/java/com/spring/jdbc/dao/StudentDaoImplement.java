package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImplement implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {

		// insert query
		String queryString = "insert into student(id,name,city) values(?,?,?);";

		// fire query
		int result = this.jdbcTemplate.update(queryString, student.getId(), student.getName(), student.getCity());
		return result;
	}

	@Override
	public int change(Student student) {

		// update query
		String updateString = "update student set name=?, city=? where id=?;";

		// fire query
		int result = this.jdbcTemplate.update(updateString, student.getName(), student.getCity(), student.getId());

		return result;
	}

	@Override
	public int delete(int studentID) {

		// delete query
		String deletString = "delete from student where id=?;";

		// fire query
		int result = this.jdbcTemplate.update(deletString, studentID);

		return result;
	}

	@Override
	public Student getStudent(int studentId) {

		String fetchString = "select * from student where id=?";

		RowMapper<Student> rowMapper = new RowMapperImpl();

		Student student = this.jdbcTemplate.queryForObject(fetchString, rowMapper, studentId);

		return student;
	}

	@Override
	public List<Student> getStuedents() {

		String fetcString = "select * from student";
		
		RowMapper<Student> rowMapper= new RowMapperImpl();
		
		List<Student> students = this.jdbcTemplate.query(fetcString, rowMapper);

		return students;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
