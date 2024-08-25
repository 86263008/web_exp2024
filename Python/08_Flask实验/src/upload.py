from flask import Flask, render_template, request

import os

app = Flask(__name__)
app.config['UPLOAD_FOLDER'] = 'static/upload/' # 设定上传目录

@app.route('/')
def index():
  '''上传界面'''
  return render_template('upload.html')

@app.route('/upload',methods=['GET','POST'])
def upload():
  '''上传'''
  if request.method == 'POST':
    f = request.files['file'] # 提取文件
    file_name = f.filename
    f.save(os.path.join(app.config['UPLOAD_FOLDER'], file_name))
    return render_template('uploaded.html', file_name = file_name) # 显示上传图片
  else:
    return render_template('upload.html')

if __name__ == '__main__':
  app.run(debug=True)