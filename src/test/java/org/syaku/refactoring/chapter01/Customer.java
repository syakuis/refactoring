package org.syaku.refactoring.chapter01;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2018. 6. 27.
 */
@RequiredArgsConstructor
public class Customer {
  @Getter
  private final String name;
  private List<Rental> rentals = new ArrayList<>();

  public void addRental(Rental rental) {
    this.rentals.add(rental);
  }

  public String statement() {
    double totalAmout = 0;
    int frequentRenterPoints = 0;
    String result = getName() + " 고객님의 대여 기록\n";
    for (Rental rental : rentals) {
      double thisAmount = 0;

      // 비디오 종류별 대여료 계산
      switch (rental.getMovie().getPriceCode()) {
        case Movie.REGULAR:
          thisAmount += 2;
          if (rental.getDayRented() > 2) {
            thisAmount += (rental.getDayRented() - 2) * 1.5;
          }
          break;
        case Movie.NEW_RELEASE:
          thisAmount += rental.getDayRented() * 3;
          break;
        case Movie.CHILDRENS:
          thisAmount += 1.5;
          if (rental.getDayRented() > 3) {
            thisAmount += (rental.getDayRented() - 3) * 1.5;
          }
          break;
      }

      // 적립 포인트를 1 포인트 증가
      frequentRenterPoints++;
      // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
      if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDayRented() > 1) {
        frequentRenterPoints++;
      }

      // 이번에 대여하는 비디오 정보와 대여료를 출력
      result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";

      // 현재까지 누적된 총 대여료
      totalAmout += thisAmount;
    }

    // 푸터 행 추가
    result += "누적 대여료: " + String.valueOf(totalAmout) + "\n";
    result += "적립 포인트: " + String.valueOf(frequentRenterPoints);

    return result;
  }
}
