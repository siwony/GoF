package creational.builder.before;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor @AllArgsConstructor
@Setter
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
