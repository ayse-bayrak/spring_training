package com.cydeo.entity;


import com.cydeo.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account_details")
@Getter
@Setter
@NoArgsConstructor
public class Account extends BaseEntity{

    private String address;
    private int age;

    private String city;
    private String country;
    private String name;


    private String postalCode;

    @Enumerated(EnumType.STRING)
    private UserRole role;
    private String state;

    @OneToOne(mappedBy = "account")
    private User user;

    @Override
    public String toString() {
        return "Account{" +
                "address='" + address + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", role=" + role +
                ", state='" + state + '\'' +
                '}';
    }

    /*
Question:
does it need to put relation in Account side.
We already put @OneToOne User side, and also it does not require user foreign key AccountDetails table,
instead of delete by mapped by, can it be not add any field about User ?


Answer:
If you think about the tables only, you don't have to create a bidirectional relationship, so yes, you don't have to put User field in Account class.
But if you think about Java side, not only the tables in database, sometimes it might be better to create a bidirectional relationship.

For example, in the application if you are using Account and User object so often and most of the times you call an account you need the User connected that
Account as well, but you don't want to save the User information in Account table in database, what you can do is, you can create a bidirectional relation ship,
and then use mappedBy in Account, so that nothing shows up in Account table, but you will still be able to get the User of an Account in your Java code.

What I mean is this.
Let's say you want to be able to access the User of the Account but you don't have User information in Account table, what you need to to be able get the User of an account?
You need to run some database query that can give you the user that you need, based on the data in the User table. Like this:
SELECT u.user_name, u.first_name, u.last_name etc FROM users u JOIN accounts a ON a.id = u.account_id WHERE a.id = 5; (For example)


But if you have User field added in Account, then you wouldn't need to run a query like above to be able to find the User of an account.
You would simply run this code in Java side:
User user = account.getUser();


There is still going to be some database query will be executed in the behind the scenes, but you wouldn't need to type it and run it manually, it will happen automatically.

This is the advantage of having bidirectional relationship(Having User in Account while having Account in User also).
But it also has a drawback/disadvantage, which is the performance. If you create everything in bidirectional way, then your application will perform poorly.
So there has to be something that you need often so that you can use a bidirectional relationship, for example if you need User information alongside with Account information most of the times, it might make sense to put User in Account while putting Account in User at the same time.
     */


}
