package creational.builder.after;


import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class TourDirector {

    private final TourPlanBuilder tourPlanBuilder;

    public TourPlan cancunTrip(){
        return tourPlanBuilder.title("칸쿤 여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2020, 12, 9))
                .whereToStay("리조트")
                .addPlan(0, "체크인하고 짐 풀기")
                .addPlan(0, "저녁 식사")
                .getPlan();
    }

    public TourPlan longBeach(){
        return tourPlanBuilder.title("롱비치")
                .startDate(LocalDate.of(2020, 12, 9))
                .getPlan();
    }
}
