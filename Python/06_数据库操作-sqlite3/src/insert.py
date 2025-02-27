import sqlite3

conn = sqlite3.connect('student.db')
c = conn.cursor()
print ("数据库打开成功")

c.execute("INSERT INTO Student (No,NAME,AGE) \
      VALUES (1, 'Paul', 32)")

c.execute("INSERT INTO Student (No,NAME,AGE) \
      VALUES (2, 'Allen', 25)")

c.execute("INSERT INTO Student (No,NAME,AGE) \
      VALUES (3, 'Teddy', 23)")

c.execute("INSERT INTO Student (No,NAME,AGE) \
      VALUES (4, 'Mark', 25)")

conn.commit()
print ("数据插入成功")
conn.close()