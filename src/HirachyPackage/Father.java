package HirachyPackage;

import java.time.LocalDate;

public abstract class Father implements GrandFather {
    abstract void gotOut();

    protected void gotOut(LocalDate when) {
        System.out.println("At : " + when);
    }
}
