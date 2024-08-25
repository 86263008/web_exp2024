import tornado.ioloop
from tornado.web import RequestHandler, Application

class HelloHandler(RequestHandler):
  def get(self):
    name = self.get_argument('name')
    age = self.get_argument('age')
    city = self.get_argument('city', default='beijing')
    self.write(f'{name} is {age} years old, he comes from {city}')

def make_app():
  return Application([
    (r'/', HelloHandler)
  ])

if __name__ == "__main__":
  app = make_app()
  app.listen(8888)
  tornado.ioloop.IOLoop.current().start()