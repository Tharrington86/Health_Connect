package sample;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class ProfileTest {
  public Profile profileTest = new Profile();
  /**
   *Main Test
   * */
  @Test
  public void testMain() throws IOException {
    profileTest.setUsername("will");
    String[] args = null;
    profileTest.main(args);
  }
  /**
   *Valid Make New Request
   * */
  @Test
  public void makeRequest(){
    profileTest.setUsername("will");
    profileTest.makeRequestButtonActionPerformed(null);

  }
  /**
   *Valid View Request Screen
   * */
  @Test
  public void viewRequest(){
    profileTest.setUsername("will");
    profileTest.viewRequestButtonActionPerformed(null);
  }
  /**
   *Valid Logout Button
   * */
  @Test
  public void logout(){
    profileTest.setUsername("will");
    profileTest.logoutActionPerformed(null);

  }
}