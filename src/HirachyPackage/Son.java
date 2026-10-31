package HirachyPackage;

public class Son extends Father {
    @Override
    void gotOut() {
        System.out.println("Now my life is bad");
    }

    @Override
    public String changePropertiesWithOpium() {
        return "Now i am poor";
    }
}
