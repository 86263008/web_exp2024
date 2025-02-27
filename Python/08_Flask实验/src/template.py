from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def index():
  name = "Jack Ma"

  # render_template方法:渲染模板
  # 参数1: 模板名称  参数n: 传到模板里的数据
  return render_template('index.html', name=name)

if __name__ == '__main__':
  app.run(debug=True)