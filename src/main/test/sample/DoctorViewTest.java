package sample;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DoctorViewTest {
  public DoctorView doctorViewTest = new DoctorView();

  /**
  * Main Test
  * */
  @Test
  public void testMain() throws IOException {
    doctorViewTest.setUsername("JohnDoe");
    String[] args = null;
    doctorViewTest.main(args);
  }


  /**
  *Open new request for Doctor profile to view
  * */
  @Test
  public void newRequest() throws NullPointerException{
    doctorViewTest.setUsername("JohnDoe");
    Assertions.assertTrue(doctorViewTest.newRequestButtonActionPerformed(null));

  }

  /**
   *Negative test for New request button
   * */
  @Test
  public void newRequestFalse() throws NullPointerException{
    doctorViewTest.setTestSqlString("false");
    Assertions.assertFalse(doctorViewTest.newRequestButtonActionPerformed(null));
  }

  /**
   *In progress button Positive Testing
   * */
  @Test
  public void inProgressButton() throws NullPointerException{
    doctorViewTest.setUsername("JohnDoe");
    Assertions.assertTrue(doctorViewTest.inProgressButtonActionPerformed(null));
  }

  /**
   *False test for In Progress Button
   * */
  @Test
  public void inProgressButtonFalse() throws NullPointerException{
    doctorViewTest.setTestSqlString("false");
    Assertions.assertFalse(doctorViewTest.inProgressButtonActionPerformed(null));

  }

  /**
   *Close Button Test
   * */
  @Test
  public void closeButton() throws NullPointerException{
    doctorViewTest.setUsername("JohnDoe");
    Assertions.assertTrue(doctorViewTest.closeRequestButtonActionPerformed(null));
  }

  /**
   *Negative Close Test
   * */
  @Test
  public void closeButtonFalse() throws NullPointerException{
    Assertions.assertFalse(doctorViewTest.closeRequestButtonActionPerformed(null));
  }

  /**
   *Open Request Test
   * */
  @Test
  public void openRequest() throws SQLException {
    doctorViewTest.setTest(1);
    doctorViewTest.setTestRequestID("103");
    doctorViewTest.setUserType("Doctor");
    doctorViewTest.setUsername("JohnDoe");
    Assertions.assertTrue(doctorViewTest.openSelectedButtonActionPerformed(null));
  }

  /**
   *Negative test for Open Request Button
   * */
  @Test
  public void openRequestFalse() throws SQLException, NullPointerException {
    doctorViewTest.setTest(1);
    doctorViewTest.setTestRequestID("");
    doctorViewTest.setUserType("Doctor");
    doctorViewTest.setUsername("JohnDoe");

    Assertions.assertFalse(doctorViewTest.openSelectedButtonActionPerformed(null));

  }

  /**
   *Testing the Logout Button
   * */
  @Test
  public void logout(){
    doctorViewTest.logoutActionPerformed(null);
  }

}