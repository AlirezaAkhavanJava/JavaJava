package SimplPackage;

public class SimpleClass {
    // =============== State ================
    private String name;
    private double decimal;
    private final Role role;

    // ===============BEHAVIOR=================
    private String random() {
        return "RANDOM TEXT";
    }

    // ===================INIT======================

    // *********************CONSTRUCTOR************************
    public SimpleClass(String name, double decimal) {
        this.name = name;
        this.decimal = decimal;
        this.role = Role.USER;
    }


    public SimpleClass() {
        // DEFAULT VALUES
        this.name = "John Doe";
        this.decimal = 5500.0D;
        this.role = Role.USER;
    }

    public SimpleClass(String name, double decimal, Role role) {
        this.name = name;
        this.decimal = decimal;
        this.role = role;
    }

    @Override
    public String toString() {
        return "SimplPackage.SimpleClass{" +
                "name='" + name + '\'' +
                ", decimal=" + decimal +
                ", role=" + role +
                '}';
    }

    public String getName(Role requestRole) {
        if (requestRole == Role.ADMIN) {
            return name;
        } else throw new NotAuthorizedException("You are not authorized to see this");
    }

    public double getDecimal(Role requestRole) {
        if (requestRole == Role.ADMIN || role == Role.BOSS)
            return decimal;
        else throw new NotAuthorizedException("You are not authorized to see this");
    }


    public void setName(String name) throws IllegalAccessException {
        if (name != null
                && !name.isBlank()
                && name.matches("[a-zA-Z]+( [a-zA-Z]+)*")
                && name.length() <= 120
                && name.length() >= 2) {
            this.name = name;
        } else throw new IllegalAccessException("Invalid name");
    }


    public void setDecimal(double decimal) throws IllegalAccessException {
        if (decimal >= 0.0D) {
            this.decimal = decimal;
        } else throw new IllegalAccessException("Can't be negative");
    }


    // ===================NESTED=====================
    private enum Role {
        ADMIN, BOSS, USER
    }


}
