# 学生管理系统（Student Management System）

基于 Java 数组实现的命令行学生管理系统，包含学生信息的增删改查功能，是 Java 面向对象编程的入门练习项目。

## 功能特性

- **添加学生**：录入学号、姓名、性别、年龄
- **删除学生**：按学号删除，使用 `System.arraycopy` 新数组复制实现
- **修改学生**：按学号定位后修改姓名、性别、年龄
- **查询学生**：按学号排序后展示全部学生
- **退出确认**：退出前二次确认，防止误操作

## 技术要点

| 知识点 | 应用位置 |
| --- | --- |
| 封装（私有属性 + getter/setter） | Student 实体类 |
| 对象数组 | `Student[]` 存储学生，count 记录有效个数 |
| `System.arraycopy` | 删除元素时新旧数组复制 |
| 冒泡排序 | 查询时按学号升序排列 |
| 静态工具类 | `ArrayUilts.findIndexById` 按学号查找下标 |
| Scanner + switch | 菜单交互 |

## 项目结构

```
studentmanage
├── src
│   ├── Student.java       学生实体类
│   ├── StudentView.java   管理主逻辑（增删改查）
│   ├── ArrayUilts.java    工具类（查找索引）
│   └── Test01.java        程序入口
└── .gitignore
```

## 快速运行

```bash
# 编译
javac -encoding UTF-8 src/*.java
# 运行
java -cp src Test01
```

## 使用说明

启动后按提示输入 1-5：

1. 添加学生
2. 删除学生
3. 修改学生
4. 查询学生
5. 退出系统

## 说明

- 本项目刻意使用**数组**而非 `ArrayList` 实现，用于练习数组与 `System.arraycopy` 底层操作
- `ArrayUilts` 类名沿用课程原始命名（拼写保留原样）
