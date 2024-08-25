from fastapi import FastAPI
import uvicorn

app = FastAPI()

@app.get("/")
async def root():
  return {"message": "Hello World"}

if __name__ == "__main__":
  '''启动FastAPI服务器'''
  config = uvicorn.Config(app = app, port = 8888, log_level = "info", reload = False)
  server = uvicorn.Server(config)
  server.run()