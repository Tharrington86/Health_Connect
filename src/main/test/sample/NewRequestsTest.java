package sample;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NewRequestsTest {
  public NewRequests newRequests = new NewRequests();
  public PatientView patientView = new PatientView();
  public NewJFrame newJFrame = new NewJFrame();



  @BeforeEach
  public void initNewRequest() throws SQLException {
    newRequests.setUserID("will");
    newRequests.setUserType("Doctor");
    newRequests.setCount(101);
    newRequests.setFinalString("I need an appointment");
  }


  /**
   *Valid New Request
   * */
  @Test
  public void validUserRequest() throws SQLException {
    newRequests.setUserID("will");
    newRequests.setFinalString("I need more supplies");
    newRequests.setCount(159);
    Assertions.assertTrue(newRequests.createButtonActionPerformed(null));
  }


  /**
   *Cancel Button Test
   * */
  @Test
  public void cancelTest(){
    newRequests.setUserID("will");
    Assertions.assertTrue(newRequests.cancelButtonActionPerformed(null));
  }


  /**
   *Test Main
   * */
  @Test
  public void testMain() throws IOException {
    newRequests.setUserID("will");
    newJFrame.setUsername("will");
    patientView.setUsername("will");
    newRequests.setNew_userID("will");
    String[] args = null;
    newRequests.main(args);
  }





}