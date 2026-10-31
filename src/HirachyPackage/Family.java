package HirachyPackage;

public class Family {
    private final GrandFather headOfFamily = new Uncle();
    private final GrandFather tailOfFamily = new Son();

    void run() {
        System.out.println(this.headOfFamily.changePropertiesWithOpium());
        tailOfFamily.changePropertiesWithOpium();
    }
}
