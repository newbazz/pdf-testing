package com.mycompany.app.matchers;

import com.mycompany.app.PDF;
import org.hamcrest.SelfDescribing;
import org.hamcrest.TypeSafeMatcher;

abstract class PDFMatcher extends TypeSafeMatcher<PDF> implements SelfDescribing {
  protected String reduceSpaces(String text) {
    return text.replaceAll("[\\s\\n\\r\u00a0]+", " ").trim();
  }
}
