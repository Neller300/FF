package persistens;

import java.sql.*;
import java.util.ArrayList;
import entities.*;

public class Datalag {
	private Connection connection;
	  
	  public void openConnection() {
	    try {
	      System.out.println("Loading JDBC Driver...");

	      //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	      
	      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	      
	      System.out.println("JDBC Driver loaded");
	    }
	    catch (ClassNotFoundException e) {
	      System.out.println("Failed to load JDBC Driver!");
	      
	      //e.printStackTrace();
	      
	      // if loading driver failed, then it is no use to continue program => terminate
	      System.exit(1);
	    }
	    
	    //String databaseName = "master";
	    String databaseName = "FerraiFinansesDB";

	    String connectionString =
	        "jdbc:sqlserver://localhost:1433;" +
	        "instanceName=SQLEXPRESS;" +
	        "databaseName=" + databaseName + ";" +
	        "integratedSecurity=true;";
	    
	    try {
	      System.out.println("Connecting to database...");
	      System.out.println(connectionString);

	      connection = DriverManager.getConnection(connectionString);

	      if (connection != null)
	        System.out.println("Connected to database");
	      else
	        System.out.println("Could not connect to database");
	      
	      //connection.close();
	    }
	    catch (SQLException e) {
	      System.out.println("Failed to connect to database: " + databaseName);
	      
	      //e.printStackTrace();
	      
	      // if connecting to database failed, then it is no use to continue program => terminate
	      System.exit(1);
	    }
	  }
	  
	  private SqlResult changeOneRowInTable(String sql) {
	    SqlResult result = new SqlResult();
	    
	    try {
	      /*
	       * execute sql statement
	       */
	      System.out.println(sql);

	      Statement statement = connection.createStatement();
	      
	      result.setSucces(statement.executeUpdate(sql) == 1);
	      
	      /*
	       * get (possible) auto-generated key
	       */
	      ResultSet resultSet =
	        statement.executeQuery("SELECT SCOPE_IDENTITY()");
	      
	      if (resultSet.next())
	        result.setAutoKey(resultSet.getInt(1));
	    }
	    catch (SQLException e) {
	      result.setSucces(false);
	    }
	    
	    return result;
	  }

	  /*
	   * course access methods
	   */
	  public boolean insertCourse(Course course) {
	    String sql =
	      "INSERT INTO course VALUES ('" +
	      course.getName() + "', " + 
	      course.getLessons() + ", " + 
	      course.getSemesterNo() + ", " + 
	      course.getTeacherId() + ")";
	    
	    SqlResult result = changeOneRowInTable(sql);
	    
	    course.setAutoKey(result.getAutoKey());
	    
	    return result.isSucces();
	  }
	  
	  public Course getCourse(int id) {
	    try {
	      String sql = "SELECT * FROM course WHERE id=" + id;
	      System.out.println(sql);
	      
	      Statement statement = connection.createStatement();
	      ResultSet resultSet = statement.executeQuery(sql);

	      // Invariant: resultSet har 0 eller 1 række
	      
	      if (resultSet.next())
	        // der er et fag med id 'id'
	        return new Course(
	          resultSet.getInt("id"), 
	          resultSet.getString("navn"), 
	          resultSet.getInt("lessons"), 
	          resultSet.getInt("semester_no"), 
	          resultSet.getInt("teacher_id")
	        );
	      else
	        // der er _ikke_ et fag med id 'id'
	        return null;
	    }
	    catch (SQLException e) {
	      return null;
	    }
	  }
	  
	  public boolean updateCourse(Course course) {
	    String sql =
	      "UPDATE course " +
	      "SET navn='" + course.getName() + 
	      "', lessons=" + course.getLessons() + 
	      ", semester_no=" + course.getSemesterNo() + 
	      ", teacher_id=" + course.getTeacherId() + 
	      " WHERE id=" + course.getId();
	    
	    return changeOneRowInTable(sql).isSucces();
	  }
	  
	  public boolean deleteCourse(Course course) {
	    String sql =
	      "DELETE FROM course WHERE id=" + course.getId();
	    
	    return changeOneRowInTable(sql).isSucces();
	  }
	  
	  //----- getAllCourses...() methods
	  
	  public ArrayList<Course> getAllCourses() {
	    ArrayList<Course> courses = new ArrayList<Course>();
	    
	    try {
	      String sql = "SELECT * FROM course";
	      
	      System.out.println(sql);
	      
	      Statement statement = connection.createStatement();
	      ResultSet resultSet = statement.executeQuery(sql);
	      
	      while (resultSet.next())
	        courses.add(new Course(
	            resultSet.getInt("id"), 
	            resultSet.getString("navn"), 
	            resultSet.getInt("lessons"), 
	            resultSet.getInt("semester_no"), 
	            resultSet.getInt("teacher_id")
	        ));
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	    
	    return courses;
	  }

	  /*
	   * student access methods
	   */
	  public boolean InsertStudent(Student student) {
	    String sql =
	      "INSERT INTO student VALUES ('" +
	      student.getLastName() + "', '" + 
	      student.getFirstName() + "', " + 
	      student.getSemesterNo() + ")";
	    
	    SqlResult result = changeOneRowInTable(sql);
	    
	    student.setAutoKey(result.getAutoKey());
	    
	    return result.isSucces();
	  }

	  public boolean InsertStudent2(Student student) {
	    try {
	      String sql = "INSERT INTO student VALUES (?, ?, ?)";
	      
	      System.out.println(sql);
	      
	      PreparedStatement statement =
	          connection.prepareStatement(sql);
	      
	      statement.setString(1, student.getLastName());
	      statement.setString(2, student.getFirstName());
	      statement.setInt(3, student.getSemesterNo());
	      
	      return statement.executeUpdate() == 1;
	      
	      // autogen key udeladt i dette eksempel
	    }
	    catch (SQLException e) {
	      return false;
	    }
	  }

	  public Student getStudent(int id) {
	    try {
	      String sql = "SELECT * FROM student WHERE id=" + id;
	      System.out.println(sql);
	      
	      Statement statement = connection.createStatement();
	      ResultSet resultSet = statement.executeQuery(sql);

	      // Invariant: resultSet har 0 eller 1 række
	      
	      if (resultSet.next())
	        // der er en studerende med id 'id'
	        return new Student(
	          resultSet.getInt("id"), 
	          resultSet.getString("lastname"), 
	          resultSet.getString("firstname"), 
	          resultSet.getInt("semester_no")
	        );
	      else
	        // der er _ikke_ en studerende med id 'id'
	        return null;
	    }
	    catch (SQLException e) {
	      return null;
	    }
	  }
	  
	  public Student getStudent2(int id) {
	    ArrayList<Student> students = getAllStudentsByWhereClause("id=" + id); 

	    if (students.size() > 0)
	      return students.get(0);
	    else
	      return null;
	  }
	  
	  public boolean updateStudent(Student student) {
	    String sql =
	      "UPDATE student " +
	      "SET lastname='" + student.getLastName() + 
	      "', firstname='" + student.getFirstName() + 
	      "', semester_no=" + student.getSemesterNo() + 
	      " WHERE id=" + student.getId();
	    
	    return changeOneRowInTable(sql).isSucces();
	  }
	  
	  public boolean deleteStudent(Student student) {
	    String sql =
	      "DELETE FROM student WHERE id=" + student.getId();
	    
	    return changeOneRowInTable(sql).isSucces();
	  }

	  //----- getAllStudents...() methods
	  
	  public ArrayList<Student> getAllStudents() {
	    return getAllStudentsByWhereClause();
	  }
	  
	  public ArrayList<Student> getAllStudentsBySemesterNo(int semesterNo) {
	    return getAllStudentsByWhereClause("semester_no=" + semesterNo);
	  }

	  public ArrayList<Student> getAllStudentsByFirstName(String firstName) {
	    return getAllStudentsByWhereClause("firstname='" + firstName + "'");
	  }

	  // lidt kunstigt!
	  public ArrayList<Student> getAllStudentsByWhereClause() {
	    return getAllStudentsByWhereClause("1=1");
	  }
	  
	  public ArrayList<Student> getAllStudentsByWhereClause(String whereClause) {
	    ArrayList<Student> students = new ArrayList<Student>();
	    
	    try {
	      Statement statement = connection.createStatement();

	      String sql = "SELECT * FROM student WHERE " + whereClause;
	      System.out.println(sql);
	      
	      ResultSet resultSet = statement.executeQuery(sql);
	      
	      while (resultSet.next()) {
	        int id = resultSet.getInt("id");
	        String lastName = resultSet.getString("lastname");
	        String firstName = resultSet.getString("firstname");
	        int semesterNo = resultSet.getInt("semester_no");

	        Student student = new Student(id, lastName, firstName, semesterNo);
	        students.add(student);
	      }
	      
	      statement.close();
	    }
	    catch (SQLException e) { }
	    
	    return students;
	  }
	}

