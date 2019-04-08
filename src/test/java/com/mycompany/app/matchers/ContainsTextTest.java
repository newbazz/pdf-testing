package com.mycompany.app.matchers;

import com.mycompany.app.PDF;
import org.junit.Test;

import java.io.IOException;

import static com.mycompany.app.PDF.containsText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ContainsTextTest {
  @Test
  public void canAssertThatPdfContainsText() throws IOException {
    PDF pdf = new PDF(getClass().getClassLoader().getResource("50quickideas.pdf"));
    assertThat(pdf, containsText("50 Quick Ideas to Improve your User Stories"));
    assertThat(pdf, containsText("Gojko Adzic"));
    assertThat(pdf, containsText("©2013 - 2014 Gojko Adzic"));
    assertThat(pdf, containsText("#50quickideas"));
    assertThat(pdf, containsText("https://twitter.com/search?q=#50quickideas"));
  }

  @Test
  public void shouldBeCaseSensitive() throws IOException {
    PDF pdf = new PDF(getClass().getClassLoader().getResource("50quickideas.pdf"));
    assertThat(pdf, not(containsText("50 quick ideas")));
  }

  @Test
  public void shouldIgnoreWhitespaces() throws IOException {
    PDF pdf = new PDF(getClass().getClassLoader().getResource("50quickideas.pdf"));
    assertThat(pdf, containsText("Gojko       Adzic"));
    assertThat(pdf, containsText("\tGojko \t Adzic\t"));
    assertThat(pdf, containsText("Gojko \n Adzic\t\n"));
    assertThat(pdf, containsText("Gojko \n Adzic\n"));
    assertThat(pdf, containsText("Gojko\r\n Adzic\r\n"));
    assertThat(pdf, containsText("Gojko \u00a0 Adzic\r\n"));
  }

  @Test
  public void errorDescription() throws IOException {
    PDF pdf = new PDF(getClass().getClassLoader().getResource("minimal.pdf"));
    try {
      assertThat(pdf, containsText("Goodbye word"));
      fail("expected AssertionError");
    }
    catch (AssertionError expected) {
      assertThat(expected.getMessage(),
          is("\nExpected: a PDF containing \"Goodbye word\"\n     but: was \"Hello World\""));
    }
  }
}
