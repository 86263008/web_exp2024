from fastapi import FastAPI, Request
from fastapi.responses import HTMLResponse
from fastapi.staticfiles import StaticFiles
from fastapi.templating import Jinja2Templates
import uvicorn

app = FastAPI()

app.mount("/static", StaticFiles(directory="static"), name="static")

templates = Jinja2Templates(directory="templates")

@app.get("/items/{id}", response_class=HTMLResponse)
async def read_item(request: Request, id: str):
  return templates.TemplateResponse("item.html", {"request": request, "id": id})

if __name__ == "__main__":
  '''启动FastAPI服务器'''
  config = uvicorn.Config(app = app, port = 8888, log_level = "info", reload = False)
  server = uvicorn.Server(config)
  server.run()