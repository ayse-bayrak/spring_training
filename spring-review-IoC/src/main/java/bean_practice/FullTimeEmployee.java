package bean_practice;

public class FullTimeEmployee implements TimeEmployee{
    @Override
    public void createAccount() {
        System.out.println("Full Time Employee ");
    }
}
