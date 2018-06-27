package org.syaku.refactoring.chapter01;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 임시변수 없애기 - 한번의 반복문을 세번을 하게 되므로 코드 가독성은 좋아도 성능면에서는 손해. 책에서는 최적화 단계에서 생각해도 늦지 않다고 한다.
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

  private double amountFor(Rental rental) {
    return rental.getCharge();
  }

  // 임시변수 없애기 : totalAmount
  private double getTotalCharge() {
    double result = 0;
    for (Rental rental : rentals) {
      result += rental.getCharge();
    }
    return result;
  }

  // 임시변수 없애기 : frequentRenterPoints
  private int getTotalFrequentRenterPoints() {
    int result = 0;
    for (Rental rental : rentals) {
      result += rental.getFrequentRenterPoints();
    }
    return result;
  }

  public String statement() {
//    double totalAmount = 0;
//    int frequentRenterPoints = 0;
    String result = getName() + " 고객님의 대여 기록\n";
    for (Rental rental : rentals) {
//      double thisAmount;

      // 비디오 종류별 대여료 계산
//      switch (rental.getMovie().getPriceCode()) {
//        case Movie.REGULAR:
//          thisAmount += 2;
//          if (rental.getDayRented() > 2) {
//            thisAmount += (rental.getDayRented() - 2) * 1.5;
//          }
//          break;
//        case Movie.NEW_RELEASE:
//          thisAmount += rental.getDayRented() * 3;
//          break;
//        case Movie.CHILDRENS:
//          thisAmount += 1.5;
//          if (rental.getDayRented() > 3) {
//            thisAmount += (rental.getDayRented() - 3) * 1.5;
//          }
//          break;
//      }

//      thisAmount = rental.getCharge();

      // 적립 포인트를 1 포인트 증가
//      frequentRenterPoints++;
      // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
//      if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDayRented() > 1) {
//        frequentRenterPoints++;
//      }

//      frequentRenterPoints += rental.getFrequentRenterPoints();

      // 이번에 대여하는 비디오 정보와 대여료를 출력
      result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";

      // 현재까지 누적된 총 대여료
//      totalAmount += rental.getCharge();
    }

    // 푸터 행 추가
    result += "누적 대여료: " + String.valueOf(getTotalCharge()) + "\n";
    result += "적립 포인트: " + String.valueOf(getTotalFrequentRenterPoints());

    return result;
  }
}
