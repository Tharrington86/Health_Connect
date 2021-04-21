package sample;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import javax.swing.JPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NewJFrameTest {
  public NewJFrame loginTest = new NewJFrame();
  public JPanel panel = new JPanel();

  /**
   *Login test empty field for Doctor
   * */
  @Test
  void EmptyLoginTestDoctor() throws Exception {
    loginTest.setUsername("");
    loginTest.setPassword("");
    Assertions.assertFalse(loginTest.LoginAsDoctorActionPerformed(null));
  }

  /**
   *Wrong Password For Doctor Login
   * */
  @Test
  void WrongPasswordTestDoctor(){
    loginTest.setUsername("JohnDoe");
    loginTest.setPassword("00000");
    Assertions.assertFalse(loginTest.LoginAsDoctorActionPerformed(null));
  }


  /**
   *Valid Login as Doctor
   * */
  @Test
  void correctLoginDoctor(){
    loginTest.setUsername("JohnDoe");
    loginTest.setPassword("000000");
    Assertions.assertTrue(loginTest.LoginAsDoctorActionPerformed(null));
  }

  /**
   *Empty Doctor Login
   * */
  @Test
  void EmptyLoginTestPatient() throws Exception {
    loginTest.setUsername("");
    loginTest.setPassword("");
    Assertions.assertFalse(loginTest.LoginAsPatientActionPerformed(null));
  }
  /**
   *Invalid Password Test for Patient
   * */
  @Test
  void WrongPasswordTestPatient() throws SQLException {
    loginTest.setUsername("JohnDoe");
    loginTest.setPassword("00000");
    Assertions.assertFalse(loginTest.LoginAsPatientActionPerformed(null));
  }

  /**
   *Correct Login for Patient
   * */
  @Test
  void correctLoginPatient() throws Exception {
    loginTest.setUsername("will");
    loginTest.setPassword("will");
    Assertions.assertTrue(loginTest.LoginAsPatientActionPerformed(null));
  }

}