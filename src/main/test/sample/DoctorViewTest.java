package sample;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DoctorViewTest {
  public DoctorView doctorViewTest = new DoctorView();


  @Test
  public void testMain() throws IOException {
    doctorViewTest.setUsername("JohnDoe");
    String[] args = null;
    doctorViewTest.main(args);
  }

  @Test
  public void newRequest() throws NullPointerException{
    doctorViewTest.setUsername("JohnDoe");
    Assertions.assertTrue(doctorViewTest.newRequestButtonActionPerformed(null));

  }
  @Test
  public void newRequestFalse() throws NullPointerException{
    doctorViewTest.setTestSqlString("false");
    Assertions.assertFalse(doctorViewTest.newRequestButtonActionPerformed(null));

  }
  @Test
  public void inProgressButton() throws NullPointerException{
    doctorViewTest.setUsername("JohnDoe");
    Assertions.assertTrue(doctorViewTest.inProgressButtonActionPerformed(null));

  }
  @Test
  public void inProgressButtonFalse() throws NullPointerException{
    doctorViewTest.setTestSqlString("false");
    Assertions.assertFalse(doctorViewTest.inProgressButtonActionPerformed(null));

  }
  @Test
  public void closeButton() throws NullPointerException{
    doctorViewTest.setUsername("JohnDoe");
    Assertions.assertTrue(doctorViewTest.closeRequestButtonActionPerformed(null));
  }
  @Test
  public void closeButtonFalse() throws NullPointerException{

    Assertions.assertFalse(doctorViewTest.closeRequestButtonActionPerformed(null));

  }
  @Test
  public void openRequest() throws SQLException {
    doctorViewTest.setTest(1);
    doctorViewTest.setTestRequestID("103");
    doctorViewTest.setUserType("Doctor");
    doctorViewTest.setUsername("JohnDoe");

    Assertions.assertTrue(doctorViewTest.openSelectedButtonActionPerformed(null));

  }
  @Test
  public void openRequestFalse() throws SQLException, NullPointerException {
    doctorViewTest.setTest(1);
    doctorViewTest.setTestRequestID("");
    doctorViewTest.setUserType("Doctor");
    doctorViewTest.setUsername("JohnDoe");

    Assertions.assertFalse(doctorViewTest.openSelectedButtonActionPerformed(null));

  }

  @Test
  public void logout(){
    doctorViewTest.logoutActionPerformed(null);
  }

}