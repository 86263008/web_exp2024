from sqlalchemy import Column, Integer, String
from database import Base

class Student(Base):
  '''学生实体类'''

  __tablename__ = "Student" #表名

  no = Column(String(50), primary_key = True) #学号
  name = Column(String(50)) #姓名
  gender = Column(String(2))  #性别
  age = Column(Integer) #年龄

  def __init__(self, obj):
    self.no = obj["no"]
    self.name = obj["name"]
    self.gender = obj["gender"]
    self.age = obj["age"]

  def __repr__(self):
    return f'<Student {self.name!r}>'