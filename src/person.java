public class person {
    // 定义私有属性 name, gender 和 birthday，用于表示个人信息
    private String name;    // 姓名
    private char gender;  // 性别
    private date birthday;  // 出生日期，使用 date 类表示

    // 带参数的构造函数，用于初始化个人对象
    public person(String name, char gender, date birthday) {
        this.name = name;         // 设置姓名
        this.gender = gender;     // 设置性别
        this.birthday = birthday; // 设置出生日期
    }

    // 默认构造函数
    public person() {
    }

    // 获取姓名
    public String getName() {
        return name;
    }

    // 设置姓名
    public void setName(String name) {
        this.name = name;
    }

    // 获取性别
    public char getGender() {
        return gender;
    }

    // 设置性别
    public void setGender(char gender) {
        this.gender = gender;
    }

    // 获取出生日期
    public date getBirthday() {
        return birthday;
    }

    // 设置出生日期
    public void setBirthday(date birthday) {
        this.birthday = birthday;
    }

    // 重写 toString 方法，返回个人信息的字符串表示
    @Override
    public String toString() {
        return "name: "+getName()+
                " gender: "+getGender()+
                " brithday: "+birthday.toString();
    }

    // 重写 clone 方法，支持对象的克隆
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // 调用父类的 clone 方法
    }
}