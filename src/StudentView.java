import java.util.Scanner;

public class StudentView {
    /*
    键盘需要反复录入学生信息，直到用户退出系统;
    所以不需要每执行一个方法就new一次Scanner对象
    可以将Scanner对象放到成员变量中
    */
    Scanner sc = new Scanner(System.in);
    /*
    老数组,长度为50,代表班级最多存放50人
    后面每个功能都需要用到数组,可以将数组放到成员变量
    */
    Student[] students = new Student[50];
    /*
    定义一个count,记录数组中存放了多少个对象,遍历数组时不能全部遍历,
    因为没有存放对象的位置遍历出来是null,再调用getxxx方法,会出现空指针
    所以我们应该记录存储对象的个数,存了多个个就遍历多少次

    而且后面可能会反复用到count,所以将count放到成员变量中
    */
    int count = 0;
    /*
    新数组,删除元素时,将老数组的元素复制到新数组中;
    因为老数组定长,所以不能随意改动老数组的长度
    由于一次删除一个,所以新数组的长度为老数组的长度 - 1
    后面可能会反复用到新数组,所以定义到成员变量
    */
    Student[] newStudents = new Student[students.length - 1];


    public void Start() {
        while (true) {
            System.out.println("---------------学生管理系统----------------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查询学生");
            System.out.println("5.退出系统");
            System.out.println("请输入您的选择(1-5):");

            int num = sc.nextInt();
            System.out.println("-----------------------------------------");

            switch (num) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    modifyStudent();
                    break;
                case 4:
                    queryStudent();
                    break;
                case 5:
                    System.out.println("是否确认退出系统???(0-确认/任意数-取消)");
                    int key = sc.nextInt();
                    if (key == 0){
                        System.out.println("退出系统!!!");
                        return;
                    }else{
                        break;
                    }

            }
        }
    }

    private void queryStudent() {
        System.out.println("查询学生");
        System.out.println("学号\t姓名\t性别\t年龄");

        for (int j = 0; j < count - 1; j++) {
            for (int i = 0; i < count - 1 - j; i++) {
                if(students[i].getId() > students[i + 1].getId()){
                    Student temp = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = temp;
                }
            }
        }
        if(count == 0){
            System.out.println("班级中没有学生!!!");
        }else{
            for (int i = 0; i < count; i++) {
                System.out.println(students[i].getId() + "\t" + students[i].getName() + "\t" + students[i].getSex() + "\t" + students[i].getAge());
            }
        }

    }

    private void modifyStudent() {
        System.out.println("修改学生");
        System.out.println("请输入要修改信息的学生学号:");
        int id = sc.nextInt();
        int modifyIndex = ArrayUilts.findIndexById(students, id, count);
        if (modifyIndex == -1){
            System.out.println("要修改的学生不存在!!!");
        }else{
            System.out.println("请输入学生姓名:");
            String name = sc.next();
            System.out.println("请输入学生性别:");
            String sex = sc.next();
            System.out.println("请输入学生年龄:");
            int age = sc.nextInt();
            //将用户输入的姓名,性别,年龄赋值给学生对象
            Student student = new Student(id, name, sex, age);
            //将学生对象赋值给对应索引位置的学生
            students[modifyIndex] = student;
            System.out.println("学生信息修改成功!!!");
        }

    }

    private void deleteStudent() {
        System.out.println("删除学生");
        //1.输入要删除的学生学号
        System.out.println("请输入您想要删除的学生学号:");
        int id = sc.nextInt();
        //2.根据学生id查询对应学生的索引位置
        int removeIndex = ArrayUilts.findIndexById(students, id, count);

        //3.将被删除元素前的元素复制到新数组中
        System.arraycopy(students, 0, newStudents, 0, removeIndex);
        //4.将被删除元素后的元素复制到新数组中
        System.arraycopy(students, removeIndex + 1, newStudents, removeIndex, count - removeIndex - 1);
        //5.将新数组赋值给老数组
        students = newStudents;
        count--;

        System.out.println("学生信息删除成功!!!");
    }

    private void addStudent() {
        System.out.println("添加学生");
        System.out.println("请输入学生信息:");
        System.out.println("学号:");
        int id = sc.nextInt();
        System.out.println("姓名:");
        String name = sc.next();
        System.out.println("性别:");
        String sex = sc.next();
        System.out.println("年龄:");
        int age = sc.nextInt();
        students[count] = new Student(id, name, sex, age);
        count++;

        System.out.println("学生信息添加成功!!!");
    }
}
