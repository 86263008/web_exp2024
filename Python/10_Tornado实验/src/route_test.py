import tornado.ioloop
from tornado.web import RequestHandler, Application

class MainHandler(tornado.web.RequestHandler):
  def get(self):
    self.write("Hello, world")

class IndexHandler(RequestHandler):
  def get(self):
    self.write('welcome to IndexHandler')

class UserHandler(RequestHandler):
  def get(self, name):
    self.write(f'welcome {name}')

def make_app():
  return Application([
    (r"/", MainHandler),
    (r'/index', IndexHandler),
    (r'/user/(.*)', UserHandler)
  ])

if __name__ == "__main__":
  app = make_app()
  app.listen(8888)
  tornado.ioloop.IOLoop.current().start()