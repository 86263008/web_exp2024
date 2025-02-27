from fastapi import FastAPI, Form
import uvicorn

app = FastAPI()

@app.post("/login/")
async def login(username: str = Form(), password: str = Form()):
  return {"username": username}

if __name__ == "__main__":
  '''启动FastAPI服务器'''
  config = uvicorn.Config(app = app, port = 8888, log_level = "info", reload = False)
  server = uvicorn.Server(config)
  server.run()