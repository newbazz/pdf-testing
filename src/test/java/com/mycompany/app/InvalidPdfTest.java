package com.mycompany.app;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

// import static org.hamcrest.Matchers.Is.is;
// import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class InvalidPdfTest {
  @Test(expected = NoSuchFileException.class)
  public void throws_IOException_ifFailedToReadPdfFile() throws IOException {
    new PDF(new File("src/test/resources/invalid-file.pdf"));
  }
}