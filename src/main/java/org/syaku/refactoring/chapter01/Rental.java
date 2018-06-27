package org.syaku.refactoring.chapter01;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2018. 6. 27.
 */
@AllArgsConstructor
class Rental {
  @Getter
  private Movie movie;
  @Getter
  private int dayRented;

  // 최신물을 이틀 이상 대여하면 2포인트 지급하고 그 외엔 1포인트 지급하는 코드를
  // 빼내 getFrequentRenterPoints 메서드로 만들고 이 Rental 클래스로 옮겼다.
  int getFrequentRenterPoints() {
    // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
    if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDayRented() > 1) {
      return 2;
    }

    return 1;
  }

  double getCharge() {
    double result = 0;
    // 비디오 종류별 대여료 계산
    switch (getMovie().getPriceCode()) {
      case Movie.REGULAR:
        result += 2;
        if (getDayRented() > 2) {
          result += (getDayRented() - 2) * 1.5;
        }
        break;
      case Movie.NEW_RELEASE:
        result += getDayRented() * 3;
        break;
      case Movie.CHILDRENS:
        result += 1.5;
        if (getDayRented() > 3) {
          result += (getDayRented() - 3) * 1.5;
        }
        break;
    }

    return result;
  }
}
