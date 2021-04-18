package sample;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RequestConversationTest {
  public RequestConversation requestConversation = new RequestConversation();

  @Test
  void addButtonDoctor() throws SQLException {
    requestConversation.setRequestNumber(103);
    requestConversation.setUserID("JohnDoe");
    requestConversation.setUserType("Doctor");
    requestConversation.setFinalString("He need to follow up soon");
    requestConversation.setTestSignal(0);
    Assertions.assertTrue(requestConversation.addButtonActionPerformed(null));

  }
  @Test
  void addButtonPatient() throws SQLException {
    requestConversation.setRequestNumber(103);
    requestConversation.setUserID("will");
    requestConversation.setUserType("Patient");
    requestConversation.setFinalString("I need to follow up soon");
    requestConversation.setTestSignal(0);
    Assertions.assertTrue(requestConversation.addButtonActionPerformed(null));

  }



  @Test
  void closeButtonActionPerformedDoctor() {
    requestConversation.setUserID("JohnDoe");
    requestConversation.setUserType("Doctor");
    requestConversation.setRequestNumber(103);
    requestConversation.setTestSignal(0);
    Assertions.assertTrue(requestConversation.closeButtonActionPerformed(null));


  }
  @Test
  void closeButtonActionPerformedPatient() {
    requestConversation.setUserID("will");
    requestConversation.setUserType("Patient");
    requestConversation.setRequestNumber(103);
    requestConversation.setTestSignal(0);
    Assertions.assertTrue(requestConversation.closeButtonActionPerformed(null));


  }

  @Test
  void backButtonActionDoctor() {
    requestConversation.setTestSignal(0);
    requestConversation.setUserType("Doctor");
    requestConversation.setUserID("JohnDoe");
    Assertions.assertTrue(requestConversation.backButtonActionPerformed(null));
  }
  @Test
  void backButtonActionPatient() {
    requestConversation.setTestSignal(0);
    requestConversation.setUserType("Patient");
    requestConversation.setUserID("will");
    Assertions.assertTrue(requestConversation.backButtonActionPerformed(null));
  }
  @Test
  public void testMain() throws IOException {
    requestConversation.setUserID("will");
    String[] args = null;
    requestConversation.main(args);
  }
}