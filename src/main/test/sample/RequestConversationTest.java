package sample;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RequestConversationTest {
  public RequestConversation requestConversation = new RequestConversation();

  @Test
  void addButtonActionPerformed() throws SQLException {
    requestConversation.setRequestNumber(103);
    requestConversation.setUserID("JohnDoe");
    requestConversation.setUserType("Doctor");
    requestConversation.setFinalString("He need to follow up soon");
    requestConversation.setTestSignal(0);
    Assertions.assertTrue(requestConversation.addButtonActionPerformed(null));

  }

  @Test
  void closeButtonActionPerformed() {
  }

  @Test
  void backButtonActionPerformed() {
  }

  @Test
  void main() {
  }
}