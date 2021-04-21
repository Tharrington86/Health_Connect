package sample;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PatientViewTest {
  public PatientView patientViewTest = new PatientView();


  /**
   *In Progress Button when it is Empty Test
   * */
  @Test
  public void inProgressButtonEmpty() throws NullPointerException{
    Assertions.assertFalse(patientViewTest.InProgressButtonActionPerformed(null));
  }

  /**
   *Valid In Progress Button
   * */
  @Test
  public void inProgressButton() throws NullPointerException{
    patientViewTest.setUsername("JaneDoe");
    Assertions.assertTrue(patientViewTest.InProgressButtonActionPerformed(null));
  }


  /**
   *New Request View Button Valid Test
   * */
  @Test
  public void newButtonButton() throws NullPointerException{
    patientViewTest.setRequestID(108);
    patientViewTest.setUsername("will");
    patientViewTest.setUserType("Patient");
    Assertions.assertTrue(patientViewTest.newButtonActionPerformed(null));
  }

  /**
   *New Request view button False Test
   * */
  @Test
  public void newButtonFalse() throws NullPointerException{
    Assertions.assertFalse(patientViewTest.newButtonActionPerformed(null));
  }
  /**
   *False Test for Closed request view
   * */
  @Test
  public void closedActionPerformedFalse() throws NullPointerException{
    patientViewTest.setUsername("");
    Assertions.assertFalse(patientViewTest.closedButtonActionPerformed(null));
  }

  /**
   *Valid closed request view
   * */
  @Test
  public void closedActionPerformed() throws NullPointerException{
    patientViewTest.setUsername("JaneDoe");
    Assertions.assertTrue(patientViewTest.closedButtonActionPerformed(null));
  }

  /**
   *Valid back button test
   * */
  @Test
  public void backActionPerformed() throws NullPointerException{
    patientViewTest.setUsername("Will");
    Assertions.assertTrue(patientViewTest.backButtonActionPerformed(null));
  }
  /**
   *Open Request Valid for Patient screen
   * */
  @Test
  public void openRequest() throws SQLException {
    patientViewTest.setTest(1);
    patientViewTest.setTestRequestID("103");
    patientViewTest.setUserType("Patient");
    patientViewTest.setUsername("will");
    Assertions.assertTrue(patientViewTest.openRequestActionPerformed(null));
  }

  /**
   *False Test for Open Request
   * */
  @Test
  public void openRequestFalse() throws SQLException, NullPointerException {
    patientViewTest.setTest(1);
    patientViewTest.setTestRequestID("");
    patientViewTest.setUserType("Patient");
    patientViewTest.setUsername("will");

    Assertions.assertFalse(patientViewTest.openRequestActionPerformed(null));

  }

  /**
   *Main Test
   * */
  @Test
  public void testMain() throws IOException {
    patientViewTest.setUsername("will");
    String[] args = null;
    patientViewTest.main(args);


  }



}