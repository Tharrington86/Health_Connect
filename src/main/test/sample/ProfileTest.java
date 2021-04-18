package sample;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class ProfileTest {
  public Profile profileTest = new Profile();

  @Test
  public void testMain() throws IOException {
    profileTest.setUsername("will");
    String[] args = null;
    profileTest.main(args);
  }
  @Test
  public void makeRequest(){
    profileTest.setUsername("will");
    profileTest.makeRequestButtonActionPerformed(null);

  }
  @Test
  public void viewRequest(){
    profileTest.setUsername("will");
    profileTest.viewRequestButtonActionPerformed(null);

  }
  @Test
  public void logout(){
    profileTest.setUsername("will");
    profileTest.logoutActionPerformed(null);

  }
}