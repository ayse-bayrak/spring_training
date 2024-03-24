package bean_practice;

public class PartTimeEmployee implements TimeEmployee {
    @Override
    public void createAccount() {
        System.out.println("Part Time Employee ");
    }
}
