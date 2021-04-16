package sample;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

public class NewRequestsTest {
  public NewRequests newRequests = new NewRequests();


  @BeforeEach
  public void initNewRequest() throws SQLException {
    newRequests.setUserID("will");
    newRequests.setUserType("Doctor");
    newRequests.setCount(101);
    newRequests.setMessage("I need an appoinment");
  }
  @Test
  public void validUserTest() throws SQLException {
    newRequests.setUserID("Will");
    Assertions.assertTrue(newRequests.createButtonActionPerformed(null));
  }
  @Test
  public void cancelTest(){
    Assertions.assertTrue(newRequests.cancelButtonActionPerformed(null));
  }
  @Test
  public void createTest()
  {
    Assertions.assertTrue(newRequests.createButtonActionPerformed(null));

  }
  @Test
  public void newRequest(){
    newRequests.setCount(108);
    newRequests.setUserID("Will");

  }

}