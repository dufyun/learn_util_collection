@echo off
mode con lines=30 cols=60
%1 mshta vbscript:CreateObject("Shell.Application").ShellExecute("cmd.exe","/c %~s0 ::","","runas",1)(window.close)&&exit
cd /d "%~dp0"
:main
cls
color 2f

rem Configuration message start
echo.----------------------------------------------------------- 
echo.有趣的灵魂终将相遇
echo.
echo.美好的一天开始，加油！
echo.
echo.提示：执行该命令 请先阅读使用说明
echo.
echo.Copyright (c) dufy
echo.
color 2e
echo.-----------------------------------------------------------
echo.请选择使用：
echo.
echo. 1.启动工作模式的软件（即在下面输入1）
echo.
echo. 2.启动家庭模式的软件（即在下面输入2）
echo.-----------------------------------------------------------
rem Configuration message end

if exist "%SystemRoot%\System32\choice.exe" goto Win7Choice

set /p choice=请输入数字并按回车键确认:

echo.
if %choice%==1 goto workStyle
if %choice%==2 goto homeStyle
cls
"set choice="
echo 您输入有误，请重新选择。
ping 127.0.1 -n "2">nul
goto main

:Win7Choice
choice /c 12 /n /m "请输入相应数字："
if errorlevel 2 goto homeStyle
if errorlevel 1 goto workStyle
cls
goto main

:workStyle
cls
color 2f

rem Here to start the work software configuration
start "QQ" "F:\Program Files\Tencent\QQ\Bin\QQScLauncher.exe""
rem Here to end the work software configuration

echo.-----------------------------------------------------------
echo.
echo 学习-思考-创新-行动-改进-成功
echo.
echo 恭喜您，工作模式软件启动成功！ 
echo.

goto end

:homeStyle
cls
color 2f

rem Here to start the home software configuration
start "QQ" "F:\Program Files\Tencent\QQ\Bin\QQScLauncher.exe""
rem Here to end the home software configuration

echo 恭喜您，家庭模式软件启动成功！
echo.
goto end

:end
echo 请按任意键退出。
@Pause>nul