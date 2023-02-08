package personmenu.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import personmenu.jdbc.dto.Person;

public class PersonJdbcDao implements PersonDao {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/ssafydb";
	private static final String DB_USER = "ssafy";
	private static final String DB_PASSWORD = "ssafy";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int insert(Person person) {
		int idx = -1;
		
		String sql = "INSERT INTO person (name, age, job) VALUES (?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, person.getName());
			ps.setInt(2, person.getAge());
			ps.setString(3, person.getJob());

			idx = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return idx;
	}
	
	public int deleteByNo(int no) {
		int idx = -1;
		
		String sql = "DELETE FROM person WHERE no = ?";
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, no);

			idx = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return idx;		
	}
	
	public int update(Person person) {
		int idx = -1;
		
		String sql = "UPDATE person SET name = ?, age = ?, job = ? WHERE no = ?";
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, person.getName());
			ps.setInt(2, person.getAge());
			ps.setString(3, person.getJob());
			ps.setInt(4, person.getNo());

			idx = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return idx;		
	}
	
	public List<Person> findAll() {
		List<Person> person = new ArrayList<>();
		String sql = "select * from person";
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			
	          try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                    int no = rs.getInt(1);
	                    String name = rs.getString(2);
	                    int age = rs.getInt(3);
	                    String job = rs.getString(4);
	                    person.add(new Person(no, name, age, job));
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
			
		} catch (Exception ex) {
            ex.printStackTrace();
        }
		
		return person;
	}
}
