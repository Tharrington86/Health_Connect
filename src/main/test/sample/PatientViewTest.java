package sample;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PatientViewTest {
  public PatientView patientViewTest = new PatientView();


  @Test
  public void inProgressButtonEmpty() throws NullPointerException{
    Assertions.assertFalse(patientViewTest.InProgressButtonActionPerformed(null));

  }
  @Test
  public void inProgressButton() throws NullPointerException{
    patientViewTest.setUsername("JaneDoe");
    Assertions.assertTrue(patientViewTest.InProgressButtonActionPerformed(null));

  }




  @Test
  public void newButtonButton() throws NullPointerException{
    patientViewTest.setRequestID(108);
    patientViewTest.setUsername("will");
    patientViewTest.setUserType("Patient");
    Assertions.assertTrue(patientViewTest.newButtonActionPerformed(null));
  }

  @Test
  public void newButtonFalse() throws NullPointerException{
    Assertions.assertFalse(patientViewTest.newButtonActionPerformed(null));

  }
  @Test
  public void closedActionPerformedFalse() throws NullPointerException{
    patientViewTest.setUsername("");

    Assertions.assertFalse(patientViewTest.closedButtonActionPerformed(null));
  }
  @Test
  public void closedActionPerformed() throws NullPointerException{
    patientViewTest.setUsername("Will");
    Assertions.assertTrue(patientViewTest.closedButtonActionPerformed(null));
  }

  @Test
  public void testMain() throws IOException {
    patientViewTest.setUsername("will");
    String[] args = null;
    patientViewTest.main(args);


  }



}