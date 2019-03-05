
@echo off
REM 声明采用UTF-8编码
chcp 65001

:: 切换账号
git config user.name "浮云晓生"
git config user.email "tengpeng.gao@gmail.com"

:: 查看账号
git config user.name
git config user.email

:: 代码更新
git pull
