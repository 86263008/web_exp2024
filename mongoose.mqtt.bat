@echo off
title Mongoose MQTT Server

:: 仅保留核心参数，确保 MQTT 启动
if not exist "mongoose.exe" (
    echo 错误：未找到 mongoose.exe！
    pause
    exit /b 1
)

echo 启动极简版 MQTT 服务器（端口 1883）...
mongoose.exe -enable_mqtt yes -mqtt_port 1883 -mqtt_allow_anonymous yes

pause
taskkill /f /im mongoose.exe