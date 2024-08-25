# -*- coding:utf-8 -*-
# my_server.py
import logging
from fastapi import FastAPI
from fastapi.responses import HTMLResponse
from fastapi.staticfiles import StaticFiles
from pydantic import BaseModel
import uvicorn

log = logging.getLogger("my_server")
app = FastAPI()
app.mount("/public", StaticFiles(directory="public"), "public")

@app.get("/", response_class=HTMLResponse)
async def root():
  '''首页'''
  html_file = open(file="index.html", mode="r", encoding="utf-8").read()
  return html_file

class AddInput(BaseModel):
  '''加法输入'''
  a: float = 0
  b: float = 2

@app.post("/add")
async def add(v: AddInput):
  '''加法服务'''
  log.debug("input:{},{}".format(v.a, v.b))
  return v.a + v.b

@app.get("/minus")
async def minus(a:float, b:float):
  '''
  减法服务
  @param a: 操作数1
  @param b: 操作数2
  '''
  log.debug("input:{},{}".format(a, b))
  return a - b

def start(port: int = 8888):
  '''启动FastAPI服务器'''
  config = uvicorn.Config(app = app, port = port, log_level = "info", reload = False)
  server = uvicorn.Server(config)
  server.run()

if __name__ == "__main__":
  logging.basicConfig(level=logging.DEBUG)
  start()