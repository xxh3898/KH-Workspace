package example.poly2;

public class Member {
    private String name;
    private int age;
    private char gender;
    private int couponCount;

    // 기본 생성자
    public Member() {
        super();
    }

    // 이름, 나이, 성별을 받는 생성자
    public Member(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.couponCount = 0;
    }

    // 모든 필드를 받는 생성자
    public Member(String name, int age, char gender, int couponCount) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.couponCount = couponCount;
    }

    // Getter / Setter
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(int couponCount) {
        this.couponCount = couponCount;
    }

    // toString() 오버라이딩
    @Override
    public String toString() {
        return name + ", " + age + "세, " + gender + ", 쿠폰: " + couponCount + "장";
    }
}
