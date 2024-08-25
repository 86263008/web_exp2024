from flask import Flask, request, render_template
app = Flask(__name__)

@app.route("/")
def hello_world():
  '''登录页面'''
  return render_template("login.html")

@app.route("/hello/<name>")
def hello_name(name):
  '''接收变量name'''
  return f"Hello {name}"

@app.route("/login", methods = ["POST", "GET"])
def login():
  '''接收表单参数'''
  if request.method == "POST":
    username = request.form["username"] #提取参数
    return f"Hello {username} by POST"
  else:
    username = request.args.get["username"] #提取参数
    return f"Hello {username} by GET"

if __name__ == "__main__":
  app.run(host="0.0.0.0", port=5000, debug=True)