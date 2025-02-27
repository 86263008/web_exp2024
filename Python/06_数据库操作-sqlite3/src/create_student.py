import sqlite3

conn = sqlite3.connect("student.db")
print ("数据库打开成功")
c = conn.cursor()
c.execute('''CREATE TABLE Student
       (No INT PRIMARY KEY     NOT NULL,
       NAME           TEXT    NOT NULL,
       AGE            INT     NOT NULL
       );''')
print ("数据表创建成功")
conn.commit()
conn.close()