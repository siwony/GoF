package creational.builder.after;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor @AllArgsConstructor
@Setter @ToString
class TourPlan {

    private String title;

    private int nights;

    private int days;

    private LocalDate startDate;

    private String whereToStay;

    private List<DetailPlan> plans = new ArrayList<>();


    public void addPlan(int day, String plan) {
        this.plans.add(new DetailPlan(day, plan));
    }



    @AllArgsConstructor
    @Getter @Setter
    static class DetailPlan {

        private int day;

        private String plan;
    }


}
