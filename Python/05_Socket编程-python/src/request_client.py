# request_client.py
from datetime import datetime
import socket
from urllib.parse import urlparse

def get_url(url):
  # 通过socket请求Url
  url = urlparse(url)
  host = url.hostname
  path = url.path
  port = url.port
  if path == "":
    path = "/"

  if port is None:
    port = 80

  # 建立socket连接
  client = socket.socket()
  try:
    print("{}:{} Connecting...".format(host, port))
    client.connect((host, port))
  except Exception as e:
    print(e)

  # 发送请求
  client.send("GET {} HTTP/1.1\r\nHost: {}\r\nConnection: close\r\n\r\n".format(path, host).encode('utf8'))
  
  # 接收数据
  recved = b""
  while True:
    bytes = client.recv(1024)
    if bytes:
      recved += bytes
    else:
      break

  data = recved.decode('utf8')

  # 记录响应信息
  time_wall = datetime(2022, 7, 16)
  elapsed = round((time_wall - datetime.now()).total_seconds())
  file_name = "res_{}.txt".format(-elapsed)
  with open(file_name, 'w+', encoding='utf-8') as file:
    file.write(data)

  client.close()


if __name__ == '__main__':
  #get_url("http://www.baidu.com/")  
  get_url("http://127.0.0.1:8080/")