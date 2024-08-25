import sqlite3

conn = sqlite3.connect('student.db')
c = conn.cursor()
print ("数据库打开成功")

c.execute("DELETE FROM Student WHERE No=2;")
conn.commit()
print("Total number of rows deleted :", conn.total_changes)

cursor = conn.execute("SELECT No, Name, Age FROM Student")
for row in cursor:
   print("No = ", row[0])
   print("Name = ", row[1])
   print("Age = ", row[2], "\n")

print ("数据操作成功")
conn.close()