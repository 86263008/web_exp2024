import json
import tornado.ioloop
from tornado.web import RequestHandler, Application

class FormHandler(RequestHandler):
  '''Form数据处理'''
  def post(self):
    name = self.get_argument('name')
    age = self.get_argument('age')
    self.write(f'{name} is {age} years old')

class JsonHandler(RequestHandler):
  '''JSON数据处理'''
  def post(self):
    data = json.loads(self.request.body)
    self.write(data)

def make_app():
  return Application([
    (r'/form', FormHandler),
    (r'/json', JsonHandler)
  ])

if __name__ == "__main__":
  app = make_app()
  app.listen(8888)
  tornado.ioloop.IOLoop.current().start()