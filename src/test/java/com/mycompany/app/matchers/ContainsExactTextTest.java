package com.mycompany.app.matchers;

import com.mycompany.app.PDF;
import org.junit.Test;

import java.io.IOException;

import static com.mycompany.app.PDF.containsExactText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ContainsExactTextTest {
  @Test
  public void canAssertThatPdfContainsText() throws IOException {
    PDF pdf = new PDF(getClass().getClassLoader().getResource("50quickideas.pdf"));
    assertThat(pdf, containsExactText("50 Quick Ideas to Improve your User Stories"));
  }

  @Test
  public void shouldBeCaseSensitive() throws IOException {
    PDF pdf = new PDF(getClass().getClassLoader().getResource("50quickideas.pdf"));
    assertThat(pdf, not(containsExactText("50 quick ideas")));
  }

  @Test
  public void shouldNotIgnoreWhitespaces() throws IOException {
    PDF pdf = new PDF(getClass().getClassLoader().getResource("50quickideas.pdf"));
    assertThat(pdf, containsExactText("Gojko Adzic"));
    assertThat(pdf, not(containsExactText("Gojko       Adzic")));
    assertThat(pdf, not(containsExactText("\tGojko \t Adzic\n")));
    assertThat(pdf, not(containsExactText("Gojko \u00a0 Adzic\r\n")));
  }

  @Test
  public void errorDescription() throws IOException {
    PDF pdf = new PDF(getClass().getClassLoader().getResource("minimal.pdf"));
    try {
      assertThat(pdf, containsExactText("Goodbye word"));
      fail("expected AssertionError");
    }
    catch (AssertionError expected) {
      assertThat(expected.getMessage(), 
          is("\nExpected: a PDF containing \"Goodbye word\"\n     but: was \"Hello World\n\""));
    }
  }
}
