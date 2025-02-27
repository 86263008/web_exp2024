from typing import Optional

from fastapi import FastAPI
from pydantic import BaseModel
import uvicorn

class Item(BaseModel):
  '''参数类型'''
  name: str
  description: Optional[str] = None
  price: float
  tax: Optional[float] = None

app = FastAPI()

@app.post("/items/")
async def create_item(item: Item):
  return item

if __name__ == "__main__":
  '''启动FastAPI服务器'''
  config = uvicorn.Config(app = app, port = 8888, log_level = "info", reload = False)
  server = uvicorn.Server(config)
  server.run()