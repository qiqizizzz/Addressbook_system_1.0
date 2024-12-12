import javax.swing.text.AttributeSet;
import java.io.*;
import java.text.Collator;
import java.util.*;

public class Mainfunction {
    // 菜单功能，提供用户与系统的交互
    public static void menu() throws IOException {
        Scanner in = new Scanner(System.in); // 创建 Scanner 对象以读取用户输入
        displaymenu(); // 显示主菜单
        char t; // 用于存储用户输入的选项

        // 循环读取用户输入，直到输入 '0' 退出
        while ((t = in.next().charAt(0)) != '0') {
            // 根据用户输入的选项执行相应的方法
            switch (t) {
                case '1': // 处理选项 1：添加或编辑人员信息
                    Function1_addedor();
                    break; // 跳出当前 switch
                case '2': // 处理选项 2：查询人员信息
                    Function2_select();
                    break; // 跳出当前 switch
                case '3': // 处理选项 3：根据姓名排序并显示人员信息
                    Function3_displayable();
                    break; // 跳出当前 switch
                case '4': // 处理选项 4：根据姓名和电话更新人员信息
                    Function4_update();
                    break; // 跳出当前 switch
                case '5': // 处理选项 5：删除人员信息
                    Function5_delete();
                    break; // 跳出当前 switch
                case '0': // 处理选项 0：退出
                    break; // 跳出当前 switch
                default: // 输入了无效的选项
                    System.out.println("Please enter a right number!"); // 提示用户输入正确的选项
                    displaymenu(); // 重新显示菜单
            }

            // 提示用户输入任意字符以返回菜单
            System.out.println("请输入任意字符返回菜单...");
            in.next(); // 等待用户输入任意字符
            displaymenu(); // 重新显示菜单
        }
    }

    // 输入功能：输入人员信息，并保存到文件中
    public static void Function1_addedor() throws IOException {
        // 创建 Scanner 对象以读取用户输入
        Scanner in = new Scanner(System.in);
        // 创建 staff 对象，用于存储输入的人员信息
        staff s = new staff();
        // 创建 date 对象，用于存储出生日期
        date d = new date();

        // 提示用户开始添加信息
        System.out.print("-----开始添加信息-----");

        // 输入姓名
        System.out.print("\n添加姓名：");
        String name = in.next(); // 读取姓名输入
        s.setName(name); // 设置姓名

        // 输入性别
        System.out.print("添加性别：");
        char gender = in.next().charAt(0); // 读取性别输入，只取第一个字符
        s.setGender(gender); // 设置性别

        // 输入出生日期
        System.out.println("添加出生日期:");
        System.out.print("年份:");
        int year = in.nextInt(); // 读取年份输入
        d.setYear(year); // 设置年份

        System.out.print("月份:");
        int month = in.nextInt(); // 读取月份输入
        d.setMonth(month); // 设置月份

        System.out.print("日期:");
        int day = in.nextInt(); // 读取日期输入
        d.setDay(day); // 设置日期

        // 将出生日期对象与 staff 对象关联
        s.setBirthday(d);

        // 输入电话号码
        System.out.print("电话号码:");
        String phonenumber = in.next(); // 读取电话号码输入
        s.setPhonenumber(phonenumber); // 设置电话号码

        // 输入地址
        System.out.print("地址:");
        String address = in.next(); // 读取地址输入
        s.setAddress(address); // 设置地址

        // 输入邮政编码
        System.out.print("邮政编码:");
        int postal_code = in.nextInt(); // 读取邮政编码输入
        s.setPostal_code(postal_code); // 设置邮政编码

        // 输入邮箱
        System.out.print("邮箱:");
        String email = in.next(); // 读取邮箱输入
        s.setEmail(email); // 设置邮箱

        // 输入 QQ 号码
        System.out.print("QQ号:");
        String qq_number = in.next(); // 读取 QQ 号码输入
        s.setQq_number(qq_number); // 设置 QQ 号码

        // 输入类别
        System.out.print("类别(例如:同学、朋友等):");
        String category = in.next(); // 读取类别输入
        s.setCategory(category); // 设置类别

        // 保存人员信息到文件
        saveToFile(s);

        // 打印保存成功信息
        System.out.println("保存成功！");
    }

    // 查询功能：
//  1）能够根据姓名、电话精确查询人员信息；
//  2）能够根据地址进行模糊查询人员信息；
//  3）根据人员类别查询人员信息
    public static void Function2_select() throws IOException {
        Scanner s = new Scanner(System.in); // 创建 Scanner 对象以读取用户输入
        System.out.println("请输入您要进行查询的方式:"); // 提示用户选择查询方式
        System.out.println("A.输入姓名、电话来查询"); // 选项 A 的提示
        System.out.println("B.输入地址来查询"); // 选项 B 的提示
        System.out.println("C.输入人员类别来查询"); // 选项 C 的提示
        System.out.println("Q.离开"); // 选项 Q 的提示，用于退出查询

        // 读取用户选择的操作
        char c = s.next().charAt(0); // 获取用户输入的第一个字符

        // 根据用户选择调用相应的查询方法
        switch (c) {
            case 'A': // 如果用户选择 A，则调用根据姓名和电话查询的函数
                Function2_select_A();
                break; // 结束当前 case
            case 'B': // 如果用户选择 B，则调用根据地址查询的函数
                Function2_select_B();
                break; // 结束当前 case
            case 'C': // 如果用户选择 C，则调用根据人员类别查询的函数
                Function2_select_C();
                break; // 结束当前 case
            case 'Q': // 如果用户选择 Q，则退出查询功能
                System.out.println("退出查询功能！");
                break; // 结束当前 case
            default: // 如果输入的选项不是 A、B、C 或 Q
                System.out.println("请输入正确的选项!");
                break;
        }
    }


    // 根据姓名对人员信息排序输出
    public static void Function3_displayable() throws IOException {
        // 创建 BufferedReader 以读取指定路径的文本文件
        BufferedReader br = new BufferedReader(new FileReader("D:\\CCodes\\vscodebase\\JAVA WORK\\address_book\\src\\text.txt"));

        // 创建 ArrayList 用于存储从文件中读取的每一行内容
        ArrayList<String> list = new ArrayList<>();
        String line; // 用于存储每一行读取的内容

        // 逐行读取文件内容，直到文件末尾
        while ((line = br.readLine()) != null) {
            list.add(line); // 将每一行添加到列表中
        }

        // 读取完成后关闭 BufferedReader，释放资源
        br.close();

        Comparator cmp= Collator.getInstance(java.util.Locale.CHINA); // 创建自定义比较器，用于按照姓名进行排序
        Collections.sort(list, cmp); // 对列表进行排序，使用自定义比较器按照姓名进行排序

        // 输出排序后的人员信息
        for (String s : list) {
            System.out.println(s); // 打印每一个排序后的记录
        }

    }

    // 能根据姓名、电话修改人员信息
    public static void Function4_update() throws IOException    {
        Scanner in = new Scanner(System.in); // 创建 Scanner 对象以读取用户输入
        BufferedReader br = new BufferedReader(new FileReader("D:\\CCodes\\vscodebase\\JAVA WORK\\address_book\\src\\text.txt")); // 创建 BufferedReader 以读取文件

        // 提示用户输入姓名
        System.out.println("输入姓名:");
        String name = in.next(); // 读取用户输入的姓名

        // 提示用户输入电话
        System.out.println("输入电话:");
        String phonenumber = in.next(); // 读取用户输入的电话

        String line; // 用于存储每一行读取的内容
        boolean found = false; // 标志变量，用于判断是否找到匹配的记录
        StringBuilder updatedContent = new StringBuilder(); // 用于存储更新后的文件内容

        // 逐行读取文件内容，直到文件末尾
        while ((line = br.readLine()) != null) {
            // 检查当前行是否以输入的姓名开头，并且电话匹配
            if (line.startsWith(name) && line.split(",")[2].equals(phonenumber)) {
                found = true; // 找到匹配的记录，设置标志为 true
                System.out.println("找到匹配的记录: " + line);

                // 提示用户输入新的信息以进行更新
                System.out.println("请输入新的电话:");
                String newPhonenumber = in.next(); // 输入新的电话号码

                System.out.println("请输入新的地址:");
                String newAddress = in.next(); // 输入新的地址

                System.out.println("请输入新的邮政编码:");
                int newPostal_code = in.nextInt(); // 输入新的邮政编码

                System.out.println("请输入新的邮箱:");
                String newEmail = in.next(); // 输入新的邮箱

                System.out.println("请输入新的 QQ 号码:");
                String newQq_number = in.next(); // 输入新的 QQ 号码

                System.out.println("请输入新的类别:");
                String newCategory = in.next(); // 输入新的类别

                // 更新记录为新的信息，保持原有的信息格式
                String[] details = line.split(","); // 假设信息由逗号分隔
                details[2] = newPhonenumber; // 更新电话号码
                details[3] = newAddress; // 更新地址
                details[4] = String.valueOf(newPostal_code); // 更新邮政编码
                details[5] = newEmail; // 更新邮箱
                details[6] = newQq_number; // 更新 QQ 号码
                details[7] = newCategory; // 更新类别

                // 将更新后的信息重写为一行字符串
                line = String.join(",", details);
                System.out.println("更新后的记录: " + line); // 显示更新后的记录
            }
            // 将每一行内容添加到更新的内容中（包括更新后的记录）
            updatedContent.append(line).append("\n");
        }

        br.close(); // 读取完成后关闭 BufferedReader，释放资源

        // 若未找到匹配记录，输出提示信息
        if (!found) {
            System.out.println("未找到匹配的记录，无法进行修改。");
        } else {
            // 将更新后的内容写回文件
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\CCodes\\vscodebase\\JAVA WORK\\address_book\\src\\text.txt"))) {
                bw.write(updatedContent.toString()); // 写回更新的文件内容
            } catch (IOException e) {
                System.out.println("更新文件时发生错误: " + e.getMessage());
            }
        }
    }

    //能根据姓名、电话删除人员信息
    public static void Function5_delete() throws IOException {
        Scanner in = new Scanner(System.in); // 创建 Scanner 对象以读取用户输入
        BufferedReader br = new BufferedReader(new FileReader("D:\\CCodes\\vscodebase\\JAVA WORK\\address_book\\src\\text.txt")); // 创建 BufferedReader 以读取文件
        // 提示用户输入姓名和电话
        System.out.println("输入姓名:");
        String name = in.next();
        System.out.println("输入电话:");
        String phonenumber = in.next();

        String line; // 用于存储读取的每一行数据
        boolean found = false; // 标志变量，用于判断是否找到匹配的记录
        StringBuilder updatedContent = new StringBuilder(); // 用于存储更新后的文件内容

        // 逐行读取文件内容进行查询
        while ((line = br.readLine()) != null) {
            // 检查当前行是否以输入的姓名开头，并且电话匹配
            if (line.startsWith(name) && (line.split(",")[2]).equals(phonenumber)) {
                found = true; // 找到匹配的记录，设置标志为 true
                System.out.println(line); // 输出查询到的信息
                System.out.println("删除成功!"); // 提示删除成功
            } else {
                // 将每一行内容添加到更新的内容中（包括未删除的记录）
                updatedContent.append(line).append("\n");
            }
        }

        br.close(); // 关闭 BufferedReader 以释放资源

        // 若未找到匹配记录，输出提示信息
        if (!found) {
            System.out.println("未找到匹配的记录，无法进行删除。");
        } else {
            // 将更新后的内容写回文件
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\CCodes\\vscodebase\\JAVA WORK\\address_book\\src\\text.txt"))) {
                bw.write(updatedContent.toString()); // 写回更新的文件内容
            } catch (IOException e) {
                System.out.println("更新文件时发生错误: " + e.getMessage());
            }
        }
    }

    // 保存 staff 对象到文件
    public static void saveToFile(staff s) throws IOException {
        // 创建一个 BufferedWriter，用于将文本写入指定文件
        // 第一个参数是文件路径，第二个参数 true 表示以追加的方式打开文件
        BufferedWriter rw = new BufferedWriter(new FileWriter("D:\\CCodes\\vscodebase\\JAVA WORK\\address_book\\src\\text.txt", true));

        // 将 staff 对象转换为字符串形式
        String t = s.toString();

        // 将字符串写入文件
        rw.write(t);

        // 写入新行，以便每个对象的信息在文件中单独占一行
        rw.newLine();

        // 关闭 BufferedWriter，释放系统资源
        rw.close();
    }

    // 查询功能--能够根据姓名、电话精确查询人员信息；
    public static void Function2_select_A() throws IOException {
        boolean bool = false; // 标志变量，用于判断是否查询到结果
        Scanner in = new Scanner(System.in); // 创建 Scanner 对象读取用户输入
        BufferedReader br = new BufferedReader(new FileReader("D:\\CCodes\\vscodebase\\JAVA WORK\\address_book\\src\\text.txt")); // 创建 BufferedReader 以读取文件
        String line; // 用于存储读取的每一行数据

        // 提示用户输入姓名和电话
        System.out.println("输入姓名:");
        String name = in.next();
        System.out.println("输入电话:");
        String phonenumber = in.next();

        // 逐行读取文件内容进行查询
        while ((line = br.readLine()) != null) {
            // 检查当前行是否以输入的姓名开头，并且电话匹配
            if (line.startsWith(name) && (line.split(",")[2]).equals(phonenumber)) {
                bool = true; // 找到匹配的记录，设置标志为 true
                System.out.println(line); // 输出查询到的信息
                System.out.println("查询成功！"); // 提示查询成功
            }
        }

        // 如果没有找到匹配的记录，输出提示信息
        if (!bool) {
            System.out.println("查询失败,不存在此人,请输入正确的姓名与电话！");
        }

        br.close(); // 关闭 BufferedReader 以释放资源

        // 提问用户是否继续查询
        System.out.println("是否继续以这种方式查询?(Y/N)");
        char c = in.next().charAt(0); // 读取用户输入的字符
        if (c == 'y' || c == 'Y') { // 如果用户输入 y 或 Y，递归调用此查询方法
            Function2_select_A();
        }
    }

    // 查询功能--能够根据地址进行模糊查询人员信息；
    public static void Function2_select_B() throws IOException {
        boolean bool = false; // 标志变量，记录是否找到结果
        Scanner in = new Scanner(System.in); // 创建 Scanner 对象读取用户输入
        BufferedReader br = new BufferedReader(new FileReader("D:\\CCodes\\vscodebase\\JAVA WORK\\address_book\\src\\text.txt")); // 创建 BufferedReader 以读取文件

        // 提示用户输入地址
        System.out.println("请输入地址:");
        String address = in.next(); // 读取用户输入的地址
        String line; // 用于存储读取的每一行数据

        // 逐行读取文件内容进行查询
        while ((line = br.readLine()) != null) {
            // 检查当前行的地址是否包含输入的地址（模糊查询）
            if (line.contains(address)) {
                bool = true; // 找到匹配的记录，设置标志为 true
                System.out.println(line); // 输出查询到的信息
            }
        }

        // 如果没有找到匹配的记录，输出提示信息
        if (!bool) {
            System.out.println("查询失败,没有找到匹配的地址!");
        } else {
            System.out.println("查询成功!"); // 提示查询成功
        }

        br.close(); // 关闭 BufferedReader 以释放资源

        // 提问用户是否继续查询
        System.out.println("是否继续以这种方式查询?(Y/N)");
        char c = in.next().charAt(0); // 读取用户输入的字符
        if (c == 'y' || c == 'Y') { // 如果用户输入 y 或 Y，递归调用此查询方法
            Function2_select_B();
        }
    }

    // 查询功能--根据人员类别查询人员信息
    public static void Function2_select_C() throws IOException {
        boolean bool = false; // 标志变量，记录是否找到结果
        Scanner in = new Scanner(System.in); // 创建 Scanner 对象读取用户输入
        BufferedReader br = new BufferedReader(new FileReader("D:\\CCodes\\vscodebase\\JAVA WORK\\address_book\\src\\text.txt")); // 创建 BufferedReader 以读取文件

        // 提示用户输入人员类别
        System.out.println("请输入人员类别:");
        String category = in.next(); // 读取用户输入的人员类别
        String line; // 用于存储读取的每一行数据

        // 逐行读取文件内容进行查询
        while ((line = br.readLine()) != null) {
            // 检查当前行的类别是否与输入的类别相同
            if (category.equals(line.split(",")[7])) {
                bool = true; // 找到匹配的记录，设置标志为 true
                System.out.println(line); // 输出查询到的信息
                System.out.println("查询成功!"); // 提示查询成功
            }
        }

        // 如果没有找到匹配的记录，输出提示信息
        if (!bool) {
            System.out.println("查询失败,请输入正确的人员类别!");
        }

        br.close(); // 关闭 BufferedReader 以释放资源

        // 提问用户是否继续查询
        System.out.println("是否继续以这种方式查询?(Y/N)");
        char c = in.next().charAt(0); // 读取用户输入的字符
        if (c == 'y' || c == 'Y') { // 如果用户输入 y 或 Y，递归调用此查询方法
            Function2_select_C();
        }
    }


    //打印菜单
    public static void displaymenu()
    {
        System.out.println("------------------菜单------------------");
        System.out.println("1.新建联系人");
        System.out.println("2.查询联系人");
        System.out.println("3.显示全部联系人");
        System.out.println("4.修改联系人信息");
        System.out.println("5.删除联系人");
        System.out.println("0.退出");
        System.out.println("----------------------------------------");
        System.out.println("请输入您要执行的操作：");
    }
}