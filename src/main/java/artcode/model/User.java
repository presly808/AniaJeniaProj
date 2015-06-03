package artcode.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements Comparable<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String name;

    @Column(nullable = false)
    private String pass;

    @Column
    private int age;

    private double money;

    public User() {
    }

    public User(long id, String name, String pass, int age) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.age = age;
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public User(String name, String pass, int age) {
        this.name = name;
        this.pass = pass;
        this.age = age;
    }

    public User(long id, String name,
                int age, double money) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", money=").append(money);
        sb.append('}');
        return sb.toString();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int compareTo(User o) {
        return (int) (id - o.id);
    }
}
