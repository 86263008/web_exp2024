import tornado.ioloop
from tornado.web import RequestHandler, Application

class HelloHandler(RequestHandler):
  def get(self):
    print(self.request.headers)             # 字典形式存储的headers信息
    print(self.request.headers['host'])     # 获取某一个首部
    print(self.request.path)                # 请求的path
    self.write('ok')

def make_app():
  return Application([
    (r'/', HelloHandler)
  ])

if __name__ == "__main__":
  app = make_app()
  app.listen(8888)
  tornado.ioloop.IOLoop.current().start()