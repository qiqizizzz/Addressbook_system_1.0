public class date {
    // 定义私有属性 year, month, date，用于表示日期的年、月、日
    private int year;   // 年
    private int month;  // 月
    private int day;   // 日

    // 带参数的构造函数，用于初始化日期对象
    public date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // 默认构造函数
    public date() {
    }

    // 获取年
    public int getYear() {
        return year;
    }

    // 设置年
    public void setYear(int year) {
        this.year = year;
    }

    // 获取月
    public int getMonth() {
        return month;
    }

    // 设置月
    public void setMonth(int month) {
        this.month = month;
    }

    // 获取日
    public int getDay() {
        return day;
    }

    // 设置日
    public void setDay(int day) {
        this.day = day;
    }

    // 重写 toString 方法，返回日期对象的字符串表示形式
    @Override
    public String toString() {
        return getYear()+"-"+getMonth()+"-"+getDay();
    }

    // 重写 clone 方法，支持对象的克隆
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // 调用父类的 clone 方法
    }

    // 重写 equals 方法，用于比较两个日期对象是否相等
    @Override
    public boolean equals(Object obj) {
        // 检查 obj 是否为 date 实例，若不是则返回 false
        if (this == obj) return true; // 同一引用的比较
        if (!(obj instanceof date)) return false; // 类型检查
        date other = (date) obj; // 向下转型
        // 比较各个属性是否相等
        return year == other.year && month == other.month && day == other.day;
    }
}