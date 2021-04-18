package sample;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import javax.swing.JPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NewJFrameTest {
  public NewJFrame loginTest = new NewJFrame();
  public JPanel panel = new JPanel();


  @Test
  void EmptyLoginTestDoctor() throws Exception {

    loginTest.setUsername("");
    loginTest.setPassword("");
    Assertions.assertFalse(loginTest.LoginAsDoctorActionPerformed(null));
  }
  @Test
  void WrongPasswordTestDoctor(){
    loginTest.setUsername("JohnDoe");
    loginTest.setPassword("00000");

    Assertions.assertFalse(loginTest.LoginAsDoctorActionPerformed(null));


  }
  @Test
  void correctLoginDoctor(){
    loginTest.setUsername("JohnDoe");
    loginTest.setPassword("000000");
    Assertions.assertTrue(loginTest.LoginAsDoctorActionPerformed(null));
  }
  @Test
  void EmptyLoginTestPatient() throws Exception {

    loginTest.setUsername("");
    loginTest.setPassword("");
    Assertions.assertFalse(loginTest.LoginAsPatientActionPerformed(null));
  }
  @Test
  void WrongPasswordTestPatient() throws SQLException {
    loginTest.setUsername("JohnDoe");
    loginTest.setPassword("00000");

    Assertions.assertFalse(loginTest.LoginAsPatientActionPerformed(null));


  }
  @Test
  void correctLoginPatient() throws Exception {
    loginTest.setUsername("will");
    loginTest.setPassword("will");
    Assertions.assertTrue(loginTest.LoginAsPatientActionPerformed(null));
  }

}