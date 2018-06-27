package org.syaku.refactoring.chapter01;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2018. 6. 27.
 */
@AllArgsConstructor
public class Movie {
  public static final int CHILDRENS = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  @Getter
  private String title;
  @Getter
  private int priceCode;
}
