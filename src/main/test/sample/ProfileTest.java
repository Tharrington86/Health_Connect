package sample;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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