package sample;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DoctorViewTest {
  public DoctorView doctorView = new DoctorView();


  @Test
  public void testMain() throws IOException {
    doctorView.setUsername("JohnDoe");
    String[] args = null;
    doctorView.main(args);
  }

  @Test
  public void newRequest() throws NullPointerException{
    doctorView.setUsername("JohnDoe");
    Assertions.assertTrue(doctorView.newRequestButtonActionPerformed(null));

  }
  @Test
  public void newRequestFalse() throws NullPointerException{
    doctorView.setTestSqlString("false");
    Assertions.assertFalse(doctorView.newRequestButtonActionPerformed(null));

  }
  @Test
  public void inProgressButton() throws NullPointerException{
    doctorView.setUsername("JohnDoe");
    Assertions.assertTrue(doctorView.inProgressButtonActionPerformed(null));

  }
  @Test
  public void inProgressButtonFalse() throws NullPointerException{
    doctorView.setTestSqlString("false");
    Assertions.assertFalse(doctorView.inProgressButtonActionPerformed(null));

  }
  @Test
  public void closeButton() throws NullPointerException{
    doctorView.setUsername("JohnDoe");
    Assertions.assertTrue(doctorView.closeRequestButtonActionPerformed(null));
  }
  @Test
  public void closeButtonFalse() throws NullPointerException{

    Assertions.assertFalse(doctorView.closeRequestButtonActionPerformed(null));

  }



}