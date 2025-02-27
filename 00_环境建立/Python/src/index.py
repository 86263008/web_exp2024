from fastapi import FastAPI
from fastapi.responses import FileResponse
from fastapi.staticfiles import StaticFiles
import os

app = FastAPI()

# 指定静态文件目录的路径
static_dir = os.path.join(os.path.dirname(__file__), "static")

# 将StaticFiles中间件添加到应用
app.mount("/static", StaticFiles(directory=static_dir), name="static")

@app.get("/")
def get_index():
    return FileResponse("static/greeting.html")
