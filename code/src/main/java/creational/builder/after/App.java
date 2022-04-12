package creational.builder.after;

class App {

    public static void main(String[] args) {
        TourDirector director = new TourDirector(new DefaultTourBuilder());
        final TourPlan tourPlan = director.cancunTrip();
        final TourPlan tourPlan1 = director.longBeach();

        System.out.println("tourPlan = " + tourPlan);
        System.out.println("tourPlan1 = " + tourPlan1);
    }
}
