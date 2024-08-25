from flask import Flask, request, render_template
from student import Student
from database import init_db, db_session
import logging
logger = logging.getLogger(__name__)

app = Flask(__name__)
app.secret_key = "random string"

@app.route("/create", methods = ["GET", "POST"])
def create():
  """增"""
  message = ""
  if request.method == "POST":
    obj = get_student(request.form)
    if not obj["no"]:
      message = "信息不完整！"
    else:
      #创建新记录
      try:
        db_session.add(Student(obj))
        db_session.commit()
        message = "增加成功！"
      except Exception as e:
        message = e

  logger.debug(message)
  return render_template("student/create.html", message = message)

def get_student(form):
  """
  从表单提取学生信息
  @form: 学生信息表单
  """
  res = {
    "no": form["no"],
    "name": form["name"],
    "gender": form["gender"],
    "age": form["age"]
  }
    
  return res

@app.route("/delete/<no>")
def delete(no):
  """删"""
  message = ""
  obj = db_session.query(Student).filter_by(no = no).first()
  if obj:
    try:
      db_session.delete(obj)
      db_session.commit()
    except Exception as e:
      message = e
  
  return render_template("student/retrieve.html", message = message, students = db_session.query(Student).all())

@app.route("/update_index/<no>")
def update_index(no):
  """显示修改页面"""
  obj = db_session.query(Student).filter_by(no = no).first()
  
  logger.debug(obj)
  return render_template("student/update.html", student = obj)

@app.route("/update", methods = ["POST"])
def update():
  """删"""
  message = ""
  obj = get_student(request.form)
  logger.debug(obj)
  if not obj["no"]:
    message = "信息不完整！"
  else:
    #创建新记录
    try:
      logger.debug(obj)
      db_session.query(Student).filter_by(no = obj["no"]).update(obj)
      db_session.commit()
      message = "修改成功！"
    except Exception as e:
      message = e
  
  return render_template("student/update.html", message = message, student = obj)

@app.route("/retrieve")
def retrieve():
  return render_template("student/retrieve.html", students = Student.query.all())

if __name__ == "__main__":
  logging.basicConfig(level = logging.DEBUG)
  init_db()
  app.run(debug = True)