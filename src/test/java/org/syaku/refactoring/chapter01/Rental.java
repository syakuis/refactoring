package org.syaku.refactoring.chapter01;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2018. 6. 27.
 */
@AllArgsConstructor
public class Rental {
  @Getter
  private Movie movie;
  @Getter
  private int dayRented;
}
