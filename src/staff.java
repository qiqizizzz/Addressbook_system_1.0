public class staff extends person {
    // 定义人员（staff）类，从 person 类派生
    // 包含电话、地址、邮政编码、邮箱、QQ号和类别（例如：同学、朋友等）
    private String phonenumber;    // 电话号码
    private String address;         // 地址
    private int postal_code;        // 邮政编码
    private String email;           // 邮箱
    private String qq_number;       // QQ号
    private String category;        // 类别（例如：同学、朋友等）

    // 带参数的构造函数，初始化 staff 对象
    public staff(String name, char gender, date birthday, String phonenumber, String address, int postal_code, String email, String qq_number, String category) {
        super(name, gender, birthday); // 调用父类 person 的构造函数
        this.phonenumber = phonenumber; // 设置电话号码
        this.address = address;           // 设置地址
        this.postal_code = postal_code;   // 设置邮政编码
        this.email = email;               // 设置邮箱
        this.qq_number = qq_number;       // 设置 QQ号码
        this.category = category;         // 设置类别
    }

    // 默认构造函数
    public staff() {
    }

    // 获取电话号码
    public String getPhonenumber() {
        return phonenumber;
    }

    // 设置电话号码
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    // 获取地址
    public String getAddress() {
        return address;
    }

    // 设置地址
    public void setAddress(String address) {
        this.address = address;
    }

    // 获取邮政编码
    public int getPostal_code() {
        return postal_code;
    }

    // 设置邮政编码
    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    // 获取邮箱
    public String getEmail() {
        return email;
    }

    // 设置邮箱
    public void setEmail(String email) {
        this.email = email;
    }

    // 获取 QQ号
    public String getQq_number() {
        return qq_number;
    }

    // 设置 QQ号
    public void setQq_number(String qq_number) {
        this.qq_number = qq_number;
    }

    // 获取类别
    public String getCategory() {
        return category;
    }

    // 设置类别
    public void setCategory(String category) {
        this.category = category;
    }

    // 重写 toString 方法，返回完整的人员信息字符串
    @Override
    public String toString() {
        return  getName() +               // 姓名
                ":" + getGender() +     // 性别
                "," + getBirthday().toString() + // 出生日期
                "," + getPhonenumber() +   // 电话号码
                "," + getAddress() +     // 地址
                "," + getPostal_code() + // 邮政编码
                "," + getEmail() +         // 邮箱
                "," + getQq_number() + // QQ号
                "," + getCategory();    // 类别
    }

    // 重写 clone 方法，支持对象的克隆
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // 调用父类的 clone 方法
    }
}
