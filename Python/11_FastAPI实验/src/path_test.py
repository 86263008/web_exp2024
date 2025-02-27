from fastapi import FastAPI
import uvicorn

app = FastAPI()

@app.get("/items/{item_id}")
async def read_item(item_id: int):
  return {"item_id": item_id}
    
if __name__ == "__main__":
  '''启动FastAPI服务器'''
  config = uvicorn.Config(app = app, port = 8888, log_level = "info", reload = False)
  server = uvicorn.Server(config)
  server.run()