package oops.enumExamples;

public class Basic {
    enum Week implements A{
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
        // these are enum constants
        //public, static and final
        //since its final you can create child enums
        //type is Week

        Week(){
            System.out.println("Constructor called for " + this);
        }
        // this is not public or proctected, only private or default
        //why? we don't want to create new Objects
        //this is not the enum concept, thats why
        //internally: public static final Week Monday = new Week();

        @Override
        public void hello(){
            System.out.println("Hey how are you?");
        }
    }

    public static void main(String[] args) {
        Week week = Week.Monday;
        week.hello();
        System.out.println(week.valueOf("Monday"));
//        for (Week day : Week.values()) {
//            System.out.print(day.ordinal() + " ");
//            System.out.println(day);
//        }
//        System.out.println(week.ordinal());
    }
}
